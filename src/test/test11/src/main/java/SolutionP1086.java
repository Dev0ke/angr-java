import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

public class SolutionP1086 {
    public int[][] highFive(int[][] items) {
        // result 需要按 IDj  递增的 顺序排列 。
        TreeMap<Integer, List<Integer>> idScoresMap = new TreeMap<>();
        for (int[] item : items) {
            List<Integer> idList = idScoresMap.getOrDefault(item[0], new ArrayList<>());
            idList.add(item[1]);
            idScoresMap.put(item[0], idList);
        }
        int resLen = idScoresMap.size();
        int[][] res = new int[resLen][2];
        int idx = 0;
        for (Map.Entry<Integer, List<Integer>> entry : idScoresMap.entrySet()) {
            List<Integer> idList = entry.getValue();
            int average = idList.stream()
                    .sorted(Comparator.reverseOrder())
                    .limit(5)
                    .mapToInt(i -> i)
                    .sum() / 5;
            res[idx++] = new int[]{entry.getKey(), average};
        }
        return res;
    }
}
/*
$1086. 前五科的均分
https://leetcode.cn/problems/high-five/

第 2 场双周赛 T2。

给你一个不同学生的分数列表 items，其中 items[i] = [IDi, scorei] 表示 IDi 的学生的一科分数，你需要计算每个学生 最高的五科 成绩的 平均分。
返回答案 result 以数对数组形式给出，其中 result[j] = [IDj, topFiveAveragej] 表示 IDj 的学生和他 最高的五科 成绩的 平均分。result 需要按 IDj  递增的 顺序排列 。
学生 最高的五科 成绩的 平均分 的计算方法是将最高的五科分数相加，然后用 整数除法 除以 5 。
提示：
1 <= items.length <= 1000
items[i].length == 2
1 <= IDi <= 1000
0 <= scorei <= 100
对于每个 IDi，至少 存在五个分数

模拟。
 */