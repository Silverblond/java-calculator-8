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
            String customDelimiter = input.substring(2,delimiterEndIndex);
            String numbersPart = input.substring(delimiterEndIndex + 1);
            numbers = numbersPart.split(customDelimiter);
        }
        else{
            numbers = input.split(DEFAULT_DELIMITER);
        }

        int sum = 0;
        for (String number : numbers) {
            int num = Integer.parseInt(number); //문자 -> 숫자 변환
            if (num < 0) {
                throw new IllegalArgumentException("음수는 허용되지 않습니다: " + num); //여기도 임시, 나중에 핸들링 통합
            }
            sum += num;
        }
        return sum;
    }
}
