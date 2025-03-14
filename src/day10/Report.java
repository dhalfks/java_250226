package day10;

import java.text.DecimalFormat;

public class Report {
	/* Report 클래스 생성
	 * 이름  국어  영어  수학  총점  평균  석차 => 멤버변수
	 * 메서드 체크 */
	
	private String name;
	private int korScore;
	private int engScore;
	private int mathScore;
	private int sum;
	private double avg;
	private int ranking;
	
	//생성자
	public Report() {}
	
	public Report(String name, int kor, int eng, int math) {
		this.name = name;
		this.korScore = kor;
		this.engScore = eng;
		this.mathScore = math;
		this.sum = kor + eng + math;
		this.avg = sum / 3.0;
	}
	
	// 만약 객체 생성시 점수가 들어오지 않았다면...
	public void score() {
		// 성적 계산
		this.sum = this.korScore + this.engScore + this.mathScore;
		this.avg = sum / 3.0;
	}

	@Override
	public String toString() {
		DecimalFormat df = new DecimalFormat("#.0");
		return "[이름:" + name + ", 국어:" + korScore + ", 영어:" + engScore + ", 수학:" + mathScore
				+ ", 합계:" + sum + ", 평균:" + df.format(avg) + ", 석차:" + ranking + "]";
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getKorScore() {
		return korScore;
	}

	public void setKorScore(int korScore) {
		this.korScore = korScore;
	}

	public int getEngScore() {
		return engScore;
	}

	public void setEngScore(int engScore) {
		this.engScore = engScore;
	}

	public int getMathScore() {
		return mathScore;
	}

	public void setMathScore(int mathScore) {
		this.mathScore = mathScore;
	}

	public int getSum() {
		return sum;
	}

	public double getAvg() {
		return avg;
	}

	public int getRanking() {
		return ranking;
	}

	public void setRanking(int ranking) {
		this.ranking = ranking;
	}
	
		
}
