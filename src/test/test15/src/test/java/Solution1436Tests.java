import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.List;

public class Solution1436Tests {
    private final Solution1436 solution1436 = new Solution1436();

    @Test
    public void example1() {
        List<List<String>> paths = UtUtils.stringToStringList2("""
                [["London","New York"],["New York","Lima"],["Lima","Sao Paulo"]]
                """);
        String expected = "Sao Paulo";
        Assertions.assertEquals(expected, solution1436.destCity(paths));
    }

    @Test
    public void example2() {
        List<List<String>> paths = UtUtils.stringToStringList2("""
                [["B","C"],["D","B"],["C","A"]]
                """);
        String expected = "A";
        Assertions.assertEquals(expected, solution1436.destCity(paths));
    }

    @Test
    public void example3() {
        List<List<String>> paths = UtUtils.stringToStringList2("""
                [["A","Z"]]
                """);
        String expected = "Z";
        Assertions.assertEquals(expected, solution1436.destCity(paths));
    }
}
