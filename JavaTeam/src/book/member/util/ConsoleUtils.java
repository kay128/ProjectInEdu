package book.member.util;

import java.util.ArrayList;

import java.util.Scanner;

import book.member.action.Action;
import book.member.action.BookBuyAction;
import book.member.controller.FrontController;
import book.member.dto.Book;

public class ConsoleUtils {
//ä����
	public void showtotalmoneySuccess(ArrayList<Book> list) {
		int tot=0;
		System.out.println("== �� ���� ==");
		for(int i=0; i<list.size();i++) {
			Book  b=list.get(i);
			tot+=(b.getCost()*b.getCount());//å�� *�Ǹŷ��� ����
		}
		System.out.println("�� ������� : "+tot+"���Դϴ�.");
	}

	public void showtotalmoneyFail() {
		System.out.println("�� ����� ��꿡 ���� �߽��ϴ�.");
		
	}

	public Book showlistSuccess(ArrayList<Book> list,Scanner sc,String str) {
		// TODO Auto-generated method stub
		Book book=null;
        System.out.println("== "+str+" ���� ��� ==");
        if(list.size()==0) {
        	System.out.println(str+" ���� ��� �� �����ϴ�.");
        	System.out.println();
        	return null;
        }
        System.out.println("�� �������� ��ȸ�� ���� �Ǽ��� �Է����ּ���.");
        System.out.println("[1 ~ 20������ ���� �Է����ּ���.]");
        int page = 0;
        boolean isStop = false;
        do {
        	System.out.print("��� �Ǽ� >> ");
			try {
				page = Integer.parseInt(sc.nextLine());
				if (page < 1 || page > 20) {
					System.out.println("�� �� �Է��ϼ̽��ϴ�.");
					System.out.println("�ٽ� �Է����ּ���.");
					isStop = true;
				} else {
					isStop = false;
				}
			} catch (NumberFormatException e) {
				System.out.println("�� �� �Է��ϼ̽��ϴ�.");
				System.out.println("�ٽ� �Է����ּ���.");
				isStop = true;
			}
		} while (isStop);
        
        int re_count=0; //��� ���� index
        boolean page_check=true; //���� ��� ��� ���� �Ǵ�
        while(true){

        	if(re_count<list.size()&& page_check==true){
	        	Book b=list.get(re_count);
	        	//System.out.println((re_count+1)+". "+b.getName()+"   (��������� : "+b.getAmount()+")");
	        	
				System.out.print((re_count+1) + ". ");
				System.out.println("���� ���� : " + b.getName());
				if (b.getSale() != 0) {
					System.out.println("    ���� : " + (int)(b.getCost()*(1-(b.getSale()*0.01))) +"�� (���� : "+ b.getCost() + "��, ������ : " + b.getSale() + " %)");
				}else if(b.getSale() == 0){
					System.out.println("    ���� : " + b.getCost() + "��");
				}
				System.out.println("    ��� : " + b.getAmount() + "��");
	        	
	        	re_count++;
        	}
        	
        	
        	if((re_count)%page==0 || re_count==list.size()){//�⺻�� 10�� ������ ���  ������ �������� 10�� ������ ���� ������ ����
        		
        		System.out.println("[1. ���������� / 2. ���� ������ / 3. ���� / 4. ����]");
        		int menu=0;
        		
    			do {
    				System.out.print("���� >> ");
    				try {
    					menu = Integer.parseInt(sc.nextLine());
    					if (menu < 1 || menu > 4) {
    						System.out.println("�� �� �Է��ϼ̽��ϴ�.");
    						System.out.println("�ٽ� �Է����ּ���.");
    						isStop = true;
    					} else {
    						isStop = false;
    					}
    				} catch (NumberFormatException e) {
    					System.out.println("�� �� �Է��ϼ̽��ϴ�.");
    					System.out.println("�ٽ� �Է����ּ���.");
    					isStop = true;
    				}
    			} while (isStop);
        		System.out.println();
        		
        		switch(menu){
        			case 1:
        				if(re_count>page){//ù ������ �Ǵ� 
            				page_check=true;
            				if(re_count%page!=0){ //������ ������ ���� 10�̸����� ��� �Ǵ°�� ���� �ϱ� �� �ؼ�
            					re_count-=((re_count%page)+page);
            				}else{
            					re_count-=(page*2);
            				}
        				}else{
            				System.out.println("ù ������ �Դϴ�.");
            				page_check=false;
            			}
        				break;
        			case 2:
        				page_check=true;
            			if(re_count==list.size()){//������ ������ �Ǵ�
                    		System.out.println("������ ������ �Դϴ�.");
                    	}
            			break;
        			case 3:
        				//Action action=new BookBuyAction();
        				//FrontController fc=new FrontController();
        				//fc.processRequest(action, sc);
        				System.out.println("�˻� ��� �� ���Ÿ� ���ϴ� å�� �����Ͽ��ּ���.");
        				int num = 0;
        				boolean inStop = false;
        				do {
        					System.out.print("���� >> ");
        					try {
        						num = Integer.parseInt(sc.nextLine());
        						if (num < 1 || num > re_count) {
        							System.out.println("�� �� �Է��ϼ̽��ϴ�.");
        							System.out.println("�ٽ� �Է����ּ���.");
        							inStop = true;
        						} else {
        							inStop = false;
        						}
        					} catch (NumberFormatException e) {
        						System.out.println("�� �� �Է��ϼ̽��ϴ�.");
        						System.out.println("�ٽ� �Է����ּ���.");
        						inStop = true;
        					}
        				} while (inStop);
        				book = list.get(num-1);
        				book = buy(sc, book);
        				return book;
        			case 4:
        				return null;
        			default:
        				System.out.println("�� �� �Է��ϼ̽��ϴ�.");
        				System.out.println("�ٽ� �Է����ּ���");
        				break;
        		}
        		       		
        	}
        	
        }
	}

