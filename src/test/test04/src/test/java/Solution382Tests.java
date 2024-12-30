import org.junit.jupiter.api.Test;

public class Solution382Tests {
    @Test
    public void example1() {
        Solution382.Solution solution = new Solution382.Solution(ListNode.buildListNode(new int[]{1, 2, 3}));
        solution.getRandom(); // 返回 1
        solution.getRandom(); // 返回 3
        solution.getRandom(); // 返回 2
        solution.getRandom(); // 返回 2
        solution.getRandom(); // 返回 3
        // getRandom() 方法应随机返回 1、2、3中的一个，每个元素被返回的概率相等。
    }
}
