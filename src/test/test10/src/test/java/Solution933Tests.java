import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class Solution933Tests {
    @Test
    public void example1() {
        Solution933.RecentCounter recentCounter = new Solution933.RecentCounter();
        Assertions.assertEquals(1, recentCounter.ping(1));
        Assertions.assertEquals(2, recentCounter.ping(1000));
        Assertions.assertEquals(3, recentCounter.ping(3001));
        Assertions.assertEquals(3, recentCounter.ping(3002));
    }
}
