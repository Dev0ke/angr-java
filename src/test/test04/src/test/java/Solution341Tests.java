import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

public class Solution341Tests {
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
        List<Integer> expected = List.of(1, 1, 2, 1, 1);

        Solution341.NestedIterator i = new Solution341.NestedIterator(nestedList);
        List<Integer> actual = new ArrayList<>();
        while (i.hasNext()) {
            actual.add(i.next());
        }
        Assertions.assertEquals(expected, actual);
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
        List<Integer> expected = List.of(1, 4, 6);

        Solution341.NestedIterator i = new Solution341.NestedIterator(nestedList);
        List<Integer> actual = new ArrayList<>();
        while (i.hasNext()) {
            actual.add(i.next());
        }
        Assertions.assertEquals(expected, actual);
    }
}