import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class Solution1345Tests {
    private final Solution1345 solution1345 = new Solution1345();

    @Test
    public void example1() {
        int[] arr = {100, -23, -23, 404, 100, 23, 23, 23, 3, 404};
        int expected = 3;
        Assertions.assertEquals(expected, solution1345.minJumps(arr));
    }

    @Test
    public void example2() {
        int[] arr = {7};
        int expected = 0;
        Assertions.assertEquals(expected, solution1345.minJumps(arr));
    }

    @Test
    public void example3() {
        int[] arr = {7, 6, 9, 6, 9, 6, 9, 7};
        int expected = 1;
        Assertions.assertEquals(expected, solution1345.minJumps(arr));
    }

    @Test
    public void example4() {
        int[] arr = {6, 1, 9};
        int expected = 2;
        Assertions.assertEquals(expected, solution1345.minJumps(arr));
    }

    @Test
    public void example5() {
        int[] arr = {11, 22, 7, 7, 7, 7, 7, 7, 7, 22, 13};
        int expected = 3;
        Assertions.assertEquals(expected, solution1345.minJumps(arr));
    }

    // 补充用例
    @Test
    public void example6() {
        int[] arr = UtUtils.loadingInts("solution1345-example6-input.txt", 0);
        int expected = 2;
        Assertions.assertEquals(expected, solution1345.minJumps(arr));
    }
}
