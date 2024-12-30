public class Solution771 {
    public int numJewelsInStones(String jewels, String stones) {
        int ans = 0;
        for (char c : stones.toCharArray()) {
            if (jewels.indexOf(c) != -1) ans++;
        }
        return ans;
    }
}
/*
771. 宝石与石头
https://leetcode.cn/problems/jewels-and-stones/description/

给你一个字符串 jewels 代表石头中宝石的类型，另有一个字符串 stones 代表你拥有的石头。 stones 中每个字符代表了一种你拥有的石头的类型，你想知道你拥有的石头中有多少是宝石。
字母区分大小写，因此 "a" 和 "A" 是不同类型的石头。
提示：
1 <= jewels.length, stones.length <= 50
jewels 和 stones 仅由英文字母组成
jewels 中的所有字符都是 唯一的

模拟。
时间复杂度 O(n^2)。
 */