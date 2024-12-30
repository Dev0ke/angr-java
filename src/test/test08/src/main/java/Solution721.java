import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Solution721 {
    public List<List<String>> accountsMerge(List<List<String>> accounts) {
        int idx = 0;
        Map<String, Integer> emailIdxMap = new HashMap<>();
        Map<String, String> emailNameMap = new HashMap<>();
        for (List<String> account : accounts) {
            String name = account.get(0);
            for (int i = 1; i < account.size(); i++) {
                String email = account.get(i);
                emailIdxMap.putIfAbsent(email, idx++);
                emailNameMap.putIfAbsent(email, name);
            }
        }

        DSU dsu = new DSU(idx);
        for (List<String> account : accounts) {
            int firstMailIdx = emailIdxMap.get(account.get(1));
            for (int i = 2; i < account.size(); i++) {
                dsu.union(firstMailIdx, emailIdxMap.get(account.get(i)));
            }
        }

        Map<Integer, List<String>> faEmailsMap = new HashMap<>();
        for (Map.Entry<String, Integer> entry : emailIdxMap.entrySet()) {
            int fa = dsu.find(entry.getValue());
            faEmailsMap.computeIfAbsent(fa, e -> new ArrayList<>()).add(entry.getKey());
        }

        List<List<String>> ans = new ArrayList<>();
        for (List<String> emails : faEmailsMap.values()) {
            List<String> account = new ArrayList<>();
            // 每个账户的第一个元素是名称
            account.add(emailNameMap.get(emails.get(0)));
            // 其余元素是 按字符 ASCII 顺序排列 的邮箱地址
            emails.sort(null);
            account.addAll(emails);
            ans.add(account);
        }
        return ans;
    }

    static class DSU {
        int[] fa;

        public DSU(int n) {
            fa = new int[n];
            for (int i = 0; i < n; i++) {
                fa[i] = i;
            }
        }

        int find(int x) { // 查找
            return x == fa[x] ? fa[x] : (fa[x] = find(fa[x]));
        }

        void union(int p, int q) { // 合并
            p = find(p);
            q = find(q);
            if (p == q) return;
            fa[q] = p;
        }
    }
}
/*
721. 账户合并
https://leetcode.cn/problems/accounts-merge/

给定一个列表 accounts，每个元素 accounts[i] 是一个字符串列表，其中第一个元素 accounts[i][0] 是 名称 (name)，其余元素是 emails 表示该账户的邮箱地址。
现在，我们想合并这些账户。如果两个账户都有一些共同的邮箱地址，则两个账户必定属于同一个人。
请注意，即使两个账户具有相同的名称，它们也可能属于不同的人，因为人们可能具有相同的名称。一个人最初可以拥有任意数量的账户，但其所有账户都具有相同的名称。
合并账户后，按以下格式返回账户：每个账户的第一个元素是名称，其余元素是 按字符 ASCII 顺序排列 的邮箱地址。账户本身可以以 任意顺序 返回。
提示：
1 <= accounts.length <= 1000
2 <= accounts[i].length <= 10
1 <= accounts[i][j].length <= 30
accounts[i][0] 由英文字母组成
accounts[i][j] (for j > 0) 是有效的邮箱地址

并查集 + HashMap
 */