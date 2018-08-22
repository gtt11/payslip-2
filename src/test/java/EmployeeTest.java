import Core.*;
import org.junit.Before;
import org.junit.Test;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

public class EmployeeTest {

    private Employee employee;

    @Before
    public void setup() {
        employee = new Employee("John", "Doe", "60050", "9", "1 March", "31 March");
    }

    @Test
    public void getsFullName() {
        assertThat(employee.getFullName(), is("John Doe"));
    }

}

