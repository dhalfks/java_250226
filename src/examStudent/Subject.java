package examStudent;

import java.util.Objects;

public class Subject {
	//과목코드, 과목명, 학점, 시수, 교수명, 시간표, 강의장...
	private String subNum;
	private String subName;
	private int subPoint;
	private int subTime;
	private String subProfessor;
	private String subTimeTable;
	private String subRoom;
	private int subScore;
	
	// 생성자
	public Subject() {}
	
	public Subject(Subject s) {
		this.subNum = s.subNum;
		this.subName = s.subName;
		this.subPoint = s.subPoint;
		this.subTime = s.subTime;
		this.subProfessor = s.subProfessor;
		this.subTimeTable = s.subTimeTable;
		this.subRoom = s.subRoom;
		this.subScore=0;
	}

	public Subject(String subNum, String subName, int subPoint, 
			int subTime, String subProfessor, String subTimeTable,
			String subRoom) {
		this.subNum = subNum;
		this.subName = subName;
		this.subPoint = subPoint;
		this.subTime = subTime;
		this.subProfessor = subProfessor;
		this.subTimeTable = subTimeTable;
		this.subRoom = subRoom;
	}
	public Subject(String subNum) {
		this.subNum = subNum;
		this.subScore=0;
	}
	
	@Override
	public int hashCode() {
		return Objects.hash(subNum);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Subject other = (Subject) obj;
		return Objects.equals(subNum, other.subNum);
	}

	public Subject(String subNum, String subName) {
		this.subNum = subNum;
		this.subName = subName;
	}

	public String getSubNum() {
		return subNum;
	}

	public void setSubNum(String subNum) {
		this.subNum = subNum;
	}

	public String getSubName() {
		return subName;
	}

	public void setSubName(String subName) {
		this.subName = subName;
	}

	public int getSubPoint() {
		return subPoint;
	}

	public void setSubPoint(int subPoint) {
		this.subPoint = subPoint;
	}

	public int getSubTime() {
		return subTime;
	}

	public void setSubTime(int subTime) {
		this.subTime = subTime;
	}

	public String getSubProfessor() {
		return subProfessor;
	}

	public void setSubProfessor(String subProfessor) {
		this.subProfessor = subProfessor;
	}

	public String getSubTimeTable() {
		return subTimeTable;
	}

	public void setSubTimeTable(String subTimeTable) {
		this.subTimeTable = subTimeTable;
	}

	public String getSubRoom() {
		return subRoom;
	}

	public void setSubRoom(String subRoom) {
		this.subRoom = subRoom;
	}

	public int getSubScore() {
		return subScore;
	}

	public void setSubScore(int subScore) {
		this.subScore = subScore;
	}

	@Override
	public String toString() {
		return "과목번호:" + subNum + " 과목명:" + subName + " 학점:" + subPoint + " 시수:" + subTime
				+ " 교수명:" + subProfessor + " 시간표:" + subTimeTable + " 강의실:" + subRoom
				+ " 점수:" + subScore + "\n";
	}
	
}
