import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class Solution1592Tests {
    private final Solution1592 solution1592 = new Solution1592();

    @Test
    public void example1() {
        String text = "  this   is  a sentence ";
        String expected = "this   is   a   sentence";
        Assertions.assertEquals(expected, solution1592.reorderSpaces(text));
    }

    @Test
    public void example2() {
        String text = " practice   makes   perfect";
        String expected = "practice   makes   perfect ";
        Assertions.assertEquals(expected, solution1592.reorderSpaces(text));
    }

    @Test
    public void example3() {
        String text = "hello   world";
        String expected = "hello   world";
        Assertions.assertEquals(expected, solution1592.reorderSpaces(text));
    }

    @Test
    public void example4() {
        String text = "  walks  udp package   into  bar a";
        String expected = "walks  udp  package  into  bar  a ";
        Assertions.assertEquals(expected, solution1592.reorderSpaces(text));
    }

    @Test
    public void example5() {
        String text = "a";
        String expected = "a";
        Assertions.assertEquals(expected, solution1592.reorderSpaces(text));
    }
}
