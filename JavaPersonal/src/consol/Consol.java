package consol;

import java.util.ArrayList;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import model.Member;
import model.Query;

public class Consol {
	private Member inMember;
	
	ArrayList<String> keyWordList = new ArrayList<String>();
	ArrayList<String> coSMenu = new ArrayList<String>();
	ArrayList<String> keyList;
	ArrayList<String> valueList;

/* ■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■
 * ■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■  생  성  자  ■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■
 * ■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■ */
	
	public Consol() {}
	public Consol(Member inMember) {
		this.inMember = inMember;
		keyWordList.add("create");
		keyWordList.add("alter");
		keyWordList.add("drop");
		keyWordList.add("insert");
		keyWordList.add("update");
		keyWordList.add("select");
		keyWordList.add("delete");
		keyWordList.add("rollback");
		keyWordList.add("grant");
		
		coSMenu.add("SQL문 수정하기");
		coSMenu.add("SQL문 삭제하기");
		coSMenu.add("이전메뉴로");
		coSMenu.add("ㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡ");
	}

	
/* ■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■
 * ■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■  공통 메소드  ■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■
 * ■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■ */


	public void title(String str) {
		System.out.print("\n ㅡㅡㅡㅡ " + str + " ㅡㅡㅡㅡ ");
	}

	public void fPage() {
		System.out.print("\n  # 처음 페이지로 돌아갑니다. ");

	}

	public void goBack() {
		System.out.print("\n  # 이전 페이지로 돌아갑니다. ");
	}

	public void pwCheckFail() {
		System.out.print("\n  # 삭제를 취소합니다. ");
		System.out.print("\n	   이전 페이지로 돌아갑니다. ");

	}
	
	public int yesOrno(String str, Scanner sc) {
		System.out.print("\n ㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡ ");	
		System.out.print("\n  # "+str);
		int choice = 0;
		boolean arange = false;

		System.out.print("\n    [ 예 : 1 / 아니오 : 2 ] ");

		do {
			try {
				System.out.print("\n  선택 >>  ");
				String c = sc.nextLine();
				if (c.equals(null) || c.replaceAll("", "").equals("") || c.length() == 0) {
					System.out.print("\n  # 메뉴를 선택해주세요. ");
				} else {
					choice = Integer.parseInt(c);
					if (choice < 1 || choice > 2) {
						arange = false;
						System.out.print("\n  # 없는 메뉴 입니다. ");
					}else if (choice >= 1 && choice <= 2) {
						arange = true;
					}
				}
			} catch (NumberFormatException e) {
				System.out.print("\n  # 메뉴는 숫자로 입력해주세요. ");
				arange = false;
			}
		} while (arange == false);
		return choice;
	}

/* ■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■
 * ■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■  회원가입 메소드  ■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■
 * ■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■ */


/* □□□□□□□□□□□□□□□□□□□□□□□□□□□□□□□□□□□□□□□□□ 아이디 입력 □□□□□□□□□□□□□□□□□□□□□□□□□□□□□□□□□□□□□□□□□□ */
	public String idInput(Scanner sc) {
		boolean wordStop = false;
		boolean longStop = false;
		String id = null;
		do {
			System.out.print("\n  # ID 입력방식 ");
			System.out.print("\n      영문자 및 숫자만 입력가능 ");
			System.out.print("\n    3자리 이상 12자리 이하 ");
			System.out.print("\n ㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡ ");
			System.out.print("\n ID >>  ");
			id = sc.nextLine();
			wordStop = Pattern.matches("^*[a-zA-Z0-9]*$", id);
			longStop = (id.length() > 2 && id.length() < 13);
			if (wordStop == false) {
				System.out.print("\n  # ID에는 영문자 및 숫자만 입력가능합니다. ");
				System.out.print("\n      다시 입력해주세요. ");
			} else {
				wordStop = true;
			}
			if (longStop == false) {
				System.out.print("\n  # ID는 3자리 이상, 12자리 이하입니다. ");
				System.out.print("\n      다시 입력해주세요. ");
			} else {
				longStop = true;
			}
		} while (wordStop == false || longStop == false);

		return id;
	}
	
	public void idOk() {
		System.out.print("\n  # 사용할 수 있는 ID입니다. ");
	}

	public void idNo() {
		System.out.print("\n  # 사용중인 ID입니다. ");
	}

/* □□□□□□□□□□□□□□□□□□□□□□□□□□□□□□□□□□□□□□□□□ 비밀번호 입력 □□□□□□□□□□□□□□□□□□□□□□□□□□□□□□□□□□□□□□□□□□ */

	public String pwInput(Scanner sc) {
		String pw = null;
		boolean wordStop = true;
		boolean longStop = true;
		Matcher nMatch = null;
		Matcher eMatch = null;
		Pattern nPattern = Pattern.compile(
				"(^*[0-9].*[!,@,#,$,%,^,&,*,(,),-,_,=,+,;,:,?,/,<,>]*$)|(^*[!,@,#,$,%,^,&,*,(,),-,_,=,+,;,:,?,/,<,>].*[0-9]*$)");
		Pattern ePattern = Pattern.compile("(^*[a-z].*[A-Z]*$)|(^*[A-Z].*[a-z]*$)");
		do {
			System.out.print("\n  # PassWord 입력방식 ");
			System.out.print("\n      영문자 및 숫자 또는 특수문자 포함  ");
			System.out.print("\n    8자리 이상 12자리 이하 ");
			System.out.print("\n ㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡ ");
			System.out.print("\n PassWord >>  ");
			pw = sc.nextLine();
			nMatch = null;
			eMatch = null;
			wordStop = Pattern.matches("^*[a-zA-Z0-9!@#$%^&*()-_=+<>;:?/]*$", pw);
			nMatch = nPattern.matcher(pw);
			eMatch = ePattern.matcher(pw);
			longStop = (pw.length() > 7 && pw.length() < 14);
			if (wordStop == false) {
				System.out.print("\n  # PassWord에는 영문자, 숫자 및 특수문자만 입력가능합니다. ");
				System.out.print("\n      다시 입력해주세요. ");
			} else {
				wordStop = true;
			}
			if (nMatch.find() == false) {
				System.out.print("\n  # PassWord에는 숫자 및 특수문자가 1자 이상 포함되어야 합니다. ");
				System.out.print("\n      다시 입력해주세요. ");
				wordStop = false;
			}
			if (eMatch.find() == false) {
				System.out.print("\n  # PassWord에는 영문자 소문자 및 대문자가 1자 이상 포함되어야 합니다. ");
				System.out.print("\n      다시 입력해주세요. ");
				wordStop = false;
			}
			if (longStop == false) {
				System.out.print("\n  # PassWord는 8자리 이상, 12자리 이하입니다. ");
				System.out.print("\n      다시 입력해주세요. ");
			} else {
				longStop = true;
			}
		} while (wordStop == false || longStop == false);
		return pw;
	}

/* □□□□□□□□□□□□□□□□□□□□□□□□□□□□□□□□□□□□□□□□□ 이름 입력 □□□□□□□□□□□□□□□□□□□□□□□□□□□□□□□□□□□□□□□□□□ */
	
