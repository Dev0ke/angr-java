import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class Solution2086Tests {
    private final Solution2086 solution2086 = new Solution2086();

    @Test
    public void example1() {
        String street = "H..H";
        int expected = 2;
        Assertions.assertEquals(expected, solution2086.minimumBuckets(street));
    }

    @Test
    public void example2() {
        String street = ".H.H.";
        int expected = 1;
        Assertions.assertEquals(expected, solution2086.minimumBuckets(street));
    }

    @Test
    public void example3() {
        String street = ".HHH.";
        int expected = -1;
        Assertions.assertEquals(expected, solution2086.minimumBuckets(street));
    }

    @Test
    public void example4() {
        String street = "H";
        int expected = -1;
        Assertions.assertEquals(expected, solution2086.minimumBuckets(street));
    }

    @Test
    public void example5() {
        String street = ".";
        int expected = 0;
        Assertions.assertEquals(expected, solution2086.minimumBuckets(street));
    }

    // 补充用例
    @Test
    public void example6() {
        String street = ".HH.H.H.H..";
        int expected = 3;
        Assertions.assertEquals(expected, solution2086.minimumBuckets(street));
    }
}
