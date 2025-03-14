package team;

import java.io.IOException;
import java.util.Scanner;

public class IndianPokerManager implements IIndianPoker{
	Scanner scan;
	IndianPoker user;
	Deck d = new Deck();
	int priceSum = 0;
	IndianPokerDeck iPK;
	IndianPoker com;
	CasinoManager cm = new CasinoManager();
	public void gameStart(Scanner scan, String id, int userBalance, UserManager uM) throws IOException, InterruptedException {
		iPK = new IndianPokerDeck();
		com = new IndianPoker();
		this.scan = scan;
		int menu = 0;
		com = new IndianPoker();
		user = new IndianPoker(id, userBalance);
		iPK.shuffle();
		while(menu != 1 || menu != 2) {
			UserManager.printInBox("1.게임 시작 | 2.게임 설명 | 3.게임 종료");
			if (scan.hasNextInt()) {
				menu = scan.nextInt();
				if(menu == 1) {
				 int index = 1;
					for(int i = 0; i < 10; i++) {
						if(user.getMoney() >= 21 && com.getMoney() >= 21) {
							System.out.println("=======================================");
							System.out.println("◆◆◆◆◆◆◆◆◆◆◆◆◆◆" + index + "번째 게임◆◆◆◆◆◆◆◆◆◆◆◆◆◆");
							round();
							uM.setUserBalance(id, user.getMoney());
							uM.userUpdate();
						}else {
							System.out.println("칩이 부족합니다!!");
							break;
						}
						index++;
						if(i != 9) {
							UserManager.printInBox("===================라운드 종료===================");
							UserManager.printInBox("게임을 계속하려면 아무키 입력");
							System.out.printf(" >>  ");
							scan.nextLine();
							String next = scan.nextLine();
							if(next != null) {
								continue;
							}
						}
					}
					UserManager.printInBox("10번의 게임이 종료되었습니다.");
					UserManager.printInBox("잠시후 게임 선택 화면으로 돌아갑니다.");

					cm.selectGame(scan, id, user.getMoney(), uM);
				

					
				}else if(menu == 2) {
					System.out.println("================게임 설명================");
					System.out.println("인디언 포커는 10번의 게임으로 진행됩니다.");
					System.out.println("1 ~ 10까지의 카드가 2개씩 존재합니다.");
					System.out.println("사용자는 본인의 패를 알 수 없고 상대방의");
					System.out.println("패만 알 수 있습니다. ");
					System.out.println("상대방의 패를 보고 게임을 포기할지, 아니면");
					System.out.println("추가적으로 돈을 걸어 계속 진행하거나 판돈을");
					System.out.println("유지하며 게임을 진행할 수 있습니다.");
					System.out.println("만약 10의 숫자를 가진 패를 가진 상태에서");
					System.out.println("게임을 포기한다면 칩 10을 잃게 됩니다.");				
					System.out.println("=======================================");
					
					System.out.println("메뉴로 돌아가려면 아무키 입력: ");
					scan.nextLine();
					String next = scan.nextLine();
					if(next != null) {
						continue;
					}
					
					
				}else if(menu == 3) {
					System.out.println("게임 선택 메뉴로 돌아갑니다.");

					cm.selectGame(scan, id, user.getMoney(), uM);

				}
				else {
					System.out.println("알맞은 숫자를 입력하세요!!");
				}
				
			}else {
				System.out.println("알맞은 숫자를 입력하세요!!");
				scan.next(); // 입력 버퍼 비우기
			}
			
		}
		
	}
	
