import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class Solution929Tests {
    private final Solution929 solution929 = new Solution929();

    @Test
    public void example1() {
        String[] emails = {"test.email+alex@leetcode.com", "test.e.mail+bob.cathy@leetcode.com", "testemail+david@lee.tcode.com"};
        int expected = 2;
        Assertions.assertEquals(expected, solution929.numUniqueEmails(emails));
    }

    @Test
    public void example2() {
        String[] emails = {"a@leetcode.com", "b@leetcode.com", "c@leetcode.com"};
        int expected = 3;
        Assertions.assertEquals(expected, solution929.numUniqueEmails(emails));
    }
}
