import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class Solution732Tests {
    @Test
    public void example1() {
        Solution732.MyCalendarThree myCalendarThree = new Solution732.MyCalendarThree();
        // 返回 1 ，第一个日程安排可以预订并且不存在相交，所以最大 k 次预订是 1 次预订。
        Assertions.assertEquals(1, myCalendarThree.book(10, 20));
        // 返回 1 ，第二个日程安排可以预订并且不存在相交，所以最大 k 次预订是 1 次预订。
        Assertions.assertEquals(1, myCalendarThree.book(50, 60));
        // 返回 2 ，第三个日程安排 [10, 40) 与第一个日程安排相交，所以最大 k 次预订是 2 次预订。
        Assertions.assertEquals(2, myCalendarThree.book(10, 40));
        // 返回 3 ，剩下的日程安排的最大 k 次预订是 3 次预订。
        Assertions.assertEquals(3, myCalendarThree.book(5, 15));
        // 返回 3
        Assertions.assertEquals(3, myCalendarThree.book(5, 10));
        // 返回 3
        Assertions.assertEquals(3, myCalendarThree.book(25, 55));
    }
}
