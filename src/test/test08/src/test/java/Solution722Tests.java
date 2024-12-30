import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.List;

public class Solution722Tests {
    private final Solution722 solution722 = new Solution722();

    @Test
    public void example1() {
        String[] source = {
                "/*Test program */", "int main()", "{ ", "  // variable declaration ", "int a, b, c;", "/* This is a test", "   multiline  ", "   comment for ", "   testing */", "a = b + c;", "}"
        };
        List<String> expected = List.of("int main()", "{ ", "  ", "int a, b, c;", "a = b + c;", "}");
        Assertions.assertEquals(expected, solution722.removeComments(source));
    }

    @Test
    public void example2() {
        String[] source = {
                "a/*comment", "line", "more_comment*/b"
        };
        List<String> expected = List.of("ab");
        Assertions.assertEquals(expected, solution722.removeComments(source));
    }
}
