import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class Solution881Tests {
    private final Solution881 solution881 = new Solution881();

    @Test
    public void example1() {
        int[] people = {1, 2};
        int limit = 3;
        int expected = 1;
        Assertions.assertEquals(expected, solution881.numRescueBoats(people, limit));
    }

    @Test
    public void example2() {
        int[] people = {3, 2, 2, 1};
        int limit = 3;
        int expected = 3;
        Assertions.assertEquals(expected, solution881.numRescueBoats(people, limit));
    }

    @Test
    public void example3() {
        int[] people = {3, 5, 3, 4};
        int limit = 5;
        int expected = 4;
        Assertions.assertEquals(expected, solution881.numRescueBoats(people, limit));
    }
}
