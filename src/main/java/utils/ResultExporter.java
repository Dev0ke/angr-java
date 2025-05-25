package utils;

import com.alibaba.fastjson2.JSON;
import java.io.*;
import java.util.List;
import java.util.Set;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.ReentrantLock;


public class ResultExporter {
    public static final int CODE_SUCCESS = 0;
    public static final int CODE_TIMEOUT = 1;
    public static final int CODE_ERROR = 2;
    public static final int CODE_UNKNOWN = 3;

    private final File outputFile;
    private BufferedWriter bufferedWriter;
    
    // 优化：使用线程本地缓冲区减少同步开销
    private final ThreadLocal<StringBuilder> localBuffer = ThreadLocal.withInitial(() -> new StringBuilder(1024));
    
    // 优化：使用定时刷新机制
    private final ScheduledExecutorService flushExecutor;
    private final ReentrantLock writeLock = new ReentrantLock();
    
    // 批量写入缓冲区
    private final StringBuilder batchBuffer = new StringBuilder(8192);
    private volatile boolean shutdown = false;

    public ResultExporter(String outputPath) {
        this.outputFile = initOutputFile(outputPath);
        this.bufferedWriter = initBufferedWriter(this.outputFile);
        
        // 创建定时刷新任务，每500ms刷新一次
        this.flushExecutor = Executors.newSingleThreadScheduledExecutor(r -> {
            Thread t = new Thread(r, "ResultExporter-Flush");
            t.setDaemon(true);
            return t;
        });
        
        // 定期刷新缓冲区
        this.flushExecutor.scheduleAtFixedRate(() -> flushBatchBuffer(), 500, 500, TimeUnit.MILLISECONDS);
        
        // 添加关闭钩子
        Runtime.getRuntime().addShutdownHook(new Thread(() -> shutdown()));
    }

    private File initOutputFile(String outputPath) {
        File file = new File(outputPath);
        File parentDir = file.getParentFile();

        if (parentDir != null && !parentDir.exists()) {
            if (!parentDir.mkdirs()) {
                Log.error("Failed to create directory: " + parentDir.getAbsolutePath());
                throw new RuntimeException("Directory creation failed");
            }
        }
        return file;
    }

    private BufferedWriter initBufferedWriter(File file) {
        try {
            return new BufferedWriter(new FileWriter(file, true));
        } catch (IOException e) {
            Log.error("Failed to initialize BufferedWriter for file: " + file.getAbsolutePath() + e);
            throw new RuntimeException("BufferedWriter initialization failed", e);
        }
    }

    // 优化后的写入方法 - 使用批量写入
    public void writeString(String content) {
        if (shutdown) {
            return;
        }
        
        // 使用线程本地缓冲区构建内容
        StringBuilder buffer = localBuffer.get();
        buffer.setLength(0); // 清空缓冲区
        buffer.append(content).append(System.lineSeparator());
        
        // 将内容添加到批量缓冲区
        writeLock.lock();
        try {
            batchBuffer.append(buffer);
            // 如果批量缓冲区过大，立即刷新
            if (batchBuffer.length() > 4096) {
                flushBatchBufferUnsafe();
            }
        } finally {
            writeLock.unlock();
        }
    }
    
    // 定期刷新批量缓冲区
    private void flushBatchBuffer() {
        writeLock.lock();
        try {
            flushBatchBufferUnsafe();
        } finally {
            writeLock.unlock();
        }
    }
    
    // 不安全的刷新方法（需要在锁保护下调用）
    private void flushBatchBufferUnsafe() {
        if (batchBuffer.length() > 0) {
            try {
                bufferedWriter.write(batchBuffer.toString());
                bufferedWriter.flush();
                batchBuffer.setLength(0); // 清空缓冲区
            } catch (IOException e) {
                Log.error("Failed to flush batch buffer: " + e.getMessage());
            }
        }
    }
    
    // 关闭资源
    private void shutdown() {
        shutdown = true;
        
        // 刷新剩余数据
        flushBatchBuffer();
        
        // 关闭定时器
        if (flushExecutor != null) {
            flushExecutor.shutdown();
            try {
                if (!flushExecutor.awaitTermination(1, TimeUnit.SECONDS)) {
                    flushExecutor.shutdownNow();
                }
            } catch (InterruptedException e) {
                flushExecutor.shutdownNow();
                Thread.currentThread().interrupt();
            }
        }
        
        // 关闭写入器
        if (bufferedWriter != null) {
            try {
                bufferedWriter.close();
            } catch (IOException e) {
                Log.error("Failed to close BufferedWriter: " + e.getMessage());
            }
        }
    }

    public synchronized void writeResult(int code, String className, String signature, Set<List<String>> result, long time,String msg) {
        try {
            String jsonOutput = JSON.toJSONString(new ResultOutput(code,className, signature, result, time,msg));
            bufferedWriter.write(jsonOutput);
            bufferedWriter.newLine();
            bufferedWriter.flush();
        } catch (IOException e) {
            Log.error("Failed to write result to file: " + this.outputFile.getAbsolutePath() + e);
        }
    }

    public static class ResultOutput {
        private final int code;
        private final String className;
        private final String signature;
        private final Set<List<String>> result;
        private final long time;
        private final String msg;

        public ResultOutput(int code,String className, String signature, Set<List<String>> result, long time, String msg) {
            this.className = className;
            this.signature = signature;
            this.code = code;
            this.result = result;
            this.time = time;
            this.msg = msg;
        }

        public String getClassName() {
            return className;
        }

        public String getSignature() {
            return signature;
        }

        public int getCode() {
            return code;
        }

        public Set<List<String>> getResult() {
            return result;
        }

        public long getTime() {
            return time;
        }
        public String getMsg() {
            return msg;
        }
    }
}
