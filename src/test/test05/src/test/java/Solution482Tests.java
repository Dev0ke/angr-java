import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class Solution482Tests {
    private final Solution482 solution482 = new Solution482();

    @Test
    public void example1() {
        String s = "5F3Z-2e-9-w";
        int k = 4;
        String expected = "5F3Z-2E9W";
        Assertions.assertEquals(expected, solution482.licenseKeyFormatting(s, k));
    }

    @Test
    public void example2() {
        String s = "2-5g-3-J";
        int k = 2;
        String expected = "2-5G-3J";
        Assertions.assertEquals(expected, solution482.licenseKeyFormatting(s, k));
    }
}

