import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class Solution2284Tests {
    private final Solution2284 solution2284 = new Solution2284();

    @Test
    public void example1() {
        String[] messages = {"Hello userTwooo", "Hi userThree", "Wonderful day Alice", "Nice day userThree"};
        String[] senders = {"Alice", "userTwo", "userThree", "Alice"};
        String expected = "Alice";
        Assertions.assertEquals(expected, solution2284.largestWordCount(messages, senders));
    }

    @Test
    public void example2() {
        String[] messages = {"How is leetcode for everyone", "Leetcode is useful for practice"};
        String[] senders = {"Bob", "Charlie"};
        String expected = "Charlie";
        Assertions.assertEquals(expected, solution2284.largestWordCount(messages, senders));
    }
}
