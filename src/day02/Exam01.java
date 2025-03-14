package day02;

import java.util.Scanner;

public class Exam01 {

	public static void main(String[] args) {
		/* 과제
		 * 정수 2개와 연산자 1개를 입력받아 두 정수의 연산 결과를 출력
		 * ex) 2 3 + => 2 + 3 = 5
		 * ex) 2 3 * => 2 * 3 = 6
		 * ex) 2 3 ! => 잘못된 연산자
		 * 연산자는 + - * / % 만 가능
		 * 다른 종류의 특수문자가 들어오면 잘못된 연산자로 출력
		 * */
		
		// 문자로 받는 케이스 : String == 비교불가능    ""
		// 한글자만 받는 케이스 : char == 비교가능  (charAt()) ''
		//scan.next() : 한단어를 입력  
		
		Scanner scan = new Scanner(System.in);
		
		System.out.println("정수 2개와 연산자 순서로 입력>");
		int num1 = scan.nextInt();
		int num2 = scan.nextInt();
		char c = scan.next().charAt(0);
//		System.out.println(c);
		
//		switch(c) {
//		case '+' :
//			System.out.println(""+num1+c+num2+"="+(num1+num2));
//			break;
//		case '-':
//			System.out.println(""+num1+c+num2+"="+(num1-num2));
//			break;
//		case '*':
//			System.out.println(""+num1+c+num2+"="+(num1*num2));
//			break;
//		case '/':
//			if(num2 == 0) {
//				System.out.println("0으로 나눌수 없습니다.");
//			}else {
//				System.out.println(""+num1+c+num2+"="+(num1/num2));				
//			}
//			break;
//		case '%' :
//			if(num2 == 0) {
//				System.out.println("0으로 나눌수 없습니다.");
//			}else {
//				System.out.println(""+num1+c+num2+"="+(num1%num2));
//			}
//			break;
//			default:
//				System.out.println("잘못된 연산자!!");
//		}
		
		if((c =='/' || c == '%') && num2 == 0) {
			System.out.println("0으로 나눌 수 없습니다.");
		}else {
			switch(c) {
			case '+' :
				System.out.println(""+num1+c+num2+"="+(num1+num2));
				break;
			case '-':
				System.out.println(""+num1+c+num2+"="+(num1-num2));
				break;
			case '*':
				System.out.println(""+num1+c+num2+"="+(num1*num2));
				break;
			case '/':
				System.out.println(""+num1+c+num2+"="+(num1/num2));				
				break;
			case '%' :
				System.out.println(""+num1+c+num2+"="+(num1%num2));
				break;
				default:
					System.out.println("잘못된 연산자!!");
			}
		}
		
		
		
		
		
		
		scan.close();

	}

}
