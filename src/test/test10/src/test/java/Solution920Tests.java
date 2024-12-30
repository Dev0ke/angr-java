import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class Solution920Tests {
    private final Solution920.V1 solution920_v1 = new Solution920.V1();
    private final Solution920.V2 solution920_v2 = new Solution920.V2();

    @Test
    public void example1() {
        int n = 3;
        int goal = 3;
        int k = 1;
        int expected = 6;
        Assertions.assertEquals(expected, solution920_v1.numMusicPlaylists(n, goal, k));
        Assertions.assertEquals(expected, solution920_v2.numMusicPlaylists(n, goal, k));
    }

    @Test
    public void example2() {
        int n = 2;
        int goal = 3;
        int k = 0;
        int expected = 6;
        Assertions.assertEquals(expected, solution920_v1.numMusicPlaylists(n, goal, k));
        Assertions.assertEquals(expected, solution920_v2.numMusicPlaylists(n, goal, k));
    }

    @Test
    public void example3() {
        int n = 2;
        int goal = 3;
        int k = 1;
        int expected = 2;
        Assertions.assertEquals(expected, solution920_v1.numMusicPlaylists(n, goal, k));
        Assertions.assertEquals(expected, solution920_v2.numMusicPlaylists(n, goal, k));
    }
}