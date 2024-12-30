import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Solution1233 {
    public List<String> removeSubfolders(String[] folder) {
        int len = folder.length;
        Arrays.sort(folder);
        List<String> resList = new ArrayList<>();
        resList.add(folder[0]);
        for (int i = 1; i < len; i++) {
            String pre = resList.get(resList.size() - 1);
            if (pre.length() < folder[i].length()
                    && pre.equals(folder[i].substring(0, pre.length()))
                    && folder[i].charAt(pre.length()) == '/'
            ) {
                // do nothing
            } else {
                resList.add(folder[i]);
            }
        }
        return resList;
    }
}
/*
1233. 删除子文件夹
https://leetcode.cn/problems/remove-sub-folders-from-the-filesystem/

你是一位系统管理员，手里有一份文件夹列表 folder，你的任务是要删除该列表中的所有 子文件夹，并以 任意顺序 返回剩下的文件夹。
如果文件夹 folder[i] 位于另一个文件夹 folder[j] 下，那么 folder[i] 就是 folder[j] 的 子文件夹 。
文件夹的「路径」是由一个或多个按以下格式串联形成的字符串：'/' 后跟一个或者多个小写英文字母。
- 例如，"/leetcode" 和 "/leetcode/problems" 都是有效的路径，而空字符串和 "/" 不是。
提示：
1 <= folder.length <= 4 * 10^4
2 <= folder[i].length <= 100
folder[i] 只包含小写字母和 '/'
folder[i] 总是以字符 '/' 起始
folder 每个元素都是 唯一 的

排序
时间复杂度 O(nl * logn)
 */