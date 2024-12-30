import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class SolutionP2689Tests {
    private final SolutionP2689 solutionP2689 = new SolutionP2689();

    @Test
    public void example1() {
        // 输入：root = [10,4,"abcpoe","g","rta"], k = 6
        SolutionP2689.RopeTreeNode root = new SolutionP2689.RopeTreeNode(10);
        root.left = new SolutionP2689.RopeTreeNode(4);
        root.left.left = new SolutionP2689.RopeTreeNode("g");
        root.left.right = new SolutionP2689.RopeTreeNode("rta");
        root.right = new SolutionP2689.RopeTreeNode("abcpoe");
        int k = 6;
        char expected = 'b';
        Assertions.assertEquals(expected, solutionP2689.getKthCharacter(root, k));
    }

    @Test
    public void example2() {
        // 输入：root = [12,6,6,"abc","efg","hij","klm"], k = 3
        SolutionP2689.RopeTreeNode root = new SolutionP2689.RopeTreeNode(12);
        root.left = new SolutionP2689.RopeTreeNode(6);
        root.left.left = new SolutionP2689.RopeTreeNode("abc");
        root.left.right = new SolutionP2689.RopeTreeNode("efg");
        root.right = new SolutionP2689.RopeTreeNode(6);
        root.right.left = new SolutionP2689.RopeTreeNode("hij");
        root.right.right = new SolutionP2689.RopeTreeNode("klm");
        int k = 3;
        char expected = 'c';
        Assertions.assertEquals(expected, solutionP2689.getKthCharacter(root, k));
    }

    @Test
    public void example3() {
        // 输入：root = ["ropetree"], k = 8
        SolutionP2689.RopeTreeNode root = new SolutionP2689.RopeTreeNode("ropetree");
        int k = 8;
        char expected = 'e';
        Assertions.assertEquals(expected, solutionP2689.getKthCharacter(root, k));
    }
}