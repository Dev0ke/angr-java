package Engine;

import com.microsoft.z3.Context;
import utils.Log;

import java.util.Map;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * Z3上下文池 - 复用Z3上下文以减少创建开销
 * Z3上下文创建是重量级操作，通过池化可以显著提升性能
 */
public class Z3ContextPool {
    private final BlockingQueue<Context> pool;
    private final int maxSize;
    private final AtomicInteger createdCount;
    private final Map<String, String> defaultConfig;
    
    // 单例模式
    private static volatile Z3ContextPool instance;
    private static final Object lock = new Object();
    
    private Z3ContextPool(int maxSize) {
        this.maxSize = maxSize;
        this.pool = new LinkedBlockingQueue<>(maxSize);
        this.createdCount = new AtomicInteger(0);
        this.defaultConfig = Map.of("model", "true");
        
        // 预创建一些上下文
        int preCreateCount = Math.min(maxSize / 2, 8);
        for (int i = 0; i < preCreateCount; i++) {
            pool.offer(createNewContext());
        }
        
        Log.info("Z3ContextPool initialized with max size: " + maxSize + ", pre-created: " + preCreateCount);
    }
    
    public static Z3ContextPool getInstance() {
        if (instance == null) {
            synchronized (lock) {
                if (instance == null) {
                    // 根据CPU核心数确定池大小
                    int poolSize = Math.min(Runtime.getRuntime().availableProcessors() * 4, 64);
                    instance = new Z3ContextPool(poolSize);
                }
            }
        }
        return instance;
    }
    
    /**
     * 借用一个Z3上下文
     * @return Z3上下文实例
     */
    public Context borrowContext() {
        Context context = pool.poll();
        if (context == null) {
            // 池中没有可用上下文，创建新的
            if (createdCount.get() < maxSize) {
                context = createNewContext();
                Log.debug("Created new Z3 context, total created: " + createdCount.get());
            } else {
                // 达到最大数量限制，等待可用上下文
                try {
                    context = pool.take();
                    Log.debug("Waited for available Z3 context");
                } catch (InterruptedException e) {
                    Thread.currentThread().interrupt();
                    Log.error("Interrupted while waiting for Z3 context");
                    return createNewContext(); // 降级处理
                }
            }
        }
        return context;
    }
    
    /**
     * 归还Z3上下文到池中
     * @param context 要归还的上下文
     */
    public void returnContext(Context context) {
        if (context != null) {
            // 检查上下文是否仍然有效
            try {
                // 简单的健康检查
                context.mkTrue();
                
                // 尝试归还到池中
                if (!pool.offer(context)) {
                    // 池已满，关闭上下文
                    context.close();
                    createdCount.decrementAndGet();
                    Log.debug("Pool full, closed Z3 context");
                }
            } catch (Exception e) {
                // 上下文已损坏，关闭它
                try {
                    context.close();
                } catch (Exception closeEx) {
                    Log.error("Error closing damaged Z3 context: " + closeEx.getMessage());
                }
                createdCount.decrementAndGet();
                Log.warn("Closed damaged Z3 context");
            }
        }
    }
    
    /**
     * 创建新的Z3上下文
     */
    private Context createNewContext() {
        createdCount.incrementAndGet();
        return new Context(defaultConfig);
    }
    
    /**
     * 关闭池中所有上下文
     */
    public void shutdown() {
        Log.info("Shutting down Z3ContextPool...");
        Context context;
        int closedCount = 0;
        while ((context = pool.poll()) != null) {
            try {
                context.close();
                closedCount++;
            } catch (Exception e) {
                Log.error("Error closing Z3 context during shutdown: " + e.getMessage());
            }
        }
        Log.info("Z3ContextPool shutdown complete, closed " + closedCount + " contexts");
    }
    
    /**
     * 获取池状态信息
     */
    public String getPoolStatus() {
        return String.format("Z3ContextPool[available=%d, created=%d, maxSize=%d]", 
                           pool.size(), createdCount.get(), maxSize);
    }
} 