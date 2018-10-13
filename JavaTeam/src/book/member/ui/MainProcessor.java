package book.member.ui;

import java.util.Scanner;

import book.member.action.Action;
import book.member.action.BookAddAction;
import book.member.action.BookBuyAction;
import book.member.action.BookEnterAction;
import book.member.action.BookRecommendAction;
import book.member.action.BookRefundAction;
import book.member.action.BookRemoveAction;
import book.member.action.BookSaleAction;
import book.member.action.BookSearchAction;
import book.member.action.MoneyModifyAction;
import book.member.action.TotalMoneyAction;
import book.member.controller.FrontController;

public class MainProcessor {

	public static void admin_memu(Scanner sc) {
		boolean isStop = false;
		do {
			Action action=null;
			int menu = 0;
			boolean inStop = false;
			FrontController fc=new FrontController();//���α׷��� ��ü �帧�� ���� �ϴ� Ŭ����
			
			System.out.println("== ������ ��� ==");
			System.out.println("  1. �������");
			System.out.println("  2. ��������");
			System.out.println("  3. �԰�");
			System.out.println("  4. �ݾ׼���[���� ���� ����]");
			System.out.println("  5. �Ѹ���");
			System.out.println("  6. ������ ��� ����");
			System.out.println("==============");
			do {
				System.out.print("���� >> ");
				try {
					menu = Integer.parseInt(sc.nextLine());
					if (menu < 1 || menu > 6) {
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
			
			
			
		
			switch(menu) {
				case 1:
					System.out.println();
					action=new BookAddAction();//�������-������
					break;
				case 2:
					System.out.println();
					action=new BookRemoveAction();//��������-�̽�ȯ
					break;
				case 3:
					System.out.println();
					action=new BookEnterAction();//�԰�-����ȣ
					break;
				case 4:
					System.out.println();
					action=new MoneyModifyAction();//�ݾ׼���-������
					break;
				case 5:
					System.out.println();
					action=new TotalMoneyAction();//�Ѹ���-ä����
					break;
				case 6:
					System.out.println();
					System.out.println("������ ���α׷��� ���� �մϴ�.");
					isStop=true;
					break;
				default:
					System.out.println();
					System.out.println("������ �ùٸ��� �ʽ��ϴ�.");
			}//switch end
			if(action != null) {
				fc.processRequest(action, sc);
			}
			
		}while(!isStop);
		
		
	}

	public static void main(String[] args) {
		Scanner sc =new Scanner(System.in);// �Է�
		int c_menu = 0;
		boolean cStop = false;
		FrontController fc=new FrontController();//���α׷��� ��ü �帧�� ���� �ϴ� Ŭ����
		
		while(true) {
			System.out.println("== �������� ���α׷� ==");
			System.out.println("  1. �����˻�");
			System.out.println("  2. ��õ����");
			System.out.println("  3. ���ε���");
			System.out.println("  4. ��������");
			System.out.println("  5. ����ȯ��");
			System.out.println("  6. ���α׷�����");
			System.out.println("===================");
			do {
				System.out.print("���� >> ");
				try {
					c_menu = Integer.parseInt(sc.nextLine());
					if (c_menu < 0 || c_menu > 6) {
						System.out.println("�� �� �Է��ϼ̽��ϴ�.");
						System.out.println("�ٽ� �Է����ּ���.");
						cStop = true;
					} else {
						cStop = false;
					}
				} catch (NumberFormatException e) {
					System.out.println("�� �� �Է��ϼ̽��ϴ�.");
					System.out.println("�ٽ� �Է����ּ���.");
					cStop = true;
				}
			} while (cStop);
			
			Action action=null;
			switch(c_menu) {
				case 0:
					int pwd =Integer.parseInt(sc.nextLine());
					if(pwd==1234) {
						admin_memu(sc);//������ ��� 
					}
					System.out.println();
					break;
				case 1:
					System.out.println();
					action=new BookSearchAction();//�����˻�-����ȣ  ����
					break;
				case 2:
					System.out.println();
					action=new BookRecommendAction();//��õ����-ä���� ����
					break;
				case 3:
					System.out.println();
					action=new BookSaleAction();//���ε���-��ƿ�  ����
					break;
				case 4:
					System.out.println();
					action=new BookBuyAction();//��������-��ƿ�  ����
					break;
				case 5:
					System.out.println();
					action=new BookRefundAction();//����ȯ��-�̽�ȯ ����
					break;
				case 6:
					System.out.println();
					System.out.println("���α׷��� ���� �մϴ�.");
					System.exit(0);
				default:
					System.out.println();
					System.out.println("������ �ùٸ��� �ʽ��ϴ�.");
			}//switch end
			if(action != null) {
				fc.processRequest(action, sc);
			}
		}

	}

}
