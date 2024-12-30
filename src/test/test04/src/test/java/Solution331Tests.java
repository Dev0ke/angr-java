import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class Solution331Tests {
    private final Solution331 solution331 = new Solution331();

    @Test
    public void example1() {
        String preorder = "9,3,4,#,#,1,#,#,2,#,6,#,#";
        Assertions.assertTrue(solution331.isValidSerialization(preorder));
    }

    @Test
    public void example2() {
        String preorder = "1,#";
        Assertions.assertFalse(solution331.isValidSerialization(preorder));
    }

    @Test
    public void example3() {
        String preorder = "9,#,#,1";
        Assertions.assertFalse(solution331.isValidSerialization(preorder));
    }
}
