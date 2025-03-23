package examStudent;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class Student {
	//학번, 이름, 나이, 전화번호, 주소, 수강과목(Subject class[])
	private String stdNum;
	private String stdName;
	private String stdAge;
	private String stdPhone;
	private String stdAddress;
	private int total;
	private List<Subject> subject = new ArrayList<>();
	
	// 생성자
	public Student() {}

	public Student(String stdNum, String stdName, String stdAge, 
			String stdPhone, String stdAddress) {
		this.stdNum = stdNum;
		this.stdName = stdName;
		this.stdAge = stdAge;
		this.stdPhone = stdPhone;
		this.stdAddress = stdAddress;
	}
	// 내가 필요한 메서드 추가하기.
	// 과목의 객체가 들어오면(입력) 내 수강배열(subject)에 추가
	public void insertSubject(Subject s) {
		subject.add(s);
		System.out.println("수강신청완료");
	}
	
	// 실제 배열에서 수강과목을 삭제하는 메서드
	// subject 배열에서 subNum가 몇번지에 있는지 찾기
	public void deleteSubject(String subNum) {
		if(subject.remove(new Subject(subNum))) {
			System.out.println("수강취소완료");
			return;
		}
		System.out.println("수강과목이 없습니다.");
	}
	
	//점수계산 메서드 
	public void subjectTotal(String subNum, int score) {
		for(int i=0; i< subject.size(); i++) {
			if(subject.get(i).getSubNum().equals(subNum)) {
				subject.get(i).setSubScore(score);
				total += score;
				return;
			}
		}
	}
	
	public void printSubject() {
		for(Subject s : subject) {
			System.out.println(s);
		}
	}
	
	
	@Override
	public int hashCode() {
		return Objects.hash(stdNum);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Student other = (Student) obj;
		return Objects.equals(stdNum, other.stdNum);
	}

	public Student(String stdNum) {
		this.stdNum = stdNum;
	}

	public String getStdNum() {
		return stdNum;
	}

	public void setStdNum(String stdNum) {
		this.stdNum = stdNum;
	}

	public String getStdName() {
		return stdName;
	}

	public void setStdName(String stdName) {
		this.stdName = stdName;
	}

	public String getStdAge() {
		return stdAge;
	}

	public void setStdAge(String stdAge) {
		this.stdAge = stdAge;
	}

	public String getStdPhone() {
		return stdPhone;
	}

	public void setStdPhone(String stdPhone) {
		this.stdPhone = stdPhone;
	}

	public String getStdAddress() {
		return stdAddress;
	}

	public void setStdAddress(String stdAddress) {
		this.stdAddress = stdAddress;
	}

	public List<Subject> getSubject() {
		return subject;
	}

	public void setSubject(List<Subject> subject) {
		this.subject = subject;
	}

	public int getTotal() {
		return total;
	}

	public void setTotal(int total) {
		this.total = total;
	}

	@Override
	public String toString() {
		return "[학번:" + stdNum + " 이름:" + stdName + " 나이:" + stdAge + " 전화번호:" + stdPhone
				+ " 주소:" + stdAddress + "]";
	}
	
	
}
