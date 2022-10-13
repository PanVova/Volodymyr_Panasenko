public class Task2 {

    static Character first_non_repeating_letter(String input) {
        String inputLowerCase = input.toLowerCase();

        for (int i = 0; i < input.length(); i++) {
            char currentLetter = inputLowerCase.charAt(i);
            long countLetter = inputLowerCase.chars()
                    .filter(letter -> letter == currentLetter)
                    .count();

            if (countLetter == 1) return input.charAt(i);
        }

        return ' ';
    }

    public static void main(String[] args) {
        String input = "stress";
        System.out.println("Result: " + first_non_repeating_letter(input));
    }
}
