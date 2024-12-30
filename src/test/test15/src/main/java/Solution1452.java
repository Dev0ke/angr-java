import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Solution1452 {
    public List<Integer> peopleIndexes(List<List<String>> favoriteCompanies) {
        List<Set<String>> fcSet = new ArrayList<>();
        for (List<String> fc : favoriteCompanies) {
            fcSet.add(new HashSet<>(fc));
        }

        int n = favoriteCompanies.size();
        List<Integer> ans = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            Set<String> setI = fcSet.get(i);
            boolean subset = false;
            for (int j = 0; j < n; j++) {
                if (i != j) {
                    Set<String> setJ = fcSet.get(j);
                    if (setJ.containsAll(setI)) {
                        subset = true;
                        break;
                    }
                }
            }
            if (!subset) {
                ans.add(i);
            }
        }
        return ans;
    }
}
/*
1452. 收藏清单
https://leetcode.cn/problems/people-whose-list-of-favorite-companies-is-not-a-subset-of-another-list/description/

给你一个数组 favoriteCompanies ，其中 favoriteCompanies[i] 是第 i 名用户收藏的公司清单（下标从 0 开始）。
请找出不是其他任何人收藏的公司清单的子集的收藏清单，并返回该清单下标。下标需要按升序排列。
提示：
1 <= favoriteCompanies.length <= 100
1 <= favoriteCompanies[i].length <= 500
1 <= favoriteCompanies[i][j].length <= 20
favoriteCompanies[i] 中的所有字符串 各不相同 。
用户收藏的公司清单也 各不相同 ，也就是说，即便我们按字母顺序排序每个清单， favoriteCompanies[i] != favoriteCompanies[j] 仍然成立。
所有字符串仅包含小写英文字母。

HashSet 子集判断，没必要离散化，速度提升并没有很明显
 */