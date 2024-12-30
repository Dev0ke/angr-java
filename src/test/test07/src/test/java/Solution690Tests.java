import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

public class Solution690Tests {
    private final Solution690 solution690 = new Solution690();

    @Test
    public void example1() {
        Solution690.Employee employee1 = new Solution690.Employee();
        employee1.id = 1;
        employee1.importance = 5;
        employee1.subordinates = List.of(2, 3);

        Solution690.Employee employee2 = new Solution690.Employee();
        employee2.id = 2;
        employee2.importance = 3;
        employee2.subordinates = List.of();

        Solution690.Employee employee3 = new Solution690.Employee();
        employee3.id = 3;
        employee3.importance = 3;
        employee3.subordinates = List.of();

        List<Solution690.Employee> employees = new ArrayList<>();
        employees.add(employee1);
        employees.add(employee2);
        employees.add(employee3);
        int id = 1;
        int expected = 11;
        Assertions.assertEquals(expected, solution690.getImportance(employees, id));
    }
}
