package book.member.util;

import java.util.ArrayList;

import java.util.Scanner;

import book.member.action.Action;
import book.member.action.BookBuyAction;
import book.member.controller.FrontController;
import book.member.dto.Book;

public class ConsoleUtils {
//채형섭
	public void showtotalmoneySuccess(ArrayList<Book> list) {
		int tot=0;
		System.out.println("== 총 매출 ==");
		for(int i=0; i<list.size();i++) {
			Book  b=list.get(i);
			tot+=(b.getCost()*b.getCount());//책값 *판매량을 누적
		}
		System.out.println("총 매출액은 : "+tot+"원입니다.");
	}

	public void showtotalmoneyFail() {
		System.out.println("총 매출액 계산에 실패 했습니다.");
		
	}

	public Book showlistSuccess(ArrayList<Book> list,Scanner sc,String str) {
		// TODO Auto-generated method stub
		Book book=null;
        System.out.println("== "+str+" 도서 목록 ==");
        if(list.size()==0) {
        	System.out.println(str+" 도서 목록 이 없습니다.");
        	System.out.println();
        	return null;
        }
        System.out.println("한 페이지에 조회할 도서 권수를 입력해주세요.");
        System.out.println("[1 ~ 20사이의 값을 입력해주세요.]");
        int page = 0;
        boolean isStop = false;
        do {
        	System.out.print("출력 권수 >> ");
			try {
				page = Integer.parseInt(sc.nextLine());
				if (page < 1 || page > 20) {
					System.out.println("잘 못 입력하셨습니다.");
					System.out.println("다시 입력해주세요.");
					isStop = true;
				} else {
					isStop = false;
				}
			} catch (NumberFormatException e) {
				System.out.println("잘 못 입력하셨습니다.");
				System.out.println("다시 입력해주세요.");
				isStop = true;
			}
		} while (isStop);
        
        int re_count=0; //출려 도서 index
        boolean page_check=true; //도서 목록 출력 여부 판단
        while(true){

        	if(re_count<list.size()&& page_check==true){
	        	Book b=list.get(re_count);
	        	//System.out.println((re_count+1)+". "+b.getName()+"   (현재수량은 : "+b.getAmount()+")");
	        	
				System.out.print((re_count+1) + ". ");
				System.out.println("도서 제목 : " + b.getName());
				if (b.getSale() != 0) {
					System.out.println("    가격 : " + (int)(b.getCost()*(1-(b.getSale()*0.01))) +"원 (원가 : "+ b.getCost() + "원, 할인율 : " + b.getSale() + " %)");
				}else if(b.getSale() == 0){
					System.out.println("    가격 : " + b.getCost() + "원");
				}
				System.out.println("    재고 : " + b.getAmount() + "권");
	        	
	        	re_count++;
        	}
        	
        	
        	if((re_count)%page==0 || re_count==list.size()){//기본은 10개 단위로 출력  마지막 페이지가 10개 단위가 되지 않을때 제어
        		
        		System.out.println("[1. 이전페이지 / 2. 다음 페이지 / 3. 구매 / 4. 종료]");
        		int menu=0;
        		
    			do {
    				System.out.print("선택 >> ");
    				try {
    					menu = Integer.parseInt(sc.nextLine());
    					if (menu < 1 || menu > 4) {
    						System.out.println("잘 못 입력하셨습니다.");
    						System.out.println("다시 입력해주세요.");
    						isStop = true;
    					} else {
    						isStop = false;
    					}
    				} catch (NumberFormatException e) {
    					System.out.println("잘 못 입력하셨습니다.");
    					System.out.println("다시 입력해주세요.");
    					isStop = true;
    				}
    			} while (isStop);
        		System.out.println();
        		
        		switch(menu){
        			case 1:
        				if(re_count>page){//첫 페이지 판단 
            				page_check=true;
            				if(re_count%page!=0){ //마지막 페이지 에서 10미만으로 출력 되는경우 제어 하기 위 해서
            					re_count-=((re_count%page)+page);
            				}else{
            					re_count-=(page*2);
            				}
        				}else{
            				System.out.println("첫 페이지 입니다.");
            				page_check=false;
            			}
        				break;
        			case 2:
        				page_check=true;
            			if(re_count==list.size()){//마지막 페이지 판단
                    		System.out.println("마지막 페이지 입니다.");
                    	}
            			break;
        			case 3:
        				//Action action=new BookBuyAction();
        				//FrontController fc=new FrontController();
        				//fc.processRequest(action, sc);
        				System.out.println("검색 결과 중 구매를 원하는 책을 선택하여주세요.");
        				int num = 0;
        				boolean inStop = false;
        				do {
        					System.out.print("선택 >> ");
        					try {
        						num = Integer.parseInt(sc.nextLine());
        						if (num < 1 || num > re_count) {
        							System.out.println("잘 못 입력하셨습니다.");
        							System.out.println("다시 입력해주세요.");
        							inStop = true;
        						} else {
        							inStop = false;
        						}
        					} catch (NumberFormatException e) {
        						System.out.println("잘 못 입력하셨습니다.");
        						System.out.println("다시 입력해주세요.");
        						inStop = true;
        					}
        				} while (inStop);
        				book = list.get(num-1);
        				book = buy(sc, book);
        				return book;
        			case 4:
        				return null;
        			default:
        				System.out.println("잘 못 입력하셨습니다.");
        				System.out.println("다시 입력해주세요");
        				break;
        		}
        		       		
        	}
        	
        }
	}

