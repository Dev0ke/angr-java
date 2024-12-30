import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class Solution138Tests {
    private final Solution138 solution138 = new Solution138();

    @Test
    public void example1() {
        Solution138.Node head = new Solution138.Node(7);
        Solution138.Node node1 = new Solution138.Node(13);
        Solution138.Node node2 = new Solution138.Node(11);
        Solution138.Node node3 = new Solution138.Node(10);
        Solution138.Node node4 = new Solution138.Node(1);
        head.next = node1;
        node1.next = node2;
        node2.next = node3;
        node3.next = node4;
        node4.next = null;
        head.random = null;
        node1.random = head;
        node2.random = node4;
        node3.random = node2;
        node4.random = head;
        Assertions.assertTrue(UtUtils.assertJsonEquals(head, solution138.copyRandomList(head)));
    }

    @Test
    public void example2() {
        Solution138.Node head = new Solution138.Node(1);
        Solution138.Node node1 = new Solution138.Node(2);
        head.next = node1;
        node1.next = null;
        head.random = node1;
        node1.random = node1;
        Assertions.assertTrue(UtUtils.assertJsonEquals(head, solution138.copyRandomList(head)));
    }

    @Test
    public void example3() {
        Solution138.Node head = new Solution138.Node(3);
        Solution138.Node node1 = new Solution138.Node(3);
        Solution138.Node node2 = new Solution138.Node(3);
        head.next = node1;
        node1.next = node2;
        node2.next = null;
        head.random = null;
        node1.random = head;
        node2.random = null;
        Assertions.assertTrue(UtUtils.assertJsonEquals(head, solution138.copyRandomList(head)));
    }

    @Test
    public void example4() {
        Solution138.Node head = null;
        Assertions.assertTrue(UtUtils.assertJsonEquals(head, solution138.copyRandomList(head)));
    }
}
