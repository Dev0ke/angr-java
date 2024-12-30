import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.List;

public class Solution429Tests {
    private final Solution429 solution429 = new Solution429();

    @Test
    public void example1() {
        Solution429.Node node1 = new Solution429.Node(1);
        Solution429.Node node2 = new Solution429.Node(2);
        Solution429.Node node3 = new Solution429.Node(3);
        Solution429.Node node4 = new Solution429.Node(4);
        Solution429.Node node5 = new Solution429.Node(5);
        Solution429.Node node6 = new Solution429.Node(6);
        node1.children = List.of(node3, node2, node4);
        node3.children = List.of(node5, node6);
        List<List<Integer>> expected = UtUtils.stringToIntegerList2("[[1],[3,2,4],[5,6]]");
        Assertions.assertEquals(expected, solution429.levelOrder(node1));
    }

    @Test
    public void example2() {
        Solution429.Node node1 = new Solution429.Node(1);
        Solution429.Node node2 = new Solution429.Node(2);
        Solution429.Node node3 = new Solution429.Node(3);
        Solution429.Node node4 = new Solution429.Node(4);
        Solution429.Node node5 = new Solution429.Node(5);
        Solution429.Node node6 = new Solution429.Node(6);
        Solution429.Node node7 = new Solution429.Node(7);
        Solution429.Node node8 = new Solution429.Node(8);
        Solution429.Node node9 = new Solution429.Node(9);
        Solution429.Node node10 = new Solution429.Node(10);
        Solution429.Node node11 = new Solution429.Node(11);
        Solution429.Node node12 = new Solution429.Node(12);
        Solution429.Node node13 = new Solution429.Node(13);
        Solution429.Node node14 = new Solution429.Node(14);
        node1.children = List.of(node2, node3, node4, node5);
        node3.children = List.of(node6, node7);
        node4.children = List.of(node8);
        node5.children = List.of(node9, node10);
        node7.children = List.of(node11);
        node8.children = List.of(node12);
        node9.children = List.of(node13);
        node11.children = List.of(node14);
        List<List<Integer>> expected = UtUtils.stringToIntegerList2("[[1],[2,3,4,5],[6,7,8,9,10],[11,12,13],[14]]");
        Assertions.assertEquals(expected, solution429.levelOrder(node1));
    }
}