	public void showrecommendFail() {
		System.out.println("��õ���� ��� ���� ����");
		
	}
	
	
//������
	public Book getNewBook(Scanner sc){
		System.out.println("== ���� ��� ==");
		System.out.println("����ϰ��� �ϴ� ���� ������ �Է����ּ���.");
		System.out.print("���� ���� >> ");
		String name =sc.nextLine();
		name = (name.replaceAll(" ", "")).toUpperCase();
		int cost = 0;
		boolean inStop = false;
		do {
			System.out.print("���� >> ");
			try {
				cost = Integer.parseInt(sc.nextLine());
				if (cost < 0) {
					System.out.println("�� �� �Է��ϼ̽��ϴ�.");
					System.out.println("�ٽ� �Է����ּ���.");
					inStop = true;
				} else {
					inStop = false;
				}
			} catch (NumberFormatException e) {
				System.out.println("�� �� �Է��ϼ̽��ϴ�.");
				System.out.println("�ٽ� �Է����ּ���.");
				inStop = true;
			}
		} while (inStop);
		int amount=0;
		do {
			System.out.print("���� >> ");
			try {
				amount = Integer.parseInt(sc.nextLine());
		        System.out.println();
				if (amount < 0) {
					System.out.println("�� �� �Է��ϼ̽��ϴ�.");
					System.out.println("�ٽ� �Է����ּ���.");
					inStop = true;
				} else {
					inStop = false;
				}
			} catch (NumberFormatException e) {
				System.out.println("�� �� �Է��ϼ̽��ϴ�.");
				System.out.println("�ٽ� �Է����ּ���.");
				inStop = true;
			}
		} while (inStop);
		
		return new Book(name, cost, amount, 0, 0);
	}
	public void showAddSuccess(Book newBook){
		System.out.println(newBook.getName()+" ���� ����� ���� �Ͽ����ϴ�");
	}
	public void showAddfail(Book newBook){
		System.out.println(newBook.getName()+" ���� ��Ͽ� ���� �Ͽ����ϴ�.");
	}
	public void showAddfail(String name){
		System.out.println(name+" ������ �̹� ��ϵǾ� �ֽ��ϴ�.");
	}
	
//	public String getName(Scanner sc) {
//		System.out.print("���ݺ����� å�̸�=");
//		String modify_book=sc.nextLine();
//		return modify_book;
//	}
	public void showBookFail(String name) {
			System.out.println(name+"����� �����Ͽ����ϴ�.");
	}
	
	public Book getUpdateBook(Book oldbook, Scanner sc) {
		System.out.println("== �ݾ׼���[���� ���� ����] ==");
		System.out.println(oldbook.getName()+"�� ���簡�� : " + oldbook.getCost() + "���Դϴ�.");
		System.out.println("�ش絵���� �������� �Է����ּ���.");
		int discount=0;
		boolean inStop = false;
		do {
			System.out.print("������(%) >> ");
			try {
				discount = Integer.parseInt(sc.nextLine());
				if (discount < 0) {
					System.out.println("�� �� �Է��ϼ̽��ϴ�.");
					System.out.println("�ٽ� �Է����ּ���.");
					inStop = true;
				} else {
					inStop = false;
				}
			} catch (NumberFormatException e) {
				System.out.println("�� �� �Է��ϼ̽��ϴ�.");
				System.out.println("�ٽ� �Է����ּ���.");
				inStop = true;
			}
		} while (inStop);
		oldbook.setSale(discount);
		return oldbook;
	}
	public void showUpdateSuccess() {
		System.out.println("���� ���� ���뿡 �����Ͽ����ϴ�.");
	}
	public void showUpdateFail() {
		System.out.println("���� ���� ���뿡 �����Ͽ����ϴ�.");
	}
	
//��ƿ�

