import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class Solution117Tests {
    private final Solution117 solution117 = new Solution117();

    @Test
    public void example1() {
        Solution117.Node root = new Solution117.Node(1);
        root.left = new Solution117.Node(2);
        root.right = new Solution117.Node(3);
        root.left.left = new Solution117.Node(4);
        root.left.right = new Solution117.Node(5);
        root.right.right = new Solution117.Node(7);
        // expected
        Solution117.Node expected = new Solution117.Node(1);
        expected.left = new Solution117.Node(2);
        expected.right = new Solution117.Node(3);
        expected.left.left = new Solution117.Node(4);
        expected.left.right = new Solution117.Node(5);
        expected.right.right = new Solution117.Node(7);
        expected.left.next = expected.right;
        expected.left.left.next = expected.left.right;
        expected.left.right.next = expected.right.right;
        // actual
        Solution117.Node actual = solution117.connect(root);
        Assertions.assertTrue(UtUtils.assertJsonEquals(expected, actual));
    }
}
