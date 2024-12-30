import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class Solution591Tests {
    private final Solution591 solution591 = new Solution591();

    @Test
    public void example1() {
        String code = "<DIV>This is the first line <![CDATA[<div>]]></DIV>";
        Assertions.assertTrue(solution591.isValid(code));
    }

    @Test
    public void example2() {
        String code = "<DIV>>>  ![cdata[]] <![CDATA[<div>]>]]>]]>>]</DIV>";
        Assertions.assertTrue(solution591.isValid(code));
    }

    @Test
    public void example3() {
        String code = "<A>  <B> </A>   </B>";
        Assertions.assertFalse(solution591.isValid(code));
    }
}