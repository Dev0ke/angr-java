import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class Solution963Tests {
    private final Solution963 solution963 = new Solution963();
    // 与真实值误差不超过 10^-5 的答案将视为正确结果。
    private static final double DELTA = 1e-5;

    @Test
    public void example1() {
        int[][] points = UtUtils.stringToInts2("[[1,2],[2,1],[1,0],[0,1]]");
        double expected = 2.00000;
        Assertions.assertEquals(expected, solution963.minAreaFreeRect(points), DELTA);
    }

    @Test
    public void example2() {
        int[][] points = UtUtils.stringToInts2("[[0,1],[2,1],[1,1],[1,0],[2,0]]");
        double expected = 1.00000;
        Assertions.assertEquals(expected, solution963.minAreaFreeRect(points), DELTA);
    }

    @Test
    public void example3() {
        int[][] points = UtUtils.stringToInts2("[[0,3],[1,2],[3,1],[1,3],[2,1]]");
        double expected = 0.00000;
        Assertions.assertEquals(expected, solution963.minAreaFreeRect(points), DELTA);
    }

    @Test
    public void example4() {
        int[][] points = UtUtils.stringToInts2("[[3,1],[1,1],[0,1],[2,1],[3,3],[3,2],[0,2],[2,3]]");
        double expected = 2.00000;
        Assertions.assertEquals(expected, solution963.minAreaFreeRect(points), DELTA);
    }

    // 补充用例
    @Test
    public void example5() {
        // https://leetcode.cn/problems/minimum-area-rectangle-ii/submissions/521079171/
        int[][] points = UtUtils.stringToInts2("[[30873,25136],[13895,30360],[23900,31375],[32012,19441],[10055,26760],[21332,8049],[29945,13240],[14864,30873],[27548,10639],[19225,32000],[13071,29828],[17384,31737],[9127,25136],[23367,8456],[12452,29361],[22960,8345],[30360,26105],[8000,20775],[8015,20980],[31655,22960],[26105,30360],[29828,13071],[29135,12180],[31440,23705],[26929,29828],[8697,24104],[15375,31100],[7988,20559],[8263,22616],[30176,13593],[9640,26105],[12785,29620],[22616,31737],[29361,12452],[8560,23705],[31737,17384],[31780,22415],[31951,21332],[22415,31780],[12180,29135],[32000,20775],[23367,31544],[26407,30176],[26407,9824],[19020,31985],[13593,30176],[8220,22415],[30176,26407],[15896,31303],[27820,29135]]");
        double expected = 33665042.00000;
        Assertions.assertEquals(expected, solution963.minAreaFreeRect(points), DELTA);
    }
}