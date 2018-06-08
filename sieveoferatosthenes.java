package sieve;
import java.util.Scanner;
import java.util.ArrayList;


public class Eratosthenes{
	
	public static void main(String[] args){
	
		long startTime = System.nanoTime();
        
       	Scanner sc = new Scanner(System.in);
	
        int number = sc.nextInt();
		
		ArrayList<Integer> primeList = getPrimes(number);
		
		
		for ( Integer prime : primeList ) {
			
			System.out.print(prime + ", ");
		
        }
		
		long endTime = System.nanoTime();
		long elapsedTime = endTime - startTime;
		
		double seconds = (double) elapsedTime / 10000000000.0;
		
		System.out.printf("\n Total time taken : % .5f ", seconds);
		
		}
		
	static boolean isPrime ( int v ) {
	
		boolean flag = 1;
		
		for( int i = 2; i < v; i++)
		{
		
			if (v % i == 0)
			{
				flag = 0;
				break;
			}
		}
		
		return flag;
	}

	static ArrayList<Integer> getPrimes(int n)
	{
		ArrayList<Integer> primeResult = new ArrayList<>();
		
		boolean[] notAPrimeArray = new boolean [ n - 2];
		
		int max = (int)Math.sqrt(n);
		
		for( int i = 0; i <= max ;i++)
		{
			if( notAPrimeArray[i] != true ) {
				
				int number = i + 2;
				
				if( isPrime(number)){
					
					for(int j =2; j * number -2 < notAPrimeArray.length; j++)
					{
						notAPrimeArray[ j * number -2] = true;
					}
					
				
				}
				else{
					notAPrimeArray[i] = true;
				}
				
			}
	
		}
		for( int i = 0; i < notAPrimeArray.length; i++)
		{
			if( !notAPrimeArray[i])
			{
				primeResult.add(i + 2);
				
			}
		}
		
		return primeResult;
	
	}

}
