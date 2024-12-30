import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.List;

public class Solution763Tests {
    private final Solution763 solution763 = new Solution763();

    @Test
    public void example1() {
        String s = "ababcbacadefegdehijhklij";
        List<Integer> expected = List.of(9, 7, 8);
        Assertions.assertEquals(expected, solution763.partitionLabels(s));
    }
}
