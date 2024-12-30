import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Solution690 {
    private Map<Integer, Employee> hashMap;

    public int getImportance(List<Employee> employees, int id) {
        hashMap = new HashMap<>();
        for (Employee employee : employees) {
            hashMap.put(employee.id, employee);
        }
        return dfs(id);
    }

    private int dfs(int id) {
        Employee employee = hashMap.get(id);
        int sum = employee.importance;
        for (int subId : employee.subordinates) {
            sum += dfs(subId);
        }
        return sum;
    }

    static class Employee {
        public int id;
        public int importance;
        public List<Integer> subordinates;
    }
}
/*
690. 员工的重要性
https://leetcode.cn/problems/employee-importance/

给定一个保存员工信息的数据结构，它包含了员工 唯一的 id ，重要度 和 直系下属的 id 。
比如，员工 1 是员工 2 的领导，员工 2 是员工 3 的领导。他们相应的重要度为 15 , 10 , 5 。那么员工 1 的数据结构是 [1, 15, [2]] ，员工 2的 数据结构是 [2, 10, [3]] ，员工 3 的数据结构是 [3, 5, []] 。注意虽然员工 3 也是员工 1 的一个下属，但是由于 并不是直系 下属，因此没有体现在员工 1 的数据结构中。
现在输入一个公司的所有员工信息，以及单个员工 id ，返回这个员工和他所有下属的重要度之和。
提示：
一个员工最多有一个 直系 领导，但是可以有多个 直系 下属
员工数量不超过 2000 。

N 叉树上 DFS 求和。
时间复杂度 O(n)
 */