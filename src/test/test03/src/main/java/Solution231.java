import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Solution231 {
    public boolean isPowerOfTwo(int n) {
        return n > 0 && (n & (n - 1)) == 0;
    }

    public boolean isPowerOfTwo2(int n) {
        int[] nums = {1, 2, 4, 8, 16, 32, 64, 128, 256, 512, 1024, 2048, 4096, 8192, 16384, 32768, 65536,
                131072, 262144, 524288, 1048576, 2097152, 4194304, 8388608, 16777216, 33554432, 67108864,
                134217728, 268435456, 536870912, 1073741824};
        return Arrays.binarySearch(nums, n) >= 0;
    }

    // 打表
    public static void main(String[] args) {
        List<Long> list = new ArrayList<>();
        for (long i = 1; i <= Integer.MAX_VALUE; i *= 2) {
            list.add(i);
        }
        System.out.println(list);
    }
}
/*
231. 2 的幂
https://leetcode.cn/problems/power-of-two/

给你一个整数 n，请你判断该整数是否是 2 的幂次方。如果是，返回 true ；否则，返回 false 。
如果存在一个整数 x 使得 n == 2^x ，则认为 n 是 2 的幂次方。
提示：
-2^31 <= n <= 2^31 - 1

相似题目: 326. 3的幂
https://leetcode.cn/problems/power-of-three/
342. 4的幂
https://leetcode.cn/problems/power-of-four/
 */