import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class SolutionP1166Tests {
    @Test
    public void example1() {
        SolutionP1166.FileSystem fileSystem = new SolutionP1166.FileSystem();

        // 返回 true
        Assertions.assertTrue(fileSystem.createPath("/leet", 1));

        // 返回 true
        Assertions.assertTrue(fileSystem.createPath("/leet/code", 2));

        // 返回 2
        Assertions.assertEquals(2, fileSystem.get("/leet/code"));

        // 返回 false 因为父路径 "/c" 不存在。
        Assertions.assertFalse(fileSystem.createPath("/c/d", 1));

        // 返回 -1 因为该路径不存在。
        Assertions.assertEquals(-1, fileSystem.get("/c"));
    }
}
