package calculator;

public class SumCalculator {
    public long calculateSum(String input, String delimiter, boolean isCustom, StringValidator validator) {
        String[] numbers;
        if (isCustom) {
            numbers = input.split(java.util.regex.Pattern.quote(delimiter)); //특수 문자를 일반 문자로 처리하도록 Pattern.quote 사용
        } else {
            numbers = input.split(delimiter);
        }

        long sum = 0;
        for (String number : numbers) {
            if (!number.trim().isEmpty()) {
                sum += validator.parsePositiveInteger(number.trim());
            }
        }
        return sum;
    }
}