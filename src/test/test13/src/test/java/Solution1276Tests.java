import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.List;

public class Solution1276Tests {
    private final Solution1276 solution1276 = new Solution1276();

    @Test
    public void example1() {
        int tomatoSlices = 16;
        int cheeseSlices = 7;
        List<Integer> expected = List.of(1, 6);
        Assertions.assertEquals(expected, solution1276.numOfBurgers(tomatoSlices, cheeseSlices));
    }

    @Test
    public void example2() {
        int tomatoSlices = 17;
        int cheeseSlices = 4;
        List<Integer> expected = List.of();
        Assertions.assertEquals(expected, solution1276.numOfBurgers(tomatoSlices, cheeseSlices));
    }

    @Test
    public void example3() {
        int tomatoSlices = 4;
        int cheeseSlices = 17;
        List<Integer> expected = List.of();
        Assertions.assertEquals(expected, solution1276.numOfBurgers(tomatoSlices, cheeseSlices));
    }

    @Test
    public void example4() {
        int tomatoSlices = 0;
        int cheeseSlices = 0;
        List<Integer> expected = List.of(0, 0);
        Assertions.assertEquals(expected, solution1276.numOfBurgers(tomatoSlices, cheeseSlices));
    }

    @Test
    public void example5() {
        int tomatoSlices = 2;
        int cheeseSlices = 1;
        List<Integer> expected = List.of(0, 1);
        Assertions.assertEquals(expected, solution1276.numOfBurgers(tomatoSlices, cheeseSlices));
    }

    // 补充用例
    @Test
    public void example6() {
        // https://leetcode.cn/problems/number-of-burgers-with-no-waste-of-ingredients/submissions/539207574
        // WA
        int tomatoSlices = 2385088;
        int cheeseSlices = 164763;
        List<Integer> expected = List.of();
        Assertions.assertEquals(expected, solution1276.numOfBurgers(tomatoSlices, cheeseSlices));
    }
}