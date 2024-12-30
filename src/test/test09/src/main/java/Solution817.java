import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Solution817 {
    public int numComponents(ListNode head, int[] nums) {
        List<Integer> list = new ArrayList<>();
        while (head != null) {
            list.add(head.val);
            head = head.next;
        }

        Set<Integer> set = new HashSet<>();
        for (int v : nums) set.add(v);

        int ans = 0;
        int n = list.size();
        int i = 0;
        while (i < n) {
            // 分组循环
            int st = i;
            for (i++; i < n && set.contains(list.get(i)) == set.contains(list.get(st)); i++) {
            }
            if (set.contains(list.get(st))) ans++;
        }
        return ans;
    }
}
/*
817. 链表组件
https://leetcode.cn/problems/linked-list-components/description/

给定链表头结点 head，该链表上的每个结点都有一个 唯一的整型值 。同时给定列表 nums，该列表是上述链表中整型值的一个子集。
返回列表 nums 中组件的个数，这里对组件的定义为：链表中一段最长连续结点的值（该值必须在列表 nums 中）构成的集合。
提示：
链表中节点数为n
1 <= n <= 10^4
0 <= Node.val < n
Node.val 中所有值 不同
1 <= nums.length <= n
0 <= nums[i] < n
nums 中所有值 不同

转数组，然后分组循环。
时间复杂度 O(n)。
 */