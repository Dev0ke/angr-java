import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.List;

public class SolutionP444Tests {
    private final SolutionP444 solutionP444 = new SolutionP444();

    @Test
    public void example1() {
        int[] org = {1, 2, 3};
        List<List<Integer>> seqs = UtUtils.stringToIntegerList2("[[1,2],[1,3]]");
        Assertions.assertFalse(solutionP444.sequenceReconstruction(org, seqs));
    }

    @Test
    public void example2() {
        int[] org = {1, 2, 3};
        List<List<Integer>> seqs = UtUtils.stringToIntegerList2("[[1,2]]");
        Assertions.assertFalse(solutionP444.sequenceReconstruction(org, seqs));
    }

    @Test
    public void example3() {
        int[] org = {1, 2, 3};
        List<List<Integer>> seqs = UtUtils.stringToIntegerList2("[[1,2],[1,3],[2,3]]");
        Assertions.assertTrue(solutionP444.sequenceReconstruction(org, seqs));
    }

    @Test
    public void example4() {
        int[] org = {4, 1, 5, 2, 6, 3};
        List<List<Integer>> seqs = UtUtils.stringToIntegerList2("[[5,2,6,3],[4,1,5,2]]");
        Assertions.assertTrue(solutionP444.sequenceReconstruction(org, seqs));
    }

    // 补充用例
    @Test
    public void example5() {
        // https://leetcode.cn/submissions/detail/239183089/
        int[] org = {1};
        List<List<Integer>> seqs = UtUtils.stringToIntegerList2("[[1,1]]");
        Assertions.assertFalse(solutionP444.sequenceReconstruction(org, seqs));
    }

    @Test
    public void example6() {
        // https://leetcode.cn/submissions/detail/239226122/
        int[] org = {3, 2, 1};
        List<List<Integer>> seqs = UtUtils.stringToIntegerList2("[[1,2],[1,3],[2,3]]");
        Assertions.assertFalse(solutionP444.sequenceReconstruction(org, seqs));
    }
}