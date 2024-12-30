import org.junit.jupiter.api.Test;

public class Solution710Tests {
    @Test
    public void example1() {
        int n = 7;
        int[] blacklist = {2, 3, 5};
        Solution710.Solution solution = new Solution710.Solution(n, blacklist);
        solution.pick(); // 返回0，任何[0,1,4,6]的整数都可以。注意，对于每一个pick的调用，
        // 0、1、4和6的返回概率必须相等(即概率为1/4)。
        solution.pick(); // 返回 4
        solution.pick(); // 返回 1
        solution.pick(); // 返回 6
        solution.pick(); // 返回 1
        solution.pick(); // 返回 0
        solution.pick(); // 返回 4
    }
}
