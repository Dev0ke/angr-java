import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class Solution1361Tests {
    private final Solution1361 solution1361 = new Solution1361();

    @Test
    public void example1() {
        int n = 4;
        int[] leftChild = {1, -1, 3, -1};
        int[] rightChild = {2, -1, -1, -1};
        Assertions.assertTrue(solution1361.validateBinaryTreeNodes(n, leftChild, rightChild));
    }

    @Test
    public void example2() {
        int n = 4;
        int[] leftChild = {1, -1, 3, -1};
        int[] rightChild = {2, 3, -1, -1};
        Assertions.assertFalse(solution1361.validateBinaryTreeNodes(n, leftChild, rightChild));
    }

    @Test
    public void example3() {
        int n = 2;
        int[] leftChild = {1, 0};
        int[] rightChild = {-1, -1};
        Assertions.assertFalse(solution1361.validateBinaryTreeNodes(n, leftChild, rightChild));
    }
}