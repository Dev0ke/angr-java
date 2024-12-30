import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class Solution599Tests {
    private final Solution599 solution599 = new Solution599();

    @Test
    public void example1() {
        String[] list1 = {"Shogun", "Tapioca Express", "Burger King", "KFC"};
        String[] list2 = {"Piatti", "The Grill at Torrey Pines", "Hungry Hunter Steakhouse", "Shogun"};
        String[] expected = {"Shogun"};
        Assertions.assertArrayEquals(expected, solution599.findRestaurant(list1, list2));
    }

    @Test
    public void example2() {
        String[] list1 = {"Shogun", "Tapioca Express", "Burger King", "KFC"};
        String[] list2 = {"KFC", "Shogun", "Burger King"};
        String[] expected = {"Shogun"};
        Assertions.assertArrayEquals(expected, solution599.findRestaurant(list1, list2));
    }
}
