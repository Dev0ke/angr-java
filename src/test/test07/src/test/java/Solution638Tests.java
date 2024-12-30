import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.List;

public class Solution638Tests {
    private final Solution638 solution638 = new Solution638();

    @Test
    public void example1() {
        List<Integer> price = List.of(2, 5);
        List<List<Integer>> special = UtUtils.stringToIntegerList2("[[3,0,5],[1,2,10]]");
        List<Integer> needs = List.of(3, 2);
        int expected = 14;
        Assertions.assertEquals(expected, solution638.shoppingOffers(price, special, needs));
    }

    @Test
    public void example2() {
        List<Integer> price = List.of(2, 3, 4);
        List<List<Integer>> special = UtUtils.stringToIntegerList2("[[1,1,0,4],[2,2,1,9]]");
        List<Integer> needs = List.of(1, 2, 1);
        int expected = 11;
        Assertions.assertEquals(expected, solution638.shoppingOffers(price, special, needs));
    }
}