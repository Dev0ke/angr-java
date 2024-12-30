import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.List;

public class Solution969Tests {
    private final Solution969 solution969 = new Solution969();

    @Test
    public void example1() {
        int[] arr = {3, 2, 4, 1};
        int[] actual = {3, 2, 4, 1};
        int[] expected = {1, 2, 3, 4};
        List<Integer> kList = solution969.pancakeSort(arr);
        for (int k : kList) {
            reverse(actual, k);
        }
        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    public void example2() {
        int[] arr = {1, 2, 3};
        int[] actual = {1, 2, 3};
        int[] expected = {1, 2, 3};
        List<Integer> kList = solution969.pancakeSort(arr);
        for (int k : kList) {
            reverse(actual, k);
        }
        Assertions.assertArrayEquals(expected, actual);
    }

    private void reverse(int[] arr, int k) {
        for (int i = 0, j = k - 1; i < j; i++, j--) {
            int tmp = arr[i];
            arr[i] = arr[j];
            arr[j] = tmp;
        }
    }
}
