import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class SolutionP1243 {
    public List<Integer> transformArray(int[] arr) {
        int n = arr.length;
        int[] arrCopy = arr.clone();
        for (int i = 1; i <= n - 2; i++) {
            if (arr[i] > arrCopy[i - 1] && arr[i] > arrCopy[i + 1]) {
                arr[i]--;
            } else if (arr[i] < arrCopy[i - 1] && arr[i] < arrCopy[i + 1]) {
                arr[i]++;
            }
        }
        if (Arrays.equals(arr, arrCopy)) {
            return Arrays.stream(arr).boxed().collect(Collectors.toList());
        }
        return transformArray(arr);
    }
}
/*
$1243. 数组变换
https://leetcode.cn/problems/array-transformation/

首先，给你一个初始数组 arr。然后，每天你都要根据前一天的数组生成一个新的数组。
第 i 天所生成的数组，是由你对第 i-1 天的数组进行如下操作所得的：
1. 假如一个元素小于它的左右邻居，那么该元素自增 1。
2. 假如一个元素大于它的左右邻居，那么该元素自减 1。
3. 首、尾元素 永不 改变。
过些时日，你会发现数组将会不再发生变化，请返回最终所得到的数组。
提示：
1 <= arr.length <= 100
1 <= arr[i] <= 100

暴力模拟
 */