	public String getName(String str, Scanner sc) { // �ѱ��� å ������ �޾ƿ��� method
		String name = null;
		System.out.println("== ���� " + str + " ==");
		System.out.println(str + " �ϰ��� �ϴ� ���� ������ �Է����ּ���");
		System.out.print(" ���� ���� >> ");
		name = sc.nextLine();
		String rename = (name.replaceAll(" ", "")).toUpperCase(); // ������⿡ ���� �˻��� �� �� ������ ����. DB�� å ������ ������� ���� �Է�, �Է¹޴�
																	// å ���� ��� ������� ���� �� ����
		System.out.println();
		return rename;
	}

	public void show(ArrayList<Book> list) { // �޾ƿ� å ������ ����ϴ� method
		Book book = null;
		System.out.println("== �˻� ��� ==");
		for (int i = 0; i < list.size(); i++) {
			book = list.get(i);
			System.out.print((i + 1) + ". ");
			System.out.println("���� ���� : " + book.getName());
			if (book.getSale() != 0) {
				System.out.println("    ���� : " + (int) (book.getCost() * (1 - (book.getSale() * 0.01))) + "�� (���� : "
						+ book.getCost() + "��, ������ : " + book.getSale() + " %)");
			} else if (book.getSale() == 0) {
				System.out.println("    ���� : " + book.getCost() + "��");
			}
			System.out.println("    ��� : " + book.getAmount() + "��");
		}
		System.out.println();
	}