	public String nameInput(Scanner sc) {
		String name = null;
		boolean wordStop = false;
		boolean longStop = false;
		Matcher nMatch = null;
		Pattern nPattern = Pattern.compile(
				"(^*[0-9].*[!,@,#,$,%,^,&,*,(,),-,_,=,+,;,:,?,/,<,>]*$)|(^*[!,@,#,$,%,^,&,*,(,),-,_,=,+,;,:,?,/,<,>].*[0-9]*$)");
		do {
			System.out.print("\n  # 이름 입력방식 ");
			System.out.print("\n      문자 15자 이하 ");
			System.out.print("\n ㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡ ");
			System.out.print("\n 이름 >>  ");
			name = sc.nextLine();
			nMatch = nPattern.matcher(name);
			wordStop = nMatch.find() == true;
			longStop = (name.length() <= 15 && name.length() >= 1);
			if (longStop == false) {
				System.out.print("\n  # 이름은 1자리 이상 15자리 이하입니다. ");
				System.out.print("\n      다시 입력해주세요. ");
			} else {
				longStop = true;
			}
			if (wordStop == true) {
				System.out.print("\n  # 이름에는 숫자 및 특수문자가 입력될 수 없습니다. ");
				System.out.print("\n      다시 입력해주세요. ");
				System.out.println();
				wordStop = false;
			} else {
				wordStop = true;
			}
		} while (longStop == false || wordStop == false);
		return name;
	};

/* □□□□□□□□□□□□□□□□□□□□□□□□□□□□□□□□□□□□□□□□□ 본인 인증 문구 입력 □□□□□□□□□□□□□□□□□□□□□□□□□□□□□□□□□□□□□□□□□□ */

	public String configWordJoin(Scanner sc) {
		String configWord = null;
		int choice = 0;
		boolean inputStop = false;
		boolean longStop = false;
		boolean arange = false;

		do {
			System.out.print("\n  # 본인 인증 문구 입력방식 ");
			System.out.print("\n      문자 30자 이하 ");
			System.out.print("\n ㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡ  ");
			System.out.print("\n 본인 인증 문구[선택사항] >>  ");
			configWord = sc.nextLine();
			longStop = (configWord.length() <= 30);
			if (configWord.replaceAll(" ", "").equals("")) {
				System.out.print("\n  # 본인 인증 문구는 ID 및 PW를 찾기위해 필요합니다. ");
				System.out.print("\n      정말로 입력하지 않으시겠습니까?");
				System.out.print("\n    [ 예 : 1 / 아니오 : 2 ] ");
				System.out.print("\n ㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡ  ");
				do {
					try {
						System.out.print("\n  메뉴 선택 >>   ");
						choice = Integer.parseInt(sc.nextLine());
						if (choice < 1 || choice > 2) {
							arange = false;
							System.out.print("\n  # 없는 메뉴 입니다. ");
						}else if (choice >= 1 && choice <= 2) {
							arange = true;
						}
					} catch (NumberFormatException e) {
						System.out.print("\n  # 메뉴는 숫자로 입력해주세요. ");
						arange = false;
					}
				} while (arange == false);

				switch (choice) {
				case 1:
					inputStop = true;
					longStop = true;
					break;
				case 2:
					inputStop = false;
					break;
				}
			}else {
				if (longStop == false) {
					System.out.print("\n  # 본인 인증 문구 는 15자리 이하입니다. ");
					System.out.print("\n      다시 입력해주세요. ");
				} else {
					inputStop = true;
					longStop = true;
				}
			}			
		} while (longStop == false || inputStop == false);
		return configWord;
	};

/* □□□□□□□□□□□□□□□□□□□□□□□□□□□□□□□□□□□□□□□□□ 회원가입 결과 □□□□□□□□□□□□□□□□□□□□□□□□□□□□□□□□□□□□□□□□□□ */
	
	public void joinSuccess(String id) {
		System.out.print("\n [ " + id + " 님 가입을 환영합니다. ] ");
		System.out.print("\n  # 회원가입에 성공하셨습니다.");
		System.out.print("\n      다시 로그인해주시기 바랍니다. ");

	}

	public void joinFail() {
		System.out.print("\n  # 회원 가입 중 오류가 발생하였습니다. ");

	}


/* ■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■
 * ■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■ 로그인 결과  ■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■
 * ■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■ */


	public void logSuccess(Member member) {
		System.out.println("\n [ " + member.getName() + " 님 환영합니다. ] ");

	}
	
	public void logOut() {
		System.out.print("\n  # 로그아웃합니다. ");
		this.inMember = null;
	}

	public int logFail(String str, Scanner sc) {
		int jChoice = 0;
		boolean arange = false;
		System.out.print("\n  # "+str);
		System.out.print("\n  # 회원가입을 하시겠습니까? ");
		System.out.print("\n    [ 예 : 1 / 아니오 : 2 ] ");
		System.out.print("\n ㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡ");
		do {
			try {
				System.out.print("\n  메뉴 선택 >>  ");
				jChoice = Integer.parseInt(sc.nextLine());
				if (jChoice < 1 || jChoice > 2) {
					arange = true;
					System.out.print("\n  # 없는 메뉴 입니다. ");
				}else if (jChoice >= 1 && jChoice <= 2) {
					arange = false;
				} 
			} catch (NumberFormatException e) {
				System.out.print("\n  # 메뉴는 숫자로 입력해주세요. ");
				arange = true;
			}
		} while (arange);
		return jChoice;
	}
	
	public void caution() {
		System.out.println("\n  # 회원 탈퇴를 하시면 기존 정보는 모두 삭제됩니다. ");		
	}

/* ■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■
 * ■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■ ID/PW 찾기  ■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■
 * ■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■ */

	public int identified(Scanner sc) {
		int choice = 0;
		boolean arange = false;
		System.out.print("\n  # ID/PW를 조회합니다. ");
		System.out.print("\n    (이름, 본인확인 문자 입력) ");
		System.out.print("\n  # 회원 유형을 선택하여주세요. ");
		System.out.print("\n    [ 일반회원 : 1 / 관리자 : 2 / 이전메뉴로 : 0] ");
		System.out.print("\n  ㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡ ");
		do {
			try {
				System.out.print("\n  메뉴 선택 >>  ");
				choice = Integer.parseInt(sc.nextLine());
				if (choice < 0 || choice > 2) {
					arange = true;
					System.out.print("\n  # 없는 메뉴 입니다. ");
				}else if (choice >= 0 && choice <= 2) {
					arange = false;
				} 
			} catch (NumberFormatException e) {
				System.out.print("\n  # 메뉴는 숫자로 입력해주세요. ");
				arange = true;
			}
		} while (arange);
		return choice;
	}
	
	public String configWordInput(Scanner sc) {
		String configWord = null;
		boolean longStop = false;

		do {
			System.out.print("\n  # 회원가입 시 입력했던 본인 확인 문자를 입력해주세요. ");
			System.out.print("\n      문자 30자 이하 ");
			System.out.print("\n ㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡ  ");
			System.out.print("\n 본인 확인 문자[필수입력]  ");
			System.out.print("\n   >>  ");
			configWord = sc.nextLine();
			longStop = (configWord.length() <= 30);
			if (configWord.replaceAll(" ", "").equals("")) {
				System.out.print("\n  # 본인확인 문자가 없다면, 회원정보 확인이 불가능합니다. ");
			}
			if (longStop == false) {
				System.out.print("\n  # 본인확인문자는 15자리 이하입니다. ");
				System.out.print("\n      다시 입력해주세요. ");
			} else {
				longStop = true;
			}
		} while (longStop == false);
		return configWord;
	}
	
