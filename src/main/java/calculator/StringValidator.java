package calculator;

public class StringValidator {
    private static final String DEFAULT_DELIMITER = ",|:";
    private final StringExtractor extractor = new StringExtractor();
    private final SumCalculator calculator = new SumCalculator();

    public String validate(String input) {
        if (isEmpty(input)) {
            return "결과 : 0";
        }

        String delimiter = DEFAULT_DELIMITER;
        String numbersString = input;
        boolean isCustom = false;

        if (isCustomDelimiter(input)) {
            delimiter = extractCustomDelimiter(input);
            numbersString = extractor.extractStringNumbers(input);
            isCustom = true;
        }

        if (isSingleNumber(numbersString, delimiter, isCustom)) {
            long number = parsePositiveInteger(numbersString.trim());
            return "결과 : " + number;
        }

        long sum = calculator.calculateSum(numbersString, delimiter, isCustom, this);
        return "결과 : " + sum;
    }

    private boolean isEmpty(String input) {
        return input == null || input.trim().isEmpty(); //공백도 확인하기 위해 trim 사용
    }

    private boolean isSingleNumber(String input, String delimiter, boolean isCustom) {
        String[] numbers;
        if (isCustom) {
            numbers = input.split(java.util.regex.Pattern.quote(delimiter)); //특수 문자를 일반 문자로 처리하도록 Pattern.quote 사용
        } else {
            numbers = input.split(delimiter);
        }
        if(numbers.length != 1) {
            return false;
        }
        return !numbers[0].trim().isEmpty();
    }

    public long parsePositiveInteger(String input) {
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

    private boolean isCustomDelimiter(String input) {
        return input.startsWith("//");
    }

    private String extractCustomDelimiter(String input) {
        int delimiterEnd = input.indexOf("\n");
        if (delimiterEnd == -1) {
            delimiterEnd = input.indexOf("\\n");
            if (delimiterEnd == -1) {
                throw new IllegalArgumentException();
            }
        }
        return input.substring(2, delimiterEnd);
    }
}