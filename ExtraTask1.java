import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class ExtraTask1 {
    public static int nextBigger(int number) {
        List<Integer> digits = new ArrayList<>();

        // create list for digits
        while (number != 0) {
            digits.add(number % 10);
            number /= 10;
        }

        int firstGreaterDigit = -1;

        // try to get bigger first digit
        for (int i = 0; i < digits.size() - 1; i++) {
            if (digits.get(i) > digits.get(i + 1)) {
                firstGreaterDigit = i + 1;
                break;
            }
        }

        // in case we didn't find anything
        if (firstGreaterDigit == -1) return -1;

        // next iteration for changes
        Collections.swap(digits, 0, firstGreaterDigit);
        for (int i = 0; i < firstGreaterDigit - 1; i++) {
            if (digits.get(i) > digits.get(i + 1)) {
                Collections.swap(digits, i, i + 1);
            } else {
                Collections.reverse(digits.subList(0, firstGreaterDigit));
                break;
            }
        }

        // connect numbers from digits
        int nextNumber = 0;
        int coefficient = 1;

        for (int digit : digits) {
            nextNumber += digit * coefficient;
            coefficient *= 10;
        }

        return nextNumber;
    }

    public static void main(String[] args) {
        int input = 12;
        System.out.println(nextBigger(input));
    }
}