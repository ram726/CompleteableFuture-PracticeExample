package org.main.programs;

import java.util.Arrays;
import java.util.List;

public class Sample 
{
	public static boolean check(int number) {
		System.out.println("t: "+number+"--"+Thread.currentThread());
		sleep(1000);
		return true;
	}
	public static int transform(int number) {
		System.out.println("t: "+number+"--"+Thread.currentThread());
		sleep(1000);
		return number*1;
	}
	private static boolean sleep(int i) {
		
		try {
			Thread.sleep(i);
			return true;
		} catch (InterruptedException e) {
			e.printStackTrace();
			return false;
		}
		
	}
	public static void printIt(int number) {
		System.out.println("p: "+number+"--"+Thread.currentThread());
	}
	public static void main(String[] args) 
	{
		List<Integer>numbers=Arrays.asList(1,2,3,4,5,6,7,8,9,10);
		
		numbers.parallelStream()
		.filter(e->check(e))
		.forEachOrdered(e->{});
	}
}