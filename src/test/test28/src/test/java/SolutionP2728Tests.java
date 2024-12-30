import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class SolutionP2728Tests {
    static class StreetImpl implements SolutionP2728.Street {
        int[] doors;
        int n, idx;

        public StreetImpl(int[] doors) {
            this.doors = doors;
            n = doors.length;
            idx = 0;
        }

        @Override
        public void openDoor() {
            doors[idx] = 1;
        }

        @Override
        public void closeDoor() {
            doors[idx] = 0;
        }

        @Override
        public boolean isDoorOpen() {
            return doors[idx] == 1;
        }

        @Override
        public void moveRight() {
            idx = (idx + 1) % n;
        }

        @Override
        public void moveLeft() {
            idx = (idx - 1 + n) % n;
        }
    }

    private final SolutionP2728 solutionP2728 = new SolutionP2728();

    @Test
    public void example1() {
        int[] doors = {0, 0, 0, 0};
        StreetImpl street = new StreetImpl(doors);
        int k = 10;
        int expected = 4;
        Assertions.assertEquals(expected, solutionP2728.houseCount(street, k));
    }

    @Test
    public void example2() {
        int[] doors = {1, 0, 1, 1, 0};
        StreetImpl street = new StreetImpl(doors);
        int k = 5;
        int expected = 5;
        Assertions.assertEquals(expected, solutionP2728.houseCount(street, k));
    }
}