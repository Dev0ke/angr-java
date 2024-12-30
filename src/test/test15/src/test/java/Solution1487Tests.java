import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class Solution1487Tests {
    private final Solution1487 solution1487 = new Solution1487();

    @Test
    public void example1() {
        String[] names = {"pes", "fifa", "gta", "pes(2019)"};
        String[] expected = {"pes", "fifa", "gta", "pes(2019)"};
        Assertions.assertArrayEquals(expected, solution1487.getFolderNames(names));
    }

    @Test
    public void example2() {
        String[] names = {"gta", "gta(1)", "gta", "avalon"};
        String[] expected = {"gta", "gta(1)", "gta(2)", "avalon"};
        Assertions.assertArrayEquals(expected, solution1487.getFolderNames(names));
    }

    @Test
    public void example3() {
        String[] names = {"onepiece", "onepiece(1)", "onepiece(2)", "onepiece(3)", "onepiece"};
        String[] expected = {"onepiece", "onepiece(1)", "onepiece(2)", "onepiece(3)", "onepiece(4)"};
        Assertions.assertArrayEquals(expected, solution1487.getFolderNames(names));
    }

    @Test
    public void example4() {
        String[] names = {"wano", "wano", "wano", "wano"};
        String[] expected = {"wano", "wano(1)", "wano(2)", "wano(3)"};
        Assertions.assertArrayEquals(expected, solution1487.getFolderNames(names));
    }

    @Test
    public void example5() {
        String[] names = {"kaido", "kaido(1)", "kaido", "kaido(1)"};
        String[] expected = {"kaido", "kaido(1)", "kaido(2)", "kaido(1)(1)"};
        Assertions.assertArrayEquals(expected, solution1487.getFolderNames(names));
    }

    // 补充用例
    @Test
    public void example6() {
        // https://leetcode.cn/submissions/detail/351126084/
        // TLE
        String[] names = UtUtils.loadingStrings("solution1487-example6-input.txt", 0);
        String[] expected = UtUtils.loadingStrings("solution1487-example6-output.txt", 0);
        Assertions.assertArrayEquals(expected, solution1487.getFolderNames(names));
    }
}
