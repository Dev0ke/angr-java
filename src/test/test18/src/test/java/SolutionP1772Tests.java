import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class SolutionP1772Tests {
    private final SolutionP1772 solutionP1772 = new SolutionP1772();

    @Test
    public void example1() {
        String[] features = {"cooler", "lock", "touch"};
        String[] responses = {"i like cooler cooler", "lock touch cool", "locker like touch"};
        String[] expected = {"touch", "cooler", "lock"};
        Assertions.assertArrayEquals(expected, solutionP1772.sortFeatures(features, responses));
    }

    @Test
    public void example2() {
        String[] features = {"a", "aa", "b", "c"};
        String[] responses = {"a", "a aa", "a a a a a", "b a"};
        String[] expected = {"a", "aa", "b", "c"};
        Assertions.assertArrayEquals(expected, solutionP1772.sortFeatures(features, responses));
    }
}