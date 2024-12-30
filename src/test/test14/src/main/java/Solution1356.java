import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Solution1356 {
    public int[] sortByBits(int[] arr) {
        List<Integer> list = Arrays.stream(arr).boxed().collect(Collectors.toList());
        list.sort((o1, o2) -> {
            int bitCount1 = Integer.bitCount(o1);
            int bitCount2 = Integer.bitCount(o2);
            if (bitCount1 == bitCount2) {
                return Integer.compare(o1, o2);
            }
            return Integer.compare(bitCount1, bitCount2);
        });
        return list.stream().mapToInt(i -> i).toArray();
    }
}
/*
1356. 根据数字二进制下 1 的数目排序
https://leetcode.cn/problems/sort-integers-by-the-number-of-1-bits/

给你一个整数数组 arr 。请你将数组中的元素按照其二进制表示中数字 1 的数目升序排序。
如果存在多个数字二进制中 1 的数目相同，则必须将它们按照数值大小升序排列。
请你返回排序后的数组。
提示：
1 <= arr.length <= 500
0 <= arr[i] <= 10^4

自定义排序。
 */