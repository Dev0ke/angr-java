import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Solution326 {
    public boolean isPowerOfThree(int n) {
        int[] nums = {1, 3, 9, 27, 81, 243, 729, 2187, 6561, 19683, 59049, 177147, 531441, 1594323, 4782969,
                14348907, 43046721, 129140163, 387420489, 1162261467};
        return Arrays.binarySearch(nums, n) >= 0;
    }

    // 打表
    public static void main(String[] args) {
        List<Long> list = new ArrayList<>();
        for (long i = 1; i <= Integer.MAX_VALUE; i *= 3) {
            list.add(i);
        }
        System.out.println(list);
    }
}
/*
326. 3的幂
https://leetcode.cn/problems/power-of-three/

给定一个整数，写一个函数来判断它是否是 3 的幂次方。如果是，返回 true ；否则，返回 false 。
整数 n 是 3 的幂次方需满足：存在整数 x 使得 n == 3^x
提示：
-2^31 <= n <= 2^31 - 1

相似题目: 231. 2 的幂
https://leetcode.cn/problems/power-of-two/
342. 4的幂
https://leetcode.cn/problems/power-of-four/
 */
