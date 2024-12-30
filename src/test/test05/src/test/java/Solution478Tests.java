import org.junit.jupiter.api.Test;

public class Solution478Tests {
    @Test
    public void example1() {
        Solution478.Solution solution = new Solution478.Solution(1.0, 0.0, 0.0);
        solution.randPoint();//返回[-0.02493，-0.38077]
        solution.randPoint();//返回[0.82314,0.38945]
        solution.randPoint();//返回[0.36572,0.17248]
    }
}
