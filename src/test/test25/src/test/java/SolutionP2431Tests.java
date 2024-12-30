import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class SolutionP2431Tests {
    private final SolutionP2431 solutionP2431 = new SolutionP2431();

    @Test
    public void example1() {
        int[] price = {10, 20, 20};
        int[] tastiness = {5, 8, 8};
        int maxAmount = 20;
        int maxCoupons = 1;
        int expected = 13;
        Assertions.assertEquals(expected, solutionP2431.maxTastiness(price, tastiness, maxAmount, maxCoupons));
    }

    @Test
    public void example2() {
        int[] price = {10, 15, 7};
        int[] tastiness = {5, 8, 20};
        int maxAmount = 10;
        int maxCoupons = 2;
        int expected = 28;
        Assertions.assertEquals(expected, solutionP2431.maxTastiness(price, tastiness, maxAmount, maxCoupons));
    }
}