import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class Solution385Tests {
    private final Solution385 solution385 = new Solution385();

    @Test
    public void example1() {
        String s = "324";
        NestedInteger expected = new NestedInteger(324);
        NestedInteger actual = solution385.deserialize(s);
        Assertions.assertTrue(UtUtils.assertJsonEquals(expected, actual));
    }

    @Test
    public void example2() {
        String s = "[123,[456,[789]]]";
        NestedInteger nested3 = new NestedInteger(789);
        NestedInteger nested2_1 = new NestedInteger(456);
        NestedInteger nested2_2 = new NestedInteger();
        nested2_2.add(nested3);
        NestedInteger nested2 = new NestedInteger();
        nested2.add(nested2_1);
        nested2.add(nested2_2);
        NestedInteger nested1 = new NestedInteger(123);
        NestedInteger expected = new NestedInteger();
        expected.add(nested1);
        expected.add(nested2);
        NestedInteger actual = solution385.deserialize(s);
        Assertions.assertTrue(UtUtils.assertJsonEquals(expected, actual));
    }
}