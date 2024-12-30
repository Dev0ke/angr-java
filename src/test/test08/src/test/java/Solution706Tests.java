import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class Solution706Tests {
    @Test
    public void example1() {
        Solution706.MyHashMap myHashMap = new Solution706.MyHashMap();
        // myHashMap 现在为 [[1,1]]
        myHashMap.put(1, 1);
        // myHashMap 现在为 [[1,1], [2,2]]
        myHashMap.put(2, 2);
        // 返回 1 ，myHashMap 现在为 [[1,1], [2,2]]
        Assertions.assertEquals(1, myHashMap.get(1));
        // 返回 -1（未找到），myHashMap 现在为 [[1,1], [2,2]]
        Assertions.assertEquals(-1, myHashMap.get(3));
        // myHashMap 现在为 [[1,1], [2,1]]（更新已有的值）
        myHashMap.put(2, 1);
        // 返回 1 ，myHashMap 现在为 [[1,1], [2,1]]
        Assertions.assertEquals(1, myHashMap.get(2));
        // 删除键为 2 的数据，myHashMap 现在为 [[1,1]]
        myHashMap.remove(2);
        // 返回 -1（未找到），myHashMap 现在为 [[1,1]]
        Assertions.assertEquals(-1, myHashMap.get(2))   ;
    }
}
