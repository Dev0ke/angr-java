import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.List;

public class Solution1604Tests {
    private final Solution1604 solution1604 = new Solution1604();

    @Test
    public void example1() {
        String[] keyName = {"daniel", "daniel", "daniel", "luis", "luis", "luis", "luis"};
        String[] keyTime = {"10:00", "10:40", "11:00", "09:00", "11:00", "13:00", "15:00"};
        List<String> expected = List.of("daniel");
        Assertions.assertEquals(expected, solution1604.alertNames(keyName, keyTime));
    }

    @Test
    public void example2() {
        String[] keyName = {"alice", "alice", "alice", "bob", "bob", "bob", "bob"};
        String[] keyTime = {"12:01", "12:00", "18:00", "21:00", "21:20", "21:30", "23:00"};
        List<String> expected = List.of("bob");
        Assertions.assertEquals(expected, solution1604.alertNames(keyName, keyTime));
    }

    @Test
    public void example3() {
        String[] keyName = {"john", "john", "john"};
        String[] keyTime = {"23:58", "23:59", "00:01"};
        List<String> expected = List.of();
        Assertions.assertEquals(expected, solution1604.alertNames(keyName, keyTime));
    }

    @Test
    public void example4() {
        String[] keyName = {"leslie", "leslie", "leslie", "clare", "clare", "clare", "clare"};
        String[] keyTime = {"13:00", "13:20", "14:00", "18:00", "18:51", "19:30", "19:49"};
        List<String> expected = List.of("clare", "leslie");
        Assertions.assertEquals(expected, solution1604.alertNames(keyName, keyTime));
    }
}
