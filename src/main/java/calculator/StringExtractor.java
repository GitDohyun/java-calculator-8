package calculator;

public class StringExtractor {
    public String extractStringNumbers(String input) {
        int numbersStart = input.indexOf("\n");
        if (numbersStart == -1) {
            numbersStart = input.indexOf("\\n");
            if (numbersStart == -1) {
                throw new IllegalArgumentException();
            }
            numbersStart += 2;
        } else {
            numbersStart += 1;
        }
        return input.substring(numbersStart);
    }
}