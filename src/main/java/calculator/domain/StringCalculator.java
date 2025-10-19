package calculator.domain;

public class StringCalculator {
    //구분자
    private static final String DEFAULT_DELIMITER = "[,:]";

    //기본 파싱 및 계산
    public int calculateString(String input) {
        if (input == null || input.isEmpty()) {
            return 0; //나중에 에러 핸들링 추가
        }
        String[] numbers;
        if (input.startsWith("//")) {
            int delimiterEndIndex = input.indexOf("\n");
            if (delimiterEndIndex == -1) {
                throw new IllegalArgumentException("커스텀 구분자 형식이 올바르지 않습니다.");
            }
            String customDelimiter = input.substring(2,delimiterEndIndex);
            String numbersPart = input.substring(delimiterEndIndex + 1);
            numbers = numbersPart.split(customDelimiter);
        }
        else{
            numbers = input.split(DEFAULT_DELIMITER);
        }

        int sum = 0;
        for (String number : numbers) {
            try {
                int num = Integer.parseInt(number); //문자 -> 숫자 변환
                if (num < 0) {
                    throw new IllegalArgumentException("음수는 허용되지 않습니다");
                }
                sum += num;
            } catch (NumberFormatException e) {
                throw new IllegalArgumentException("숫자 이외의 값은 입력할 수 없습니다.");
            }
        }
        return sum;
    }
}
