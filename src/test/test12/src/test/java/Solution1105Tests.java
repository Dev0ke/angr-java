import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class Solution1105Tests {
    private final Solution1105 solution1105 = new Solution1105();

    @Test
    public void example1() {
        int[][] books = UtUtils.stringToInts2("[[1,1],[2,3],[2,3],[1,1],[1,1],[1,1],[1,2]]");
        int shelfWidth = 4;
        int expected = 6;
        Assertions.assertEquals(expected, solution1105.minHeightShelves(books, shelfWidth));
    }

    @Test
    public void example2() {
        int[][] books = UtUtils.stringToInts2("[[1,3],[2,4],[3,2]]");
        int shelfWidth = 6;
        int expected = 4;
        Assertions.assertEquals(expected, solution1105.minHeightShelves(books, shelfWidth));
    }
}
