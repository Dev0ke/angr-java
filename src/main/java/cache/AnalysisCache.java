package cache;

import utils.Log;

import java.util.List;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicLong;

/**
 * 分析结果缓存 - 避免重复分析相同的方法
 * 使用方法签名作为键，分析结果作为值
 */
public class AnalysisCache {
    
    // 缓存分析结果
    private final ConcurrentHashMap<String, CachedResult> resultCache;
    
    // 统计信息
    private final AtomicLong hitCount = new AtomicLong(0);
    private final AtomicLong missCount = new AtomicLong(0);
    
    // 单例模式
    private static volatile AnalysisCache instance;
    private static final Object lock = new Object();
    
    // 缓存大小限制
    private final int maxCacheSize;
    
    private AnalysisCache(int maxCacheSize) {
        this.maxCacheSize = maxCacheSize;
        this.resultCache = new ConcurrentHashMap<>(maxCacheSize);
        Log.info("AnalysisCache initialized with max size: " + maxCacheSize);
    }
    
    public static AnalysisCache getInstance() {
        if (instance == null) {
            synchronized (lock) {
                if (instance == null) {
                    // 默认缓存大小为10000个方法
                    instance = new AnalysisCache(10000);
                }
            }
        }
        return instance;
    }
    
    /**
     * 生成缓存键
     */
    private String generateCacheKey(String className, String methodSignature) {
        return className + "#" + methodSignature;
    }
    
    /**
     * 获取缓存的分析结果
     */
    public CachedResult getResult(String className, String methodSignature) {
        String key = generateCacheKey(className, methodSignature);
        CachedResult result = resultCache.get(key);
        
        if (result != null) {
            hitCount.incrementAndGet();
            Log.debug("Cache hit for: " + key);
            return result;
        } else {
            missCount.incrementAndGet();
            Log.debug("Cache miss for: " + key);
            return null;
        }
    }
    
    /**
     * 缓存分析结果
     */
    public void putResult(String className, String methodSignature, 
                         Set<List<String>> analysisResult, long analysisTime, 
                         int resultCode, String errorMessage) {
        String key = generateCacheKey(className, methodSignature);
        
        // 检查缓存大小限制
        if (resultCache.size() >= maxCacheSize) {
            // 简单的LRU策略：随机移除一些旧条目
            clearOldEntries();
        }
        
        CachedResult cachedResult = new CachedResult(
            analysisResult, analysisTime, resultCode, errorMessage, System.currentTimeMillis()
        );
        
        resultCache.put(key, cachedResult);
        Log.debug("Cached result for: " + key);
    }
    
    /**
     * 清理旧的缓存条目
     */
    private void clearOldEntries() {
        int targetSize = maxCacheSize * 3 / 4; // 清理到75%
        int toRemove = resultCache.size() - targetSize;
        
        if (toRemove > 0) {
            Log.info("Clearing " + toRemove + " old cache entries");
            
            // 简单策略：移除前N个条目
            resultCache.entrySet().stream()
                .limit(toRemove)
                .forEach(entry -> resultCache.remove(entry.getKey()));
        }
    }
    
    /**
     * 获取缓存统计信息
     */
    public String getCacheStats() {
        long hits = hitCount.get();
        long misses = missCount.get();
        long total = hits + misses;
        double hitRate = total > 0 ? (double) hits / total * 100 : 0;
        
        return String.format("AnalysisCache[size=%d, hits=%d, misses=%d, hitRate=%.2f%%]", 
                           resultCache.size(), hits, misses, hitRate);
    }
    
    /**
     * 清空缓存
     */
    public void clear() {
        resultCache.clear();
        hitCount.set(0);
        missCount.set(0);
        Log.info("AnalysisCache cleared");
    }
    
    /**
     * 缓存结果数据结构
     */
    public static class CachedResult {
        private final Set<List<String>> analysisResult;
        private final long analysisTime;
        private final int resultCode;
        private final String errorMessage;
        private final long cacheTime;
        
        public CachedResult(Set<List<String>> analysisResult, long analysisTime, 
                           int resultCode, String errorMessage, long cacheTime) {
            this.analysisResult = analysisResult;
            this.analysisTime = analysisTime;
            this.resultCode = resultCode;
            this.errorMessage = errorMessage;
            this.cacheTime = cacheTime;
        }
        
        public Set<List<String>> getAnalysisResult() {
            return analysisResult;
        }
        
        public long getAnalysisTime() {
            return analysisTime;
        }
        
        public int getResultCode() {
            return resultCode;
        }
        
        public String getErrorMessage() {
            return errorMessage;
        }
        
        public long getCacheTime() {
            return cacheTime;
        }
    }
} 