import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.List;

public class Solution1333Tests {
    private final Solution1333 solution1333 = new Solution1333();

    @Test
    public void example1() {
        int[][] restaurants = UtUtils.stringToInts2("[[1,4,1,40,10],[2,8,0,50,5],[3,8,1,30,4],[4,10,0,10,3],[5,1,1,15,1]]");
        int veganFriendly = 1;
        int maxPrice = 50;
        int maxDistance = 10;
        List<Integer> expected = List.of(3, 1, 5);
        Assertions.assertEquals(expected, solution1333.filterRestaurants(restaurants, veganFriendly, maxPrice, maxDistance));
    }

    @Test
    public void example2() {
        int[][] restaurants = UtUtils.stringToInts2("[[1,4,1,40,10],[2,8,0,50,5],[3,8,1,30,4],[4,10,0,10,3],[5,1,1,15,1]]");
        int veganFriendly = 0;
        int maxPrice = 50;
        int maxDistance = 10;
        List<Integer> expected = List.of(4, 3, 2, 1, 5);
        Assertions.assertEquals(expected, solution1333.filterRestaurants(restaurants, veganFriendly, maxPrice, maxDistance));
    }

    @Test
    public void example3() {
        int[][] restaurants = UtUtils.stringToInts2("[[1,4,1,40,10],[2,8,0,50,5],[3,8,1,30,4],[4,10,0,10,3],[5,1,1,15,1]]");
        int veganFriendly = 0;
        int maxPrice = 30;
        int maxDistance = 3;
        List<Integer> expected = List.of(4, 5);
        Assertions.assertEquals(expected, solution1333.filterRestaurants(restaurants, veganFriendly, maxPrice, maxDistance));
    }
}