import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class Solution2418Tests {
    private final Solution2418 solution2418 = new Solution2418();

    @Test
    public void example1() {
        String[] names = {"Mary", "John", "Emma"};
        int[] heights = {180, 165, 170};
        String[] expected = {"Mary", "Emma", "John"};
        Assertions.assertArrayEquals(expected, solution2418.sortPeople(names, heights));
    }

    @Test
    public void example2() {
        String[] names = {"Alice", "Bob", "Bob"};
        int[] heights = {155, 185, 150};
        String[] expected = {"Bob", "Alice", "Bob"};
        Assertions.assertArrayEquals(expected, solution2418.sortPeople(names, heights));
    }
}
