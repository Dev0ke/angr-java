import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

public class Solution1948 {
    public List<List<String>> deleteDuplicateFolder(List<List<String>> paths) {
        TrieNode root = new TrieNode();
        for (List<String> path : paths) {
            TrieNode cur = root;
            for (String folder : path) {
                if (!cur.child.containsKey(folder)) {
                    cur.child.put(folder, new TrieNode());
                }
                cur = cur.child.get(folder);
            }
        }
        delete(root, new HashMap<>());
        List<List<String>> ans = new ArrayList<>();
        dfs(root, new ArrayList<>(), ans);
        return ans;
    }

    private String delete(TrieNode root, Map<String, TrieNode> map) {
        if (root.child.isEmpty()) return "";
        StringBuilder sb = new StringBuilder();
        for (Map.Entry<String, TrieNode> p : root.child.entrySet()) {
            String folder = p.getKey();
            TrieNode child = p.getValue();
            sb.append("(").append(folder).append(delete(child, map)).append(")");
        }
        String serialized = sb.toString();
        if (map.containsKey(serialized)) {// 已经存在此序列化值，两者都删除
            map.get(serialized).deleted = true;
            root.deleted = true;
        } else {
            map.put(serialized, root);
        }
        return serialized;
    }

    private void dfs(TrieNode root, List<String> path, List<List<String>> ans) {
        for (Map.Entry<String, TrieNode> p : root.child.entrySet()) {
            String folder = p.getKey();
            TrieNode child = p.getValue();
            if (child.deleted) continue;
            path.add(folder);
            dfs(child, path, ans);
            path.remove(path.size() - 1);
        }
        if (!path.isEmpty()) ans.add(new ArrayList<>(path));
    }

    static class TrieNode {
        Map<String, TrieNode> child = new TreeMap<>();
        boolean deleted;
    }
}
/*
1948. 删除系统中的重复文件夹
https://leetcode.cn/problems/delete-duplicate-folders-in-system/description/

由于一个漏洞，文件系统中存在许多重复文件夹。给你一个二维数组 paths，其中 paths[i] 是一个表示文件系统中第 i 个文件夹的绝对路径的数组。
- 例如，["one", "two", "three"] 表示路径 "/one/two/three" 。
如果两个文件夹（不需要在同一层级）包含 非空且相同的 子文件夹 集合 并具有相同的子文件夹结构，则认为这两个文件夹是相同文件夹。相同文件夹的根层级 不 需要相同。如果存在两个（或两个以上）相同 文件夹，则需要将这些文件夹和所有它们的子文件夹 标记 为待删除。
- 例如，下面文件结构中的文件夹 "/a" 和 "/b" 相同。它们（以及它们的子文件夹）应该被 全部 标记为待删除：
  - /a
  - /a/x
  - /a/x/y
  - /a/z
  - /b
  - /b/x
  - /b/x/y
  - /b/z
然而，如果文件结构中还包含路径 "/b/w" ，那么文件夹 "/a" 和 "/b" 就不相同。注意，即便添加了新的文件夹 "/b/w" ，仍然认为 "/a/x" 和 "/b/x" 相同。
一旦所有的相同文件夹和它们的子文件夹都被标记为待删除，文件系统将会 删除 所有上述文件夹。文件系统只会执行一次删除操作。执行完这一次删除操作后，不会删除新出现的相同文件夹。
返回二维数组 ans ，该数组包含删除所有标记文件夹之后剩余文件夹的路径。路径可以按 任意顺序 返回。
提示：
1 <= paths.length <= 2 * 10^4
1 <= paths[i].length <= 500
1 <= paths[i][j].length <= 10
1 <= sum(paths[i][j].length) <= 2 * 10^5
path[i][j] 由小写英文字母组成
不会存在两个路径都指向同一个文件夹的情况
对于不在根层级的任意文件夹，其父文件夹也会包含在输入中

字典树+括号表示法+哈希表
https://leetcode.cn/problems/delete-duplicate-folders-in-system/solutions/895148/zi-dian-shu-ha-xi-biao-by-endlesscheng-115r
 */