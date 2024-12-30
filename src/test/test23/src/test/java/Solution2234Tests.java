import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class Solution2234Tests {
    private final Solution2234 solution2234 = new Solution2234();

    @Test
    public void example1() {
        int[] flowers = {1, 3, 1, 1};
        long newFlowers = 7;
        int target = 6;
        int full = 12;
        int partial = 1;
        long expected = 14;
        Assertions.assertEquals(expected, solution2234.maximumBeauty(flowers, newFlowers, target, full, partial));
    }

    @Test
    public void example2() {
        int[] flowers = {2, 4, 5, 3};
        long newFlowers = 10;
        int target = 5;
        int full = 2;
        int partial = 6;
        long expected = 30;
        Assertions.assertEquals(expected, solution2234.maximumBeauty(flowers, newFlowers, target, full, partial));
    }

    // 补充用例
    @Test
    public void example3() {
        // https://leetcode.cn/submissions/detail/297683919/
        int[] flowers = {18, 16, 10, 10, 5};
        long newFlowers = 10;
        int target = 3;
        int full = 15;
        int partial = 4;
        long expected = 75;
        Assertions.assertEquals(expected, solution2234.maximumBeauty(flowers, newFlowers, target, full, partial));
    }

    @Test
    public void example4() {
        // https://leetcode.cn/submissions/detail/297688199/
        int[] flowers = {5, 5, 15, 1, 9};
        long newFlowers = 36;
        int target = 12;
        int full = 9;
        int partial = 2;
        long expected = 58;
        Assertions.assertEquals(expected, solution2234.maximumBeauty(flowers, newFlowers, target, full, partial));
    }

    @Test
    public void example5() {
        // https://leetcode.cn/submissions/detail/297810635/
        // 69 / 77 个通过测试用例 TLE
        String fileName = "solution2234-example5-input.txt";
        int[] flowers = UtUtils.loadingInts(fileName, 0);
        long newFlowers = UtUtils.loadingLong(fileName, 1);
        int target = UtUtils.loadingInt(fileName, 2);
        int full = UtUtils.loadingInt(fileName, 3);
        int partial = UtUtils.loadingInt(fileName, 4);
        long expected = 4527585163L;
        Assertions.assertEquals(expected, solution2234.maximumBeauty(flowers, newFlowers, target, full, partial));
    }

    @Test
    public void example6() {
        // https://leetcode.cn/submissions/detail/321504855/
        // 63 / 77 个通过测试用例
        int[] flowers = new int[]{89287, 5538, 37141, 72522, 84502, 44451, 24432, 2324, 72779, 57060, 99178, 6, 29440, 53664, 76197, 46742, 17384, 22072, 33067, 66274, 19323, 72943, 12914, 91475, 96826, 84847, 28100, 89590, 34977, 74052, 4813, 24563, 97491, 71687, 8533, 49262, 2265, 10553, 63902, 19647, 27006, 64548, 89892, 64046, 72766, 34623, 17297, 21417, 70630, 93469, 83379, 19483, 93842, 65968, 28401, 1889, 24441, 99401, 37907, 13794, 3640, 95432, 36875, 10200, 95360, 10829, 96763, 15900, 8490, 68972, 52537, 72458, 95269};
        long newFlowers = 42;
        int target = 4534;
        int full = 32415;
        int partial = 11040;
        long expected = 2734140;
        Assertions.assertEquals(expected, solution2234.maximumBeauty(flowers, newFlowers, target, full, partial));
    }
}

