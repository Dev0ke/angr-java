import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class Solution2409Tests {
    private final Solution2409 solution2409 = new Solution2409();

    @Test
    public void example1() {
        String arriveAlice = "08-15";
        String leaveAlice = "08-18";
        String arriveBob = "08-16";
        String leaveBob = "08-19";
        int expected = 3;
        Assertions.assertEquals(expected, solution2409.countDaysTogether(arriveAlice, leaveAlice, arriveBob, leaveBob));
    }

    @Test
    public void example2() {
        String arriveAlice = "10-01";
        String leaveAlice = "10-31";
        String arriveBob = "11-01";
        String leaveBob = "12-31";
        int expected = 0;
        Assertions.assertEquals(expected, solution2409.countDaysTogether(arriveAlice, leaveAlice, arriveBob, leaveBob));
    }
}
