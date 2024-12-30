import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class Solution705Tests {
    @Test
    public void example1() {
        Solution705.MyHashSet myHashSet = new Solution705.MyHashSet();
        // set = [1]
        myHashSet.add(1);
        // set = [1, 2]
        myHashSet.add(2);
        // 返回 True
        Assertions.assertTrue(myHashSet.contains(1));
        // 返回 False ，（未找到）
        Assertions.assertFalse(myHashSet.contains(3));
        // set = [1, 2]
        myHashSet.add(2);
        // 返回 True
        Assertions.assertTrue(myHashSet.contains(2));
        // set = [1]
        myHashSet.remove(2);
        // 返回 False ，（已移除）
        Assertions.assertFalse(myHashSet.contains(2));
    }
}
