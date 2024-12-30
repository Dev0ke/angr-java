import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class Solution1024Tests {
    private final Solution1024 solution1024 = new Solution1024();

    @Test
    public void example1() {
        int[][] clips = UtUtils.stringToInts2("[[0,2],[4,6],[8,10],[1,9],[1,5],[5,9]]");
        int time = 10;
        int expected = 3;
        Assertions.assertEquals(expected, solution1024.videoStitching(clips, time));
    }

    @Test
    public void example2() {
        int[][] clips = UtUtils.stringToInts2("[[0,1],[1,2]]");
        int time = 5;
        int expected = -1;
        Assertions.assertEquals(expected, solution1024.videoStitching(clips, time));
    }

    @Test
    public void example3() {
        int[][] clips = UtUtils.stringToInts2("[[0,1],[6,8],[0,2],[5,6],[0,4],[0,3],[6,7],[1,3],[4,7],[1,4],[2,5],[2,6],[3,4],[4,5],[5,7],[6,9]]");
        int time = 9;
        int expected = 3;
        Assertions.assertEquals(expected, solution1024.videoStitching(clips, time));
    }
}
