import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Set;

public class Solution2512 {
    public List<Integer> topStudents(String[] positive_feedback, String[] negative_feedback, String[] report, int[] student_id, int k) {
        Set<String> postiveSet = new HashSet<>();
        Set<String> negativeSet = new HashSet<>();
        Collections.addAll(postiveSet, positive_feedback);
        Collections.addAll(negativeSet, negative_feedback);
        // id, 分数
        PriorityQueue<int[]> maxHeap = new PriorityQueue<>((o1, o2) -> {
            // 如果有多名学生分数相同，ID 越小排名越前。
            if (o1[1] == o2[1]) {
                return Integer.compare(o1[0], o2[0]);
            }
            return Integer.compare(o2[1], o1[1]);
        });
        int n = report.length;
        for (int i = 0; i < n; i++) {
            int score = 0;
            for (String x : report[i].split(" ")) {
                if (postiveSet.contains(x)) {
                    score += 3;
                }
                if (negativeSet.contains(x)) {
                    score -= 1;
                }
            }
            maxHeap.add(new int[]{student_id[i], score});
        }

        List<Integer> resList = new ArrayList<>();
        for (int i = 0; i < k; i++) {
            resList.add(maxHeap.remove()[0]);
        }
        return resList;
    }
}
/*
2512. 奖励最顶尖的 K 名学生
https://leetcode.cn/problems/reward-top-k-students/

第 94 场双周赛 T2。

给你两个字符串数组 positive_feedback 和 negative_feedback ，分别包含表示正面的和负面的词汇。不会 有单词同时是正面的和负面的。
一开始，每位学生分数为 0 。每个正面的单词会给学生的分数 加 3 分，每个负面的词会给学生的分数 减  1 分。
给你 n 个学生的评语，用一个下标从 0 开始的字符串数组 report 和一个下标从 0 开始的整数数组 student_id 表示，其中 student_id[i] 表示这名学生的 ID ，这名学生的评语是 report[i] 。每名学生的 ID 互不相同。
给你一个整数 k ，请你返回按照得分 从高到低 最顶尖的 k 名学生。如果有多名学生分数相同，ID 越小排名越前。
提示：
1 <= positive_feedback.length, negative_feedback.length <= 10^4
1 <= positive_feedback[i].length, negative_feedback[j].length <= 100
positive_feedback[i] 和 negative_feedback[j] 都只包含小写英文字母。
positive_feedback 和 negative_feedback 中不会有相同单词。
n == report.length == student_id.length
1 <= n <= 10^4
report[i] 只包含小写英文字母和空格 ' ' 。
report[i] 中连续单词之间有单个空格隔开。
1 <= report[i].length <= 100
1 <= student_id[i] <= 10^9
student_id[i] 的值 互不相同 。
1 <= k <= n

模拟。先算出每个学生的分数，然后就是经典 top k 问题，用堆处理即可。
 */