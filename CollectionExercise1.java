package Week5.Exercise.Project2onCollections;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.function.Function;
import java.util.function.Predicate;

public class CollectionExercise1 {
    public static void main(String[] args) {
        String[] array = {"Mary","Maryam","Mitchell","Mimi","Margaret","Emily","Monster","Mammy"};
        List<String> stringList = new ArrayList<>(Arrays.asList(array));
        /*int len = array.length;
        for(String s : array)
            stringList.add(s);*/
        System.out.println(stringList);
       /* Function<String, String> stringFunction = s ->{
            if(s.length() > 4)
                return s;
            return "";
        };*/
        Predicate<String> onlyWordsWithMax5Char = s-> s.length() <= 5;
        Function<String, String> convert2Upper = String::toUpperCase;
        //this (/*!s.isEmpty() &&*/) was to remove the empty spaces created by one of the commented out logic for sorting the length  of the string elements.
        //Predicate<String> startWithMA = s -> /*!s.isEmpty() &&*/ s.startsWith("MA");
        Predicate<String> startWithMA = s -> s.startsWith("MA");
        Comparator<String> descendingOrder = Comparator.reverseOrder();

        stringList.stream().filter(onlyWordsWithMax5Char).map(convert2Upper).filter(startWithMA).sorted(descendingOrder).forEach(System.out::println);

       // System.out.println(stringList);
    }
}
