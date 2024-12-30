public class Solution2601 {
//    private static final int MAX_N = 1000;
    private static final int[] PRIMES = {0, 2, 3, 5, 7, 11, 13, 17, 19, 23, 29, 31, 37, 41, 43, 47, 53, 59, 61, 67, 71, 73, 79, 83, 89, 97, 101, 103, 107, 109, 113, 127, 131, 137, 139, 149, 151, 157, 163, 167, 173, 179, 181, 191, 193, 197, 199, 211, 223, 227, 229, 233, 239, 241, 251, 257, 263, 269, 271, 277, 281, 283, 293, 307, 311, 313, 317, 331, 337, 347, 349, 353, 359, 367, 373, 379, 383, 389, 397, 401, 409, 419, 421, 431, 433, 439, 443, 449, 457, 461, 463, 467, 479, 487, 491, 499, 503, 509, 521, 523, 541, 547, 557, 563, 569, 571, 577, 587, 593, 599, 601, 607, 613, 617, 619, 631, 641, 643, 647, 653, 659, 661, 673, 677, 683, 691, 701, 709, 719, 727, 733, 739, 743, 751, 757, 761, 769, 773, 787, 797, 809, 811, 821, 823, 827, 829, 839, 853, 857, 859, 863, 877, 881, 883, 887, 907, 911, 919, 929, 937, 941, 947, 953, 967, 971, 977, 983, 991, 997};

    public boolean primeSubOperation(int[] nums) {
//        List<Integer> primes = new ArrayList<>();
//        boolean[] isPrime = new boolean[MAX_N];
//        Arrays.fill(isPrime, true);
//        for (int i = 2; i < MAX_N; i++) {
//            if (isPrime[i]) {
//                primes.add(i);
//            }
//            for (int j = 0; j < primes.size() && i * primes.get(j) < MAX_N; j++) {
//                isPrime[i * primes.get(j)] = false;
//                if (i % primes.get(j) == 0) {
//                    break;
//                }
//            }
//        }
//        System.out.println(primes);

        int n = nums.length;
        int reduce0 = binarySearch(nums[0]);
        nums[0] -= reduce0;
        for (int i = 1; i < n; i++) {
            int d = nums[i] - nums[i - 1];
            if (d <= 0) {
                return false;
            }
            int reduce = binarySearch(d);
            nums[i] -= reduce;
        }
        return true;
    }

    // 返回严格小于 num 的质数，不存在返回 -1
    private int binarySearch(int num) {
        int left = 1;
        int right = PRIMES.length;
        while (left < right) {
            int mid = left + (right - left) / 2;
            // 边界二分 F, F,..., F, [T, T,..., T]
            // ----------------------^
            if (!(PRIMES[mid] < num)) {
                right = mid;
            } else {
                left = mid + 1;
            }
        }
        return PRIMES[left - 1];
    }
}
/*
2601. 质数减法运算
https://leetcode.cn/problems/prime-subtraction-operation/

第 338 场周赛 T2。

给你一个下标从 0 开始的整数数组 nums ，数组长度为 n 。
你可以执行无限次下述运算：
- 选择一个之前未选过的下标 i ，并选择一个 严格小于 nums[i] 的质数 p ，从 nums[i] 中减去 p 。
如果你能通过上述运算使得 nums 成为严格递增数组，则返回 true ；否则返回 false 。
严格递增数组 中的每个元素都严格大于其前面的元素。

贪心 + 素数筛 + 遍历
 */