	public int infoView(Member infoMember, Scanner sc) {
		int choice = 0;
		boolean arange = false;
		System.out.print("\n  # 회원님의 ID/PW는 아래와 같습니다. ");
		System.out.print("\n 1. ID: " + infoMember.getId());
		System.out.print("\n 2. Password: " + (infoMember.getPw()).subSequence(0, 3));
		for (int i = 3; i < infoMember.getPw().length(); i++) {
			System.out.print("*");
		}
		System.out.print("\n  # 로그인 하시겠습니까? ");
		System.out.print("\n   [ 예 : 1 / 아니오 : 2 ] ");
		System.out.print("\n ㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡ");
		do {
			try {
				System.out.print("\n  메뉴 선택 >>  ");
				choice = Integer.parseInt(sc.nextLine());
				System.out.println();
				if (choice < 1 || choice > 2) {
					arange = true;
					System.out.print("\n  # 없는 메뉴 입니다. ");
				}else if (choice >= 1 && choice <= 2) {
					arange = false;
				} 
			} catch (NumberFormatException e) {
				System.out.print("\n  # 메뉴는 숫자로 입력해주세요. ");
				arange = true;
			}
		} while (arange);
		return choice;
	}
	public void identifiedFail() {
		System.out.print("\n  # 회원님의 ID/PW 조회에 실패하였습니다. ");
	}

/* ■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■
 * ■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■ 회원 메소드  ■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■
 * ■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■ */

	
	
	
/* □□□□□□□□□□□□□□□□□□□□□□□□□□□□□□□□□□□□□□□□□ 회원정보 수정 □□□□□□□□□□□□□□□□□□□□□□□□□□□□□□□□□□□□□□□□□□ */
	
	public Member cModify(Member modifyMember, Scanner sc) {
		boolean wordStop = false;
		boolean longStop = false;
		String id = null;
		String pw = null;
		String name = null;
		String kind = null;
		String configWord = null;
		Member afterMember;

		System.out.print("\n  # 수정정보 입력방식 ");
		System.out.print("\n      수정을 희망하는 항목 만 입력해주세요. ");
		System.out.print("\n ㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡ ");
		System.out.print("\n 수정 회원 ID : " + modifyMember.getId());
		id = modifyMember.getId();
		System.out.print("\n 기존 Password : ");
		System.out.print((modifyMember.getPw()).subSequence(0, 3));
		for (int i = 3; i < modifyMember.getPw().length(); i++) {
			System.out.print("*");
		}
		Matcher nMatch = null;
		Matcher eMatch = null;
		Pattern nPattern = Pattern.compile(
				"(^*[0-9].*[!,@,#,$,%,^,&,*,(,),-,_,=,+,;,:,?,/,<,>]*$)|(^*[!,@,#,$,%,^,&,*,(,),-,_,=,+,;,:,?,/,<,>].*[0-9]*$)");
		Pattern ePattern = Pattern.compile("(^*[a-z].*[A-Z]*$)|(^*[A-Z].*[a-z]*$)");
		do {
			System.out.print("\n 수정 PassWord >>  ");
			pw = sc.nextLine();
			nMatch = null;
			eMatch = null;
			if (pw.replaceAll(" ", "").equals("")) {
				pw = modifyMember.getPw();
				wordStop = true;
				longStop = true;
			} else {
				wordStop = Pattern.matches("^*[a-zA-Z0-9!@#$%^&*()-_=+<>;:?/]*$", pw);
				nMatch = nPattern.matcher(pw);
				eMatch = ePattern.matcher(pw);
				longStop = (pw.length() > 7 && pw.length() < 14);
				if (wordStop == false) {
					System.out.print("\n  # PassWord에는 영문자, 숫자 및 특수문자만 입력가능합니다. ");
					System.out.print("\n      다시 입력해주세요. ");
				} else {
					wordStop = true;
				}
				if (nMatch.find() == false) {
					System.out.print("\n  # PassWord에는 숫자 및 특수문자가 1자 이상 포함되어야 합니다. ");
					System.out.print("\n      다시 입력해주세요. ");
					wordStop = false;
				}
				if (eMatch.find() == false) {
					System.out.print("\n  # PassWord에는 영문자 소문자 및 대문자가 1자 이상 포함되어야 합니다. ");
					System.out.print("\n      다시 입력해주세요. ");
					wordStop = false;
				}
				if (longStop == false) {
					System.out.print("\n  # PassWord는 8자리 이상, 12자리 이하입니다. ");
					System.out.print("\n      다시 입력해주세요. ");
				} else {
					longStop = true;
				}
			}
		} while (wordStop == false || longStop == false);

		wordStop = false;
		longStop = false;
		System.out.print("\n 기존 이름 : " + modifyMember.getName());
		nMatch = null;
		nPattern = Pattern.compile(
				"(^*[0-9].*[!,@,#,$,%,^,&,*,(,),-,_,=,+,;,:,?,/,<,>]*$)|(^*[!,@,#,$,%,^,&,*,(,),-,_,=,+,;,:,?,/,<,>].*[0-9]*$)");
		do {
			System.out.print("\n 수정 이름 >>  ");
			name = sc.nextLine();
			if (name.replaceAll(" ", "").equals("")) {
				name = modifyMember.getName();
				wordStop = true;
				longStop = true;
			} else {
				nMatch = nPattern.matcher(name);
				wordStop = nMatch.find() == true;
				longStop = (name.length() <= 15 && name.length() >= 1);
				if (longStop == false) {
					System.out.print("\n  # 이름은 1자리 이상 15자리 이하입니다. ");
					System.out.print("\n      다시 입력해주세요. ");
				} else {
					longStop = true;
				}
				if (wordStop == true) {
					System.out.print("\n  # 이름에는 숫자 및 특수문자가 입력될 수 없습니다. ");
					System.out.print("\n      다시 입력해주세요. ");
					System.out.println();
					wordStop = false;
				} else {
					wordStop = true;
				}
			}
		} while (longStop == false || wordStop == false);

		System.out.print("\n 기존 권한 : " + modifyMember.getKind());

		kind = modifyMember.getKind();

		wordStop = false;
		longStop = false;
		System.out.print("\n 기존 본인 확인 문자 : " + modifyMember.getConfigWord());
		nMatch = null;

		do {
			System.out.print("\n 수정 본인 확인 문자 >>  ");
			configWord = sc.nextLine();
			longStop = (configWord.length() <= 30);
			if (configWord.replaceAll(" ", "").equals("")) {
				name = modifyMember.getName();
				longStop = true;
			} else {
				if (longStop == false) {
					System.out.print("\n  # 본인확인문자는 15자리 이하입니다. ");
					System.out.print("\n      다시 입력해주세요. ");
				} else {
					longStop = true;
				}
			}
		} while (longStop == false);

		afterMember = new Member(id, pw, name, kind, configWord);

		return afterMember;
	}	
	
	
/* □□□□□□□□□□□□□□□□□□□□□□□□□□□□□□□□□□□□□□□□□ DB 작성 □□□□□□□□□□□□□□□□□□□□□□□□□□□□□□□□□□□□□□□□□□ */
	public void coWrite(String str, String value1) {
		System.out.print("\n  # "+str+" SQL을 작성합니다. ");
		System.out.print("\n      "+str+" 을 위해 " +value1+ " 의 입력이 필요합니다. ");
		System.out.print("\n ㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡ ");
	}
	public void coWrite(String str, String value1, String value2) {
		System.out.print("\n  # "+str+" SQL을 작성합니다. ");
		System.out.print("\n      "+str+"을 위해 " +value1+"과 " +value2+ " 의 입력이 필요합니다. ");
		System.out.print("\n ㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡ ");
	}
	public void coWrite(String str, String value1, String value2,  String value3) {
		System.out.print("\n  # "+str+" SQL을 작성합니다. ");
		System.out.print("\n      "+str+"을 위해 " +value1+", " +value2+"과 " +value3+" 의 입력이 필요합니다. ");
		System.out.print("\n ㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡ ");
	}
	
