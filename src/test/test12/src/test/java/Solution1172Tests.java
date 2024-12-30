import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class Solution1172Tests {
    @Test
    public void example1() {
        // 初始化，栈最大容量 capacity = 2
        Solution1172.DinnerPlates D = new Solution1172.DinnerPlates(2);
        D.push(1);
        D.push(2);
        D.push(3);
        D.push(4);
        D.push(5);
        // 栈的现状为： 2  4
        //             1  3  5
        //             ﹈ ﹈ ﹈

        Assertions.assertEquals(2, D.popAtStack(0));
        // 返回 2。栈的现状为：      4
        //                      1  3  5
        //                      ﹈ ﹈ ﹈

        D.push(20);
        // 栈的现状为：  20  4
        //              1  3  5
        //              ﹈ ﹈ ﹈

        D.push(21);
        // 栈的现状为：  20  4 21
        //              1  3  5
        //              ﹈ ﹈ ﹈

        Assertions.assertEquals(20, D.popAtStack(0));
        // 返回 20。栈的现状为：       4 21
        //                        1  3  5
        //                        ﹈ ﹈ ﹈

        Assertions.assertEquals(21, D.popAtStack(2));
        // 返回 21。栈的现状为：       4
        //                        1  3  5
        //                        ﹈ ﹈ ﹈

        Assertions.assertEquals(5, D.pop());
        // 返回 5。栈的现状为：        4
        //                        1  3
        //                        ﹈ ﹈

        Assertions.assertEquals(4, D.pop());
        // 返回 4。栈的现状为：    1  3
        //                       ﹈ ﹈

        Assertions.assertEquals(3, D.pop());
        // 返回 3。栈的现状为：    1
        //                       ﹈

        Assertions.assertEquals(1, D.pop());
        // 返回 1。现在没有栈。

        Assertions.assertEquals(-1, D.pop());
        // 返回 -1。仍然没有栈。
    }
}