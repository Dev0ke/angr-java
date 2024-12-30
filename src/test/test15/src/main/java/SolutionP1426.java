import java.util.HashSet;
import java.util.Set;

public class SolutionP1426 {
    public int countElements(int[] arr) {
        Set<Integer> set = new HashSet<>();
        for (int x : arr) {
            set.add(x);
        }
        int cnt = 0;
        for (int x : arr) {
            if (set.contains(x + 1)) {
                cnt++;
            }
        }
        return cnt;
    }
}
/*
$1426. 数元素
https://leetcode.cn/problems/counting-elements/

给你一个整数数组 arr， 对于元素 x ，只有当 x + 1 也在数组 arr 里时，才能记为 1 个数。
如果数组 arr 里有重复的数，每个重复的数单独计算。
提示：
1 <= arr.length <= 1000
0 <= arr[i] <= 1000

HashSet模拟
 */