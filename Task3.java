public class Task3 {
    public static int digital_root(int number) {
        return number < 10 ? number : digital_root(number % 10 + digital_root(number / 10));
    }

    public static void main(String[] args) {
        int input = 942;
        System.out.println("Result: " + digital_root(input));
    }
}