import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.List;

public class Solution1324Tests {
    private final Solution1324 solution1324 = new Solution1324();

    @Test
    public void example1() {
        String s = "HOW ARE YOU";
        List<String> expected = List.of("HAY", "ORO", "WEU");
        Assertions.assertEquals(expected, solution1324.printVertically(s));
    }

    @Test
    public void example2() {
        String s = "TO BE OR NOT TO BE";
        List<String> expected = List.of("TBONTB", "OEROOE", "   T");
        Assertions.assertEquals(expected, solution1324.printVertically(s));
    }

    @Test
    public void example3() {
        String s = "CONTEST IS COMING";
        List<String> expected = List.of("CIC", "OSO", "N M", "T I", "E N", "S G", "T");
        Assertions.assertEquals(expected, solution1324.printVertically(s));
    }
}
