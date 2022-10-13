public class Task4 {
    static boolean checkPair(int arr[], int size, int targetNumber)
    {
        for (int i = 0; i < (size - 1); i++) {
            for (int j = (i + 1); j < size; j++) {
                if (arr[i] + arr[j] == targetNumber) {
                    return true;
                }
            }
        }
        return false;
    }

    public static void main(String[] args)
    {

        int arr[] = { 1, 3, 6, 2, 2, 0, 4, 5 };
        int x = 5;
        int size = arr.length;

        if (checkPair(arr, size, x)) {
            System.out.println("Yes");
        }
        else {
            System.out.println("No");
        }
    }
}