	public void round() throws InterruptedException {
		int myChoice1 = 0;
		int myChoice2 = 0;
		int comChoice = 0;
		priceSum = 0;
		
		for(int i = 0; i < user.handCard.size(); i++) {
			user.handCard.remove(i);
			com.handCard.remove(i);
		}
		System.out.println("게임을 시작합니다.");
		System.out.println("베팅은 3번까지!");
		user.handCard.add(iPK.drawCard());
		priceSum += com.paySetting();
		com.handCard.add(iPK.drawCard());
		priceSum += user.paySetting();
		System.out.println("=======================================");
		
		UserManager.printInBox("사용자 칩 1개 베팅 || 컴퓨터 칩 1개 베팅");
		UserManager.printInBox("사용자 칩: " + user.getMoney()+" || 컴퓨터 칩: " + com.getMoney());
		System.out.println("카드를 받았습니다.");
		
		System.out.println("상대방의 카드");
		d.printCards(com.handCard);
		
		myChoice1 = choice1(scan);
		
		if(myChoice1 == 1) { 
			UserManager.printInBox("FOLD를 선택하셨습니다!");
			if(user.handCard.get(0).getIndex() == 9 || user.handCard.get(0).getIndex() == 19) {
				System.out.println("카드 패가 10이었습니다!!");
				user.setMoney(10);
				priceSum += 10;
			}
			UserManager.printInBox("AI 승!");
			System.out.println("나의 카드");
			d.printCards(user.handCard);
			com.plusMoney(priceSum);
			UserManager.printInBox("사용자 칩: " + user.getMoney());
			return;
		}else if(myChoice1 == 2) { //첫번째
			UserManager.printInBox("user betting 2 Chips");
			user.setMoney(2);
			priceSum += 2;
			
			comChoice = comCal();
			if(comChoice == 1) {
				UserManager.printInBox("Ai가 Fold를 선택했습니다!");
				if(com.handCard.get(0).getIndex() == 9 || com.handCard.get(0).getIndex() == 19) {
					System.out.println("카드 패가 10이었습니다!!");
					com.setMoney(10);
					priceSum += 10;
				}
				UserManager.printInBox("user Win");
				System.out.println("나의 카드");
				d.printCards(user.handCard);
				user.plusMoney(priceSum);
				UserManager.printInBox("사용자 칩: " + user.getMoney());
				return;
			}else if(comChoice == 2) {
				UserManager.printInBox("Ai가 체크를 선택했습니다!");
				priceSum += comChoice;
				checkWin();
				UserManager.printInBox("사용자 칩: " + user.getMoney());
				return;
			}else if(comChoice == 4) {
				UserManager.printInBox("AI betting 4 Chips");
				priceSum += comChoice;
				
				myChoice2 = choice2(scan);
				
				if(myChoice2 == 1) {
					UserManager.printInBox("Fold 하셨습니다!");
					if(user.handCard.get(0).getIndex() == 9 || user.handCard.get(0).getIndex() == 19) {
						System.out.println("카드 패가 10이었습니다!!");
						user.setMoney(10);
						priceSum += 10;
					}
					UserManager.printInBox("상대방의 승");
					System.out.println("나의 카드");
					d.printCards(user.handCard);
					com.plusMoney(priceSum);
					System.out.println("사용자 칩: " + user.getMoney());
					return;
				}else if(myChoice2 == 2) { //두번째
					UserManager.printInBox("user betting 4 Chips");
					user.setMoney(4);
					priceSum += 4;
					
					comChoice = comCal();
					if(comChoice == 1) {
						UserManager.printInBox("AI FOLD가 폴드를 선택했습니다!");
						if(com.handCard.get(0).getIndex() == 9 || com.handCard.get(0).getIndex() == 19) {
							System.out.println("카드 패가 10이었습니다!!");
							com.setMoney(10);
							priceSum += 10;
						}
						UserManager.printInBox("user Win");
						System.out.println("나의 카드");
						d.printCards(user.handCard);
						user.plusMoney(priceSum);
						System.out.println("사용자 칩: " + user.getMoney());
						return;
					}else if(comChoice == 2) {
						UserManager.printInBox("Ai check를 선택했습니다!");
						priceSum += comChoice;
						checkWin();
						System.out.println("사용자 칩: " + user.getMoney());
						return;
					}else if(comChoice == 4) { 
						UserManager.printInBox("computer betting 4 Chips");
						priceSum += comChoice;
						
						myChoice2 = choice2(scan);
						
						if(myChoice2 == 1) {
							UserManager.printInBox("FOLD를 선택하셨습니다!");
							if(user.handCard.get(0).getIndex() == 9 || user.handCard.get(0).getIndex() == 19) {
								UserManager.printInBox("카드 패가 10이었습니다!!");
								user.setMoney(10);
								priceSum += 10;
							}
							UserManager.printInBox("Ai의 승리");
							System.out.println("나의 카드");
							d.printCards(user.handCard);
							com.plusMoney(priceSum);
							System.out.println("사용자 칩: " + user.getMoney());
							return;
						}else if(myChoice2 == 2) { //세번째
							UserManager.printInBox("user betting 4 Chips");
							user.setMoney(4);
							priceSum += 4;
							
							comChoice = comCal();
							if(comChoice == 1) {
								UserManager.printInBox("AI가 FOLD를 선택했습니다!");
								if(com.handCard.get(0).getIndex() == 9 || com.handCard.get(0).getIndex() == 19) {
									System.out.println("카드 패가 10이었습니다!!");
									com.setMoney(10);
									priceSum += 10;
								}
								UserManager.printInBox("user Win");
								System.out.println("나의 카드");
								d.printCards(user.handCard);
								user.plusMoney(priceSum);
								System.out.println("사용자 칩: " + user.getMoney());
								return;
							}else if(comChoice == 2) {
								UserManager.printInBox("AI가 check를 선택했습니다.");
								priceSum += comChoice;
								checkWin();
								UserManager.printInBox("사용자 칩: " + user.getMoney());
								return;
							}else if(comChoice == 4) {
								UserManager.printInBox("computer check");
								priceSum -= 2;
								com.plusMoney(2);
								checkWin();
								UserManager.printInBox("사용자 칩: " + user.getMoney());
								return;
							}
						
						
					}else if(myChoice2 == 3) {
						UserManager.printInBox("user check 2 Chips");
						user.setMoney(2);
						priceSum += 2;
						checkWin();
						UserManager.printInBox("사용자 칩: " + user.getMoney());
						return;
					}
				
				}
			}else if(myChoice2 == 3) {
				UserManager.printInBox("user check 2 Chips");
				user.setMoney(2);
				priceSum += 2;
				checkWin();
				UserManager.printInBox("사용자 칩: " + user.getMoney());
				return;
			}
			}
			
		}
		
	}
	public void checkWin() {
		int userNum = user.handCard.get(0).getIndex() + 1; //0~9  => 1 ~ 10
		int comNum = com.handCard.get(0).getIndex() + 1; //10~19 => 11 ~ 20  1 ~ 20

		if(userNum >= 1 && userNum <=10 ) {
			if(comNum >= 1 && comNum <= 10) {
				if(userNum > comNum) {
					System.out.println("user Win!!");
					System.out.println("나의 카드");
					d.printCards(user.handCard);
					user.plusMoney(priceSum);
				}else if(userNum < comNum) {
					System.out.println("AI Win!!");
					System.out.println("나의 카드");
					d.printCards(user.handCard);
					com.plusMoney(priceSum);
				}else if(userNum == comNum) {
					System.out.println("Draw!!");
					System.out.println("나의 카드");
					d.printCards(user.handCard);
					user.plusMoney(priceSum / 2);
					com.plusMoney(priceSum / 2);
				}
			}else if(comNum > 10 && comNum <= 20) {
				userNum += 10;
				if(userNum > comNum) {
					System.out.println("user Win!!");
					System.out.println("나의 카드");
					d.printCards(user.handCard);
					user.plusMoney(priceSum);
				}else if(userNum < comNum) {
					System.out.println("AI Win!!");
					System.out.println("나의 카드");
					d.printCards(user.handCard);
					com.plusMoney(priceSum);
				}else if(userNum == comNum) {
					System.out.println("Draw!!");
					System.out.println("나의 카드");
					d.printCards(user.handCard);
					user.plusMoney(priceSum / 2);
					com.plusMoney(priceSum / 2);
				}
			}
		}else if(userNum > 10 && userNum <= 20) {
			if(comNum >= 1 && comNum <= 10) {
				comNum += 10;
				if(userNum > comNum) {
					System.out.println("user Win!!");
					System.out.println("나의 카드");
					d.printCards(user.handCard);
					user.plusMoney(priceSum);
				}else if(userNum < comNum) {
					System.out.println("AI Win!!");
					System.out.println("나의 카드");
					d.printCards(user.handCard);
					com.plusMoney(priceSum);
				}else if(userNum == comNum) {
					System.out.println("Draw!!");
					System.out.println("나의 카드");
					d.printCards(user.handCard);
					user.plusMoney(priceSum / 2);
					com.plusMoney(priceSum / 2);
				}
			}else if(comNum >= 10 && comNum <= 20) {
				if(userNum > comNum) {
					System.out.println("user Win!!");
					System.out.println("나의 카드");
					d.printCards(user.handCard);
					user.plusMoney(priceSum);
				}else if(userNum < comNum) {
					System.out.println("AI Win!!");
					System.out.println("나의 카드");
					d.printCards(user.handCard);
					com.plusMoney(priceSum);
				}else if(userNum == comNum) {
					System.out.println("Draw!!");
					System.out.println("나의 카드");
					d.printCards(user.handCard);
					user.plusMoney(priceSum / 2);
					com.plusMoney(priceSum / 2);
				}
			}
		}
	}
//	public void checkWin1() {
//		if(user.handCard.get(0).getIndex() > 0 && user.handCard.get(0).getIndex() < 10 ) {
//			if(com.handCard.get(0).getIndex() > 0 && com.handCard.get(0).getIndex() < 10) {
//				if(user.handCard.get(0).getIndex() > com.handCard.get(0).getIndex()) {
//					System.out.println("user Win!!");
//					user.printCards(user.handCard);
//					user.plusMoney(priceSum);
//				}else if(user.handCard.get(0).getIndex() < com.handCard.get(0).getIndex()){
//					System.out.println("computer Win!!");
//					user.printCards(user.handCard);
//					com.plusMoney(priceSum);
//				}else if(user.handCard.get(0).getIndex() == com.handCard.get(0).getIndex()) {
//					System.out.println("Draw!!");
//					user.printCards(user.handCard);
//					user.plusMoney(priceSum / 2);
//					com.plusMoney(priceSum / 2);
//				}
//			}else if(com.handCard.get(0).getIndex() >= 10 && com.handCard.get(0).getIndex() < 20) {
//				int num1 = user.handCard.get(0).getIndex() + 10;
//				if(num1 > com.handCard.get(0).getIndex()) {
//					System.out.println("user Win!!");
//					user.printCards(user.handCard);
//					user.plusMoney(priceSum);
//				}else if(num1 < com.handCard.get(0).getIndex()){
//					System.out.println("computer Win!!");
//					user.printCards(user.handCard);
//					com.plusMoney(priceSum);
//				}else if(num1 == com.handCard.get(0).getIndex()) {
//					System.out.println("Draw!!");
//					user.printCards(user.handCard);
//					user.plusMoney(priceSum / 2);
//					com.plusMoney(priceSum / 2);
//				}
//			}
//		}else if(user.handCard.get(0).getIndex() >= 10 && user.handCard.get(0).getIndex() < 20 ) {
//			if(com.handCard.get(0).getIndex() > 0 && com.handCard.get(0).getIndex() < 10) {
//				int num2 = com.handCard.get(0).getIndex() + 10;
//				if(num2 < user.handCard.get(0).getIndex()) {
//					System.out.println("user Win!!");
//					user.printCards(user.handCard);
//					user.plusMoney(priceSum);
//				}else if(num2 > user.handCard.get(0).getIndex()){
//					System.out.println("computer Win!!");
//					user.printCards(user.handCard);
//					com.plusMoney(priceSum);
//				}else if(num2 == user.handCard.get(0).getIndex()) {
//					System.out.println("Draw!!");
//					user.printCards(user.handCard);
//					user.plusMoney(priceSum / 2);
//					com.plusMoney(priceSum / 2);
//				}
//			}else if(com.handCard.get(0).getIndex() >= 10 && com.handCard.get(0).getIndex() < 20) {
//				if(com.handCard.get(0).getIndex() < user.handCard.get(0).getIndex()) {
//					System.out.println("user Win!!");
//					user.printCards(user.handCard);
//					user.plusMoney(priceSum);
//				}else if(com.handCard.get(0).getIndex() > user.handCard.get(0).getIndex()){
//					System.out.println("computer Win!!");
//					user.printCards(user.handCard);
//					com.plusMoney(priceSum);
//				}else if(com.handCard.get(0).getIndex() == user.handCard.get(0).getIndex()) {
//					System.out.println("Draw!!");
//					user.printCards(user.handCard);
//					user.plusMoney(priceSum / 2);
//					com.plusMoney(priceSum / 2);
//				}
//			}
//		}
//	}
	
