package Console;

import java.text.*;

public class Validator {

    private final int superMinimum = 0;
    private int superMaximum;

    public Validator(int superMaximum) {
        this.superMaximum = superMaximum;
    }

    public boolean dateInputIsValid(String inputValue) {
        SimpleDateFormat sdf = new SimpleDateFormat("dd MMMMM");
        sdf.setLenient(false);
        try {
            sdf.parse(inputValue);
            return true;
        } catch (ParseException e) {
            return false;
        }
    }

    public boolean salaryInputIsValid(String inputValue) {
        try {
            Integer numericValue = Integer.parseInt(inputValue);
            return numericValue >= 0;
        } catch (Exception e) {
            return false;
        }
    }

    public boolean superInputIsValid(String inputValue) {
        try {
            float numericValue = Float.parseFloat(inputValue);
            return numericValue >= superMinimum && numericValue <= superMaximum;
        } catch (Exception e) {
            return false;
        }
    }

    public boolean nameInputIsValid(String inputValue) {
        return !inputValue.equals("");
    }

}
