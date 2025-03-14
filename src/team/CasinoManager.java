package team;

import java.io.IOException;
import java.util.Scanner;

public class CasinoManager {


    public User login(Scanner scan, UserManager m) throws IOException {
      while(true) {
    	System.out.print("회원ID: ");
        String id = scan.next();
        System.out.print("비밀번호: ");
        String pass = scan.next();

        boolean foundUser = false;
        for (int i = 0; i < m.userList.size(); i++) {
            if (m.userList.get(i).getId().equals(id) && m.userList.get(i).getPassword().equals(pass)) {
            	//입력한 아이디와 비번이 'admin'으로 일치한다면 관리자페이지로 바로 이동하도록 설정
            	if(m.userList.get(i).getId().equals("admin")&&m.userList.get(i).getPassword().equals("admin")){
            		admin(scan, m);
            	}

                foundUser = true;
                Thread loginThread = new Thread(() -> {
                    try {
                        System.out.println("𝙇𝙤𝙖𝙙𝙞𝙣𝙜....");
                        for (int j = 0; j < 6; j++) {
                        	
                            Thread.sleep(250);
                            System.out.print(" 🂠 🂡 🂢 🃏");
                           
                        }
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                });
                loginThread.start(); 

                try {
                    loginThread.join();   
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println("");
                UserManager.printInBox("☑ 로그인 성공");
                UserManager.printInBox("회원명: " + m.userList.get(i).getName() + " | 칩: " + m.userList.get(i).getBalance()+"개");
	                return m.userList.get(i);
               }
        	
        }
	            

    if (!foundUser) {
    	UserManager.printInBox("존재하지 않는 유저입니다.");
    	UserManager.printInBox("1.회원가입 | 2. 재입력");
        int menu = scan.nextInt();
        switch (menu) {
		case 1: m.userAdd(scan); break;
		case 2:break;
		default: UserManager.printInBox("잘못된 입력입니다.");
			
		}
    	}
      }
    }



    public void admin(Scanner scan, UserManager u) throws IOException {
System.out.println("╔═══════════════════════════════════════════════════════════╗");
System.out.println("  1.회원등록 | 2.회원삭제 | 3.회원수정 | 4.회원검색 | 5.자본금 | 6.종료");
System.out.println("╚═══════════════════════════════════════════════════════════╝");

        int menu = 0;
        do {
            menu = scan.nextInt();
            switch (menu) {
                case 1:
                    u.userAdd(scan);
                    break;
                case 2:
                    u.deleteUser(scan);
                    break;
                case 3:
                    u.editUser(scan);
                    break;
                case 4:
                    u.searchUser(scan);
                    break;
                case 5:
                    u.balanceChoice(scan);
                    break;
                case 6:
                    break;
                default:

                	u.printInBox("잘못된 입력입니다.");

            }
        } while (menu != 6);
        System.out.println("프로그램을 종료합니다.");
    }

    public void selectGame(Scanner scan, String id, int userBalance, UserManager u) throws InterruptedException, IOException {
        Baccarat baccarat = new Baccarat();
        BlackJack blackjack = new BlackJack(); 

        IndianPokerManager Indian = new IndianPokerManager();
        CoinFlipManager CoinFlip = new CoinFlipManager();
        int menu = 0;
        do {
        	u.printInBox("1.바카라 |2.블랙잭 |3.인디언포커 |4.코인플립 |5.랭킹|6.종료");
            System.out.println("게임을 선택해주세요.");

            menu = scan.nextInt();
            switch (menu) {
                case 1:
                	bacarratImage();
                    baccarat.start(scan, id, userBalance, u);
                    break;
                case 2:
                	blackjackImage();
                    blackjack.start(scan, id, userBalance, u);
                    break;
                case 3:
                	indianImage();
                    Indian.gameStart(scan, id, userBalance, u);
                    break;
                case 4:
                	CoinFilpImage();
                	CoinFlip.gameStart(scan, id, userBalance, u);
                	break;
                case 5:
                    u.rankUsersByBalance();
                    break;
                case 6:
                    break;
                default:
                    System.out.println("잘못된 입력입니다.");
            }
        } while (menu != 6);
        System.out.println("프로그램을 종료합니다.");
    }

    public void mainImage() {
    	System.out.println(""
    			+ "                                                                                   \r"
    			+ "███████╗███████╗███████╗███╗   ██╗     ██████╗ █████╗ ███████╗██╗███╗   ██╗ ██████╗ \r\n"
    			+ "██╔════╝╚══███╔╝██╔════╝████╗  ██║    ██╔════╝██╔══██╗██╔════╝██║████╗  ██║██╔═══██╗\r\n"
    			+ "█████╗    ███╔╝ █████╗  ██╔██╗ ██║    ██║     ███████║███████╗██║██╔██╗ ██║██║   ██║\r\n"
    			+ "██╔══╝   ███╔╝  ██╔══╝  ██║╚██╗██║    ██║     ██╔══██║╚════██║██║██║╚██╗██║██║   ██║\r\n"
    			+ "███████╗███████╗███████╗██║ ╚████║    ╚██████╗██║  ██║███████║██║██║ ╚████║╚██████╔╝\r\n"
    			+ "╚══════╝╚══════╝╚══════╝╚═╝  ╚═══╝");
 
    	}
    public void bacarratImage() {
    	System.out.println(""
    			+ "                                                                  \r"
    			+ "                                                                  \r"
    			+ "                                                                  \r"
    			+ "                                                                  \r"
    			+ "                                                                  \r"
    			+ "██████╗  █████╗  ██████╗ ██████╗ █████╗ ██████╗  █████╗ ████████╗\r\n"
    			+ "██╔══██╗██╔══██╗██╔════╝██╔════╝██╔══██╗██╔══██╗██╔══██╗╚══██╔══╝\r\n"
    			+ "██████╔╝███████║██║     ██║     ███████║██████╔╝███████║   ██║   \r\n"
    			+ "██╔══██╗██╔══██║██║     ██║     ██╔══██║██╔══██╗██╔══██║   ██║   \r\n"
    			+ "██████╔╝██║  ██║╚██████╗╚██████╗██║  ██║██║  ██║██║  ██║   ██║   \r\n"
    			+ "                                                                  \r"
    			+ "                                                                  \r");}
    public void blackjackImage() {
    	System.out.println(""
    			+ "                                                                  \r"
    			+ "                                                                  \r"
    			+ "                                                                  \r"
    			+ "                                                                  \r"
    			+ "                                                                  \r"
    			+ "                                                                  \r"
    			+ "                                                                  \r"
    			+ "██████╗ ██╗      █████╗  ██████╗██╗  ██╗         ██╗ █████╗  ██████╗██╗  ██╗\r\n"
    			+ "██╔══██╗██║     ██╔══██╗██╔════╝██║ ██╔╝         ██║██╔══██╗██╔════╝██║ ██╔╝\r\n"
    			+ "██████╔╝██║     ███████║██║     █████╔╝          ██║███████║██║     █████╔╝ \r\n"
    			+ "██╔══██╗██║     ██╔══██║██║     ██╔═██╗     ██   ██║██╔══██║██║     ██╔═██╗ \r\n"
    			+ "██████╔╝███████╗██║  ██║╚██████╗██║  ██╗    ╚█████╔╝██║  ██║╚██████╗██║  ██╗\r\n"
    			+ "╚═════╝ ╚══════╝╚═╝  ╚═╝ ╚═════╝╚═╝  ╚═╝     ╚════╝ ╚═╝  ╚═╝ ╚═════╝╚═╝  ╚═╝\r\n"
    			+ "                                                                  \r"
    			+ "                                                                  \r"
    			+ "                                                                            ");
    }
    public void indianImage() {
    	System.out.println(""
    			+ "██╗███╗   ██╗██████╗ ██╗ █████╗ ███╗   ██╗    ██████╗  ██████╗ ██╗  ██╗███████╗██████╗ \r\n"
    			+ "██║████╗  ██║██╔══██╗██║██╔══██╗████╗  ██║    ██╔══██╗██╔═══██╗██║ ██╔╝██╔════╝██╔══██╗\r\n"
    			+ "██║██╔██╗ ██║██║  ██║██║███████║██╔██╗ ██║    ██████╔╝██║   ██║█████╔╝ █████╗  ██████╔╝\r\n"
    			+ "██║██║╚██╗██║██║  ██║██║██╔══██║██║╚██╗██║    ██╔═══╝ ██║   ██║██╔═██╗ ██╔══╝  ██╔══██╗\r\n"
    			+ "██║██║ ╚████║██████╔╝██║██║  ██║██║ ╚████║    ██║     ╚██████╔╝██║  ██╗███████╗██║  ██║\r\n"
    			+ "╚═╝╚═╝  ╚═══╝╚═════╝ ╚═╝╚═╝  ╚═╝╚═╝  ╚═══╝    ╚═╝      ╚═════╝ ╚═╝  ╚═╝╚══════╝╚═╝  ╚═╝\r\n"
    			+ "                                                                                       ");}

public void CoinFilpImage() {
	System.out.println(" "
			+ " ██████╗ ██████╗ ██╗███╗   ██╗    ███████╗██╗██╗     ██████╗ \r\n"
			+ "██╔════╝██╔═══██╗██║████╗  ██║    ██╔════╝██║██║     ██╔══██╗\r\n"
			+ "██║     ██║   ██║██║██╔██╗ ██║    █████╗  ██║██║     ██████╔╝\r\n"
			+ "██║     ██║   ██║██║██║╚██╗██║    ██╔══╝  ██║██║     ██╔═══╝ \r\n"
			+ "╚██████╗╚██████╔╝██║██║ ╚████║    ██║     ██║███████╗██║     \r\n"
			+ " ╚═════╝ ╚═════╝ ╚═╝╚═╝  ╚═══╝    ╚═╝     ╚═╝╚══════╝╚═╝     ");}
}