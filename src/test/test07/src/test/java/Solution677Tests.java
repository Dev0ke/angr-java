import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class Solution677Tests {
    @Test
    public void example1() {
        Solution677.MapSum mapSum = new Solution677.MapSum();
        mapSum.insert("apple", 3);
        // return 3 (apple = 3)
        Assertions.assertEquals(3, mapSum.sum("ap"));
        mapSum.insert("app", 2);
        // return 5 (apple + app = 3 + 2 = 5)
        Assertions.assertEquals(5, mapSum.sum("ap"));
    }
}
