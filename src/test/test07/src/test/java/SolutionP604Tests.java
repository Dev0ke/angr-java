import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class SolutionP604Tests {
    @Test
    public void example1() {
        SolutionP604.StringIterator stringIterator = new SolutionP604.StringIterator("L1e2t1C1o1d1e1");

        // 返回 "L"
        Assertions.assertEquals('L', stringIterator.next());

        // 返回 "e"
        Assertions.assertEquals('e', stringIterator.next());

        // 返回 "e"
        Assertions.assertEquals('e', stringIterator.next());

        // 返回 "t"
        Assertions.assertEquals('t', stringIterator.next());

        // 返回 "C"
        Assertions.assertEquals('C', stringIterator.next());

        // 返回 "o"
        Assertions.assertEquals('o', stringIterator.next());

        // 返回 True
        Assertions.assertTrue(stringIterator.hasNext());

        // 返回 "d"
        Assertions.assertEquals('d', stringIterator.next());

        // 返回 True
        Assertions.assertTrue(stringIterator.hasNext());
    }
}