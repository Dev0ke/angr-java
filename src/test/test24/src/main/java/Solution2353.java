import java.util.HashMap;
import java.util.Map;
import java.util.TreeSet;

public class Solution2353 {
    static class FoodRatings {
        private final Map<String, Node> foodCuisineMap;
        private final Map<String, TreeSet<Node>> cuisineFoodTreeSetMap;

        public FoodRatings(String[] foods, String[] cuisines, int[] ratings) {
            foodCuisineMap = new HashMap<>();
            cuisineFoodTreeSetMap = new HashMap<>();

            int n = foods.length;
            for (int i = 0; i < n; i++) {
                Node node = new Node(foods[i], cuisines[i], ratings[i]);

                foodCuisineMap.put(foods[i], node);
                cuisineFoodTreeSetMap.computeIfAbsent(cuisines[i], key -> new TreeSet<>((o1, o2) -> {
                    // foods 中的所有字符串 互不相同
                    if (o1.food.equals(o2.food)) {
                        return 0;
                    }
                    // 如果存在并列，返回 字典序较小 的名字。
                    if (o2.rating == o1.rating) {
                        return o1.food.compareTo(o2.food);
                    }
                    // 返回指定烹饪方式 cuisine 下评分最高的食物的名字
                    return Integer.compare(o2.rating, o1.rating);
                })).add(node);
            }
        }

        public void changeRating(String food, int newRating) {
            Node node = foodCuisineMap.get(food);

            TreeSet<Node> treeSet = cuisineFoodTreeSetMap.get(node.cuisine);
            // 新值不会覆盖旧值，需删除后重新添加
            treeSet.remove(node);
            node.rating = newRating;
            treeSet.add(node);
        }

        public String highestRated(String cuisine) {
            return cuisineFoodTreeSetMap.get(cuisine).first().food;
        }

        static class Node {
            String food;
            String cuisine;
            int rating;

            public Node(String food, String cuisine, int rating) {
                this.food = food;
                this.cuisine = cuisine;
                this.rating = rating;
            }
        }
    }
}
/*
2353. 设计食物评分系统
https://leetcode.cn/problems/design-a-food-rating-system/

第 303 场周赛 T3。

设计一个支持下述操作的食物评分系统：
- 修改 系统中列出的某种食物的评分。
- 返回系统中某一类烹饪方式下评分最高的食物。
实现 FoodRatings 类：
- FoodRatings(String[] foods, String[] cuisines, int[] ratings) 初始化系统。食物由 foods、cuisines 和 ratings 描述，长度均为 n 。
 - foods[i] 是第 i 种食物的名字。
 - cuisines[i] 是第 i 种食物的烹饪方式。
 - ratings[i] 是第 i 种食物的最初评分。
- void changeRating(String food, int newRating) 修改名字为 food 的食物的评分。
- String highestRated(String cuisine) 返回指定烹饪方式 cuisine 下评分最高的食物的名字。如果存在并列，返回 字典序较小 的名字。
注意，字符串 x 的字典序比字符串 y 更小的前提是：x 在字典中出现的位置在 y 之前，
也就是说，要么 x 是 y 的前缀，或者在满足 x[i] != y[i] 的第一个位置 i 处，x[i] 在字母表中出现的位置在 y[i] 之前。
提示：
1 <= n <= 2 * 10^4
n == foods.length == cuisines.length == ratings.length
1 <= foods[i].length, cuisines[i].length <= 10
foods[i]、cuisines[i] 由小写英文字母组成
1 <= ratings[i] <= 10^8
foods 中的所有字符串 互不相同
在对 changeRating 的所有调用中，food 是系统中食物的名字。
在对 highestRated 的所有调用中，cuisine 是系统中 至少一种 食物的烹饪方式。
最多调用 changeRating 和 highestRated 总计 2 * 10^4 次

双 HashMap 模拟。
    public static void main(String[] args) {
        // 以 a 属性唯一确定对象
        TreeSet<ClassA> treeSet = new TreeSet<>(Comparator.comparing(o -> o.a));
        treeSet.add(new ClassA("aa", "bb"));
        treeSet.add(new ClassA("aa", "cc"));
        // size=1, a="aa", b="bb"
        System.out.println(treeSet.size());
    }

    static class ClassA {
        String a;
        String b;

        public ClassA(String a, String b) {
            this.a = a;
            this.b = b;
        }
    }
注意当 TreeSet 接收相同元素时，采取的策略是把新值丢弃（而非将新值覆盖旧值）。
 */