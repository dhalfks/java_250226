package day10;

import java.util.Scanner;

public class Exam01 {

	public static void main(String[] args) {
		/* 성적표
		 * 몇명의 성적을 출력할지 결정 > 3
		 * 이름  국어  영어  수학  총점  평균  석차  => syso 출력
		 * hong 89   90   85   OO   OO    O 
		 * choi 89   90   85   OO   OO    O 
		 * park 89   90   85   OO   OO    O 
		 * "\t" : 탭
		 * */
		
		/* Report 클래스 생성
		 * 이름  국어  영어  수학  총점  평균  석차 => 멤버변수
		 * 메서드 체크 
		 * */
		/* main Report 객체의 배열 생성
		 * 석차구하기
		 * */
		
		Scanner scan = new Scanner(System.in);
		
		System.out.println("몇명의 성적을 출력할지 결정 >");
		int count = scan.nextInt(); //3
		
		Report[] report = new Report[count];
		
		for(int i=0; i<count; i++) {
			System.out.println(i+1+" 이름/국어/영어/수학 순으로 입력>");
			Report r = new Report();
			r.setName(scan.next());
			r.setKorScore(scan.nextInt());
			r.setEngScore(scan.nextInt());
			r.setMathScore(scan.nextInt());
			r.score();
			report[i] = r;
		}
		
		// 순위 계산
		for(int i=0; i<report.length; i++) {
			int r = 1;
			for(int j=0; j<report.length; j++) {
				if(report[i].getSum() < report[j].getSum()) {
					r++;
				}
			}
			report[i].setRanking(r);
		}
		
		System.out.println("=========================================");
		System.out.println("이름\t국어\t영어\t수학\t총점\t평균\t순위");
			
		for(Report temp : report) {
			System.out.println(temp);
			
		}
		
		
		
		
		
		scan.close();
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		

	}

}
