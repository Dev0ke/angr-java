public class SolutionP3062 {
    public String gameResult(ListNode head) {
        int odd = 0, even = 0;
        while (head != null) {
            int e = head.val;
            head = head.next;
            int o = head.val;
            head = head.next;

            if (e > o) even++;
            else if (e < o) odd++;
        }
        if (odd == even) return "Tie";
        return even > odd ? "Even" : "Odd";
    }
}
/*
$3062. 链表游戏的获胜者
https://leetcode.cn/problems/winner-of-the-linked-list-game/description/

给定长度为 偶数 ，包含整数的链表的 head 节点。
每个 奇数编号 的节点包含一个奇数，并且每个 偶数编号 的节点包含一个偶数。
我们把每个偶数编号的节点和它的下一个节点叫做一个 对，例如编号为 0 和 1 的节点是一对，编号为 2 和 3 的节点是一对，以此类推。
对于每个 对，我们比较对中节点的值：
- 如果奇数节点更大，"Odd" 队得一分。
- 如果偶数节点更大，"Even" 队得一分。
返回分数更 高 的队名，如果分数相同，返回 "Tie"。
提示：
链表中节点的数字在范围 [2, 100] 内。
链表中的节点数为偶数。
1 <= Node.val <= 100
每个奇数编号节点的值都是奇数。
每个偶数编号节点的值都是偶数。

模拟。
时间复杂度 O(n)。
 */