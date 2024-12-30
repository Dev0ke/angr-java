import java.util.HashMap;
import java.util.Map;

public class SolutionP1166 {
    static class FileSystem {
        private final Map<String, Integer> hashMap;

        public FileSystem() {
            hashMap = new HashMap<>();
            // 空字符串 "" 和 "/" 不是。
            hashMap.put("", -1);
            hashMap.put("/", -1);
        }

        public boolean createPath(String path, int value) {
            // 如果路径已经存在或其父路径不存在，则返回 false 。
            if (hashMap.containsKey(path)) {
                return false;
            }
            String parentPath = path.substring(0, path.lastIndexOf("/"));
            if (!hashMap.containsKey(parentPath)) {
                return false;
            }
            hashMap.put(path, value);
            return true;
        }

        public int get(String path) {
            return hashMap.getOrDefault(path, -1);
        }
    }
}
/*
$1166. 设计文件系统
https://leetcode.cn/problems/design-file-system/

你需要设计一个文件系统，你可以创建新的路径并将它们与不同的值关联。
路径的格式是一个或多个连接在一起的字符串，形式为： / ，后面跟着一个或多个小写英文字母。例如， " /leetcode" 和 "/leetcode/problems" 是有效路径，而空字符串 "" 和 "/" 不是。
实现 FileSystem 类:
- bool createPath(string path, int value) 创建一个新的 path ，并在可能的情况下关联一个 value ，然后返回 true 。如果路径已经存在或其父路径不存在，则返回 false 。
- int get(string path) 返回与 path 关联的值，如果路径不存在则返回 -1 。
提示：
对两个函数的调用次数加起来小于等于 10^4
2 <= path.length <= 100
1 <= value <= 10^9

HashMap 模拟。
 */