import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class SolutionP251Tests {
    @Test
    public void example1() {
        int[][] vec = UtUtils.stringToInts2("[[1,2],[3],[4]]");
        SolutionP251.Vector2D iterator = new SolutionP251.Vector2D(vec);
        // 返回 1
        Assertions.assertEquals(1, iterator.next());
        // 返回 2
        Assertions.assertEquals(2, iterator.next());
        // 返回 3
        Assertions.assertEquals(3, iterator.next());
        // 返回 true
        Assertions.assertTrue(iterator.hasNext());
        // 返回 true
        Assertions.assertTrue(iterator.hasNext());
        // 返回 4
        Assertions.assertEquals(4, iterator.next());
        // 返回 false
        Assertions.assertFalse(iterator.hasNext());
    }
}