	public void coWrite(String str, String value1, String value2,  String value3,  String value4) {
		System.out.print("\n  # "+str+" SQL을 작성합니다. ");
		System.out.print("\n      "+str+"을 위해 " +value1+", " +value2+", " +value3+"과 "+ value4+" 의 입력이 필요합니다. ");
		System.out.print("\n ㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡ ");
	}
	
	public void coWrite(String str, String value1, String value2,  String value3,  String value4,  String value5) {
		System.out.print("\n  # "+str+" SQL을 작성합니다. ");
		System.out.print("\n      "+str+"을 위해 " +value1+", " +value2+", " +value3+", "+ value4+"과 "+value5+" 의 입력이 필요합니다. ");
		System.out.print("\n ㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡ ");
	}
	
	public void coModify(Query choicedQuery) {
		System.out.print("\n  # SQL문을 수정합니다. ");
		System.out.println("\n  # 기존 작성 SQL문 : " + choicedQuery.getQuery());
		
	}
	public void coSpecific(Query choicedQuery) {
		System.out.println("\n  # SQL문 상세 : " + choicedQuery.getQuery());
		
	}
	
	public void codingSuccess() {
		System.out.print("\n  # 작성하신 SQL문을 저장하였습니다. ");

	}
	
	public void codingFail() {
		System.out.print("\n  # 작성하신 SQL문을 저장하던 중 오류가 발생하였습니다. ");

	}
	
	public String coUserName(Scanner sc){
		String userName = null;
		boolean wordStop = false;
		boolean longStop = false;
		do {
			System.out.print("\n UserName >>  ");
			userName = sc.nextLine();
			wordStop = Pattern.matches("^*[a-zA-Z0-9]*$", userName);
			longStop = (userName.length() > 0 && userName.length() < 30);
			if(userName == null || userName.replaceAll(" ", "").length() == 0) {
				System.out.print("\n  # UserName을 입력해주세요. ");
				longStop = false;
				wordStop = false;
			}else {
				if (wordStop == false) {
					System.out.print("\n  # UserName에는 영문자 및 숫자만 입력가능합니다. ");
					System.out.print("\n      다시 입력해주세요. ");
				} else {
					wordStop = true;
				}
				if (longStop == false) {
					System.out.print("\n  # UserName는 1자리 이상 30자리 이하입니다. ");
					System.out.print("\n        다시 입력해주세요. ");
				} else {
					longStop = true;
				}
			}
		} while (wordStop == false || longStop == false);
		
		return userName;
	}
	
	public String coPassWord(Scanner sc) {
		String passWord = null;
		boolean wordStop = false;
		boolean longStop = false;
		do {
			System.out.print("\n Password >>  ");
			passWord = sc.nextLine();
			wordStop = Pattern.matches("^*[a-zA-Z0-9]*$", passWord);
			longStop = (passWord.length() > 0 && passWord.length() < 30);

			if (passWord == null || passWord.replaceAll(" ", "").length() == 0) {
				System.out.print("\n  # Password를 입력해주세요. ");
				longStop = false;
				wordStop = false;
			} else {
				if (wordStop == false) {
					System.out.print("\n  # Password에는 영문자 및 숫자만 입력가능합니다. ");
					System.out.print("\n      다시 입력해주세요. ");
				} else {
					wordStop = true;
				}
				if (longStop == false) {
					System.out.print("\n  # Password는 1자리 이상 30자리 이하입니다. ");
				} else {
					longStop = true;
				}
			}
		} while (wordStop == false || longStop == false);

		return passWord;
	};

