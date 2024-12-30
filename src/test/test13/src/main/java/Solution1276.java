import java.util.ArrayList;
import java.util.List;

public class Solution1276 {
    public List<Integer> numOfBurgers(int tomatoSlices, int cheeseSlices) {
        int x = (tomatoSlices - cheeseSlices * 2);
        if (x < 0 || x % 2 == 1) return new ArrayList<>();
        x /= 2;
        int y = cheeseSlices - x;
        if (y < 0) return new ArrayList<>();
        return List.of(x, y);
    }
}
/*
1276. 不浪费原料的汉堡制作方案
https://leetcode.cn/problems/number-of-burgers-with-no-waste-of-ingredients/description/

圣诞活动预热开始啦，汉堡店推出了全新的汉堡套餐。为了避免浪费原料，请你帮他们制定合适的制作计划。
给你两个整数 tomatoSlices 和 cheeseSlices，分别表示番茄片和奶酪片的数目。不同汉堡的原料搭配如下：
- 巨无霸汉堡：4 片番茄和 1 片奶酪
- 小皇堡：2 片番茄和 1 片奶酪
请你以 [total_jumbo, total_small]（[巨无霸汉堡总数，小皇堡总数]）的格式返回恰当的制作方案，使得剩下的番茄片 tomatoSlices 和奶酪片 cheeseSlices 的数量都是 0。
如果无法使剩下的番茄片 tomatoSlices 和奶酪片 cheeseSlices 的数量为 0，就请返回 []。

二元一次方程求解。
设 x 个 total_jumbo, y 个 total_small，有：
4x + 2y = tomatoSlices
x + y = cheeseSlices
解得：
x = (tomatoSlices - cheeseSlices*2) / 2
时间复杂度 O(1)。
 */