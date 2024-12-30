import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class Solution1603Tests {
    @Test
    public void example1() {
        Solution1603.ParkingSystem parkingSystem = new Solution1603.ParkingSystem(1, 1, 0);
        // 返回 true ，因为有 1 个空的大车位
        Assertions.assertTrue(parkingSystem.addCar(1));
        // 返回 true ，因为有 1 个空的中车位
        Assertions.assertTrue(parkingSystem.addCar(2));
        // 返回 false ，因为没有空的小车位
        Assertions.assertFalse(parkingSystem.addCar(3));
        // 返回 false ，因为没有空的大车位，唯一一个大车位已经被占据了
        Assertions.assertFalse(parkingSystem.addCar(1));
    }
}
