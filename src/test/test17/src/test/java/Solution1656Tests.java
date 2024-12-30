import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.List;

public class Solution1656Tests {
    @Test
    public void example1() {
        Solution1656.OrderedStream os = new Solution1656.OrderedStream(5);

        // 插入 (3, "ccccc")，返回 []
        Assertions.assertEquals(List.of(), os.insert(3, "ccccc"));

        // 插入 (1, "aaaaa")，返回 ["aaaaa"]
        Assertions.assertEquals(List.of("aaaaa"), os.insert(1, "aaaaa"));

        // 插入 (2, "bbbbb")，返回 ["bbbbb", "ccccc"]
        Assertions.assertEquals(List.of("bbbbb", "ccccc"), os.insert(2, "bbbbb"));

        // 插入 (5, "eeeee")，返回 []
        Assertions.assertEquals(List.of(), os.insert(5, "eeeee"));

        // 插入 (4, "ddddd")，返回 ["ddddd", "eeeee"]
        Assertions.assertEquals(List.of("ddddd", "eeeee"), os.insert(4, "ddddd"));
    }
}