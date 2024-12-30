import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

public class SolutionP582Tests {
    private final SolutionP582 solutionP582 = new SolutionP582();

    @Test
    public void example1() {
        List<Integer> pid = List.of(1, 3, 10, 5);
        List<Integer> ppid = List.of(3, 0, 5, 3);
        int kill = 5;
        List<Integer> expected = new ArrayList<>(List.of(5, 10));
        List<Integer> actual = solutionP582.killProcess(pid, ppid, kill);
        expected.sort(null);
        actual.sort(null);
        Assertions.assertEquals(expected, actual);
    }

    @Test
    public void example2() {
        List<Integer> pid = List.of(1);
        List<Integer> ppid = List.of(0);
        int kill = 1;
        List<Integer> expected = new ArrayList<>(List.of(1));
        List<Integer> actual = solutionP582.killProcess(pid, ppid, kill);
        expected.sort(null);
        actual.sort(null);
        Assertions.assertEquals(expected, actual);
    }
}
