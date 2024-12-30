import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class Solution1109Tests {
    private final Solution1109 solution1109 = new Solution1109();

    @Test
    public void example1() {
        int[][] bookings = UtUtils.stringToInts2("[[1,2,10],[2,3,20],[2,5,25]]");
        int n = 5;
        int[] expected = {10, 55, 45, 25, 25};
        Assertions.assertArrayEquals(expected, solution1109.corpFlightBookings(bookings, n));
    }

    @Test
    public void example2() {
        int[][] bookings = UtUtils.stringToInts2("[[1,2,10],[2,2,15]]");
        int n = 2;
        int[] expected = {10, 25};
        Assertions.assertArrayEquals(expected, solution1109.corpFlightBookings(bookings, n));
    }
}
