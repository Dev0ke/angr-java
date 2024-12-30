import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class SolutionP1826Tests {
    private final SolutionP1826 solutionP1826 = new SolutionP1826();

    @Test
    public void example1() {
        int[] sensor1 = {2, 3, 4, 5};
        int[] sensor2 = {2, 1, 3, 4};
        int expected = 1;
        Assertions.assertEquals(expected, solutionP1826.badSensor(sensor1, sensor2));
    }

    @Test
    public void example2() {
        int[] sensor1 = {2, 2, 2, 2, 2};
        int[] sensor2 = {2, 2, 2, 2, 5};
        int expected = -1;
        Assertions.assertEquals(expected, solutionP1826.badSensor(sensor1, sensor2));
    }

    @Test
    public void example3() {
        int[] sensor1 = {2, 3, 2, 2, 3, 2};
        int[] sensor2 = {2, 3, 2, 3, 2, 7};
        int expected = 2;
        Assertions.assertEquals(expected, solutionP1826.badSensor(sensor1, sensor2));
    }
}