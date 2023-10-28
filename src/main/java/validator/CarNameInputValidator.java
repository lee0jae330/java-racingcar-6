package validator;

import util.NameConstant;
import java.util.regex.Pattern;

public class CarNameInputValidator {
    private final String REGEXP_PATTERN_SPACE_NO_CHAR = "^[^\\s]+$";
    private final String REGEXP_PATTERN_ONLY_COMMA = "^,+$";


    public void validate(String input) {
        isNameOnlyComma(input);
        String[] carNames = input.split(",");
        for(String name: carNames) {
            System.out.printf(name);
            isNameBelowFiveLetters(input);
            isNameContainBlank(input);
        }
    }

    public void isNameBelowFiveLetters(String input) {
        if(input.length()>NameConstant.MAX_LENGTH){
            throw new IllegalArgumentException("다섯 글자이하의 입력값이 아닙니다.");
        }
    }

    public void isNameContainBlank(String input){
        if(!Pattern.matches(REGEXP_PATTERN_SPACE_NO_CHAR,input)){
            throw new IllegalArgumentException("공백이 포함되어 있거나 빈 문자열입니다.");
        }
    }

    public void isNameOnlyComma(String input){
        if (Pattern.matches(REGEXP_PATTERN_ONLY_COMMA, input)) {
            throw new IllegalArgumentException("이름에 대한 정보가 없습니다.");
        }
    }
}