	public void showrecommendFail() {
		System.out.println("추천도서 목록 생성 실패");
		
	}
	
	
//김현승
	public Book getNewBook(Scanner sc){
		System.out.println("== 도서 등록 ==");
		System.out.println("등록하고자 하는 도서 정보를 입력해주세요.");
		System.out.print("도서 제목 >> ");
		String name =sc.nextLine();
		name = (name.replaceAll(" ", "")).toUpperCase();
		int cost = 0;
		boolean inStop = false;
		do {
			System.out.print("가격 >> ");
			try {
				cost = Integer.parseInt(sc.nextLine());
				if (cost < 0) {
					System.out.println("잘 못 입력하셨습니다.");
					System.out.println("다시 입력해주세요.");
					inStop = true;
				} else {
					inStop = false;
				}
			} catch (NumberFormatException e) {
				System.out.println("잘 못 입력하셨습니다.");
				System.out.println("다시 입력해주세요.");
				inStop = true;
			}
		} while (inStop);
		int amount=0;
		do {
			System.out.print("수량 >> ");
			try {
				amount = Integer.parseInt(sc.nextLine());
		        System.out.println();
				if (amount < 0) {
					System.out.println("잘 못 입력하셨습니다.");
					System.out.println("다시 입력해주세요.");
					inStop = true;
				} else {
					inStop = false;
				}
			} catch (NumberFormatException e) {
				System.out.println("잘 못 입력하셨습니다.");
				System.out.println("다시 입력해주세요.");
				inStop = true;
			}
		} while (inStop);
		
		return new Book(name, cost, amount, 0, 0);
	}
	public void showAddSuccess(Book newBook){
		System.out.println(newBook.getName()+" 도서 등록이 성공 하였습니다");
	}
	public void showAddfail(Book newBook){
		System.out.println(newBook.getName()+" 도서 등록에 실패 하였습니다.");
	}
	public void showAddfail(String name){
		System.out.println(name+" 도서가 이미 등록되어 있습니다.");
	}
	
//	public String getName(Scanner sc) {
//		System.out.print("가격변경할 책이름=");
//		String modify_book=sc.nextLine();
//		return modify_book;
//	}
	public void showBookFail(String name) {
			System.out.println(name+"등록이 실패하였습니다.");
	}
	
	public Book getUpdateBook(Book oldbook, Scanner sc) {
		System.out.println("== 금액수정[할인 도서 설정] ==");
		System.out.println(oldbook.getName()+"의 현재가격 : " + oldbook.getCost() + "원입니다.");
		System.out.println("해당도서의 할인율을 입력해주세요.");
		int discount=0;
		boolean inStop = false;
		do {
			System.out.print("할인율(%) >> ");
			try {
				discount = Integer.parseInt(sc.nextLine());
				if (discount < 0) {
					System.out.println("잘 못 입력하셨습니다.");
					System.out.println("다시 입력해주세요.");
					inStop = true;
				} else {
					inStop = false;
				}
			} catch (NumberFormatException e) {
				System.out.println("잘 못 입력하셨습니다.");
				System.out.println("다시 입력해주세요.");
				inStop = true;
			}
		} while (inStop);
		oldbook.setSale(discount);
		return oldbook;
	}
	public void showUpdateSuccess() {
		System.out.println("도서 할인 적용에 성공하였습니다.");
	}
	public void showUpdateFail() {
		System.out.println("도서 할인 적용에 실패하였습니다.");
	}
	
//김아영

