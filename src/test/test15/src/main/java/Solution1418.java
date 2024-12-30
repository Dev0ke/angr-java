import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.TreeSet;

public class Solution1418 {
    public List<List<String>> displayTable(List<List<String>> orders) {
        // foodItem 第 1 行
        TreeSet<String> foodItemTreeSet = new TreeSet<>();
        // tableNumber 第 1 列
        TreeSet<Integer> tableNumberTreeSet = new TreeSet<>();
        // foodItem:tableNumber -> cnt
        Map<String, Integer> cntMap = new HashMap<>();

        for (List<String> order : orders) {
            String customerName = order.get(0);
            String tableNumber = order.get(1);
            String foodItem = order.get(2);

            foodItemTreeSet.add(foodItem);
            // 按餐桌桌号升序排列。非字典序
            tableNumberTreeSet.add(Integer.parseInt(tableNumber));

            String key = foodItem + ":" + tableNumber;
            cntMap.put(key, cntMap.getOrDefault(key, 0) + 1);
        }

        List<List<String>> resList = new ArrayList<>();
        // 第 1 行
        List<String> line1 = new ArrayList<>();
        line1.add("Table");
        for (String food = foodItemTreeSet.first(); food != null; food = foodItemTreeSet.higher(food)) {
            line1.add(food);
        }
        resList.add(line1);

        // 第 2 行到第 N 行
        for (Integer table = tableNumberTreeSet.first(); table != null; table = tableNumberTreeSet.higher(table)) {
            List<String> list = new ArrayList<>();
            // 第 1 列
            list.add(String.valueOf(table));
            for (int i = 1; i < line1.size(); i++) {
                String food = line1.get(i);
                int cnt = cntMap.getOrDefault(food + ":" + table, 0);
                list.add(String.valueOf(cnt));
            }
            resList.add(list);
        }
        return resList;
    }
}
/*
1418. 点菜展示表
https://leetcode.cn/problems/display-table-of-food-orders-in-a-restaurant/

给你一个数组 orders，表示客户在餐厅中完成的订单，确切地说， orders[i]=[customerNamei,tableNumberi,foodItemi] ，
其中 customerNamei 是客户的姓名，tableNumberi 是客户所在餐桌的桌号，而 foodItemi 是客户点的餐品名称。
请你返回该餐厅的 点菜展示表 。在这张表中，表中第一行为标题，其第一列为餐桌桌号 “Table” ，后面每一列都是按字母顺序排列的餐品名称。
接下来每一行中的项则表示每张餐桌订购的相应餐品数量，第一列应当填对应的桌号，后面依次填写下单的餐品数量。
注意：客户姓名不是点菜展示表的一部分。此外，表中的数据行应该按餐桌桌号升序排列。
提示：
1 <= orders.length <= 5 * 10^4
orders[i].length == 3
1 <= customerNamei.length, foodItemi.length <= 20
customerNamei 和 foodItemi 由大小写英文字母及空格字符 ' ' 组成。
tableNumberi 是 1 到 500 范围内的整数。

HashMap 模拟
 */