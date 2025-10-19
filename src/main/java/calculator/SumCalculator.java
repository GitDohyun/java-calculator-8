package calculator;

public class SumCalculator {
    public long calculateSum(String input, String delimiter, StringValidator validator) {
        String[] numbers = input.split(delimiter);
        long sum = 0;
        for (String number : numbers) {
            if (!number.trim().isEmpty()) {
                sum += validator.parsePositiveInteger(number.trim());
            }
        }
        return sum;
    }
}