	public String coAutorityAll(Scanner sc) {
		
		keyList = new ArrayList<String>();
		valueList = new ArrayList<String>();
		
		keyList.add("ㅡㅡㅡㅡ 시스템 권한 목록 ㅡㅡㅡㅡ");
		keyList.add("사용자 생성");
		valueList.add("CREATE USER");
		keyList.add("모든 사용자의 테이블 조회");
		valueList.add("SELECT ANY TABLE");
		keyList.add("모든 사용자의 테이블 생성");
		valueList.add("CREATE ANY TABLE");
		keyList.add("데이터베이스 접속");
		valueList.add("CREATE SESSION");
		keyList.add("테이블 생성");
		valueList.add("CREATE TABLE");
		keyList.add("뷰 생성");
		valueList.add("CREATE VIEW");
		keyList.add("프로시저 생성");
		valueList.add("CREATE PROCED USER");
		keyList.add("시퀀스 생성");
		valueList.add("CREATE SEQUENCE");
		keyList.add("데이터베이스를 관리하는 권한");
		valueList.add("SYSOPER");
		keyList.add("데이터베이스를 관리하는 최고 권한(데이터베이스 생성, 삭제, 불완전 복구 가능)");
		valueList.add("SYSDBA");
		keyList.add("ㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡ");
		
		int choice = 0;
		boolean inputStop = false;
		String autority = null;
		
			System.out.print("\n " + keyList.get(0));
			for (int i = 1; i < keyList.size() - 1; i++) {
				System.out.print("\n  " + (i) + ". " + keyList.get(i) + " ");
			}
			System.out.print("\n " + keyList.get(keyList.size() - 1));
			do {
				try {
					System.out.print("\n  권한 선택 >>  ");
					choice = Integer.parseInt(sc.nextLine());
					System.out.println();
					if (choice > keyList.size() - 2 || choice < 1) {
						System.out.print("\n > 잘 못 선택하셨습니다. 다시 선택해주세요 ");
						inputStop = false;
					}else if (choice < keyList.size() - 2 || choice >= 1) {
						inputStop = true;
					} 
				} catch (NumberFormatException e) {
					System.out.print("\n > 잘 못 선택하셨습니다. 다시 선택해주세요 ");
					inputStop = false;
				}
			} while (inputStop == false);
			for (int i = 1; i < keyList.size() - 1; i++) {
				if(choice == i) {
					autority = valueList.get(i-1);
				}
			}
			
		return autority;
	}
	public String coAutorityTarget(Scanner sc) {
		keyList = new ArrayList<String>();
		valueList = new ArrayList<String>();
		
		keyList.add("ㅡㅡㅡㅡ 객체 권한 목록 ㅡㅡㅡㅡ");
		keyList.add("TABLE 수정(변수, 속성 등) * VIEW는 수정이 불가능하다.");
		valueList.add("ALTER");
		keyList.add("TABLE, VIEW 내용 삭제");
		valueList.add("DELETE");
		keyList.add("TABLE, VIEW 내용 삽입");
		valueList.add("INSERT");
		keyList.add("TABLE, VIEW 내용 수정");
		valueList.add("UPDATE");
		keyList.add("TABLE에 대한 인덱스 작성 * VIEW는 인덱스 작성이 불가능하다.");
		valueList.add("INDEX");
		keyList.add("TABLE, VIEW 자료 선택");
		valueList.add("SELECT");
		keyList.add("프로시저 생성");
		valueList.add("CREATE PROCED USER");
		keyList.add("시퀀스 생성");
		valueList.add("CREATE SEQUENCE");
		keyList.add("ㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡ");
		
		int choice = 0;
		boolean inputStop = false;
		String autority = null;
		
			System.out.print("\n " + keyList.get(0));
			for (int i = 1; i < keyList.size() - 1; i++) {
				System.out.print("\n  " + (i) + ". " + keyList.get(i) + " ");
			}
			System.out.print("\n " + keyList.get(keyList.size() - 1));
			do {
				try {
					System.out.print("\n  권한 선택 >>  ");
					choice = Integer.parseInt(sc.nextLine());
					System.out.println();
					if (choice > keyList.size() - 2 || choice < 1) {
						System.out.print("\n > 잘 못 선택하셨습니다. 다시 선택해주세요 ");
						inputStop = false;
					}else if (choice < keyList.size() - 2 || choice >= 1) {
						inputStop = true;
					} 
				} catch (NumberFormatException e) {
					System.out.print("\n > 잘 못 선택하셨습니다. 다시 선택해주세요 ");
					inputStop = false;
				}
			} while (inputStop == false);
			for (int i = 1; i < keyList.size() - 1; i++) {
				if(choice == i) {
					autority = valueList.get(i-1);
				}
			}
			
		return autority;
	}
	public String coTarget(Scanner sc, String str) {
		String targetName = null;
		boolean wordStop = false;
		boolean longStop = false;
		do {
			System.out.print("\n  # "+str+" TABLE, VIEW등의 이름을 입력해주세요");
			System.out.print("\n 대상 이름 >>  ");
			targetName = sc.nextLine();
			wordStop = Pattern.matches("^*[a-zA-Z0-9]*$", targetName);
			longStop = (targetName.length() > 0 && targetName.length() < 30);
			if (targetName == null || targetName.replaceAll(" ", "").length() == 0) {
				targetName = null;
				longStop = true;
				wordStop = true;
			} else {
			
				if (wordStop == false) {
					System.out.print("\n  # 대상 이름에는 영문자 및 숫자만 입력가능합니다. ");
					System.out.print("\n      다시 입력해주세요. ");
				} else {
					wordStop = true;
				}
				if (longStop == false) {
					System.out.print("\n  # 대상 이름은 1자리 이상 30자리 이하입니다. ");
					System.out.print("\n        다시 입력해주세요. ");
				} else {
					longStop = true;
				}
			}
		} while (wordStop == false || longStop == false);
		
		return targetName;
	}
	
	
	

	
	/* □□□□□□□□□□□□□□□□□□□□□□□□□□□□□□□□□□□□□□□□□ DB 수정 □□□□□□□□□□□□□□□□□□□□□□□□□□□□□□□□□□□□□□□□□□ */
	
	public void codingModifySuccess(Query afterQuery) {
		System.out.print("\n  # "+afterQuery.getDay()+"일에 학습한 " + afterQuery.getKeyWord()+"SQL 문의 수정을 성공하였습니다.");
	}
	public void codingModifyFail() {
		System.out.print("\n  # SQL문 수정 중 오류가 발생했습니다.");
	}

/* □□□□□□□□□□□□□□□□□□□□□□□□□□□□□□□□□□□□□□□□□ DB 조회 □□□□□□□□□□□□□□□□□□□□□□□□□□□□□□□□□□□□□□□□□□ */
	
	public void showList(ArrayList<Query> list) {
		for (int i = 0; i < list.size(); i++) {
			String day = list.get(i).getDay().substring(2, 10);
			if (i == 0) {
				System.out.print("\n  # " + day + " 에 공부한 SQL문");
				System.out.print("\n   " + (i + 1) + ". " + list.get(i).getKeyWord());
			} else {
				String day2 = null;
				day2 = list.get(i-1).getDay().substring(2, 10);
				if (day.equals(day2)) {
					System.out.print("\n   " + (i + 1) + ". " + list.get(i).getKeyWord());
				} else {
					System.out.print("\n ㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡ");
					System.out.print("\n  # " + day + " 에 공부한 SQL문");
					System.out.print("\n   " + (i + 1) + ". " + list.get(i).getKeyWord());
				}
			} 
		}
		System.out.print("\n ㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡ");

	}
	
	public void noList() {
		System.out.print("\n  # 공부하신 SQL문이 없습니다. ");
		System.out.print("\n  	이전 페이지로 돌아갑니다. ");

	}
	
/* □□□□□□□□□□□□□□□□□□□□□□□□□□□□□□□□□□□□□□□□□ DB 선택 □□□□□□□□□□□□□□□□□□□□□□□□□□□□□□□□□□□□□□□□□□ */

	public Query choiceQuery(ArrayList<Query> list, String str, Scanner sc) {
		int choice = 0;
		boolean inputStop = false;
		Query choicedQuery = null;
		System.out.print("\n  # " + str + " 를 원하는 SQL문을 선택해주세요. ");
		System.out.print("\n   [이전 페이지로 가고 싶으면, 0번을 입력해주세요]");
		do {
			try {
				System.out.print("\n  SQL문 선택 >>  ");
				choice = Integer.parseInt(sc.nextLine());
				if (choice == 0) {
					return null;
				}else if (choice > list.size() || choice < 1) {
					System.out.print("\n > 잘 못 선택하셨습니다. 다시 선택해주세요 ");
					inputStop = false;
				} 
				else if (choice <= list.size() || choice >= 1) {
					inputStop = true;
					choicedQuery = list.get(choice - 1);
				}
			} catch (NumberFormatException e) {
				System.out.print("\n > 잘 못 선택하셨습니다. 다시 선택해주세요 ");
				inputStop = false;
			}
		} while (inputStop == false);

		return choicedQuery;
	}
	
