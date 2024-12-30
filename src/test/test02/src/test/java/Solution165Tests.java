import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class Solution165Tests {
    private final Solution165 solution165 = new Solution165();

    @Test
    public void example1() {
        String version1 = "1.01";
        String version2 = "1.001";
        int expected = 0;
        Assertions.assertEquals(expected, solution165.compareVersion(version1, version2));
    }

    @Test
    public void example2() {
        String version1 = "1.0";
        String version2 = "1.0.0";
        int expected = 0;
        Assertions.assertEquals(expected, solution165.compareVersion(version1, version2));
    }

    @Test
    public void example3() {
        String version1 = "0.1";
        String version2 = "1.1";
        int expected = -1;
        Assertions.assertEquals(expected, solution165.compareVersion(version1, version2));
    }
}
