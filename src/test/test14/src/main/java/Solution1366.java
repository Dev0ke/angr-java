import java.util.ArrayList;
import java.util.List;

public class Solution1366 {
    public String rankTeams(String[] votes) {
        int m = votes.length;
        int n = votes[0].length();

        // 只有一个投票者，所以排名完全按照他的意愿。
        if (m == 1) {
            return votes[0];
        }

        // 预处理
        int[][] cntArr = new int[n][26];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                cntArr[j][votes[i].charAt(j) - 'A']++;
            }
        }

        // 转化为下标进行排序
        List<Integer> chList = new ArrayList<>();
        for (char ch : votes[0].toCharArray()) {
            chList.add(ch - 'A');
        }
        chList.sort((o1, o2) -> {
            for (int i = 0; i < n; i++) {
                if (cntArr[i][o1] != cntArr[i][o2]) {
                    return Integer.compare(cntArr[i][o2], cntArr[i][o1]);
                }
            }
            return Integer.compare(o1, o2);
        });

        // => String
        StringBuilder stringBuilder = new StringBuilder();
        for (int ch : chList) {
            stringBuilder.append((char) (ch + 'A'));
        }
        return stringBuilder.toString();
    }
}
/*
1366. 通过投票对团队排名
https://leetcode.cn/problems/rank-teams-by-votes/

现在有一个特殊的排名系统，依据参赛团队在投票人心中的次序进行排名，每个投票者都需要按从高到低的顺序对参与排名的所有团队进行排位。
排名规则如下：
- 参赛团队的排名次序依照其所获「排位第一」的票的多少决定。如果存在多个团队并列的情况，将继续考虑其「排位第二」的票的数量。以此类推，直到不再存在并列的情况。
- 如果在考虑完所有投票情况后仍然出现并列现象，则根据团队字母的字母顺序进行排名。
给你一个字符串数组 votes 代表全体投票者给出的排位情况，请你根据上述排名规则对所有参赛团队进行排名。
请你返回能表示按排名系统 排序后 的所有团队排名的字符串。
提示：
1 <= votes.length <= 1000
1 <= votes[i].length <= 26
votes[i].length == votes[j].length for 0 <= i, j < votes.length
votes[i][j] 是英文 大写 字母
votes[i] 中的所有字母都是唯一的
votes[0] 中出现的所有字母 同样也 出现在 votes[j] 中，其中 1 <= j < votes.length

组合排序
时间复杂度 O(26n + n^2 * logn)
空间复杂度 O(n^2)
 */