import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class Solution116Tests {
    private final Solution116 solution116 = new Solution116();

    @Test
    public void example1() {
        Solution116.Node root = new Solution116.Node(1);
        root.left = new Solution116.Node(2);
        root.right = new Solution116.Node(3);
        root.left.left = new Solution116.Node(4);
        root.left.right = new Solution116.Node(5);
        root.right.left = new Solution116.Node(6);
        root.right.right = new Solution116.Node(7);
        // expected
        Solution116.Node expected = new Solution116.Node(1);
        expected.left = new Solution116.Node(2);
        expected.right = new Solution116.Node(3);
        expected.left.left = new Solution116.Node(4);
        expected.left.right = new Solution116.Node(5);
        expected.right.left = new Solution116.Node(6);
        expected.right.right = new Solution116.Node(7);
        expected.left.next = expected.right;
        expected.left.left.next = expected.left.right;
        expected.left.right.next = expected.right.left;
        expected.right.left.next = expected.right.right;
        // actual
        Solution116.Node actual = solution116.connect(root);
        Assertions.assertTrue(UtUtils.assertJsonEquals(expected, actual));
    }
}