	public void quSpecific(Query choicedQuery) {
		System.out.print("\n  1. 일시  " + choicedQuery.getDay());
		System.out.print("\n  2. 내가 작성한SQL문");
		System.out.print("\n    > "+ choicedQuery.getQuery()+"");
		System.out.print("\n  3. SQL문의 구조");
		System.out.print("\n    > "+ choicedQuery.getStructure());
		System.out.print("\n  4. SQL문의 설명");
		System.out.print("\n    > "+ choicedQuery.getExplain());
	}
	
/* □□□□□□□□□□□□□□□□□□□□□□□□□□□□□□□□□□□□□ DB 수정할꺼야 삭제할꺼야? □□□□□□□□□□□□□□□□□□□□□□□□□□□□□□□□□□□□□□ */

	
	public int quChoice(Scanner sc) {
		int choice = 0;
		boolean inputStop = false;
		for (int i = 0; i < coSMenu.size() - 1; i++) {
			System.out.print("\n  " + (i + 1) + ". " + coSMenu.get(i) + " ");
		}
		System.out.print("\n " + coSMenu.get(coSMenu.size() - 1));
		System.out.print("\n   [이전 페이지로 가고 싶으면, 0번을 입력해주세요]");
		
		do {
			try {
				System.out.print("\n  메뉴 선택 >>  ");
				choice = Integer.parseInt(sc.nextLine());
				System.out.println();
				if (choice > coSMenu.size() - 1 || choice < 0) {
					System.out.print("\n > 잘 못 선택하셨습니다. 다시 선택해주세요 ");
					inputStop = false;
				}else if (choice <= coSMenu.size() - 1 || choice >= 0) {
					inputStop = true;
				} 
			} catch (NumberFormatException e) {
				System.out.print("\n > 잘 못 선택하셨습니다. 다시 선택해주세요 ");
				inputStop = false;
			}
		} while (inputStop == false);
		return choice;
	}


	
/* □□□□□□□□□□□□□□□□□□□□□□□□□□□□□□□□□□□□□□□□□ DB 삭제 □□□□□□□□□□□□□□□□□□□□□□□□□□□□□□□□□□□□□□□□□□ */

	public void coDropFail(String keyWord, String string) {
		System.out.println("\n  # " +keyWord+"의 "+string + "에 실패하였습니다.");
		
	}
	public void coDropSuccess(String keyWord, String string) {
		System.out.println("\n  # " +keyWord+"의 "+string + "에 성공하였습니다.");
		
	}
	

/* ■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■
 * ■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■ 관리자 메소드  ■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■
 * ■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■ */

/* □□□□□□□□□□□□□□□□□□□□□□□□□□□□□□□□□□□□□□□□□ 고객 검색 □□□□□□□□□□□□□□□□□□□□□□□□□□□□□□□□□□□□□□□□□□ */

	public String cSearch(Scanner sc) {
		ArrayList<String> csMenu = new ArrayList<String>();
		csMenu.add("ㅡㅡ Customer Search ㅡㅡ");
		csMenu.add("ID로 검색");
		csMenu.add("이름으로 검색");
		csMenu.add("회원 유형으로 검색");
		csMenu.add("이전메뉴로");
		csMenu.add("ㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡ");

		int csChoice = 0;
		boolean inputStop = false;
		String key = null;
		System.out.print("\n  # 회원 검색을 실행합니다. \n");
		System.out.print("\n " + csMenu.get(0));
		for (int x = 1; x < csMenu.size() - 1; x++) {
			System.out.print("\n  " + (x) + ". " + csMenu.get(x) + " ");
		}
		System.out.print("\n " + csMenu.get(csMenu.size() - 1));
		do {
			try {
				System.out.print("\n  메뉴 선택 >>  ");
				csChoice = Integer.parseInt(sc.nextLine());
				 if (csChoice > csMenu.size()-2 || csChoice < 1) {
					 System.out.print("\n > 잘 못 선택하셨습니다. 다시 선택해주세요 ");
					inputStop = false;
				}else if (csChoice <= csMenu.size() - 2 || csChoice >= 1) {
					inputStop = true;
				}
			} catch (NumberFormatException e) {
				System.out.print("\n > 잘 못 선택하셨습니다. 다시 선택해주세요 ");
				inputStop = false;
			}
		} while (inputStop == false);
		switch (csChoice) {
		case 1:
			key = "id";
			break;
		case 2:
			key = "name";
			break;
		case 3:
			key = "kind";
			break;
		case 4:
			key = "exit";
			break;
		}
		return key;
	}
	
	public void csSearchSuccess(ArrayList<Member> list) {
		System.out.print("\n  # 검색 결과 회원 목록을 불러옵니다.   ");
		for (int i = 0; i < list.size(); i++) {
			System.out.print("\n  " + (i + 1) + ". ID : " + list.get(i).getId() + " ");
			System.out.print("\n      이름 : " + list.get(i).getName() + " ");
		}
		System.out.println("\n ㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡ");
	}

	public Member cChoice(String str, ArrayList<Member> list, Scanner sc) {
		int choice = 0;
		boolean inputStop = false;
		Member choicedMember = new Member();
		System.out.print("\n  # " + str + " 실행을 원하는 회원 을 선택해주세요. ");
		System.out.print("\n   [이전 페이지로 가고 싶으면, 0번을 입력해주세요]");
			
		do {
			try {
				System.out.print("\n  회원 선택 >>  ");
				choice = Integer.parseInt(sc.nextLine());
				if (choice == 0) {
					return null;
				}else if (choice > list.size() || choice < 1) {
					System.out.print("\n > 잘 못 선택하셨습니다. 다시 선택해주세요 ");
					inputStop = false;
				} else if (choice <= list.size() || choice >= 1) {
					inputStop = true;
					choicedMember = list.get(choice - 1);
				} 
			} catch (NumberFormatException e) {
				System.out.print("\n > 잘 못 선택하셨습니다. 다시 선택해주세요 ");
				inputStop = false;
			}
		} while (inputStop == false);
		return choicedMember;
	}
	
	public void showMember(Member choicedMember) {
		System.out.print("\n ㅡㅡㅡㅡ 선택한 회원 정보 ㅡㅡㅡㅡ ");
		System.out.print("\n      1. I   D: " + choicedMember.getId());
		System.out.print("\n      2. 이    름: " + choicedMember.getName());
		System.out.print("\n      3. 회원유형: " + choicedMember.getKind());
		System.out.print("\n ㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡ ");
	}

/* □□□□□□□□□□□□□□□□□□□□□□□□□□□□□□□□□□□□□□□□□ ID 검색 □□□□□□□□□□□□□□□□□□□□□□□□□□□□□□□□□□□□□□□□□□ */
	


	public String idSInput(Scanner sc) {
		boolean wordStop = false;
		boolean longStop = false;
		String id = null;
		do {
			System.out.print("\n  # 검색 문구가 포함된 ID를 검색합니다. ");
			System.out.print("\n ID >>  ");
			id = sc.nextLine();
			wordStop = Pattern.matches("^*[a-zA-Z0-9]*$", id);
			longStop = (id.length() > 0 && id.length() < 13);
			if (wordStop == false) {
				System.out.print("\n  # ID에는 영문자 및 숫자만 입력가능합니다. ");
				System.out.print("\n      다시 입력해주세요. ");
			} else {
				wordStop = true;
			}
			if (longStop == false) {
				System.out.print("\n  # ID는 12자리 이하입니다. ");
				System.out.print("\n      다시 입력해주세요. ");
			} else {
				longStop = true;
			}
		} while (wordStop == false || longStop == false);

		return id;
	}

/* □□□□□□□□□□□□□□□□□□□□□□□□□□□□□□□□□□□□□□□□□ 이름 검색 □□□□□□□□□□□□□□□□□□□□□□□□□□□□□□□□□□□□□□□□□□ */
	
