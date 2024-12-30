import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class Solution354Tests {
    private final Solution354 solution354 = new Solution354();

    @Test
    public void example1() {
        int[][] envelopes = UtUtils.stringToInts2("[[5,4],[6,4],[6,7],[2,3]]");
        int expected = 3;
        Assertions.assertEquals(expected, solution354.maxEnvelopes(envelopes));
    }

    @Test
    public void example2() {
        int[][] envelopes = UtUtils.stringToInts2("[[1,1],[1,1],[1,1]]");
        int expected = 1;
        Assertions.assertEquals(expected, solution354.maxEnvelopes(envelopes));
    }
}
