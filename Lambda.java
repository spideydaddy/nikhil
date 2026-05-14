import java.util.*;
import java.util.stream.*;

public class Lambda {

    public static void main(String[] args) {

        List<Integer> numbers = Arrays.asList(2, 5, 8, 3, 10, 7);

        // Filter Even Numbers
        List<Integer> evenNumbers = numbers.stream()
                .filter(n -> n % 2 == 0)
                .collect(Collectors.toList());

        System.out.println("Even Numbers: " + evenNumbers);

        // Square Numbers
        List<Integer> squared = numbers.stream()
                .map(n -> n * n)
                .collect(Collectors.toList());

        System.out.println("Squared Numbers: " + squared);

        // Sum of Numbers
        int sum = numbers.stream()
                .reduce(0, (a, b) -> a + b);

        System.out.println("Sum: " + sum);

        // Maximum Number
        Optional<Integer> max = numbers.stream()
                .max(Integer::compare);

        if (max.isPresent()) {

            System.out.println("Maximum number: " + max.get());

        } else {

            System.out.println("No value present");
        }
    }
}