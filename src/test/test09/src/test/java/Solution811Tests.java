import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

public class Solution811Tests {
    private final Solution811 solution811 = new Solution811();

    @Test
    public void example1() {
        String[] cpdomains = {"9001 discuss.leetcode.com"};
        List<String> expected = new ArrayList<>(List.of("9001 leetcode.com", "9001 discuss.leetcode.com", "9001 com"));
        List<String> actual = solution811.subdomainVisits(cpdomains);
        expected.sort(null);
        actual.sort(null);
        Assertions.assertEquals(expected, actual);
    }

    @Test
    public void example2() {
        String[] cpdomains = {"900 google.mail.com", "50 yahoo.com", "1 intel.mail.com", "5 wiki.org"};
        List<String> expected = new ArrayList<>(List.of("901 mail.com", "50 yahoo.com", "900 google.mail.com", "5 wiki.org", "5 org", "1 intel.mail.com", "951 com"));
        List<String> actual = solution811.subdomainVisits(cpdomains);
        expected.sort(null);
        actual.sort(null);
        Assertions.assertEquals(expected, actual);
    }
}
