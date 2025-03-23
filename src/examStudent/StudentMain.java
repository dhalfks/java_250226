package examStudent;

import java.util.Scanner;


public class StudentMain {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner scan = new Scanner(System.in);
		
		// 컨트롤러 객체 생성
		StudentController sc = new StudentController();
		/*	- 학생등록 | 학생리스트출력 | 학생검색(학생정보)
			- 학생정보수정 | 학생삭제
			- 수강신청 | 수강철회
			- 과목별 신청자리스트 (학생정보)
			- 학생별 성적표 출력 (학생의 수강정보+성적) => 성적평균
			- 종료
		 * */
		int menu = 0;
		sc.addStudent();
		sc.addSubList();
		do {
			// 메뉴 넣기 
			
			menu = sc.menuPrint(scan);
			
			//sc.subListPrint();
			
			switch(menu) {
			case 1: sc.insertStudent(scan); break;
			case 2: sc.printStudent(); break;
			case 3: sc.searchStudent(scan); break;
			case 4: sc.modifyStudent(scan); break;
			case 5: sc.removeStudent(scan); break;
			case 6: sc.insertSubject(scan); break;
			case 7: sc.deleteSubject(scan); break;
			case 8: sc.searchSubject(scan); break;
			case 9: sc.insertScore(scan); break;
			case 10: sc.printSubject(scan); break;
			case 11: 
				System.out.println("종료");
				break;
				default :
					System.out.println("잘못된 메뉴");
			}
			
			
		}while(menu != 11);
		
		scan.close();
	}

}
