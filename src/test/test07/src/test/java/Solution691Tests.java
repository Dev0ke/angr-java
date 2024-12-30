import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class Solution691Tests {
    private final Solution691 solution691 = new Solution691();

    @Test
    public void example1() {
        String[] stickers = {"with", "example", "science"};
        String target = "thehat";
        int expected = 3;
        Assertions.assertEquals(expected, solution691.minStickers(stickers, target));
    }

    @Test
    public void example2() {
        String[] stickers = {"notice", "possible"};
        String target = "basicbasic";
        int expected = -1;
        Assertions.assertEquals(expected, solution691.minStickers(stickers, target));
    }
}
