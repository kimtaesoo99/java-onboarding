package onboarding;


import java.util.Stack;
import java.util.stream.Collectors;

/**
 * decodingCryptogram 메서드 암호문을 받은뒤 중복된 값을 제거하여 반환
 * isProperCryptogram 메서드 암호문이 올바른지 확인
 */

public class Problem2 {
    private static final int MIN_LENGTH = 1;
    private static final int MAX_LENGTH = 1000;
    private static final String LOWERCASE = "^[a-z]*$";

    public static String solution(String cryptogram) {
        return decodingCryptogram(cryptogram);
    }


    private static String decodingCryptogram(String cryptogram) {
        Stack stack = new Stack<>();
        char[] arrayOfCryptogram = cryptogram.toCharArray();
        stack.push(arrayOfCryptogram[0]);

        for (int i = 1; i < arrayOfCryptogram.length; i++) {
            if (!stack.empty() && stack.peek().equals(arrayOfCryptogram[i])) stack.pop();
            else if (arrayOfCryptogram[i - 1] == arrayOfCryptogram[i]) ;
            else stack.push(arrayOfCryptogram[i]);
        }

        return stack.stream()
                .map(String::valueOf)
                .collect(Collectors.joining())
                .toString();

    }
}