	public String getName(String str, Scanner sc) { // 한권의 책 제목을 받아오는 method
		String name = null;
		System.out.println("== 도서 " + str + " ==");
		System.out.println(str + " 하고자 하는 도서 제목을 입력해주세요");
		System.out.print(" 도서 제목 >> ");
		name = sc.nextLine();
		String rename = (name.replaceAll(" ", "")).toUpperCase(); // 띄워쓰기에 따라 검색이 안 될 오류를 방지. DB에 책 제목은 띄워쓰기 없이 입력, 입력받는
																	// 책 제목 모두 띄워쓰기 제거 후 실행
		System.out.println();
		return rename;
	}

	public void show(ArrayList<Book> list) { // 받아온 책 정보를 출력하는 method
		Book book = null;
		System.out.println("== 검색 결과 ==");
		for (int i = 0; i < list.size(); i++) {
			book = list.get(i);
			System.out.print((i + 1) + ". ");
			System.out.println("도서 제목 : " + book.getName());
			if (book.getSale() != 0) {
				System.out.println("    가격 : " + (int) (book.getCost() * (1 - (book.getSale() * 0.01))) + "원 (원가 : "
						+ book.getCost() + "원, 할인율 : " + book.getSale() + " %)");
			} else if (book.getSale() == 0) {
				System.out.println("    가격 : " + book.getCost() + "원");
			}
			System.out.println("    재고 : " + book.getAmount() + "권");
		}
		System.out.println();
	}

	public Book buyChoice(String str,Scanner sc, ArrayList<Book> list) {
		Book book = null;
		int choice = 0;
		System.out.println("검색 결과 중 " + str+ " 원하는 도서를 선택하여주세요.");
		boolean inStop = false;
		do {
			System.out.print("선택 >> ");
			try {
				choice = Integer.parseInt(sc.nextLine());
				System.out.println();
				if (choice < 0 || choice > list.size()) {
					System.out.println("잘 못 입력하셨습니다.");
					System.out.println("다시 입력해주세요.");
					inStop = true;
				} else {
					inStop = false;
				}
			} catch (NumberFormatException e) {
				System.out.println("잘 못 입력하셨습니다.");
				System.out.println("다시 입력해주세요.");
				inStop = true;
			}
		} while (inStop);
		for (int i = 0; i < list.size(); i++) {
			if ((choice - 1) == i) {
				book = list.get(i);
			}
		}
		System.out.println(choice + ". " + book.getName());
		System.out.println();
		return book;
	}

	public Book buy(Scanner sc, Book book) { // 검색 결과 book 객체를 받아 구매 여부에 따라 collection에 저장하는 메소드
		int choice = 0;
		int num = 0;
		boolean isStop = false;
		System.out.println("== 도서 구매 ==");
		System.out.println("검색하신 도서를 구매하시겠습니까? ");
		System.out.println(" [1. 구매 / 2. 처음으로]");
		do {
			System.out.print("선택 >> ");
			try {
				choice = Integer.parseInt(sc.nextLine());
				if (choice < 0 || choice > 2) {
					System.out.println("잘 못 입력하셨습니다.");
					System.out.println("다시 입력해주세요.");
					isStop = true;
				} else {
					isStop = false;
				}
			} catch (NumberFormatException e) {
				System.out.println("잘 못 입력하셨습니다.");
				System.out.println("다시 입력해주세요.");
				isStop = true;
			}
		} while (isStop);
		System.out.println();
		boolean inStop = false;
		switch (choice) {
		case 1: // 도서 구매
			System.out.println(book.getName() + " 도서 구매를 선택하셨습니다.");
				do {
					System.out.print("구매 수량 >> ");
					try {
						num = Integer.parseInt(sc.nextLine());
						System.out.println();
						if (num < 1) {
							System.out.println("잘 못 입력하셨습니다.");
							System.out.println("다시 입력해주세요.");
							inStop = true;
						} else {
							inStop = false;
						}
					} catch (NumberFormatException e) {
						System.out.println("잘 못 입력하셨습니다.");
						System.out.println("다시 입력해주세요.");
						inStop = true;
					}
				} while (inStop);
				boolean max = book.buyAmount(num);
				if(max) {
					book = null;
				}else {book.buyCount(num);}				
				break;
			// book dto 내 메소드를 사용하여 구매수량을 count에 반영.
		case 2: // 구매 취소
			System.out.println("처음 메뉴로 돌아갑니다.");
			System.out.println();
			book = null;
			break;
		}
		return book;
	}

