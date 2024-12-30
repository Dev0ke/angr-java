import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class SolutionP346Tests {
    @Test
    public void example1() {
        SolutionP346.MovingAverage movingAverage = new SolutionP346.MovingAverage(3);
        Assertions.assertEquals(1.0, movingAverage.next(1));
        Assertions.assertEquals(5.5, movingAverage.next(10));
        Assertions.assertEquals(4.666666666666667, movingAverage.next(3));
        Assertions.assertEquals(6.0, movingAverage.next(5));
    }
}
