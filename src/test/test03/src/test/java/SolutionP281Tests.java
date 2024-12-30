import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

public class SolutionP281Tests {
    @Test
    public void example1() {
        List<Integer> v1 = List.of(1, 2);
        List<Integer> v2 = List.of(3, 4, 5, 6);
        List<Integer> expected = List.of(1, 3, 2, 4, 5, 6);
        SolutionP281.ZigzagIterator i = new SolutionP281.ZigzagIterator(v1, v2);
        List<Integer> actual = new ArrayList<>();
        while (i.hasNext()) {
            actual.add(i.next());
        }
        Assertions.assertEquals(expected, actual);
    }
}
