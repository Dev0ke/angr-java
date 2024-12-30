import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class Solution1095Tests {
    static class MountainArrayImpl implements Solution1095.MountainArray {
        int[] array;
        int cnt = 0;

        public MountainArrayImpl(int[] array) {
            this.array = array;
        }

        @Override
        public int get(int index) {
            cnt++;
            return array[index];
        }

        @Override
        public int length() {
            return array.length;
        }
    }

    private final Solution1095 solution1095 = new Solution1095();

    @Test
    public void example1() {
        int[] array = {1, 2, 3, 4, 5, 3, 1};
        int target = 3;
        Solution1095.MountainArray mountainArr = new MountainArrayImpl(array);
        int expected = 2;
        Assertions.assertEquals(expected, solution1095.findInMountainArray(target, mountainArr));
        Assertions.assertTrue(((MountainArrayImpl) mountainArr).cnt <= 100);
    }

    @Test
    public void example2() {
        int[] array = {0, 1, 2, 4, 2, 1};
        int target = 3;
        Solution1095.MountainArray mountainArr = new MountainArrayImpl(array);
        int expected = -1;
        Assertions.assertEquals(expected, solution1095.findInMountainArray(target, mountainArr));
        Assertions.assertTrue(((MountainArrayImpl) mountainArr).cnt <= 100);
    }

    // 补充用例
    @Test
    public void example3() {
        int[] array = UtUtils.loadingInts("solution1095-example3-input.txt", 0);
        int target = UtUtils.loadingInt("solution1095-example3-input.txt", 1);
        Solution1095.MountainArray mountainArr = new MountainArrayImpl(array);
        int expected = -1;
        Assertions.assertEquals(expected, solution1095.findInMountainArray(target, mountainArr));
        Assertions.assertTrue(((MountainArrayImpl) mountainArr).cnt <= 100);
    }
}
