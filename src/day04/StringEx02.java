package day04;

public class StringEx02 {

	public static void main(String[] args) {
		// file 파일명.확장자
		// 파일명과 확장자로 분리하여 출력
		// 확장자가 java면 자바파일입니다. 출력 (기타파일입니다. 출력)
		
		String file = "자바의정석.java";
		
		String fileName = file.substring(0, file.indexOf("."));
		System.out.println("파일명:"+fileName);
		String suffix = file.substring(file.indexOf(".")+1);
		System.out.println("확장자:"+suffix);
		
		//equals() : 같은지 확인 == 주소가 같은지 확인.  suffix.equals("java")
		if(suffix.equals("java")) {
			System.out.println("java 파일입니다.");
		}else {
			System.out.println("기타 파일입니다.");
		}
		

	}

}
