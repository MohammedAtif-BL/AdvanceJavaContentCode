import com.bridgelabz.content.employee.Employee;
import com.bridgelabz.content.employee.EmployeeManager;
import com.bridgelabz.content.employee.EmployeeProcessor;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Comparator;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

public class EmployeeManagerTest {

    private EmployeeManager manager;

    @BeforeEach
    public void setUp() {
        manager = new EmployeeManager();
    }

    @Test
    public void testAddEmployee() {
        Employee e1 = new Employee(1, "Alice", "HR", 50000);
        manager.addEmployee(e1);
        assertEquals(1, manager.getEmployees().size());
    }

    @Test
    public void testRemoveEmployee() {
        Employee e1 = new Employee(1, "Alice", "HR", 50000);
        Employee e2 = new Employee(2, "Bob", "IT", 60000);
        manager.addEmployee(e1);
        manager.addEmployee(e2);
        manager.removeEmployee(1);
        assertEquals(1, manager.getEmployees().size());
        assertEquals(e2, manager.getEmployees().get(0));
    }

    @Test
    public void testProcessEmployees() {
        Employee e1 = new Employee(1, "Alice", "HR", 50000);
        manager.addEmployee(e1);

        // Increase salary
        EmployeeProcessor increaseSalaryProcessor = emp -> emp.setSalary(emp.getSalary() + 5000);
        manager.processEmployees(increaseSalaryProcessor);
        assertEquals(55000, e1.getSalary());
    }

    @Test
    public void testSortEmployees() {
        Employee e1 = new Employee(1, "Alice", "HR", 50000);
        Employee e2 = new Employee(2, "Bob", "IT", 60000);
        manager.addEmployee(e1);
        manager.addEmployee(e2);

        // Sort by salary
        manager.sortEmployees(Comparator.comparing(Employee::getSalary));
        List<Employee> sortedEmployees = manager.getEmployees();
        assertEquals(e1, sortedEmployees.get(0));
        assertEquals(e2, sortedEmployees.get(1));
    }

    @Test
    public void testCalculateBonus() {
        Employee e1 = new Employee(1, "Alice", "HR", 50000);
        manager.addEmployee(e1);

        // Calculate bonus
        EmployeeProcessor bonusProcessor = emp -> emp.setSalary(emp.getSalary() * 1.10);
        manager.processEmployees(bonusProcessor);
        assertEquals(55000, e1.getSalary());
    }

    @Test
    public void testPrintEmployeeDetails() {
        Employee e1 = new Employee(1, "Alice", "HR", 50000);
        manager.addEmployee(e1);

        // Print details
        EmployeeProcessor printProcessor = System.out::println;
        manager.processEmployees(printProcessor);
    }
}

