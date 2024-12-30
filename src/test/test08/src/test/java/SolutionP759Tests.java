import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

public class SolutionP759Tests {
    private final SolutionP759 solutionP759 = new SolutionP759();

    @Test
    public void example1() {
        List<List<SolutionP759.Interval>> schedule = new ArrayList<>();
        schedule.add(List.of(new SolutionP759.Interval(1, 2), new SolutionP759.Interval(5, 6)));
        schedule.add(List.of(new SolutionP759.Interval(1, 3)));
        schedule.add(List.of(new SolutionP759.Interval(4, 10)));
        List<SolutionP759.Interval> expected = List.of(new SolutionP759.Interval(3, 4));
        Assertions.assertTrue(UtUtils.assertJsonEquals(expected, solutionP759.employeeFreeTime(schedule)));
    }

    @Test
    public void example2() {
        List<List<SolutionP759.Interval>> schedule = new ArrayList<>();
        schedule.add(List.of(new SolutionP759.Interval(1, 3), new SolutionP759.Interval(6, 7)));
        schedule.add(List.of(new SolutionP759.Interval(2, 4)));
        schedule.add(List.of(new SolutionP759.Interval(2, 5), new SolutionP759.Interval(9, 12)));
        List<SolutionP759.Interval> expected = List.of(new SolutionP759.Interval(5, 6), new SolutionP759.Interval(7, 9));
        Assertions.assertTrue(UtUtils.assertJsonEquals(expected, solutionP759.employeeFreeTime(schedule)));
    }
}