	public void sale(ArrayList<Book> list, Scanner sc) {
		String saleS = null;
		Book book = null;
		boolean isStop = false;
		int choice = 0;
		System.out.println("== 할인 도서목록 ==");
		if (list.size() == 0) {
			System.out.println("현재 할인하는 도서가 없습니다.");
		}
		for (int i = 0; i < list.size(); i++) {
			if (i == 10) {
				System.out.println("할인도서 목록 출력을 계속하시겠습니까?");
				System.out.println("[1. 계속 / 2. 처음으로]");
				do {
					System.out.print("선택 >> ");
					try {
						choice = Integer.parseInt(sc.nextLine());
						if (choice < 0 || choice > 2) {
							System.out.println("잘 못 입력하셨습니다.");
							System.out.println("다시 입력해주세요.");
							isStop = true;
						} else {
							isStop = false;
						}
					} catch (NumberFormatException e) {
						System.out.println("잘 못 입력하셨습니다.");
						System.out.println("다시 입력해주세요.");
						isStop = true;
					}
				} while (isStop);
				if (choice == 2) {
					break;
				}
			}
			book = list.get(i);
			System.out.print((i + 1) + ". ");
			System.out.println("도서 제목 : " + book.getName());
			if (book.getSale() != 0) {
				System.out.println("    가격 : " + (int) (book.getCost() * (1 - (book.getSale() * 0.01))) + "원 (원가 : "
						+ book.getCost() + "원, 할인율 : " + book.getSale() + " %)");
			} else if (book.getSale() == 0) {
				System.out.println("    가격 : " + book.getCost() + "원");
			}
			System.out.println("    재고 : " + book.getAmount() + "권");
		}
		System.out.println();
	}

	public void searchFail(String name) { // DB에 동일한 책 제목이 없을 경우
		System.out.println("도서 제목 ' " + name + " '는 본 점에서 판매 중 제품이 아닙니다.");
	}

	public void buySuccess(String str, ArrayList<Book> list) { // 구매결과 DB에 반영까지 성공한 경우 구매를 계속하여 list에 추가하기 위한 메소드
		System.out.println("== 총 "+ str +" 목록 ==");
		for (int i = 0; i < list.size(); i++) {
			System.out.println((i + 1) + ". " + list.get(i).getName());
		}
		System.out.println("도서" + str + "에 성공하였습니다.");
		System.out.println();
	}

	public int buyContinue(Scanner sc) {
		System.out.println("다른 도서 구매를 계속하시겠습니까?");
		System.out.println("[1. 다른 도서 구매 / 2. 종료]"); // 다른 도서 구매 여부 입력받음
		boolean isStop = false;
		int choice = 0;
		do {
			System.out.print("선택 >> ");
			try {
				choice = Integer.parseInt(sc.nextLine());
				if (choice < 0 || choice > 2) {
					System.out.println("잘 못 입력하셨습니다.");
					System.out.println("다시 입력해주세요.");
					isStop = true;
				} else {
					isStop = false;
				}
			} catch (NumberFormatException e) {
				System.out.println("잘 못 입력하셨습니다.");
				System.out.println("다시 입력해주세요.");
				isStop = true;
			}
		} while (isStop);
		System.out.println();
		return choice; // 계속할 것인지 여부를 리턴 _ action으로 리턴
	}

	public void buyFail() { // 구매에 실패한 경우 _ 재고가 부족한 등의 사유로
		System.out.println("처리 중 오류가 발생하였습니다.");
		System.out.println();
	}

	public void saleFail() {
		System.out.println("할인 도서 목록을 불러오지 못했습니다.");
		System.out.println();
	}
	
//김종호

	public void showMemberFail(String name) {
		System.out.println(name+" 입력한 책이 없습니다.");
		
	}
	
//	public String getbookname(Scanner sc) {
//		// TODO Auto-generated method stub
//		return null;
//	}
	
