import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class Solution911Tests {
    @Test
    public void example1() {
        int[] persons = {0, 1, 1, 0, 0, 1, 0};
        int[] times = {0, 5, 10, 15, 20, 25, 30};
        Solution911.TopVotedCandidate topVotedCandidate = new Solution911.TopVotedCandidate(persons, times);
        // 返回 0 ，在时刻 3 ，票数分布为 [0] ，编号为 0 的候选人领先。
        Assertions.assertEquals(0, topVotedCandidate.q(3));
        // 返回 1 ，在时刻 12 ，票数分布为 [0,1,1] ，编号为 1 的候选人领先。
        Assertions.assertEquals(1, topVotedCandidate.q(12));
        // 返回 1 ，在时刻 25 ，票数分布为 [0,1,1,0,0,1] ，编号为 1 的候选人领先。（在平局的情况下，1 是最近获得投票的候选人）。
        Assertions.assertEquals(1, topVotedCandidate.q(25));
        // 返回 0
        Assertions.assertEquals(0, topVotedCandidate.q(15));
        // 返回 0
        Assertions.assertEquals(0, topVotedCandidate.q(24));
        // 返回 1
        Assertions.assertEquals(1, topVotedCandidate.q(8));
    }
}
