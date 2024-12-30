import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.List;

public class Solution589Tests {
    private final Solution589 solution589 = new Solution589();

    @Test
    public void example1() {
        Solution589.Node node1 = new Solution589.Node(1);
        Solution589.Node node2 = new Solution589.Node(2);
        Solution589.Node node3 = new Solution589.Node(3);
        Solution589.Node node4 = new Solution589.Node(4);
        Solution589.Node node5 = new Solution589.Node(5);
        Solution589.Node node6 = new Solution589.Node(6);
        node1.children = List.of(node3, node2, node4);
        node3.children = List.of(node5, node6);
        List<Integer> expected = List.of(1, 3, 5, 6, 2, 4);
        Assertions.assertEquals(expected, solution589.preorder(node1));
    }

    @Test
    public void example2() {
        Solution589.Node node1 = new Solution589.Node(1);
        Solution589.Node node2 = new Solution589.Node(2);
        Solution589.Node node3 = new Solution589.Node(3);
        Solution589.Node node4 = new Solution589.Node(4);
        Solution589.Node node5 = new Solution589.Node(5);
        Solution589.Node node6 = new Solution589.Node(6);
        Solution589.Node node7 = new Solution589.Node(7);
        Solution589.Node node8 = new Solution589.Node(8);
        Solution589.Node node9 = new Solution589.Node(9);
        Solution589.Node node10 = new Solution589.Node(10);
        Solution589.Node node11 = new Solution589.Node(11);
        Solution589.Node node12 = new Solution589.Node(12);
        Solution589.Node node13 = new Solution589.Node(13);
        Solution589.Node node14 = new Solution589.Node(14);
        node1.children = List.of(node2, node3, node4, node5);
        node3.children = List.of(node6, node7);
        node4.children = List.of(node8);
        node5.children = List.of(node9, node10);
        node7.children = List.of(node11);
        node8.children = List.of(node12);
        node9.children = List.of(node13);
        node11.children = List.of(node14);
        List<Integer> expected = List.of(1, 2, 3, 6, 7, 11, 14, 4, 8, 12, 5, 9, 13, 10);
        Assertions.assertEquals(expected, solution589.preorder(node1));
    }
}
