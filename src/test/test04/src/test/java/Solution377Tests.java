import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class Solution377Tests {
    private final Solution377 solution377 = new Solution377();

    @Test
    public void example1() {
        int[] nums = {1, 2, 3};
        int target = 4;
        int expected = 7;
        Assertions.assertEquals(expected, solution377.combinationSum4(nums, target));
    }

    @Test
    public void example2() {
        int[] nums = {9};
        int target = 3;
        int expected = 0;
        Assertions.assertEquals(expected, solution377.combinationSum4(nums, target));
    }

    // 补充用例
    @Test
    public void example3() {
        // https://leetcode.cn/problems/combination-sum-iv/submissions/554431696/
        // C++ 溢出
        int[] nums = {10, 20, 30, 40, 50, 60, 70, 80, 90, 100, 110, 120, 130, 140, 150, 160, 170, 180, 190, 200, 210, 220, 230, 240, 250, 260, 270, 280, 290, 300, 310, 320, 330, 340, 350, 360, 370, 380, 390, 400, 410, 420, 430, 440, 450, 460, 470, 480, 490, 500, 510, 520, 530, 540, 550, 560, 570, 580, 590, 600, 610, 620, 630, 640, 650, 660, 670, 680, 690, 700, 710, 720, 730, 740, 750, 760, 770, 780, 790, 800, 810, 820, 830, 840, 850, 860, 870, 880, 890, 900, 910, 920, 930, 940, 950, 960, 970, 980, 990, 111};
        int target = 999;
        int expected = 1;
        Assertions.assertEquals(expected, solution377.combinationSum4(nums, target));
    }
}
