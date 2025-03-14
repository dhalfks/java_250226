package day04;

public class For08 {

	public static void main(String[] args) {
		// 이중 for문
		for(int i=1; i<=5; i++) {   	// i = 1     2    3   4   5
			for(int j=1; j<=5; j++) { 	// j = 1~5   1~5  1~5 1~5 1~5
				System.out.print(j+" ");
			}
			System.out.println();//j가 모두 출력 후 줄바꿈.
		}
		System.out.println("-------------");
		
		/* 별찍기 => 5개씩 5줄
		 * ***** 
		 * *****
		 * *****
		 * *****
		 * ***** 
		 * */
		for(int i=1; i<=5; i++) {     // i(줄) = 1   2   3   4   5 
			for(int j=1; j<=5; j++) { // j(*) = 1~5 1~5 1~5 1~5 1~5
				System.out.print("*");
			}
			System.out.println(); //줄바꿈
		}
		
		System.out.println("-----------");
		
		/* *
		 * **
		 * ***
		 * ****
		 * *****
		 * 
		 * */
		for(int i=1; i<=5; i++) {		// i(줄) = 1   2   3   4   5 
			for(int j=1; j<=i; j++) { 	// j(*) = 1~1 1~2 1~3 1~4 1~5
				System.out.print("*");
			}
			System.out.println();
		}
		
		System.out.println("----------");
		
		/* *****	// i(줄) = 1   2   3   4   5 
		 * ****		// j(*) = 1~5 1~4 1~3 1~2 1~1  (6-i)
		 * ***
		 * **
		 * *
		 * 
		 * */
		for(int i=1; i<=5; i++) {
			for(int j=1; j<=6-i; j++) {
				System.out.print("*");
			}
			System.out.println();
		}
		
		System.out.println("----------");
		
		/*     *	// i(줄) = 1   2   3   4   5 
		 *    **	// j(*) = 1~1 1~2 1~3 1~4 1~5 (i)
		 *   ***	// K공백 = 1~4 1~3 1~2 1~1 0 (5-i)
		 *  ****
		 * *****
		 * 
		 * */
		
		for(int i=1; i<=5; i++) {
			for(int k=1; k<=5-i; k++) {
				System.out.print(" ");
			}
			for(int j=1; j<=i; j++) {
				System.out.print("*");
			}
			System.out.println();
		}
		
		System.out.println("--------");
		
		/*     *		// i(줄) = 1   2   3   4   5 
		 *    ***		// K공백 = 1~4 1~3 1~2 1~1 0 (5-i)
		 *   *****		// j(*) = 1~1 1~3 1~5 1~7 1~9 (i*2)-1
		 *  *******
		 * *********  
		 * */
		
		int cnt = 1;
		for(int i=1; i<=5; i++) {
			for(int k=1; k<=5-i; k++) {
				System.out.print(" ");
			}
			for(int j=1; j<=cnt; j++) {
				System.out.print("*");
			}
			cnt = cnt+2;
			System.out.println();
		}
		
		System.out.println("--------");
		
		/* 1 2 3  
		 * 4 5 6
		 * 7 8 9
		 * 3줄씩 3개의 숫자 (2중 for)
		 * */
		int number = 1;
		for(int i=1; i<=3; i++) {
			for(int j=1; j<=3; j++) {
				System.out.print(number+" ");
				number++;
			}
			System.out.println();
		}
		
	}

}
