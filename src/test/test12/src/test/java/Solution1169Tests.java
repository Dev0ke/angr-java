import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

public class Solution1169Tests {
    private final Solution1169 solution1169 = new Solution1169();

    @Test
    public void example1() {
        String[] transactions = {"alice,20,800,mtv", "alice,50,100,beijing"};
        List<String> expected = new ArrayList<>(List.of("alice,20,800,mtv", "alice,50,100,beijing"));
        List<String> actual = solution1169.invalidTransactions(transactions);
        expected.sort(null);
        actual.sort(null);
        Assertions.assertEquals(expected, actual);
    }

    @Test
    public void example2() {
        String[] transactions = {"alice,20,800,mtv", "alice,50,1200,mtv"};
        List<String> expected = new ArrayList<>(List.of("alice,50,1200,mtv"));
        List<String> actual = solution1169.invalidTransactions(transactions);
        expected.sort(null);
        actual.sort(null);
        Assertions.assertEquals(expected, actual);
    }

    @Test
    public void example3() {
        String[] transactions = {"alice,20,800,mtv", "bob,50,1200,mtv"};
        List<String> expected = new ArrayList<>(List.of("bob,50,1200,mtv"));
        List<String> actual = solution1169.invalidTransactions(transactions);
        expected.sort(null);
        actual.sort(null);
        Assertions.assertEquals(expected, actual);
    }
}
