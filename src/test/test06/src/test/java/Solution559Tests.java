import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.List;

public class Solution559Tests {
    private final Solution559 solution559 = new Solution559();

    @Test
    public void example1() {
        Solution559.Node node1 = new Solution559.Node(1);
        Solution559.Node node2 = new Solution559.Node(2);
        Solution559.Node node3 = new Solution559.Node(3);
        Solution559.Node node4 = new Solution559.Node(4);
        Solution559.Node node5 = new Solution559.Node(5);
        Solution559.Node node6 = new Solution559.Node(6);
        node1.children = List.of(node3, node2, node4);
        node3.children = List.of(node5, node6);
        int expected = 3;
        Assertions.assertEquals(expected, solution559.maxDepth(node1));
    }

    @Test
    public void example2() {
        Solution559.Node node1 = new Solution559.Node(1);
        Solution559.Node node2 = new Solution559.Node(2);
        Solution559.Node node3 = new Solution559.Node(3);
        Solution559.Node node4 = new Solution559.Node(4);
        Solution559.Node node5 = new Solution559.Node(5);
        Solution559.Node node6 = new Solution559.Node(6);
        Solution559.Node node7 = new Solution559.Node(7);
        Solution559.Node node8 = new Solution559.Node(8);
        Solution559.Node node9 = new Solution559.Node(9);
        Solution559.Node node10 = new Solution559.Node(10);
        Solution559.Node node11 = new Solution559.Node(11);
        Solution559.Node node12 = new Solution559.Node(12);
        Solution559.Node node13 = new Solution559.Node(13);
        Solution559.Node node14 = new Solution559.Node(14);
        node1.children = List.of(node2, node3, node4, node5);
        node3.children = List.of(node6, node7);
        node4.children = List.of(node8);
        node5.children = List.of(node9, node10);
        node7.children = List.of(node11);
        node8.children = List.of(node12);
        node9.children = List.of(node13);
        node11.children = List.of(node14);
        int expected = 5;
        Assertions.assertEquals(expected, solution559.maxDepth(node1));
    }
}