	public String nameSInput(Scanner sc) {
		String name = null;
		boolean wordStop = false;
		Matcher nMatch = null;
		Pattern nPattern = Pattern.compile(
				"(^*[0-9].*[!,@,#,$,%,^,&,*,(,),-,_,=,+,;,:,?,/,<,>]*$)|(^*[!,@,#,$,%,^,&,*,(,),-,_,=,+,;,:,?,/,<,>].*[0-9]*$)");
		do {
			System.out.print("\n  # 검색 문구가 포함된 이름을 검색합니다. ");
			System.out.print("\n 이름 >>  ");
			name = sc.nextLine();
			nMatch = nPattern.matcher(name);
			wordStop = nMatch.find() == true;
			if (wordStop) {
				System.out.print("\n  # 이름에는 숫자 및 특수문자가 입력될 수 없습니다. ");
				System.out.print("\n      다시 입력해주세요. ");
			} else {
				wordStop = false;
			}
		} while (wordStop == true);
		return name;
	};

/* □□□□□□□□□□□□□□□□□□□□□□□□□□□□□□□□□□□□□□□□□ 권한 검색 □□□□□□□□□□□□□□□□□□□□□□□□□□□□□□□□□□□□□□□□□□ */

	public String kindSInput(Scanner sc) {
		String kind = null;
		int choice = 0;
		boolean arange = false;
		System.out.print("\n  # 권한으로 검색합니다. ");
		System.out.print("\n       회원 유형을 선택하여주세요. ");
		System.out.print("\n    [ 일반회원 : 1 / 관리자 : 2 ] ");
		System.out.print("\n  ㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡ ");
		do {
			try {
				System.out.print("\n  메뉴 선택 >>   ");
				choice = Integer.parseInt(sc.nextLine());
				if (choice < 1 || choice > 2) {
					arange = false;
					System.out.print("\n  # 없는 메뉴 입니다. ");
				}else if (choice >= 1 && choice <= 2) {
					arange = true;
				} 
			} catch (NumberFormatException e) {
				System.out.print("\n  # 메뉴는 숫자로 입력해주세요. ");
				arange = false;
			}
		} while (arange == false);
		if (choice == 1) {
			kind = "customer";
		} else if (choice == 2) {
			kind = "manager";
		}
		return kind;
	};

/* □□□□□□□□□□□□□□□□□□□□□□□□□□□□□□□□□□□□□□□□□ 성공실패구문? □□□□□□□□□□□□□□□□□□□□□□□□□□□□□□□□□□□□□□□□□□ */
	
	
	public void dropFail(Member modifyMember, String str) {
		System.out.println("\n  # " + modifyMember.getId() + "님의 " + str + "에 실패하였습니다.");

	}

	public void dropSuccess(Member modifyMember, String str) {
		System.out.println("\n  # " + modifyMember.getId() + "님의 " + str + "에 성공하였습니다.");

	}

	public void autorityFail(Member afterMember) {
		System.out.println("\n  # " + afterMember.getId() + "님에게 " + afterMember.getKind() + " 권한 부여에 실패하였습니다.");
	}

	public void autoritySuccess(Member afterMember) {
		System.out.println("\n  # " + afterMember.getId() + "님에게 " + afterMember.getKind() + " 권한을 부여하였습니다.");
	}



	public void csSearchFail(String key, String word) {
		System.out.print("\n  # " + key + " : " + word + "인 회원을 찾을 수 없습니다. ");
	}

/* □□□□□□□□□□□□□□□□□□□□□□□□□□□□□□□□□□□□□□□□□ 회원정보 수정 □□□□□□□□□□□□□□□□□□□□□□□□□□□□□□□□□□□□□□□□□□ */
	
	public Member mModify(Member modifyMember, Scanner sc) {
		boolean wordStop = false;
		boolean longStop = false;
		String id = null;
		String pw = null;
		String name = null;
		String kind = null;
		String configWord = null;
		Member afterMember;

		System.out.print("\n  # 수정정보 입력방식 ");
		System.out.print("\n      수정을 희망하는 항목 만 입력해주세요. ");
		System.out.print("\n ㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡ ");
		System.out.print("\n 수정 회원 ID : " + modifyMember.getId());
		id = modifyMember.getId();
		System.out.print("\n 기존 Password : ");
		System.out.print((modifyMember.getPw()).subSequence(0, 3));
		for (int i = 3; i < modifyMember.getPw().length(); i++) {
			System.out.print("*");
		}
		Matcher nMatch = null;
		Matcher eMatch = null;
		Pattern nPattern = Pattern.compile(
				"(^*[0-9].*[!,@,#,$,%,^,&,*,(,),-,_,=,+,;,:,?,/,<,>]*$)|(^*[!,@,#,$,%,^,&,*,(,),-,_,=,+,;,:,?,/,<,>].*[0-9]*$)");
		Pattern ePattern = Pattern.compile("(^*[a-z].*[A-Z]*$)|(^*[A-Z].*[a-z]*$)");
		do {
			System.out.print("\n 수정 PassWord >>  ");
			pw = sc.nextLine();
			nMatch = null;
			eMatch = null;
			if (pw.replaceAll(" ", "").equals("")) {
				pw = modifyMember.getPw();
				wordStop = true;
				longStop = true;
			} else {
				wordStop = Pattern.matches("^*[a-zA-Z0-9!@#$%^&*()-_=+<>;:?/]*$", pw);
				nMatch = nPattern.matcher(pw);
				eMatch = ePattern.matcher(pw);
				longStop = (pw.length() > 7 && pw.length() < 14);
				if (wordStop == false) {
					System.out.print("\n  # PassWord에는 영문자, 숫자 및 특수문자만 입력가능합니다. ");
					System.out.print("\n      다시 입력해주세요. ");
				} else {
					wordStop = true;
				}
				if (nMatch.find() == false) {
					System.out.print("\n  # PassWord에는 숫자 및 특수문자가 1자 이상 포함되어야 합니다. ");
					System.out.print("\n      다시 입력해주세요. ");
					wordStop = false;
				}
				if (eMatch.find() == false) {
					System.out.print("\n  # PassWord에는 영문자 소문자 및 대문자가 1자 이상 포함되어야 합니다. ");
					System.out.print("\n      다시 입력해주세요. ");
					wordStop = false;
				}
				if (longStop == false) {
					System.out.print("\n  # PassWord는 8자리 이상, 12자리 이하입니다. ");
					System.out.print("\n      다시 입력해주세요. ");
				} else {
					longStop = true;
				}
			}
		} while (wordStop == false || longStop == false);

		wordStop = false;
		longStop = false;
		System.out.print("\n 기존 이름 : " + modifyMember.getName());
		nMatch = null;
		nPattern = Pattern.compile(
				"(^*[0-9].*[!,@,#,$,%,^,&,*,(,),-,_,=,+,;,:,?,/,<,>]*$)|(^*[!,@,#,$,%,^,&,*,(,),-,_,=,+,;,:,?,/,<,>].*[0-9]*$)");
		do {
			System.out.print("\n 수정 이름 >>  ");
			name = sc.nextLine();
			if (name.replaceAll(" ", "").equals("")) {
				name = modifyMember.getName();
				wordStop = true;
				longStop = true;
			} else {
				nMatch = nPattern.matcher(name);
				wordStop = nMatch.find() == true;
				longStop = (name.length() <= 15 && name.length() >= 1);
				if (longStop == false) {
					System.out.print("\n  # 이름은 1자리 이상 15자리 이하입니다. ");
					System.out.print("\n      다시 입력해주세요. ");
				} else {
					longStop = true;
				}
				if (wordStop == true) {
					System.out.print("\n  # 이름에는 숫자 및 특수문자가 입력될 수 없습니다. ");
					System.out.print("\n      다시 입력해주세요. ");
					System.out.println();
					wordStop = false;
				} else {
					wordStop = true;
				}
			}
		} while (longStop == false || wordStop == false);

		System.out.print("\n 기존 권한 : " + modifyMember.getKind());

		int choice = 0;
		boolean arange = false;

		System.out.print("\n  # 수정 권한을 선택하여주세요. ");
		System.out.print("\n    [ 일반회원 : 1 / 관리자 : 2 ] ");

		do {
			try {
				System.out.print("\n  수정 권한 >>  ");
				String c = sc.nextLine();
				if (c.equals(null) || c.replaceAll("", "").equals("") || c.length() == 0) {
					choice = 0;
				} else {
					choice = Integer.parseInt(c);
				}
				if (choice == 0) {
					kind = modifyMember.getKind();
					arange = true;
				} else {
					if (choice < 1 || choice > 2) {
						arange = false;
						System.out.print("\n  # 없는 메뉴 입니다. ");
					} else if (choice >= 1 && choice <= 2) {
						if (choice == 1) {
							kind = "customer";
						} else if (choice == 2) {
							kind = "manager";
						}
						arange = true;
					}
				}
			} catch (NumberFormatException e) {
				System.out.print("\n  # 메뉴는 숫자로 입력해주세요. ");
				arange = false;
			}
		} while (arange == false);

		wordStop = false;
		longStop = false;
		System.out.print("\n 기존 본인 확인 문자 : " + modifyMember.getConfigWord());
		nMatch = null;

		do {
			System.out.print("\n 수정 본인 확인 문자 >>  ");
			configWord = sc.nextLine();
			longStop = (configWord.length() <= 30);
			if (configWord.replaceAll(" ", "").equals("")) {
				name = modifyMember.getName();
				longStop = true;
			} else {
				if (longStop == false) {
					System.out.print("\n  # 본인확인문자는 15자리 이하입니다. ");
					System.out.print("\n      다시 입력해주세요. ");
				} else {
					longStop = true;
				}
			}
		} while (longStop == false);

		afterMember = new Member(id, pw, name, kind, configWord);

		return afterMember;
	}
	
/* □□□□□□□□□□□□□□□□□□□□□□□□□□□□□□□□□□□□□□□□□ 권한부여 □□□□□□□□□□□□□□□□□□□□□□□□□□□□□□□□□□□□□□□□□□ */