	public void showMemberSuccess(Book book) {
		System.out.println("책이름 = " + book.getName());
		System.out.println("가격 = " + (int)(book.getCost()*(1-(book.getSale()*0.01))) +"원 (원가 : "+ book.getCost() + "원, 할인율 : " + book.getSale() + " %)");
		System.out.println("수량 = " + book.getAmount());
	
	}
	
	public void showMemberList(Book lol, Scanner sc) {
		int amount=(sc.nextInt() + lol.getAmount());
		System.out.println("입고가 완료되었습니다.");
	
		// TODO Auto-generated method stub
		
	}
	public Book getEnterBook(Book book, Scanner sc) {
		System.out.println("입고 도서 제목 : "+book.getName());
		System.out.println("현재 수량 : " + book.getAmount());
		int amount=0;
		boolean inStop = false;
		do {
			System.out.print("입고 수량 >> ");
			try {
				amount = Integer.parseInt(sc.nextLine());
				if (amount < 0) {
					System.out.println("잘 못 입력하셨습니다.");
					System.out.println("다시 입력해주세요.");
					inStop = true;
				} else {
					inStop = false;
				}
			} catch (NumberFormatException e) {
				System.out.println("잘 못 입력하셨습니다.");
				System.out.println("다시 입력해주세요.");
				inStop = true;
			}
		} while (inStop);
		book.setAmount(book.getAmount()+amount);

		return book;
	}

	
	public void showEnterSuccess() {
		System.out.println("등록 되었습니다.");
		
	}
	
	public void showEnterFail() {
		System.out.println("등록에 실패하였습니다.");
		
	}
	
//이승환
	public String showMenu(Scanner sc) {
		System.out.println("==도서 삭제==");
		System.out.println("1. 이름으로 삭제");
		System.out.println("2. 돌아가기");
		System.out.println("===========");
		System.out.print("선택=");
		return sc.nextLine();
	}
	
public int showRefundMenu(Scanner sc) {
		
		System.out.println("==도서 환불==");
		System.out.println("1. 이름으로 검색");
		System.out.println("===========");
		System.out.print("선택=");
		int menuNo = Integer.parseInt(sc.nextLine());
		return menuNo;
	}

	public Book refundBook(Book book, Scanner sc) {
		
		System.out.println("환불 할 도서 제목 >> "+book.getName());
		 if(book.getCount() ==0){
				System.out.println("판매 수량이 0 입니다.");
				return null;
			}
		 boolean inStop = false;
		int amount=0;
		do {
			System.out.print("환불 도서 수량 >>  ");
			try {
				amount = Integer.parseInt(sc.nextLine());
				if (amount < 0) {
					System.out.println("잘 못 입력하셨습니다.");
					System.out.println("다시 입력해주세요.");
					inStop = true;
				} else {
					inStop = false;
				}
			} catch (NumberFormatException e) {
				System.out.println("잘 못 입력하셨습니다.");
				System.out.println("다시 입력해주세요.");
				inStop = true;
			}
		} while (inStop);
		System.out.println();
		
		if(book.getCount() <amount){
			System.out.println("판매 수량 보다 많습니다.");
			return null;
		}
		book.setAmount(book.getAmount()+amount);
		book.setCount(book.getCount()-amount);
		return book;
	}


	
	
//	public String getName(String str, Scanner sc) {
//		System.out.println(str + "할 책의 이름을 입력하세요.");
//	    System.out.print("이름 = ");
//	    return sc.nextLine();
//	}
	
//	public void showMemberFail(String name) {
//		System.out.println("입력한 이름의 책 " + name + " 은 존재하지 않습니다.");
//	}
	public void showRemoveSuccess() {
		System.out.println("도서 삭제에 성공하였습니다.");
	}
		
	public void showRemoveFail() {
		System.out.println("도서 삭제에 실패하였습니다.");
	}
	
	public void showrefundSuccess(Book book) { // 구매결과 DB에 반영까지 성공한 경우 구매를 계속하여 list에 추가하기 위한 메소드

		System.out.println(book.getName()+"도서 환불에 성공하였습니다.");
		System.out.println();
	}
		
	public void showrefundFail() {
		System.out.println("환불에 실패하였습니다.");
	}
	
}