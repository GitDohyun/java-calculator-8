package calculator;

public class StringValidator {
    public String validate(String input) {
        if (isEmpty(input)) {
            return "결과 : 0";
        }

        long positiveInteger = parsePositiveInteger(input);
        return "결과 : " + positiveInteger;
    }

    private boolean isEmpty(String input) {
        return input == null || input.trim().isEmpty(); //공백도 확인하기 위해 trim 사용
    }

    private long parsePositiveInteger(String input) {
        try {
            long positiveInteger = Long.parseLong(input);
            if (positiveInteger < 0) {
                throw new IllegalArgumentException();
            }
            return positiveInteger;
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException();
        }
    }
}