	public Member autorityCheck(Member autorityMember, Scanner sc) {
		System.out.print("\n 수정 회원 ID : " + autorityMember.getId());
		int choice = 0;
		boolean arange = false;
		String kind = null;
		Member afterMember;

		System.out.print("\n  # 수정 권한을 선택하여주세요. ");
		System.out.print("\n    [ 일반회원 : 1 / 관리자 : 2 ] ");

		do {
			try {
				System.out.print("\n  수정 권한 >>  ");
				String c = sc.nextLine();
				if (c.equals(null) || c.replaceAll("", "").equals("") || c.length() == 0) {
					choice = 0;
				} else {
					choice = Integer.parseInt(c);
				}
				if (choice == 0) {
					kind = autorityMember.getKind();
					arange = true;
				} else {
					if (choice < 1 || choice > 2) {
						arange = false;
						System.out.print("\n  # 없는 메뉴 입니다. ");
					} else if (choice >= 1 && choice <= 2) {
						if (choice == 1) {
							kind = "customer";
						} else if (choice == 2) {
							kind = "manager";
						}
						arange = true;
					}
				}
			} catch (NumberFormatException e) {
				System.out.print("\n  # 메뉴는 숫자로 입력해주세요. ");
				arange = false;
			}
		} while (arange == false);
		autorityMember.setKind(kind);
		afterMember = autorityMember;
		return afterMember;
	}
	
/* □□□□□□□□□□□□□□□□□□□□□□□□□□□□□□□□□□□□□□□□□ recheck □□□□□□□□□□□□□□□□□□□□□□□□□□□□□□□□□□□□□□□□□□ */

	public boolean passCheck(Member inMember, Scanner sc, String str) {
		String pw = null;
		boolean wordStop = true;
		boolean longStop = true;
		Matcher nMatch = null;
		Matcher eMatch = null;
		Pattern nPattern = Pattern.compile(
				"(^*[0-9].*[!,@,#,$,%,^,&,*,(,),-,_,=,+,;,:,?,/,<,>]*$)|(^*[!,@,#,$,%,^,&,*,(,),-,_,=,+,;,:,?,/,<,>].*[0-9]*$)");
		Pattern ePattern = Pattern.compile("(^*[a-z].*[A-Z]*$)|(^*[A-Z].*[a-z]*$)");
		do {
			System.out.print("\n  # " + str + " 완료를 위해 ");
			System.out.print("\n      비밀번호를 한번 더 입력해주세요.  ");
			System.out.print("\n ㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡ ");
			System.out.print("\n PassWord >>  ");
			pw = sc.nextLine();
			nMatch = null;
			eMatch = null;
			wordStop = Pattern.matches("^*[a-zA-Z0-9!@#$%^&*()-_=+<>;:?/]*$", pw);
			nMatch = nPattern.matcher(pw);
			eMatch = ePattern.matcher(pw);
			longStop = (pw.length() > 7 && pw.length() < 14);
			if (wordStop == false) {
				System.out.print("\n  # PassWord에는 영문자, 숫자 및 특수문자만 입력가능합니다. ");
				System.out.print("\n      다시 입력해주세요. ");
			} else {
				wordStop = true;
			}
			if (nMatch.find() == false) {
				System.out.print("\n  # PassWord에는 숫자 및 특수문자가 1자 이상 포함되어야 합니다. ");
				System.out.print("\n      다시 입력해주세요. ");
				wordStop = false;
			}
			if (eMatch.find() == false) {
				System.out.print("\n  # PassWord에는 영문자 소문자 및 대문자가 1자 이상 포함되어야 합니다. ");
				System.out.print("\n      다시 입력해주세요. ");
				wordStop = false;
			}
			if (longStop == false) {
				System.out.print("\n  # PassWord는 8자리 이상, 12자리 이하입니다. ");
				System.out.print("\n      다시 입력해주세요. ");
			} else {
				longStop = true;
			}
		} while (wordStop == false || longStop == false);

		if (pw.equals(inMember.getPw())) {
			return true;
		} else {
			return false;
		}

	}







	


}
