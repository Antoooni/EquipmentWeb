package by.htp.servlet.command;

public class CommandChooser {
	public static �ommandAction chooseAction(String action) {
		switch (action) {
		case "login":
			System.out.println("Login action: " + action);
			return new LoginCommandAction();
		}
		return null;
	}
}
