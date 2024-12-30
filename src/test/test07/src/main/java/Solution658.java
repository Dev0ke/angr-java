import java.util.Arrays;
import java.util.List;

public class Solution658 {
    public List<Integer> findClosestElements(int[] arr, int k, int x) {
        return Arrays.stream(arr)
                .boxed()
                .sorted((o1, o2) -> o1.equals(o2) ? 0 : Math.abs(o1 - x) - Math.abs(o2 - x))
                .toList()
                .subList(0, k)
                .stream()
                .sorted()
                .toList();
    }
}
/*
658. 找到 K 个最接近的元素
https://leetcode.cn/problems/find-k-closest-elements/

从数组中找到最靠近 x（两数之差最小）的 k 个数。返回的结果必须要是按升序排好的。
一个 lambda 搞定。-x 后按绝对值升序排序，取前 k 个，再升序排序
提示：
1 <= k <= arr.length
1 <= arr.length <= 10^4
arr 按 升序 排列
-10^4 <= arr[i], x <= 10^4
 */