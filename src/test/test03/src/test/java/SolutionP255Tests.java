import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class SolutionP255Tests {
    private final SolutionP255 solutionP255 = new SolutionP255();

    @Test
    public void example1() {
        int[] preorder = {5, 2, 1, 3, 6};
        Assertions.assertTrue(solutionP255.verifyPreorder(preorder));
    }

    @Test
    public void example2() {
        int[] preorder = {5, 2, 6, 1, 3};
        Assertions.assertFalse(solutionP255.verifyPreorder(preorder));
    }
}