	public int choice1(Scanner scan) {
	    int choice = 0;
	    while (true) {
	    	UserManager.printInBox("1. fold | 2. bet(2 Chips)");
	        System.out.println("insert number >>  ");
	        if (scan.hasNextInt()) {
	            choice = scan.nextInt();
	            switch (choice) {
	                case 1:
	                    System.out.println("FOLD");
	                    return 1;
	                case 2:
	                    System.out.println("BET");
	                    return 2;
	                default:
	                    System.out.println("잘못된 선택");
	            }
	        }else {
	            System.out.println("숫자를 입력해주세요");
	            scan.next(); // 입력 버퍼 비우기
	        }
	        
	    }
	}
	
	public int choice2(Scanner scan) {
		int choice = 0;
		while(true) {
			UserManager.printInBox("1.fold | 2.bet(4 Chips) | 3.check(2 Chips)");
			System.out.println("insert number >>  ");
			if (scan.hasNextInt()) {
				choice = scan.nextInt();
				switch(choice) {
				case 1:
					System.out.println("FOLD");
					return 1;
				case 2:
					System.out.println("BET");
					return 2;
				case 3:
					System.out.println("CHECK");
					return 3;
				default:
					System.out.println("잘못된 선택");
				}	
			}else {
	            System.out.println("알맞은 숫자를 입력하세요!!");
	            scan.next(); // 입력 버퍼 비우기
	        }
		}
	}
	
