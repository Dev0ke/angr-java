import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class Solution1352Tests {
    @Test
    public void example1() {
        Solution1352.ProductOfNumbers productOfNumbers = new Solution1352.ProductOfNumbers();

        // [3]
        productOfNumbers.add(3);

        // [3,0]
        productOfNumbers.add(0);

        // [3,0,2]
        productOfNumbers.add(2);

        // [3,0,2,5]
        productOfNumbers.add(5);

        // [3,0,2,5,4]
        productOfNumbers.add(4);

        // 返回 20 。最后 2 个数字的乘积是 5 * 4 = 20
        Assertions.assertEquals(20, productOfNumbers.getProduct(2));

        // 返回 40 。最后 3 个数字的乘积是 2 * 5 * 4 = 40
        Assertions.assertEquals(40, productOfNumbers.getProduct(3));

        // 返回  0 。最后 4 个数字的乘积是 0 * 2 * 5 * 4 = 0
        Assertions.assertEquals(0, productOfNumbers.getProduct(4));

        // [3,0,2,5,4,8]
        productOfNumbers.add(8);

        // 返回 32 。最后 2 个数字的乘积是 4 * 8 = 32
        Assertions.assertEquals(32, productOfNumbers.getProduct(2));
    }
}
