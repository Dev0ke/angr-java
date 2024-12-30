import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Solution893 {
    public int numSpecialEquivGroups(String[] words) {
        List<int[][]> oddEvenList = new ArrayList<>();
        for (String word : words) {
            int[][] oddEven = new int[2][26];
            oddEven[0] = getCnt(word, false);
            oddEven[1] = getCnt(word, true);
            // 去重，类似 Set
            if (!listContainTarget(oddEvenList, oddEven)) {
                oddEvenList.add(oddEven);
            }
        }
        return oddEvenList.size();
    }

    private boolean listContainTarget(List<int[][]> list, int[][] target) {
        for (int[][] cur : list) {
            if (Arrays.deepEquals(cur, target)) {
                return true;
            }
        }
        return false;
    }

    private int[] getCnt(String str, boolean isOdd) {
        int[] oddCnt = new int[26];
        int i = isOdd ? 1 : 0;
        for (; i < str.length(); i += 2) {
            oddCnt[str.charAt(i) - 'a']++;
        }
        return oddCnt;
    }
}
/*
893. 特殊等价字符串组
https://leetcode.cn/problems/groups-of-special-equivalent-strings/

第 99 场周赛 T2。

给你一个字符串数组 words。
一步操作中，你可以交换字符串 words[i] 的任意两个偶数下标对应的字符或任意两个奇数下标对应的字符。
对两个字符串 words[i] 和 words[j] 而言，如果经过任意次数的操作，words[i] == words[j] ，那么这两个字符串是 特殊等价 的。
- 例如，words[i] = "zzxy" 和 words[j] = "xyzz" 是一对 特殊等价 字符串，因为可以按 "zzxy" -> "xzzy" -> "xyzz" 的操作路径使 words[i] == words[j] 。
现在规定，words 的 一组特殊等价字符串 就是 words 的一个同时满足下述条件的非空子集：
- 该组中的每一对字符串都是 特殊等价 的
- 该组字符串已经涵盖了该类别中的所有特殊等价字符串，容量达到理论上的最大值（也就是说，如果一个字符串不在该组中，那么这个字符串就 不会 与该组内任何字符串特殊等价）
返回 words 中 特殊等价字符串组 的数量。
提示：
1 <= words.length <= 1000
1 <= words[i].length <= 20
所有 words[i] 都只由小写字母组成。
所有 words[i] 都具有相同的长度。

经过任意次交换字符串 s 任意两个偶数下标的字符或任意两个奇数下标的字符，使字符串 s 与字符串 t 相等，s 与 t 即是特殊等价字符串
由此易得出，统计两个字符串偶数下标字符频次与奇数下标字符频次，如果相等，即为特殊等价字符串
如 abcd 被记为 [[1,0,1,0,...,0],
               [0,1,0,1,...,0]]
   cdab 被记为 [[1,0,1,0,...,0],
               [0,1,0,1,...,0]]
而 zzyx 被记为 [[0,...,0,0,1,1],
               [0,...,0,1,0,1]]
然后去重统计个数即可。
 */