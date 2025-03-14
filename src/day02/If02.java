package day02;

import java.util.Scanner;

public class If02 {

	public static void main(String[] args) {
		/* 국어, 영어, 수학점수를 입력받아
		 * 합계, 평균, pass 여부를 출력
		 * pass 여부는 80이상이면 합격 - if
		 * 
		 * break; : 구문종료
		 * return : 메서드 종료
		 * */
		
		Scanner scan = new Scanner(System.in);
		
		System.out.println("국어/영어/수학 순서대로 입력>");
		int kor = scan.nextInt();
		int eng = scan.nextInt();
		int math = scan.nextInt();
		
//		System.out.println(kor);
//		System.out.println(eng);
//		System.out.println(math);
		
		if((kor>100 || kor<0) || (eng>100 || eng <0) || (math>100 || math<0)) {
			System.out.println("잘못된 점수입니다.");
			
		}else {
			// 합계 / 평균 / pass
			int sum = kor + eng + math;
			double avg = sum / (double)3;
			System.out.println("sum:"+sum);
			System.out.println("average:"+avg);
			
			if(avg >=80) {
				System.out.println("pass");
			}
		}
		
		
//		if((kor>100 || kor<0) || (eng>100 || eng <0) || (math>100 || math<0)) {
//			System.out.println("잘못된 점수입니다.");
//			return;
//		}
//		
//		// 합계 / 평균 / pass
//		int sum = kor + eng + math;
//		double avg = sum / (double)3;
//		System.out.println("sum:"+sum);
//		System.out.println("average:"+avg);
//		
//		if(avg >=80) {
//			System.out.println("pass");
//		}
		
		
		scan.close();

	}

}
