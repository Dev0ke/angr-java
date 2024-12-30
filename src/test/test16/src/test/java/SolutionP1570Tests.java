import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class SolutionP1570Tests {
    @Test
    public void example1() {
        int[] nums1 = {1, 0, 0, 2, 3};
        int[] nums2 = {0, 3, 0, 4, 0};
        int expected = 8;
        SolutionP1570.SparseVector v1 = new SolutionP1570.SparseVector(nums1);
        SolutionP1570.SparseVector v2 = new SolutionP1570.SparseVector(nums2);
        Assertions.assertEquals(expected, v1.dotProduct(v2));
    }

    @Test
    public void example2() {
        int[] nums1 = {0, 1, 0, 0, 0};
        int[] nums2 = {0, 0, 0, 0, 2};
        int expected = 0;
        SolutionP1570.SparseVector v1 = new SolutionP1570.SparseVector(nums1);
        SolutionP1570.SparseVector v2 = new SolutionP1570.SparseVector(nums2);
        Assertions.assertEquals(expected, v1.dotProduct(v2));
    }

    @Test
    public void example3() {
        int[] nums1 = {0, 1, 0, 0, 2, 0, 0};
        int[] nums2 = {1, 0, 0, 0, 3, 0, 4};
        int expected = 6;
        SolutionP1570.SparseVector v1 = new SolutionP1570.SparseVector(nums1);
        SolutionP1570.SparseVector v2 = new SolutionP1570.SparseVector(nums2);
        Assertions.assertEquals(expected, v1.dotProduct(v2));
    }
}
