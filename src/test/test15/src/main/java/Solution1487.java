import java.util.HashMap;
import java.util.Map;

public class Solution1487 {
    public String[] getFolderNames(String[] names) {
        int n = names.length;
        Map<String, Integer> hashMap = new HashMap<>();
        String[] res = new String[n];
        for (int i = 0; i < n; i++) {
            if (!hashMap.containsKey(names[i])) {
                hashMap.put(names[i], 0);
                res[i] = names[i];
            } else {
                int k = hashMap.getOrDefault(names[i], 0) + 1;
                String newName = names[i] + "(" + k + ")";
                while (hashMap.containsKey(newName)) {
                    k++;
                    newName = names[i] + "(" + k + ")";
                }
                hashMap.put(names[i], k);
                hashMap.put(newName, 0);
                res[i] = newName;
            }
        }
        return res;
    }
}
/*
1487. 保证文件名唯一
https://leetcode.cn/problems/making-file-names-unique/

给你一个长度为 n 的字符串数组 names 。你将会在文件系统中创建 n 个文件夹：在第 i 分钟，新建名为 names[i] 的文件夹。
由于两个文件 不能 共享相同的文件名，因此如果新建文件夹使用的文件名已经被占用，系统会以 (k) 的形式为新文件夹的文件名添加后缀，其中 k 是能保证文件名唯一的 最小正整数 。
返回长度为 n 的字符串数组，其中 ans[i] 是创建第 i 个文件夹时系统分配给该文件夹的实际名称。
提示：
1 <= names.length <= 5 * 10^4
1 <= names[i].length <= 20
names[i] 由小写英文字母、数字和/或圆括号组成。

贪心，
时间复杂度 O(n)
 */