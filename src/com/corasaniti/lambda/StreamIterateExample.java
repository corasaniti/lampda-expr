package com.corasaniti.lambda;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/*
 * http://www.java2s.com/Tutorials/Java_Streams/Tutorial/Streams/Stream_iterate_.htm
 * 
 * Description
 * The iterate() method takes two arguments: 
 * a seed (seme) and a function.  
 * A seed is the first element of the stream. 
 * The second element is generated by applying the function to the first  element. 
 * The third  element is generated by applying the function on the second element.
 * 
 * Therefore the elements are: seed, f(seed), f(f(seed)), f(f(f(seed)))....
 * 
 * The following code  creates 
 * a stream of natural numbers
 * Stream<Long> naturalNumbers = Stream.iterate(1L, n -> n + 1);
 * 
 */
public class StreamIterateExample {

	public static void main(String[] args) {
		
		//Natural Numbers
		Stream<Long> tenNaturalNumbers = naturalNumbers(10);
		tenNaturalNumbers.forEach(System.out::println);
		
		//Fibonacci Series
		List<Integer> fibonacci = generate(15);
		fibonacci.forEach(System.out::print);
	}
	
	
	
	/**
	 * Java8/Lambda approach to generate
	 * natural numbers long stream
	 */
	public static Stream<Long> naturalNumbers(int upperLimit){
		return Stream.iterate(1L, n  ->  n  + 1).limit(upperLimit);
	}
	
	
	/**
     * Java 8 / Lambda approach to generate Fibonacci series.
     * Fibonacci always start as classic (e.g. 0, 1, 1, 2, 3, 5)
     * @param series Number of how many Fibonacci number should be generated
     * @return List holding resulting Fibonacci number.
     */
    public static List<Integer> generate(int series) {
        return Stream.iterate(new int[]{0, 1}, s -> new int[]{s[1], s[0] + s[1]})
                .limit(series)
                .map(n -> n[0])
                .collect(Collectors.toList());
    }

}
