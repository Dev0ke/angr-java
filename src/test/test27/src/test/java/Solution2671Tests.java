import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class Solution2671Tests {
    @Test
    public void example1() {
        Solution2671.FrequencyTracker frequencyTracker = new Solution2671.FrequencyTracker();

        // 数据结构现在包含 [3]
        frequencyTracker.add(3);

        // 数据结构现在包含 [3, 3]
        frequencyTracker.add(3);

        // 返回 true ，因为 3 出现 2 次
        Assertions.assertTrue(frequencyTracker.hasFrequency(2));
    }

    @Test
    public void example2() {
        Solution2671.FrequencyTracker frequencyTracker = new Solution2671.FrequencyTracker();

        // 数据结构现在包含 [1]
        frequencyTracker.add(1);

        // 数据结构现在为空 []
        frequencyTracker.deleteOne(1);

        // 返回 false ，因为数据结构为空
        Assertions.assertFalse(frequencyTracker.hasFrequency(1));
    }

    @Test
    public void example3() {
        Solution2671.FrequencyTracker frequencyTracker = new Solution2671.FrequencyTracker();

        // 返回 false ，因为数据结构为空
        frequencyTracker.hasFrequency(2);

        // 数据结构现在包含 [3]
        frequencyTracker.add(3);

        // 返回 true ，因为 3 出现 1 次
        Assertions.assertTrue(frequencyTracker.hasFrequency(1));
    }
}