import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class SolutionP1429Tests {
    @Test
    public void example1() {
        int[] nums = {2, 3, 5};
        SolutionP1429.FirstUnique firstUnique = new SolutionP1429.FirstUnique(nums);

        // 返回 2
        Assertions.assertEquals(2, firstUnique.showFirstUnique());

        // 此时队列为 [2,3,5,5]
        firstUnique.add(5);

        // 返回 2
        Assertions.assertEquals(2, firstUnique.showFirstUnique());

        // 此时队列为 [2,3,5,5,2]
        firstUnique.add(2);

        // 返回 3
        Assertions.assertEquals(3, firstUnique.showFirstUnique());

        // 此时队列为 [2,3,5,5,2,3]
        firstUnique.add(3);

        // 返回 -1
        Assertions.assertEquals(-1, firstUnique.showFirstUnique());
    }

    @Test
    public void example2() {
        int[] nums = {7, 7, 7, 7, 7, 7};
        SolutionP1429.FirstUnique firstUnique = new SolutionP1429.FirstUnique(nums);

        // 返回 -1
        Assertions.assertEquals(-1, firstUnique.showFirstUnique());

        // 此时队列为 [7,7,7,7,7,7,7]
        firstUnique.add(7);

        // 此时队列为 [7,7,7,7,7,7,7,3]
        firstUnique.add(3);

        // 此时队列为 [7,7,7,7,7,7,7,3,3]
        firstUnique.add(3);

        // 此时队列为 [7,7,7,7,7,7,7,3,3,7]
        firstUnique.add(7);

        // 此时队列为 [7,7,7,7,7,7,7,3,3,7,17]
        firstUnique.add(17);

        // 返回 17
        Assertions.assertEquals(17, firstUnique.showFirstUnique());
    }

    @Test
    public void example3() {
        int[] nums = {809};
        SolutionP1429.FirstUnique firstUnique = new SolutionP1429.FirstUnique(nums);

        // 返回 809
        Assertions.assertEquals(809, firstUnique.showFirstUnique());

        // 此时队列为 [809,809]
        firstUnique.add(809);

        // 返回 -1
        Assertions.assertEquals(-1, firstUnique.showFirstUnique());
    }
}