import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class Solution855Tests {
    @Test
    public void example1() {
        Solution855.ExamRoom examRoom = new Solution855.ExamRoom(10);

        // 没有人在考场里，那么学生坐在 0 号座位上。
        Assertions.assertEquals(0, examRoom.seat());

        // 学生最后坐在 9 号座位上。
        Assertions.assertEquals(9, examRoom.seat());

        // 学生最后坐在 4 号座位上。
        Assertions.assertEquals(4, examRoom.seat());

        // 学生最后坐在 2 号座位上。
        Assertions.assertEquals(2, examRoom.seat());

        examRoom.leave(4);

        // 学生最后坐在 5 号座位上。
        Assertions.assertEquals(5, examRoom.seat());
    }
}
