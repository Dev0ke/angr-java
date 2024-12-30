import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.List;

public class Solution1311Tests {
    private final Solution1311 solution1311 = new Solution1311();

    @Test
    public void example1() {
        List<List<String>> watchedVideos = UtUtils.stringToStringList2("""
                [["A","B"],["C"],["B","C"],["D"]]
                """);
        int[][] friends = UtUtils.stringToInts2("[[1,2],[0,3],[0,3],[1,2]]");
        int id = 0;
        int level = 1;
        List<String> expected = List.of("B", "C");
        Assertions.assertEquals(expected, solution1311.watchedVideosByFriends(watchedVideos, friends, id, level));
    }

    @Test
    public void example2() {
        List<List<String>> watchedVideos = UtUtils.stringToStringList2("""
                [["A","B"],["C"],["B","C"],["D"]]
                """);
        int[][] friends = UtUtils.stringToInts2("[[1,2],[0,3],[0,3],[1,2]]");
        int id = 0;
        int level = 2;
        List<String> expected = List.of("D");
        Assertions.assertEquals(expected, solution1311.watchedVideosByFriends(watchedVideos, friends, id, level));
    }
}