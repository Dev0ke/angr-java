import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.List;

public class Solution1943Tests {
    private final Solution1943 solution1943 = new Solution1943();

    @Test
    public void example1() {
        int[][] segments = UtUtils.stringToInts2("[[1,4,5],[4,7,7],[1,7,9]]");
        List<List<Long>> expected = UtUtils.stringToLongList2("[[1,4,14],[4,7,16]]");
        Assertions.assertEquals(expected, solution1943.splitPainting(segments));
    }

    @Test
    public void example2() {
        int[][] segments = UtUtils.stringToInts2("[[1,7,9],[6,8,15],[8,10,7]]");
        List<List<Long>> expected = UtUtils.stringToLongList2("[[1,6,9],[6,7,24],[7,8,15],[8,10,7]]");
        Assertions.assertEquals(expected, solution1943.splitPainting(segments));
    }

    @Test
    public void example3() {
        int[][] segments = UtUtils.stringToInts2("[[1,4,5],[1,4,7],[4,7,1],[4,7,11]]");
        List<List<Long>> expected = UtUtils.stringToLongList2("[[1,4,12],[4,7,12]]");
        Assertions.assertEquals(expected, solution1943.splitPainting(segments));
    }
}
