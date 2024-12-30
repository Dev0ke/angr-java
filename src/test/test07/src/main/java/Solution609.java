import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Solution609 {
    public List<List<String>> findDuplicate(String[] paths) {
        Map<String, List<String>> map = new HashMap<>();
        for (String path : paths) {
            String[] split = path.split(" ");
            String directory = split[0];
            for (int i = 1; i < split.length; i++) {
                int idx = split[i].indexOf("(");
                String file = split[i].substring(0, idx);
                String content = split[i].substring(idx, split[i].length() - 1);
                map.computeIfAbsent(content, key -> new ArrayList<>()).add(directory + "/" + file);
            }
        }

        List<List<String>> ans = new ArrayList<>();
        for (List<String> list : map.values()) {
            if (list.size() > 1) {
                ans.add(list);
            }
        }
        return ans;
    }
}
/*
609. 在系统中查找重复文件
https://leetcode.cn/problems/find-duplicate-file-in-system/

给你一个目录信息列表 paths ，包括目录路径，以及该目录中的所有文件及其内容，请你按路径返回文件系统中的所有重复文件。答案可按 任意顺序 返回。
一组重复的文件至少包括 两个 具有完全相同内容的文件。
输入 列表中的单个目录信息字符串的格式如下：
- "root/d1/d2/.../dm f1.txt(f1_content) f2.txt(f2_content) ... fn.txt(fn_content)"
这意味着，在目录 root/d1/d2/.../dm 下，有 n 个文件 ( f1.txt, f2.txt ... fn.txt ) 的内容分别是 ( f1_content, f2_content ... fn_content ) 。注意：n >= 1 且 m >= 0 。如果 m = 0 ，则表示该目录是根目录。
输出 是由 重复文件路径组 构成的列表。其中每个组由所有具有相同内容文件的文件路径组成。文件路径是具有下列格式的字符串：
- "directory_path/file_name.txt"
进阶：
假设您有一个真正的文件系统，您将如何搜索文件？广度搜索还是宽度搜索？
如果文件内容非常大（GB级别），您将如何修改您的解决方案？
如果每次只能读取 1 kb 的文件，您将如何修改解决方案？
修改后的解决方案的时间复杂度是多少？其中最耗时的部分和消耗内存的部分是什么？如何优化？
如何确保您发现的重复文件不是误报？

哈希表 模拟
 */