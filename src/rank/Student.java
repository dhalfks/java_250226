package rank;

public class Student {

	private String name;
	private int korScore;
	private int engScore;
	private int mathScore;
	private int sum;
	private double avg;
	private int ranking;
	
	public Student() {	}
	
	public Student(String name) {
		this.name = name;
	}
	
	public Student(String name, int kor, int eng, int math) {
		this.name = name;
		this.korScore = kor;
		this.engScore = eng;
		this.mathScore = math;
		this.sum = korScore + engScore+ mathScore;
		this.avg = sum / 3.0;
	}
	
	@Override
	public String toString() {
		return "Student [name=" + name + ", korScore=" + korScore + ", engScore=" + engScore + ", mathScore="
				+ mathScore + ", sum=" + sum + ", avg=" + avg + ", ranking=" + ranking + "]";
	}
	
	public void score() {
		this.sum = korScore + engScore+ mathScore;
		this.avg = sum / 3.0;
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

	public void setSum(int sum) {
		this.sum = sum;
	}

	public double getAvg() {
		return avg;
	}

	public void setAvg(double avg) {
		this.avg = avg;
	}

	public int getRanking() {
		return ranking;
	}

	public void setRanking(int ranking) {
		this.ranking = ranking;
	}
	
	
}
