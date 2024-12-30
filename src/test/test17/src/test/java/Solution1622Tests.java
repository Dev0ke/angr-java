import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class Solution1622Tests {
    @Test
    public void example1() {
        Solution1622.Fancy fancy = new Solution1622.Fancy();

        // 奇妙序列：[2]
        fancy.append(2);

        // 奇妙序列：[2+3] -> [5]
        fancy.addAll(3);

        // 奇妙序列：[5, 7]
        fancy.append(7);

        // 奇妙序列：[5*2, 7*2] -> [10, 14]
        fancy.multAll(2);

        // 返回 10
        Assertions.assertEquals(10, fancy.getIndex(0));

        // 奇妙序列：[10+3, 14+3] -> [13, 17]
        fancy.addAll(3);

        // 奇妙序列：[13, 17, 10]
        fancy.append(10);

        // 奇妙序列：[13*2, 17*2, 10*2] -> [26, 34, 20]
        fancy.multAll(2);

        // 返回 26
        Assertions.assertEquals(26, fancy.getIndex(0));

        // 返回 34
        Assertions.assertEquals(34, fancy.getIndex(1));

        // 返回 20
        Assertions.assertEquals(20, fancy.getIndex(2));
    }
}