package calculator;

public class StringValidator {
    public String validate(String input) {
        if (isEmpty(input)) {
            return "결과 : 0";
        }

        return "결과 : ";
    }

    private boolean isEmpty(String input) {
        return input == null || input.trim().isEmpty(); //공백도 확인하기 위해 trim 사용
    }
}
