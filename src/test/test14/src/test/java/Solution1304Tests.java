import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.HashSet;
import java.util.Set;

public class Solution1304Tests {
    private final Solution1304 solution1304 = new Solution1304();

    boolean check(int n, int[] actual) {
        if (actual.length != n) return false;
        Set<Integer> set = new HashSet<>();
        long s = 0;
        for (int v : actual) {
            if (set.contains(v)) return false;
            set.add(v);
            s += v;
        }
        return s == 0;
    }

    @Test
    public void example1() {
        int n = 5;
        int[] expected = {-7, -1, 1, 3, 4};
        int[] actual = solution1304.sumZero(n);
        Assertions.assertTrue(check(n, actual));
    }


    @Test
    public void example2() {
        int n = 3;
        int[] expected = {-1, 0, 1};
        int[] actual = solution1304.sumZero(n);
        Assertions.assertTrue(check(n, actual));
    }

    @Test
    public void example3() {
        int n = 1;
        int[] expected = {0};
        int[] actual = solution1304.sumZero(n);
        Assertions.assertTrue(check(n, actual));
    }
}