	public int comCal() throws InterruptedException {
		int random1 = 0;
		Thread loginThread = new Thread(() -> {
            try {
            	UserManager.printInBox("컴퓨터가 선택중입니다.");
                for (int j = 0; j < 3; j++) {
                    Thread.sleep(500);
                    System.out.print(".");
                }
                System.out.println();
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
		if((user.handCard.get(0).getIndex() == 0) || (user.handCard.get(0).getIndex() == 10)) { //숫자1
			com.setMoney(4);
			return 4;
			
		}else if((user.handCard.get(0).getIndex() == 1) || (user.handCard.get(0).getIndex() == 11)) { //숫자2
			random1 = (int)(Math.random() * 100) + 1;
			
			if(random1 <= 20) {
				return 1; //die
			}else if(random1 > 20 && random1 <= 60) {
				com.setMoney(2);
				return 2;
			}else if(random1 > 60) {
				com.setMoney(4);
				return 4;
			}
		}else if((user.handCard.get(0).getIndex() == 2) || (user.handCard.get(0).getIndex() == 12)) { //숫자3
			random1 = (int)(Math.random() * 100) + 1;
			
			if(random1 <= 30) {
				return 1; //die
			}else if(random1 > 30 && random1 <= 65) {
				com.setMoney(2);
				return 2;
			}else if(random1 > 65) {
				com.setMoney(4);
				return 4;
			}
		}else if((user.handCard.get(0).getIndex() == 3) || (user.handCard.get(0).getIndex() == 13)) { //숫자4
			random1 = (int)(Math.random() * 100) + 1;
			
			if(random1 <= 35) {
				return 1; //die
			}else if(random1 > 35 && random1 <= 65) {
				com.setMoney(2);
				return 2;
			}else if(random1 > 65) {
				com.setMoney(4);
				return 4;
			}
		}else if((user.handCard.get(0).getIndex() == 4) || (user.handCard.get(0).getIndex() == 14)) { //숫자5
			random1 = (int)(Math.random() * 100) + 1;
			
			if(random1 <= 35) {
				return 1; //die
			}else if(random1 > 35 && random1 <= 65) {
				com.setMoney(2);
				return 2;
			}else if(random1 > 65) {
				com.setMoney(4);
				return 4;
			}
		}else if((user.handCard.get(0).getIndex() == 5) || (user.handCard.get(0).getIndex() == 15)) { //숫자6
			random1 = (int)(Math.random() * 100) + 1;
			
			if(random1 <= 35) {
				return 1; //die
			}else if(random1 > 35 && random1 <= 65) {
				com.setMoney(2);
				return 2;
			}else if(random1 > 65) {
				com.setMoney(4);
				return 4;
			}
		}else if((user.handCard.get(0).getIndex() == 6) || (user.handCard.get(0).getIndex() == 16)) { //숫자7
			random1 = (int)(Math.random() * 100) + 1;
			
			if(random1 <= 35) {
				return 1; //die
			}else if(random1 > 35 && random1 <= 65) {
				com.setMoney(2);
				return 2;
			}else if(random1 > 65) {
				com.setMoney(4);
				return 4;
			}
		}else if((user.handCard.get(0).getIndex() == 7) || (user.handCard.get(0).getIndex() == 17)) { //숫자8
			random1 = (int)(Math.random() * 100) + 1;
			
			if(random1 <= 35) {
				return 1; //die
			}else if(random1 > 35 && random1 <= 65) {
				com.setMoney(2);
				return 2;
			}else if(random1 > 65) {
				com.setMoney(4);
				return 4;
			}
		}else if((user.handCard.get(0).getIndex() == 8) || (user.handCard.get(0).getIndex() == 18)) { //숫자 9
			random1 = (int)(Math.random() * 100) + 1;
			
			if(random1 <= 35) {
				return 1; //die
			}else if(random1 > 35 && random1 <= 65) {
				com.setMoney(2);
				return 2;
			}else if(random1 > 65) {
				com.setMoney(4);
				return 4;
			}
		}else if((user.handCard.get(0).getIndex() == 9) || (user.handCard.get(0).getIndex() == 19)) { //숫자10
			random1 = (int)(Math.random() * 100) + 1;
			
			if(random1 <= 30) {
				return 1; //die
			}else if(random1 > 30 && random1 <= 65) {
				com.setMoney(2);
				return 2;
			}else if(random1 > 65) {
				com.setMoney(4);
				return 4;
			}
		}
		return 1;
	}
}
