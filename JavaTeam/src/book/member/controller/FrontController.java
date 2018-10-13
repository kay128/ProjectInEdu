package book.member.controller;

import java.util.Scanner;

import book.member.action.Action;

public class FrontController {
	public void processRequest(Action action,Scanner sc) {
		try {
			action.execute(sc);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
