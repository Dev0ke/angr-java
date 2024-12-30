import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class Solution1845Tests {
    @Test
    public void example1() {
        // 初始化 SeatManager ，有 5 个座位。
        Solution1845.SeatManager seatManager = new Solution1845.SeatManager(5);
        // 所有座位都可以预约，所以返回最小编号的座位，也就是 1 。
        Assertions.assertEquals(1, seatManager.reserve());
        // 可以预约的座位为 [2,3,4,5] ，返回最小编号的座位，也就是 2 。
        Assertions.assertEquals(2, seatManager.reserve());
        // 将座位 2 变为可以预约，现在可预约的座位为 [2,3,4,5] 。
        seatManager.unreserve(2);
        // 可以预约的座位为 [2,3,4,5] ，返回最小编号的座位，也就是 2 。
        Assertions.assertEquals(2, seatManager.reserve());
        // 可以预约的座位为 [3,4,5] ，返回最小编号的座位，也就是 3 。
        Assertions.assertEquals(3, seatManager.reserve());
        // 可以预约的座位为 [4,5] ，返回最小编号的座位，也就是 4 。
        Assertions.assertEquals(4, seatManager.reserve());
        // 唯一可以预约的是座位 5 ，所以返回 5 。
        Assertions.assertEquals(5, seatManager.reserve());
        // 将座位 5 变为可以预约，现在可预约的座位为 [5] 。
        seatManager.unreserve(5);
    }
}
