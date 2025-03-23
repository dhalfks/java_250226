package examStudent;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class StudentController {
	private List<Student> student = new ArrayList<>();
	private List<Subject> subjectList = new ArrayList<>();

	public void addStudent() {
		student.add(new Student("111", "김순이", "20", "010-1111-1111", "서울 강남구"));
		student.add(new Student("222", "박철수", "20", "010-1111-2222", "수원 영통구"));
		student.add(new Student("333", "황순이", "20", "010-1111-3333", "서울 강서구"));
		student.add(new Student("444", "박짱구", "21", "010-1111-4444", "수원 강동구"));
		student.add(new Student("555", "신짱아", "21", "010-1111-5555", "서울 강남구"));
	}

	public void addSubList() {
		// TODO Auto-generated method stub
		subjectList.add(new Subject("1111", "java", 3, 2, "홍길동", "화목/2시~4시", "1강의장"));
		subjectList.add(new Subject("2222", "DB", 3, 2, "이순신", "월수/2시~4시", "2강의장"));
		subjectList.add(new Subject("3333", "HTML", 2, 3, "김영이", "화금/2시~4시", "3강의장"));
		subjectList.add(new Subject("4444", "CSS", 2, 3, "황기동", "월목/2시~4시", "4강의장"));
		subjectList.add(new Subject("5555", "javascript", 3, 3, "박순철", "수목/2시~4시", "5강의장"));
	}

	public int menuPrint(Scanner scan) {
		// TODO Auto-generated method stub
		System.out.println("--menu--");
		System.out.println("1.학생등록 | 2.학생리스트출력 | 3.학생검색(학생정보)");
		System.out.println("4.학생정보수정 | 5.학생삭제");
		System.out.println("6.수강신청 | 7.수강철회");
		System.out.println("8.과목별 신청자 리스트(학생정보)");
		System.out.println("9.학생별 성적등록(교수님전용)");
		System.out.println("10.학생별 성적표 출력(수강정보)| 11.종료");
		System.out.println("메뉴선택 >");
		return scan.nextInt();
	}

	public void insertStudent(Scanner scan) {
		// TODO Auto-generated method stub
		System.out.println("학번>");
		String num = scan.next();
		System.out.println("이름>");
		String name = scan.next();
		System.out.println("나이>");
		String age = scan.next();
		System.out.println("전화번호>");
		String phone = scan.next();
		scan.nextLine(); //공백처리용
		System.out.println("주소>");
		String address = scan.nextLine();
		
		//학생 객체 생성
		Student s = new Student(num, name, age, phone, address);
		student.add(s);
		System.out.println("학생등록완료");
		
	}

	public void printStudent() {
		// TODO Auto-generated method stub
		System.out.println("--학생목록--");
		for(Student s : student) {
			System.out.println(s);
			s.printSubject();
		}
		System.out.println("-----------------");
	}

	public void searchStudent(Scanner scan) {
		// TODO Auto-generated method stub
		System.out.println("학번>");
		String num = scan.next();
		for(Student s : student) {
			if(s.getStdNum().equals(num)) {
				System.out.println(s);
				s.printSubject();
				return;
			}
		}
		System.out.println("검색학번이 없습니다.");
		
	}

	public void removeStudent(Scanner scan) {
		// TODO Auto-generated method stub
		System.out.println("학번>");
		String num = scan.next();
		if(student.remove(new Student(num))) {
			System.out.println("학생삭제완료");
			return;
		}
		System.out.println("학번이 없습니다.");
		
	}

	public void modifyStudent(Scanner scan) {
		// TODO Auto-generated method stub
		System.out.println("학번>");
		String num = scan.next();
		
		
	}
	
	public void subjectListPrint() {
		// TODO Auto-generated method stub
		System.out.println("--과목목록--");
		for(Subject s : subjectList) {
			System.out.println(s);
		}
		System.out.println("-----------------");
	}

	public void insertSubject(Scanner scan) {
		// TODO Auto-generated method stub
		System.out.println("학번>");
		String num = scan.next();
		for(int i=0; i<student.size(); i++) {
			if(student.get(i).getStdNum().equals(num)) {
				subjectListPrint();
				System.out.println("수강신청 번호>");
				String subNum = scan.next();
				Subject tmp = null;
				for(Subject sub : subjectList) {
					if(sub.getSubNum().equals(subNum)) {
						tmp = new Subject(sub);
						System.out.println(tmp);
						student.get(i).insertSubject(tmp);
						return;
					}
				}
				System.out.println("신청 번호가 없습니다.");
				return;
			}
		}
		System.out.println("검색 학번이 없습니다. ");
		
	}

	public void deleteSubject(Scanner scan) {
		// TODO Auto-generated method stub
		System.out.println("학번>");
		String num = scan.next();
		for(int i=0; i<student.size(); i++) {
			if(student.get(i).getStdNum().equals(num)) {
				System.out.println(student.get(i).getSubject());
				System.out.println("수강철회 번호>");
				String subNum = scan.next();
				Subject tmp = new Subject(subNum);
				student.get(i).deleteSubject(subNum);
			}
			System.out.println("수강번호가 없습니다.");
			return;
		}
		System.out.println("검색 학번이 없습니다. ");
	}

	public void searchSubject(Scanner scan) {
		// TODO Auto-generated method stub
		System.out.println("과목번호>");
		String num = scan.next();
		Subject tmp = new Subject(num);
		for(Student s : student) {
			for(int i=0; i<s.getSubject().size(); i++) {
//				s.getSubject().get(i).getSubNum().equals(num)
				if(s.getSubject().get(i).equals(tmp)) {
					System.out.println(s);
				}
			}
		}
	}

	public void printSubject(Scanner scan) {
		// TODO Auto-generated method stub
		System.out.println("학번>");
		String num = scan.next();
		for(Student s : student) {
			s.printSubject();
			System.out.println("평균:"+s.getTotal()/s.getSubject().size());
			return;
		}
	}

	public void insertScore(Scanner scan) {
		// TODO Auto-generated method stub
		System.out.println("학번>");
		String num = scan.next();
		for(Student s : student) {
			if(s.getStdNum().equals(num)) {
				System.out.println(s.getSubject());
				System.out.println("과목번호>");
				String subNum = scan.next();
				System.out.println("점수>");
				int score = scan.nextInt();
				s.subjectTotal(subNum, score);
				return;				
			}
		}
	}

}
