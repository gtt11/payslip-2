package Unit;

import Console.Validator;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

public class ValidatorTest {

    private Validator validator;

    @Before
    public void setup() {
        validator = new Validator(50);
    }

    @Test
    public void returnsTrue_WhenValidSalaryValueProvided() {
        assertTrue(validator.salaryInputIsValid("65000"));
    }

    @Test
    public void returnsFalse_WhenNonNumericSalaryValueProvided() {
        assertFalse(validator.salaryInputIsValid("65ab201"));
    }

    @Test
    public void returnsFalse_WhenTwoSalaryValuesProvided() {
        assertFalse(validator.salaryInputIsValid("65 45"));
    }

    @Test
    public void returnsFalse_WhenNegativeSalaryValueProvided() {
        assertFalse(validator.salaryInputIsValid("-10"));
    }

    @Test
    public void returnsFalse_WhenNonIntegerSalaryValueProvided() {
        assertFalse(validator.salaryInputIsValid("50.45"));
    }

    @Test
    public void returnsTrue_WhenValidSuperRateProvided() {
        assertTrue(validator.superInputIsValid("9.5"));
    }

    @Test
    public void returnsFalse_WhenNonNumericSuperValueProvided() {
        assertFalse(validator.superInputIsValid("9a"));
    }

    @Test
    public void returnsFalse_WhenTwoSuperValuesProvided() {
        assertFalse(validator.superInputIsValid("9 4"));
    }

    @Test
    public void returnsFalse_WhenNegativeSuperValueProvided() {
        assertFalse(validator.superInputIsValid("-1"));
    }

    @Test
    public void returnsFalse_WhenSuperValueProvidedExceedsMaximum() {
        assertFalse(validator.superInputIsValid("51"));
    }

    @Test
    public void returnsTrue_WhenValidDateProvided() {
        assertTrue(validator.dateInputIsValid("01 March"));
    }

    @Test
    public void returnsFalse_WhenDateInvalid() {
        assertFalse(validator.dateInputIsValid("32 March"));
    }

    @Test
    public void returnsFalse_WhenMonthInvalid() {
        assertFalse(validator.dateInputIsValid("3 Maarssch"));
    }

    @Test
    public void returnsFalse_WhenDateNegative() {
        assertFalse(validator.dateInputIsValid("-5 March"));
    }

}
