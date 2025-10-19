package calculator;

import camp.nextstep.edu.missionutils.Console;

public class StringInputReader {
    public String readStringInput() {
        System.out.print("덧겜할 문자열을 입력해 주세요.\n");
        return Console.readLine();
    }
}
