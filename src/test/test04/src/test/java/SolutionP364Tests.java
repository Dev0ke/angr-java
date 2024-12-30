import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.List;

public class SolutionP364Tests {
    private final SolutionP364 solutionP364 = new SolutionP364();

    @Test
    public void example1() {
        NestedInteger nested1 = new NestedInteger();
        NestedInteger nested1_1 = new NestedInteger(1);
        NestedInteger nested1_2 = new NestedInteger(1);
        nested1.add(nested1_1);
        nested1.add(nested1_2);
        NestedInteger nested2 = new NestedInteger(2);
        NestedInteger nested3 = new NestedInteger();
        NestedInteger nested3_1 = new NestedInteger(1);
        NestedInteger nested3_2 = new NestedInteger(1);
        nested3.add(nested3_1);
        nested3.add(nested3_2);
        NestedInteger root = new NestedInteger();
        root.add(nested1);
        root.add(nested2);
        root.add(nested3);

        List<NestedInteger> nestedList = root.getList();
        int expected = 8;
        Assertions.assertEquals(expected, solutionP364.depthSumInverse(nestedList));
    }

    @Test
    public void example2() {
        NestedInteger nested3 = new NestedInteger(6);
        NestedInteger nested2_1 = new NestedInteger(4);
        NestedInteger nested2_2 = new NestedInteger();
        nested2_2.add(nested3);
        NestedInteger nested2 = new NestedInteger();
        nested2.add(nested2_1);
        nested2.add(nested2_2);
        NestedInteger nested1 = new NestedInteger(1);
        NestedInteger root = new NestedInteger();
        root.add(nested1);
        root.add(nested2);

        List<NestedInteger> nestedList = root.getList();
        int expected = 17;
        Assertions.assertEquals(expected, solutionP364.depthSumInverse(nestedList));
    }
}