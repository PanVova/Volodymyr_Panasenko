import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Task1 {
    public static List<Integer> getIntegersFromList(List<Object> originalList) {
        List<Integer> targetList = new ArrayList<>();

        for (Object element : originalList) {
            if (element instanceof Integer) {
                targetList.add((Integer) element);
            }
        }

        return targetList;
    }


    public static void main(String[] args) {
        List<Object> array = Arrays.asList(1,2,"a","b");
        List<Object> array1 = Arrays.asList(1,2,"a","b",0,15);
        System.out.println("Result array: " + getIntegersFromList(array));
        System.out.println("Result array1: " + getIntegersFromList(array1));

    }
}