	public Book buyChoice(String str,Scanner sc, ArrayList<Book> list) {
		Book book = null;
		int choice = 0;
		System.out.println("�˻� ��� �� " + str+ " ���ϴ� ������ �����Ͽ��ּ���.");
		boolean inStop = false;
		do {
			System.out.print("���� >> ");
			try {
				choice = Integer.parseInt(sc.nextLine());
				System.out.println();
				if (choice < 0 || choice > list.size()) {
					System.out.println("�� �� �Է��ϼ̽��ϴ�.");
					System.out.println("�ٽ� �Է����ּ���.");
					inStop = true;
				} else {
					inStop = false;
				}
			} catch (NumberFormatException e) {
				System.out.println("�� �� �Է��ϼ̽��ϴ�.");
				System.out.println("�ٽ� �Է����ּ���.");
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

	public Book buy(Scanner sc, Book book) { // �˻� ��� book ��ü�� �޾� ���� ���ο� ���� collection�� �����ϴ� �޼ҵ�
		int choice = 0;
		int num = 0;
		boolean isStop = false;
		System.out.println("== ���� ���� ==");
		System.out.println("�˻��Ͻ� ������ �����Ͻðڽ��ϱ�? ");
		System.out.println(" [1. ���� / 2. ó������]");
		do {
			System.out.print("���� >> ");
			try {
				choice = Integer.parseInt(sc.nextLine());
				if (choice < 0 || choice > 2) {
					System.out.println("�� �� �Է��ϼ̽��ϴ�.");
					System.out.println("�ٽ� �Է����ּ���.");
					isStop = true;
				} else {
					isStop = false;
				}
			} catch (NumberFormatException e) {
				System.out.println("�� �� �Է��ϼ̽��ϴ�.");
				System.out.println("�ٽ� �Է����ּ���.");
				isStop = true;
			}
		} while (isStop);
		System.out.println();
		boolean inStop = false;
		switch (choice) {
		case 1: // ���� ����
			System.out.println(book.getName() + " ���� ���Ÿ� �����ϼ̽��ϴ�.");
				do {
					System.out.print("���� ���� >> ");
					try {
						num = Integer.parseInt(sc.nextLine());
						System.out.println();
						if (num < 1) {
							System.out.println("�� �� �Է��ϼ̽��ϴ�.");
							System.out.println("�ٽ� �Է����ּ���.");
							inStop = true;
						} else {
							inStop = false;
						}
					} catch (NumberFormatException e) {
						System.out.println("�� �� �Է��ϼ̽��ϴ�.");
						System.out.println("�ٽ� �Է����ּ���.");
						inStop = true;
					}
				} while (inStop);
				boolean max = book.buyAmount(num);
				if(max) {
					book = null;
				}else {book.buyCount(num);}				
				break;
			// book dto �� �޼ҵ带 ����Ͽ� ���ż����� count�� �ݿ�.
		case 2: // ���� ���
			System.out.println("ó�� �޴��� ���ư��ϴ�.");
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
		System.out.println("== ���� ������� ==");
		if (list.size() == 0) {
			System.out.println("���� �����ϴ� ������ �����ϴ�.");
		}
		for (int i = 0; i < list.size(); i++) {
			if (i == 10) {
				System.out.println("���ε��� ��� ����� ����Ͻðڽ��ϱ�?");
				System.out.println("[1. ��� / 2. ó������]");
				do {
					System.out.print("���� >> ");
					try {
						choice = Integer.parseInt(sc.nextLine());
						if (choice < 0 || choice > 2) {
							System.out.println("�� �� �Է��ϼ̽��ϴ�.");
							System.out.println("�ٽ� �Է����ּ���.");
							isStop = true;
						} else {
							isStop = false;
						}
					} catch (NumberFormatException e) {
						System.out.println("�� �� �Է��ϼ̽��ϴ�.");
						System.out.println("�ٽ� �Է����ּ���.");
						isStop = true;
					}
				} while (isStop);
				if (choice == 2) {
					break;
				}
			}
			book = list.get(i);
			System.out.print((i + 1) + ". ");
			System.out.println("���� ���� : " + book.getName());
			if (book.getSale() != 0) {
				System.out.println("    ���� : " + (int) (book.getCost() * (1 - (book.getSale() * 0.01))) + "�� (���� : "
						+ book.getCost() + "��, ������ : " + book.getSale() + " %)");
			} else if (book.getSale() == 0) {
				System.out.println("    ���� : " + book.getCost() + "��");
			}
			System.out.println("    ��� : " + book.getAmount() + "��");
		}
		System.out.println();
	}

	public void searchFail(String name) { // DB�� ������ å ������ ���� ���
		System.out.println("���� ���� ' " + name + " '�� �� ������ �Ǹ� �� ��ǰ�� �ƴմϴ�.");
	}

	public void buySuccess(String str, ArrayList<Book> list) { // ���Ű�� DB�� �ݿ����� ������ ��� ���Ÿ� ����Ͽ� list�� �߰��ϱ� ���� �޼ҵ�
		System.out.println("== �� "+ str +" ��� ==");
		for (int i = 0; i < list.size(); i++) {
			System.out.println((i + 1) + ". " + list.get(i).getName());
		}
		System.out.println("����" + str + "�� �����Ͽ����ϴ�.");
		System.out.println();
	}

	public int buyContinue(Scanner sc) {
		System.out.println("�ٸ� ���� ���Ÿ� ����Ͻðڽ��ϱ�?");
		System.out.println("[1. �ٸ� ���� ���� / 2. ����]"); // �ٸ� ���� ���� ���� �Է¹���
		boolean isStop = false;
		int choice = 0;
		do {
			System.out.print("���� >> ");
			try {
				choice = Integer.parseInt(sc.nextLine());
				if (choice < 0 || choice > 2) {
					System.out.println("�� �� �Է��ϼ̽��ϴ�.");
					System.out.println("�ٽ� �Է����ּ���.");
					isStop = true;
				} else {
					isStop = false;
				}
			} catch (NumberFormatException e) {
				System.out.println("�� �� �Է��ϼ̽��ϴ�.");
				System.out.println("�ٽ� �Է����ּ���.");
				isStop = true;
			}
		} while (isStop);
		System.out.println();
		return choice; // ����� ������ ���θ� ���� _ action���� ����
	}

	public void buyFail() { // ���ſ� ������ ��� _ ��� ������ ���� ������
		System.out.println("ó�� �� ������ �߻��Ͽ����ϴ�.");
		System.out.println();
	}

	public void saleFail() {
		System.out.println("���� ���� ����� �ҷ����� ���߽��ϴ�.");
		System.out.println();
	}
	
//����ȣ

	public void showMemberFail(String name) {
		System.out.println(name+" �Է��� å�� �����ϴ�.");
		
	}
	
//	public String getbookname(Scanner sc) {
//		// TODO Auto-generated method stub
//		return null;
//	}
	
	public void showMemberSuccess(Book book) {
		System.out.println("å�̸� = " + book.getName());
		System.out.println("���� = " + (int)(book.getCost()*(1-(book.getSale()*0.01))) +"�� (���� : "+ book.getCost() + "��, ������ : " + book.getSale() + " %)");
		System.out.println("���� = " + book.getAmount());
	
	}
	
	public void showMemberList(Book lol, Scanner sc) {
		int amount=(sc.nextInt() + lol.getAmount());
		System.out.println("�԰� �Ϸ�Ǿ����ϴ�.");
	
		// TODO Auto-generated method stub
		
	}
	public Book getEnterBook(Book book, Scanner sc) {
		System.out.println("�԰� ���� ���� : "+book.getName());
		System.out.println("���� ���� : " + book.getAmount());
		int amount=0;
		boolean inStop = false;
		do {
			System.out.print("�԰� ���� >> ");
			try {
				amount = Integer.parseInt(sc.nextLine());
				if (amount < 0) {
					System.out.println("�� �� �Է��ϼ̽��ϴ�.");
					System.out.println("�ٽ� �Է����ּ���.");
					inStop = true;
				} else {
					inStop = false;
				}
			} catch (NumberFormatException e) {
				System.out.println("�� �� �Է��ϼ̽��ϴ�.");
				System.out.println("�ٽ� �Է����ּ���.");
				inStop = true;
			}
		} while (inStop);
		book.setAmount(book.getAmount()+amount);

		return book;
	}

	
	public void showEnterSuccess() {
		System.out.println("��� �Ǿ����ϴ�.");
		
	}
	
	public void showEnterFail() {
		System.out.println("��Ͽ� �����Ͽ����ϴ�.");
		
	}
	
//�̽�ȯ
	public String showMenu(Scanner sc) {
		System.out.println("==���� ����==");
		System.out.println("1. �̸����� ����");
		System.out.println("2. ���ư���");
		System.out.println("===========");
		System.out.print("����=");
		return sc.nextLine();
	}
	
public int showRefundMenu(Scanner sc) {
		
		System.out.println("==���� ȯ��==");
		System.out.println("1. �̸����� �˻�");
		System.out.println("===========");
		System.out.print("����=");
		int menuNo = Integer.parseInt(sc.nextLine());
		return menuNo;
	}

	public Book refundBook(Book book, Scanner sc) {
		
		System.out.println("ȯ�� �� ���� ���� >> "+book.getName());
		 if(book.getCount() ==0){
				System.out.println("�Ǹ� ������ 0 �Դϴ�.");
				return null;
			}
		 boolean inStop = false;
		int amount=0;
		do {
			System.out.print("ȯ�� ���� ���� >>  ");
			try {
				amount = Integer.parseInt(sc.nextLine());
				if (amount < 0) {
					System.out.println("�� �� �Է��ϼ̽��ϴ�.");
					System.out.println("�ٽ� �Է����ּ���.");
					inStop = true;
				} else {
					inStop = false;
				}
			} catch (NumberFormatException e) {
				System.out.println("�� �� �Է��ϼ̽��ϴ�.");
				System.out.println("�ٽ� �Է����ּ���.");
				inStop = true;
			}
		} while (inStop);
		System.out.println();
		
		if(book.getCount() <amount){
			System.out.println("�Ǹ� ���� ���� �����ϴ�.");
			return null;
		}
		book.setAmount(book.getAmount()+amount);
		book.setCount(book.getCount()-amount);
		return book;
	}


	
	
//	public String getName(String str, Scanner sc) {
//		System.out.println(str + "�� å�� �̸��� �Է��ϼ���.");
//	    System.out.print("�̸� = ");
//	    return sc.nextLine();
//	}
	
//	public void showMemberFail(String name) {
//		System.out.println("�Է��� �̸��� å " + name + " �� �������� �ʽ��ϴ�.");
//	}
	public void showRemoveSuccess() {
		System.out.println("���� ������ �����Ͽ����ϴ�.");
	}
		
	public void showRemoveFail() {
		System.out.println("���� ������ �����Ͽ����ϴ�.");
	}
	
	public void showrefundSuccess(Book book) { // ���Ű�� DB�� �ݿ����� ������ ��� ���Ÿ� ����Ͽ� list�� �߰��ϱ� ���� �޼ҵ�

		System.out.println(book.getName()+"���� ȯ�ҿ� �����Ͽ����ϴ�.");
		System.out.println();
	}
		
	public void showrefundFail() {
		System.out.println("ȯ�ҿ� �����Ͽ����ϴ�.");
	}
	
}