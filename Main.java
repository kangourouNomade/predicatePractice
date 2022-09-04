import java.util.*;
import java.util.function.BiPredicate;
import java.util.function.IntPredicate;
import java.util.function.Predicate;
import java.util.stream.Stream;

public class Main {
    public static void main(String[] args) {
//  Task1. Using the Predicate interface delete all the words from the List, begins with certain letter. For example, letter "F"
        List<String> strings = new ArrayList<>(List.of("good", "bad", "wealthy", "first", "firebat", "ninja", "happy", "successfull", "adorable"));
        Predicate <String> pr1 = a -> a.startsWith("f");
        strings.removeIf(pr1);
        System.out.println(strings);
//  Task2. Using the Predicate interface, delete from the list all Strings which begins from letters which contain certain array of chars.
        List<String> stringsList = new ArrayList<>(List.of("good", "bad", "wealthy", "first", "firebat", "ninja", "happy", "successfull", "adorable"));
        List<String> forbidenChars = Arrays.asList("a", "b", "c");
        stringsList.removeIf(a -> forbidenChars.contains(a.substring(0, 1)));
        System.out.println(stringsList);
//  Task3. Using the Predicate and logical methods of it, delete objects <Cat> from list, which have age >5 and their name starts from the char after "H".
        Cat cat = new Cat(1, 2, "Tolya");
        Cat cat1 = new Cat(3, 4, "Gizya");
        Cat cat2 = new Cat(6, 6, "Tender");
        Cat cat3 = new Cat(7, 8, "Mastodont");
        Cat cat4 = new Cat(9, 10, "Anhel");
        List<Cat> cats = new ArrayList<>(List.of(cat, cat1, cat2, cat3, cat4));
        Predicate<Cat> prettyKate = a -> a.getAge() > 5;
        cats.removeIf(prettyKate.and(a -> a.getName().charAt(0) > 'H'));
        System.out.println(cats);
//  Task4. Using Predicate interface delete from the map all the key-value pairs if number of letters in value not equal to the key digit.
        Map<Integer, String> myMap = new HashMap<>();
        myMap.put(1, "OK");
        myMap.put(2, "OK");
        myMap.put(3, "OK");
        myMap.put(4, "Frog");
        myMap.put(5, "Panda");
        myMap.put(6, "Color");
        BiPredicate <Integer, String> ááábiPr = (a, b) -> a != b.length();
        myMap.entrySet().removeIf(a -> a.getKey() != a.getValue().length());
        System.out.println(myMap);
//  Task5. Using the Predicate make method returns true if the sum of digits in certain number is even.
        int cancer = 6851;
        IntPredicate astrology = a -> a%2 == 0;
        System.out.println(isSumOfDigitsEven(cancer, astrology));
    }
    public static boolean isSumOfDigitsEven(int a, IntPredicate prdkt) {
        int sumOfDigits = Stream.of(Integer.toString(a).split("")).mapToInt(Integer::parseInt).sum();
        return prdkt.test(sumOfDigits);
    }
}
