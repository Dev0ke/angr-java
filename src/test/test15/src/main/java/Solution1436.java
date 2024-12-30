import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Solution1436 {
    public String destCity(List<List<String>> paths) {
        Set<String> cityAiSet = new HashSet<>();
        Set<String> cityBiSet = new HashSet<>();
        for (List<String> path : paths) {
            cityAiSet.add(path.get(0));
            cityBiSet.add(path.get(1));
        }
        cityBiSet.removeAll(cityAiSet);
        if (cityBiSet.size() == 1) {
            return new ArrayList<>(cityBiSet).get(0);
        }
        return "";
    }
}
/*
1436. 旅行终点站
https://leetcode.cn/problems/destination-city/

第 187 场周赛 T1。

给你一份旅游线路图，该线路图中的旅行线路用数组 paths 表示，其中 paths[i] = [cityAi, cityBi] 表示该线路将会从 cityAi 直接前往 cityBi 。
请你找出这次旅行的终点站，即没有任何可以通往其他城市的线路的城市。
题目数据保证线路图会形成一条不存在循环的线路，因此恰有一个旅行终点站。
提示：
1 <= paths.length <= 100
paths[i].length == 2
1 <= cityAi.length, cityBi.length <= 10
cityAi != cityBi
所有字符串均由大小写英文字母和空格字符组成。

构造 cityAi、cityBi 两个集合，终点站存在于 cityBi 中且不存在于 cityAi 中。
 */