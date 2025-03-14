package day08;

public class Exam01 {

	public static void main(String[] args) {
		/* Tv 클래스 생성
		 * 멤버변수 : brand, power, ch, vol
		 * 메서드 : 
		 * power() 
		 * chUp()  / chDown() : 1씩 증가 / 감소
		 * 30까지 있음 30이 넘어가면 1로 순환구조
		 * 
		 * volUp / volDown() : 1씩 증가 / 감소
		 * vol 10까지 있음. 10이 넘으면 10, 0이면 음소거라고 출력
		 * */
		
		Tv t = new Tv();
		t.power();
		t.chUp();
		t.chUp();
		t.setCh(28);
		t.chUp();
		t.chUp();
		t.chUp();
		t.chUp();
		t.chUp();
		System.out.println("----");
		t.chDown();
		t.chDown();
		t.chDown();
		t.chDown();
		t.chDown();
		t.chDown();
		System.out.println("----");
		t.volUp();
		t.volUp();
		t.volUp();
		t.setVol(9);
		t.volUp();
		t.volUp();
		t.volUp();
		System.out.println("----");
		t.volDown();
		t.volDown();
		t.volDown();
		t.volDown();
		t.volDown();
		t.volDown();
		t.volDown();
		t.volDown();
		t.volDown();
		t.volDown();
		t.volDown();
		t.volDown();
		t.volDown();
		
		
		
	}

}

class Tv{
	// 상수 : 변하지 않는 값. = final 변경할 수 없는 값을 지정. (변수명은 대문자로)
	private final String BRAND="LG";
	private boolean power;
	private int ch;
	private int vol;
	
	public Tv() {
		ch = 1;
		vol = 3;
	}
	
	public void print() {
		System.out.println(BRAND+"TV, ch:"+ch+" / vol:"+vol);
	}
	
	public void power() {
		power = !power;
		if(power) {  //tv가 켜져있다면...
			System.out.println("전원이 켜집니다.");
			print();
		}else {
			System.out.println("전원이 꺼집니다.");
		}
	}
	
	public void chUp() { //ch 기본값 = 1
		if(power) {
			ch++;
			if(ch >30) {
				ch=1;
			}
			System.out.println("ch:"+ch);
		}
	}
	
	public void chDown() {
		if(power) {
			ch--;
			if(ch<=0) {
				ch=30;
			}
			System.out.println("ch:"+ch);
		}
	}
	
	public void volUp() {
		if(power) {
			vol++;
			if(vol > 10) {
				vol = 10;
			}
			System.out.println("vol:"+vol);
			
		}
	}
	
	public void volDown() {
		if(power) {
			vol--;
			if(vol <= 0) {
				System.out.println("음소거");
				vol=0;
			}else {
				System.out.println("vol:"+vol);
			}
		}
	}
	
	public boolean isPower() {
		return power;
	}

	public void setPower(boolean power) {
		this.power = power;
	}

	public int getCh() {
		return ch;
	}

	public void setCh(int ch) {
		this.ch = ch;
	}

	public int getVol() {
		return vol;
	}

	public void setVol(int vol) {
		this.vol = vol;
	}

	public String getBRAND() {
		return BRAND;
	}

	
}