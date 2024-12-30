import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class SolutionP1650Tests {
    private final SolutionP1650 solutionP1650 = new SolutionP1650();

    @Test
    public void example1() {
        SolutionP1650.Node root = new SolutionP1650.Node(3);
        root.left = new SolutionP1650.Node(5);
        root.right = new SolutionP1650.Node(1);
        root.left.parent = root;
        root.right.parent = root;
        root.left.left = new SolutionP1650.Node(6);
        root.left.right = new SolutionP1650.Node(2);
        root.left.left.parent = root.left;
        root.left.right.parent = root.left;
        root.right.left = new SolutionP1650.Node(0);
        root.right.right = new SolutionP1650.Node(8);
        root.right.left.parent = root.right;
        root.right.right.parent = root.right;
        root.left.right.left = new SolutionP1650.Node(7);
        root.left.right.right = new SolutionP1650.Node(4);
        root.left.right.left.parent = root.left.right;
        root.left.right.right.parent = root.left.right;

        SolutionP1650.Node p = root.left;
        SolutionP1650.Node q = root.right;
        SolutionP1650.Node expected = root;
        Assertions.assertTrue(UtUtils.assertJsonEquals(expected, solutionP1650.lowestCommonAncestor(p, q)));
    }

    @Test
    public void example2() {
        SolutionP1650.Node root = new SolutionP1650.Node(3);
        root.left = new SolutionP1650.Node(5);
        root.right = new SolutionP1650.Node(1);
        root.left.parent = root;
        root.right.parent = root;
        root.left.left = new SolutionP1650.Node(6);
        root.left.right = new SolutionP1650.Node(2);
        root.left.left.parent = root.left;
        root.left.right.parent = root.left;
        root.right.left = new SolutionP1650.Node(0);
        root.right.right = new SolutionP1650.Node(8);
        root.right.left.parent = root.right;
        root.right.right.parent = root.right;
        root.left.right.left = new SolutionP1650.Node(7);
        root.left.right.right = new SolutionP1650.Node(4);
        root.left.right.left.parent = root.left.right;
        root.left.right.right.parent = root.left.right;

        SolutionP1650.Node p = root.left;
        SolutionP1650.Node q = root.left.right.right;
        SolutionP1650.Node expected = root.left;
        Assertions.assertTrue(UtUtils.assertJsonEquals(expected, solutionP1650.lowestCommonAncestor(p, q)));
    }

    @Test
    public void example3() {
        SolutionP1650.Node root = new SolutionP1650.Node(1);
        root.left = new SolutionP1650.Node(2);
        root.left.parent = root;

        SolutionP1650.Node p = root;
        SolutionP1650.Node q = root.left;
        SolutionP1650.Node expected = root;
        Assertions.assertTrue(UtUtils.assertJsonEquals(expected, solutionP1650.lowestCommonAncestor(p, q)));
    }
}
