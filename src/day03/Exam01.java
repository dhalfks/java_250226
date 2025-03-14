package day03;

import java.util.Scanner;

public class Exam01 {

	public static void main(String[] args) {
		/*up/down 게임
		 * 
		 * 1~50까지의 랜덤 수 생성하여 맞추는 게임 컴퓨터가 랜덤 수 생성 : 23 
		 * 입력> 10 up!! 
		 * 입력> 20 up!! 
		 * 입력> 30 down!! 
		 * 입력> 25 down!! 
		 * 입력> 23 정답!!
		 */

		// 랜덤수 > 내값 up
		// 랜덤수 < 내값 down
		// 랜덤수 == 내값 정답 break;

		Scanner scan = new Scanner(System.in);
		int random = (int)(Math.random()*50)+10; 
		System.out.println(random);
		
		System.out.println("컴퓨터가 랜덤수를 생성하였습니다.");
		int num=0, count=0;
		
		while(true) {
			System.out.println("입력>");
			num = scan.nextInt();
			count++;
			if(random > num) {
				System.out.println("up!!");
			}else if(random < num) {
				System.out.println("down!!");
			}else if(random == num){
				System.out.println("정답!! "+ count+"회");
				break;
			}
			if(count == 5) {
				System.out.println(count+"회 횟수제한 실패!!");
				break;
			}
		}
		scan.close();

	}

}
