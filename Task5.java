import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

public class Task5 {
    static String meeting(String str) {
        str = str.toUpperCase();
        List<String[]> persons = new ArrayList<>();

        for (String person : str.split(";")) {
            persons.add(person.split(":"));
        }

        // sorting firstName and LastName
        persons.sort(Comparator.comparing(person -> person[0]));
        persons.sort(Comparator.comparing(person -> person[1]));

        return persons.stream()
                .map(person -> person[1] + " " + person[0] + "\n")
                .reduce((el1, el2) -> el1 + el2).orElse("");
    }

    public static void main(String[] args) {
        String input = "Fired:Corwill;Wilfred:Corwill;Barney:TornBull;Betty:Tornbull;Bjon:Tornbull;Raphael:Corwill;Alfred:Corwill";
        System.out.println(meeting(input));
    }
}
