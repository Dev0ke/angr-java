import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class Solution234Tests {
    private final Solution234 solution234 = new Solution234();

    @Test
    public void example1() {
        ListNode head = ListNode.buildListNode(new int[]{1, 2, 2, 1});
        Assertions.assertTrue(solution234.isPalindrome(head));
    }

    @Test
    public void example2() {
        ListNode head = ListNode.buildListNode(new int[]{1, 2});
        Assertions.assertFalse(solution234.isPalindrome(head));
    }

    // 补充用例
    @Test
    public void example3() {
        ListNode head = ListNode.buildListNode(new int[]{1, 0, 1});
        Assertions.assertTrue(solution234.isPalindrome(head));
    }
}
