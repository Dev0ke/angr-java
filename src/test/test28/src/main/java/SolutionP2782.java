public class SolutionP2782 {
    public int numberOfCategories(int n, CategoryHandler categoryHandler) {
        int categories = 1;
        for (int i = 1; i < n; i++) {
            boolean foundSameCategory = false;
            for (int j = 0; j < i && !foundSameCategory; j++) {
                if (categoryHandler.haveSameCategory(j, i)) {
                    foundSameCategory = true;
                }
            }
            if (!foundSameCategory) {
                categories++;
            }
        }
        return categories;
    }

    // UT
    interface CategoryHandler {
        boolean haveSameCategory(int a, int b);
    }
}
/*
$2782. 唯一类别的数量
https://leetcode.cn/problems/number-of-unique-categories/description/

现给定一个整数 n 和一个 CategoryHandler 类的对象 categoryHandler 。
有 n  个元素，编号从 0 到 n - 1。每个元素都有一个类别，你的任务是找出唯一类别的数量。
CategoryHandler 类包含以下方法，可能对你有帮助：
- boolean haveSameCategory(integer a, integer b)：如果 a 和 b 属于相同的类别，则返回 true，否则返回 false。同时，如果 a 或 b 不是有效的数字（即大于等于 n 或小于 0），它也会返回 false。
返回 唯一类别的数量。
提示：
1 <= n <= 100

由于编号 0 的元素一定属于一个类别，因此将类别数量初始化为 1。
对于 1≤i<n 的每个 i，需要判断编号 i 的元素是否和至少一个编号小于 i 的元素属于相同的类别。如果编号 i 的元素和至少一个编号小于 i 的元素属于相同的类别，则类别数量不变；如果编号 i 的元素和所有编号小于 i 的元素都不属于相同的类别，则将类别数量加 1。
遍历所有的元素编号之后，即可得到不同类别的数量。
https://leetcode.cn/problems/number-of-unique-categories/solutions/2580817/2782-wei-yi-lei-bie-de-shu-liang-by-stor-xf48/
 */