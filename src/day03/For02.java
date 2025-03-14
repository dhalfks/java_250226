package day03;

public class For02 {

	public static void main(String[] args) {
		// for 예제
		// for(1초기화; 258조건식; 47증감식){
		//   36실행문;
		// }
		// 조건식은 참이여야 실행 (true가 될수있게 설정)
		// 초기화 한 변수가 조건식을 만족하면 실행 -> 증감식(증가/감소)
		// 증가한 변수를 다시 조건식 비교 -> 만족하면 실행 -> 증감식
		// 증가한 변수를 다시 조건식 비교 -> 불만족하면 -> 종료
		
		// 1부터 10까지 출력
		for(int i=1; i<=10; i++) {
			System.out.println(i);
		}
		
		System.out.println("--------------");
		
		//1부터 10까지 짝수만 출력
		for(int i=1; i<=10; i++) {
			if(i % 2 ==0) {
				System.out.println(i);
			}
		}
		
		System.out.println("-----------");
		
		// 1부터 10까지의 합계 출력
		// 지역변수는 반드시 초기값이 있어야 함. 숫자 = 0, 문자 = null
		int sum=0;
		for(int i=1; i<=10; i++) {
			sum = sum + i;
		}
		System.out.println(sum);
		
		System.out.println("----------");
		// 1~10까지 짝수합 / 홀수합 출력
		
		int sum_even = 0;
//		int sum_odd = 0;
		sum = 0; // 이미 선언된 변수를 다시 활용하려면 다시 초기값 지정 후 사용
		for(int i=1; i<=10; i++) {
			if(i % 2 == 0) {
				sum_even = sum_even + i;  // sum_even += i
			}else {
				sum += i;
//				sum_odd = sum_odd + i; // sum_odd += i
			}
		}
		
		System.out.println("even : "+sum_even);
//		System.out.println("odd : "+sum_odd);
		System.out.println("odd : "+sum);
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		

	}

}
