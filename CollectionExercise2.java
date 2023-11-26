package Week5.Exercise.Project2onCollections;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Function;
import java.util.function.Predicate;

public class CollectionExercise2 {
    public static void main(String[] args) {

        List<Integer> array = new ArrayList<>();
        //A loop to populate the list from 1 to 20.
        for (int i = 0; i < 20; i++) {
            array.add(i+1);
        }
        /*for(Integer p : array)
        {
            System.out.println(p);
        }*/

        //A predicate to get the even numbers from the given list.
        Predicate<Integer> evenPredicate = (a) -> a % 2 == 0;
        //A predicate to get the odd numbers from the given list.
        Predicate<Integer> oddPredicate = (a) -> a % 2 != 0;

        /*A list of evenNumbers created to hold all the even numbers
         generated from the stream operation.*/
        List<Integer> evenNumbers = array.stream().filter(evenPredicate).toList();
        /*A list of evenNumbers created to hold all the odd numbers
         generated from the stream operation.*/
        List<Integer> oddNumbers = array.stream().filter(oddPredicate).toList();
        //A function to qet the square of an integer and return an integer.
        Function<Integer, Integer> squareFunction = a-> a*a;
        //A function to return the sum of a given list (oddNumbers)
        Function<Integer, Integer> sumOdd = a -> {
            int sum = 0;
            for(Integer x : oddNumbers){
                sum += x;
            }
            return sum;
        };
        // this will print to the console the square of the even numbers from array list.
        array.stream().filter(evenPredicate).map(squareFunction).forEach(X->System.out.print(X +", "));
        System.out.println();
        evenNumbers.stream().map(squareFunction).forEach(System.out::println);
        /*This will give the sum of all the objects(Integers) in the oddNumbers list,
         the method limit() is used to printout only one of the result as the
         sumOdd function will produce the same result for the total number of
         objects in the list */
        System.out.println();
        oddNumbers.stream().filter(oddPredicate).map(sumOdd).limit(1).forEach(System.out::print);
    }
}



