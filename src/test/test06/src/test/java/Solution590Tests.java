import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.List;

public class Solution590Tests {
    private final Solution590 solution590 = new Solution590();

    @Test
    public void example1() {
        Solution590.Node node1 = new Solution590.Node(1);
        Solution590.Node node2 = new Solution590.Node(2);
        Solution590.Node node3 = new Solution590.Node(3);
        Solution590.Node node4 = new Solution590.Node(4);
        Solution590.Node node5 = new Solution590.Node(5);
        Solution590.Node node6 = new Solution590.Node(6);
        node1.children = List.of(node3, node2, node4);
        node3.children = List.of(node5, node6);
        List<Integer> expected = List.of(5, 6, 3, 2, 4, 1);
        Assertions.assertEquals(expected, solution590.postorder(node1));
    }

    @Test
    public void example2() {
        Solution590.Node node1 = new Solution590.Node(1);
        Solution590.Node node2 = new Solution590.Node(2);
        Solution590.Node node3 = new Solution590.Node(3);
        Solution590.Node node4 = new Solution590.Node(4);
        Solution590.Node node5 = new Solution590.Node(5);
        Solution590.Node node6 = new Solution590.Node(6);
        Solution590.Node node7 = new Solution590.Node(7);
        Solution590.Node node8 = new Solution590.Node(8);
        Solution590.Node node9 = new Solution590.Node(9);
        Solution590.Node node10 = new Solution590.Node(10);
        Solution590.Node node11 = new Solution590.Node(11);
        Solution590.Node node12 = new Solution590.Node(12);
        Solution590.Node node13 = new Solution590.Node(13);
        Solution590.Node node14 = new Solution590.Node(14);
        node1.children = List.of(node2, node3, node4, node5);
        node3.children = List.of(node6, node7);
        node4.children = List.of(node8);
        node5.children = List.of(node9, node10);
        node7.children = List.of(node11);
        node8.children = List.of(node12);
        node9.children = List.of(node13);
        node11.children = List.of(node14);
        List<Integer> expected = List.of(2, 6, 14, 11, 7, 3, 12, 8, 4, 13, 9, 10, 5, 1);
        Assertions.assertEquals(expected, solution590.postorder(node1));
    }
}
