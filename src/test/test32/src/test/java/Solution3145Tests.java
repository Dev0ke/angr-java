import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class Solution3145Tests {
    private final Solution3145 solution3145 = new Solution3145();

    @Test
    public void example1() {
        long[][] queries = UtUtils.stringToLongs2("[[1,3,7]]");
        int[] expected = {4};
        Assertions.assertArrayEquals(expected, solution3145.findProductsOfElements(queries));
    }

    @Test
    public void example2() {
        long[][] queries = UtUtils.stringToLongs2("[[2,5,3],[7,7,4]]");
        int[] expected = {2, 2};
        Assertions.assertArrayEquals(expected, solution3145.findProductsOfElements(queries));
    }
}