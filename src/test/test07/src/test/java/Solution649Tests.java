import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class Solution649Tests {
    private final Solution649 solution649 = new Solution649();

    @Test
    public void example1() {
        String senate = "RD";
        String expected = "Radiant";
        Assertions.assertEquals(expected, solution649.predictPartyVictory(senate));
    }

    @Test
    public void example2() {
        String senate = "RDD";
        String expected = "Dire";
        Assertions.assertEquals(expected, solution649.predictPartyVictory(senate));
    }
}