import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class Solution864Tests {
    private final Solution864 solution864 = new Solution864();

    @Test
    public void example1() {
        String[] grid = {"@.a.#", "###.#", "b.A.B"};
        int expected = 8;
        Assertions.assertEquals(expected, solution864.shortestPathAllKeys(grid));
    }

    @Test
    public void example2() {
        String[] grid = {"@..aA", "..B#.", "....b"};
        int expected = 6;
        Assertions.assertEquals(expected, solution864.shortestPathAllKeys(grid));
    }

    @Test
    public void example3() {
        String[] grid = {"@Aa"};
        int expected = -1;
        Assertions.assertEquals(expected, solution864.shortestPathAllKeys(grid));
    }
}
