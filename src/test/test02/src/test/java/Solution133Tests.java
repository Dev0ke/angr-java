import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;

public class Solution133Tests {
    private final Solution133 solution133 = new Solution133();

    @Test
    public void example1() {
        Solution133.Node node1 = new Solution133.Node(1, new ArrayList<>());
        Solution133.Node node2 = new Solution133.Node(2, new ArrayList<>());
        Solution133.Node node3 = new Solution133.Node(3, new ArrayList<>());
        Solution133.Node node4 = new Solution133.Node(4, new ArrayList<>());
        node1.neighbors.add(node2);
        node1.neighbors.add(node4);
        node2.neighbors.add(node1);
        node2.neighbors.add(node3);
        node3.neighbors.add(node2);
        node3.neighbors.add(node4);
        node4.neighbors.add(node1);
        node4.neighbors.add(node3);
        Assertions.assertTrue(UtUtils.assertJsonEquals(node1, solution133.cloneGraph(node1)));
    }

    @Test
    public void example2() {
        Solution133.Node node1 = new Solution133.Node(1);
        Assertions.assertTrue(UtUtils.assertJsonEquals(node1, solution133.cloneGraph(node1)));
    }

    @Test
    public void example3() {
        Solution133.Node node1 = null;
        Assertions.assertTrue(UtUtils.assertJsonEquals(node1, solution133.cloneGraph(node1)));
    }

    @Test
    public void example4() {
        Solution133.Node node1 = new Solution133.Node(1, new ArrayList<>());
        Solution133.Node node2 = new Solution133.Node(2, new ArrayList<>());
        node1.neighbors.add(node2);
        node2.neighbors.add(node1);
        Assertions.assertTrue(UtUtils.assertJsonEquals(node1, solution133.cloneGraph(node1)));
    }
}
