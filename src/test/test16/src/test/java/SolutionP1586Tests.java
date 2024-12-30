import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class SolutionP1586Tests {
    @Test
    public void example1() {
        TreeNode root = TreeNode.buildTreeNode("[7,3,15,null,null,9,20]");

        // 划线的元素表示指针当前的位置。
        // 当前状态为 <u> </u> [3, 7, 9, 15, 20]
        SolutionP1586.BSTIterator bSTIterator = new SolutionP1586.BSTIterator(root);

        // 状态变为 [<u>3</u>, 7, 9, 15, 20], 返回 3
        Assertions.assertEquals(3, bSTIterator.next());

        // 状态变为 [3, <u>7</u>, 9, 15, 20], 返回 7
        Assertions.assertEquals(7, bSTIterator.next());

        // 状态变为 [<u>3</u>, 7, 9, 15, 20], 返回 3
        Assertions.assertEquals(3, bSTIterator.prev());

        // 状态变为 [3, <u>7</u>, 9, 15, 20], 返回 7
        Assertions.assertEquals(7, bSTIterator.next());

        // 返回 true
        Assertions.assertTrue(bSTIterator.hasNext());

        // 状态变为 [3, 7, <u>9</u>, 15, 20], 返回 9
        Assertions.assertEquals(9, bSTIterator.next());

        // 状态变为 [3, 7, 9, <u>15</u>, 20], 返回 15
        Assertions.assertEquals(15, bSTIterator.next());

        // 状态变为 [3, 7, 9, 15, <u>20</u>], 返回 20
        Assertions.assertEquals(20, bSTIterator.next());

        // 返回 false
        Assertions.assertFalse(bSTIterator.hasNext());

        // 返回 true
        Assertions.assertTrue(bSTIterator.hasPrev());

        // 状态变为 [3, 7, 9, <u>15</u>, 20], 返回 15
        Assertions.assertEquals(15, bSTIterator.prev());

        // 状态变为 [3, 7, <u>9</u>, 15, 20], 返回 9
        Assertions.assertEquals(9, bSTIterator.prev());
    }
}
