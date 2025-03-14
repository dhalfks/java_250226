package day03;

import java.util.Scanner;

public class Exam02 {

	public static void main(String[] args) {
		/* 주사위 게임
		 * 주사위를 던져서 총 30칸을 이동하는 게임
		 * 주사위는 랜덤으로 생성 (1~6까지 중 생성)
		 * ex)
		 * 주사위 : 3
		 * 3칸전진 => 27칸 남았습니다.
		 * 주사위 : 1
		 * 1칸전진 => 26칸 남았습니다.
		 * 주사위 : 6
		 * 6칸전진 => 20칸 남았습니다.
		 * ...
		 * 도착~!!  총 이동횟수 : 10번 => 주사위를 던진 횟수
		 * */
		
		/* 지역변수 범위 {  } */
		
		Scanner scan = new Scanner(System.in);
		
		int sum = 0; //거리 누적 값 (주사위 누적)
		int count = 0; // 주사위 던진 횟수 (이동횟수)
		int last = 30;  //최종 목표 이동 수
		
		System.out.println("게임시작~!! 주사위를 던져주세요.(enter)");
		while(sum < last) {
			
			scan.nextLine(); // enter를 이용하여 주사위를 던질 수 있게 해줌
			int random = (int)(Math.random()*6)+1;
			System.out.println("주사위 : "+random);
			//발생거리 합산
			sum += random;
			count++;
			System.out.println(random+"칸 전진 => "+(last - sum)
					+"칸 남았습니다.");
		}
		System.out.println("도착~!!, 총이동횟수:"+count);
		
		scan.close();

	}

}
