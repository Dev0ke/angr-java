import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class Solution838Tests {
    private final Solution838 solution838 = new Solution838();

    @Test
    public void example1() {
        String dominoes = "RR.L";
        String expected = "RR.L";
        Assertions.assertEquals(expected, solution838.pushDominoes(dominoes));
    }

    @Test
    public void example2() {
        String dominoes = ".L.R...LR..L..";
        String expected = "LL.RR.LLRRLL..";
        Assertions.assertEquals(expected, solution838.pushDominoes(dominoes));
    }

    @Test
    public void example3() {
        String dominoes = "RL";
        String expected = "RL";
        Assertions.assertEquals(expected, solution838.pushDominoes(dominoes));
    }
}
