package rank;

public class StudentManager {
	
	public static void main(String[] args) {
		Student[] std = new Student[5];
		int cnt=0;
		Student s = new Student("hong");
		std[cnt]=s;
		cnt++;
		Student s1 = new Student("kim", 90, 80, 70);
		std[cnt]=s1;
		cnt++;
		s.setKorScore(30);
		s.setEngScore(75);
		s.setMathScore(96);
		s.score();
		
//		System.out.println(s);
//		System.out.println(s1);
		
		//순위
		for(int i=0; i<cnt; i++){
			int rank = 1;
			for(int r=0; r<cnt; r++) {
				if(std[i].getSum() < std[r].getSum()) {
					rank++;
				}
				std[i].setRanking(rank); // ranking 배열에 넣기
			}
			
			System.out.println(std[i]);
		}
		
	}
	
	


}
