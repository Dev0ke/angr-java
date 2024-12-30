import java.util.Arrays;

public class Solution927 {
    public int[] threeEqualParts(int[] arr) {
        final int[] IMPOSSIBLE = {-1, -1};

        int sum = Arrays.stream(arr).sum();
        if (sum % 3 != 0) return IMPOSSIBLE;
        if (sum == 0) return new int[]{0, 2};

        int n = arr.length;
        int part = sum / 3;
        // 第 1 个 1 出现的位置，第 part+1 个 1 出现的位置，第 part*2+1 个 1 出现的位置
        int first = 0, second = 0, third = 0, s = 0;
        for (int i = 0; i < n; i++) {
            if (arr[i] == 0) continue;
            if (s == 0) first = i;
            else if (s == part) second = i;
            else if (s == part * 2) third = i;
            s++;
        }

        // 因为数组末尾的值是无法改变的，因此 [third, n-1] 所表示的二进制值可以唯一确定
        int len = n - third;
        if (first + len <= second && second + len <= third) {
            for (int i = 0; i + third < n; i++) {
                if (arr[i + first] != arr[i + second] || arr[i + first] != arr[i + third]) {
                    return IMPOSSIBLE;
                }
            }
            return new int[]{first + len - 1, second + len};
        }
        return IMPOSSIBLE;
    }
}
/*
927. 三等分
https://leetcode.cn/problems/three-equal-parts/description/

给定一个由 0 和 1 组成的数组 arr ，将数组分成  3 个非空的部分 ，使得所有这些部分表示相同的二进制值。
如果可以做到，请返回任何 [i, j]，其中 i+1 < j，这样一来：
- arr[0], arr[1], ..., arr[i] 为第一部分；
- arr[i + 1], arr[i + 2], ..., arr[j - 1] 为第二部分；
- arr[j], arr[j + 1], ..., arr[arr.length - 1] 为第三部分。
- 这三个部分所表示的二进制值相等。
如果无法做到，就返回 [-1, -1]。
注意，在考虑每个部分所表示的二进制时，应当将其看作一个整体。例如，[1,1,0] 表示十进制中的 6，而不会是 3。此外，前导零也是被允许的，所以 [0,1,1] 和 [1,1] 表示相同的值。
提示：
3 <= arr.length <= 3 * 10^4
arr[i] 是 0 或 1

模拟。将 1 的数量三等分，最后一段可以唯一确定这个二进制的值，再判断是否合法即可。
时间复杂度 O(n)。
 */