import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class Solution1169 {
    public List<String> invalidTransactions(String[] transactions) {
        Set<Integer> invalidIdSet = new HashSet<>();
        Map<String, List<Node>> hashMap = new HashMap<>();

        for (int i = 0; i < transactions.length; i++) {
            Node node = new Node(i, transactions[i]);

            if (node.amount > 1000) {
                // 交易金额超过 $1000
                invalidIdSet.add(i);
            }
            // 或者，它和 另一个城市 中 同名 的另一笔交易相隔不超过 60 分钟（包含 60 分钟整）
            boolean flag = false;
            for (Node node1 : hashMap.getOrDefault(node.name, new ArrayList<>())) {
                if (!node1.city.equals(node.city)
                        && Math.abs(node1.time - node.time) <= 60) {
                    invalidIdSet.add(node1.id);
                    flag = true;
                }
            }
            if (flag) {
                invalidIdSet.add(node.id);
            }

            hashMap.computeIfAbsent(node.name, key -> new ArrayList<>()).add(node);
        }

        List<String> resList = new ArrayList<>();
        for (int id : invalidIdSet) {
            resList.add(transactions[id]);
        }
        return resList;
    }

    private static class Node {
        int id;
        String name;
        int time;
        int amount;
        String city;

        public Node(int id, String transaction) {
            this.id = id;
            String[] tuple = transaction.split(",");
            this.name = tuple[0];
            this.time = Integer.parseInt(tuple[1]);
            this.amount = Integer.parseInt(tuple[2]);
            this.city = tuple[3];
        }
    }
}
/*
1169. 查询无效交易
https://leetcode.cn/problems/invalid-transactions/

如果出现下述两种情况，交易 可能无效：
交易金额超过 $1000
或者，它和 另一个城市 中 同名 的另一笔交易相隔不超过 60 分钟（包含 60 分钟整）
给定字符串数组交易清单 transaction 。每个交易字符串 transactions[i] 由一些用逗号分隔的值组成，这些值分别表示交易的名称，时间（以分钟计），金额以及城市。
返回 transactions，返回可能无效的交易列表。你可以按 任何顺序 返回答案。
提示：
transactions.length <= 1000
每笔交易 transactions[i] 按 "{name},{time},{amount},{city}" 的格式进行记录
每个交易名称 {name} 和城市 {city} 都由小写英文字母组成，长度在 1 到 10 之间
每个交易时间 {time} 由一些数字组成，表示一个 0 到 1000 之间的整数
每笔交易金额 {amount} 由一些数字组成，表示一个 0 到 2000 之间的整数

模拟。用 HashMap 存储之前的交易
时间复杂度 O(n^2)
 */