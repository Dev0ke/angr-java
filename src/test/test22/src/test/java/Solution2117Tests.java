import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;

public class Solution2117Tests {
    private final Solution2117 solution2117 = new Solution2117();

    @Test
    public void example1() {
        int left = 1;
        int right = 4;
        String expected = "24e0";
        Assertions.assertEquals(expected, solution2117.abbreviateProduct(left, right));
    }

    @Test
    public void example2() {
        int left = 2;
        int right = 11;
        String expected = "399168e2";
        Assertions.assertEquals(expected, solution2117.abbreviateProduct(left, right));
    }

    @Test
    public void example3() {
        int left = 371;
        int right = 375;
        String expected = "7219856259e3";
        Assertions.assertEquals(expected, solution2117.abbreviateProduct(left, right));
    }

    @Test
    @Disabled
    public void example4() {
        int left = 256;
        int right = 65535;
        String expected = "23510...78528e16317";
        Assertions.assertEquals(expected, solution2117.abbreviateProduct(left, right));
    }

    // 补充用例
    @Test
    @Disabled
    public void example5() {
        int left = 6;
        int right = 563035;
        String expected = "78783...41888e140755";
        Assertions.assertEquals(expected, solution2117.abbreviateProduct(left, right));
    }

    @Test
    @Disabled
    public void example6() {
        int left = 18;
        int right = 237575;
        String expected = "76683...22496e59389";
        Assertions.assertEquals(expected, solution2117.abbreviateProduct(left, right));
    }

    @Test
    @Disabled
    public void example7() {
        int left = 3940;
        int right = 836328;
        String expected = "24931...02464e208096";
        Assertions.assertEquals(expected, solution2117.abbreviateProduct(left, right));
    }

    @Test
    @Disabled
    public void example8() {
        int left = 2965;
        int right = 574229;
        String expected = "89070...91968e142815";
        Assertions.assertEquals(expected, solution2117.abbreviateProduct(left, right));
    }

    @Test
    @Disabled
    public void example9() {
        int left = 6148;
        int right = 215373;
        String expected = "36552...31392e52304";
        Assertions.assertEquals(expected, solution2117.abbreviateProduct(left, right));
    }

    @Test
    @Disabled
    public void example10() {
        int left = 468620;
        int right = 595075;
        String expected = "16557...51744e31618";
        Assertions.assertEquals(expected, solution2117.abbreviateProduct(left, right));
    }
}
