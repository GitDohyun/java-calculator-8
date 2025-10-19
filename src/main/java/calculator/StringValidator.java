package calculator;

public class StringValidator {
    public String validate(String input) {
        if (isEmpty(input)) {
            return "결과 : 0";
        }

        String delimiter = DEFAULT_DELIMITER;
        String numbersString = input;

        if (isCustomDelimiter(input)) {
            delimiter = extractCustomDelimiter(input);
            numbersString = extractStringNumbers(input);
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

    private static final String DEFAULT_DELIMITER = ",|:";

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

    private String extractStringNumbers(String input) {
        int numbersStart = input.indexOf("\n");
        if (numbersStart == -1) {
            numbersStart = input.indexOf("\\n");
            if (numbersStart == -1) {
                throw new IllegalArgumentException();
            }
            numbersStart += 2;
        } else  {
            numbersStart += 1;
        }
        return input.substring(numbersStart);
    }
}
