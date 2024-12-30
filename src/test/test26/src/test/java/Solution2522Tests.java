import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class Solution2522Tests {
    private final Solution2522 solution2522 = new Solution2522();

    @Test
    public void example1() {
        String s = "165462";
        int k = 60;
        int expected = 4;
        Assertions.assertEquals(expected, solution2522.minimumPartition(s, k));
    }

    @Test
    public void example2() {
        String s = "238182";
        int k = 5;
        int expected = -1;
        Assertions.assertEquals(expected, solution2522.minimumPartition(s, k));
    }
}
