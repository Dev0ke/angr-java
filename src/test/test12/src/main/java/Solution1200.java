import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Solution1200 {
    public List<List<Integer>> minimumAbsDifference(int[] arr) {
        int len = arr.length;
        Arrays.sort(arr);

        int pre = arr[0];
        int diff = Integer.MAX_VALUE;
        List<List<Integer>> resList = new ArrayList<>();
        for (int i = 1; i < len; i++) {
            if (arr[i] - pre < diff) {
                diff = arr[i] - pre;
                resList.clear();
                resList.add(List.of(pre, arr[i]));
            } else if (arr[i] - pre == diff) {
                resList.add(List.of(pre, arr[i]));
            }
            pre = arr[i];
        }
        return resList;
    }
}
/*
1200. 最小绝对差
https://leetcode.cn/problems/minimum-absolute-difference/

给你个整数数组 arr，其中每个元素都 不相同。
请你找到所有具有最小绝对差的元素对，并且按升序的顺序返回。
提示：
2 <= arr.length <= 10^5
-10^6 <= arr[i] <= 10^6

排序+遍历。
 */