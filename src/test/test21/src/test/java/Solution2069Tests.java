import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class Solution2069Tests {
    @Test
    public void example1() {
        Solution2069.Robot robot = new Solution2069.Robot(6, 3);
        robot.move(2);
        robot.move(2);
        // 返回 [4, 0]
        Assertions.assertArrayEquals(new int[]{4, 0}, robot.getPos());
        // 返回 "East"
        Assertions.assertEquals("East", robot.getDir());
        robot.move(2);
        robot.move(1);
        robot.move(4);
        // 返回 [1, 2]
        Assertions.assertArrayEquals(new int[]{1, 2}, robot.getPos());
        // 返回 "West"
        Assertions.assertEquals("West", robot.getDir());
    }

    // 补充用例
    @Test
    public void example2() {
        // 输入：
        // ["Robot","move","getPos","getDir","move","getPos","getDir","move","move","getPos","getDir","move","move","move","getPos","getDir","move","move","move","getPos","getDir","move"]
        // [[8,2],[17],[],[],[21],[],[],[22],[34],[],[],[1],[46],[35],[],[],[44],[14],[31],[],[],[50]]
        // 预期：
        // [null,null,[1,0],"East",null,[6,0],"East",null,null,[1,1],"West",null,null,null,[0,0],"East",null,null,null,[6,1],"West",null]
        Solution2069.Robot robot = new Solution2069.Robot(8, 2);
        robot.move(17);
        Assertions.assertArrayEquals(new int[]{1, 0}, robot.getPos());
        Assertions.assertEquals("East", robot.getDir());

        robot.move(21);
        Assertions.assertArrayEquals(new int[]{6, 0}, robot.getPos());
        Assertions.assertEquals("East", robot.getDir());

        robot.move(22);
        robot.move(34);
        Assertions.assertArrayEquals(new int[]{1, 1}, robot.getPos());
        Assertions.assertEquals("West", robot.getDir());

        robot.move(1);
        robot.move(46);
        robot.move(35);
        Assertions.assertArrayEquals(new int[]{0, 0}, robot.getPos());
        Assertions.assertEquals("South", robot.getDir());

        robot.move(44);
        robot.move(14);
        robot.move(31);
        Assertions.assertArrayEquals(new int[]{6, 1}, robot.getPos());
        Assertions.assertEquals("West", robot.getDir());

        robot.move(50);
    }
}