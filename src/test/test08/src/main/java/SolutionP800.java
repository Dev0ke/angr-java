public class SolutionP800 {
    // 常规做法 枚举
    public String similarRGB(String color) {
        int[] mask = new int[3];
        mask[0] = Integer.parseInt(color.substring(1, 3), 16);
        mask[1] = Integer.parseInt(color.substring(3, 5), 16);
        mask[2] = Integer.parseInt(color.substring(5, 7), 16);

        int[] res = new int[3];
        for (int i = 0; i < 3; i++) {
            int max = Integer.MIN_VALUE;
            int x = mask[i];
            for (int j = 0; j < 16; j++) {
                int y = (j << 4) + j;
                int similar = -(x - y) * (x - y);
                if (max < similar) {
                    max = similar;
                    res[i] = y;
                }
            }
        }
        return String.format("#%02x%02x%02x", res[0], res[1], res[2]);
    }

    // 数学规律
    public String similarRGB2(String color) {
        return "#" + f(color.substring(1, 3)) + f(color.substring(3, 5)) + f(color.substring(5, 7));
    }

    private String f(String sub) {
        // 转十进制
        int dec = Integer.parseInt(sub, 16);
        // 00 ~ ff 均为 17 的倍数
        int similar = (dec / 17 + (dec % 17 > 8 ? 1 : 0)) * 17;
        return String.format("%02x", similar);
    }
}
/*
$800. 相似 RGB 颜色
https://leetcode.cn/problems/similar-rgb-color/

RGB 颜色 "#AABBCC" 可以简写成 "#ABC" 。
- 例如，"#15c" 其实是 "#1155cc" 的简写。
现在，假如我们分别定义两个颜色 "#ABCDEF" 和 "#UVWXYZ"，则他们的相似度可以通过这个表达式 -(AB - UV)^2 - (CD - WX)^2 - (EF - YZ)^2 来计算。
那么给你一个按 "#ABCDEF" 形式定义的字符串 color 表示 RGB 颜色，请你以字符串形式，返回一个与它相似度最大且可以简写的颜色。（比如，可以表示成类似 "#XYZ" 的形式）
任何 具有相同的（最大）相似度的答案都会被视为正确答案。
提示：
color.length == 7
color[0] == '#'
对于任何 i > 0，color[i] 都是一个在范围 ['0', 'f'] 内的 16 进制数

枚举 or 数学
时间复杂度 O(1)
空间复杂度 O(1)
 */