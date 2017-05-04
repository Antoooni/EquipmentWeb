package by.htp.servlet.command;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import by.htp.Lesson7.equipment.domain.RentUnit;
import by.htp.Lesson7.parsers.service.ParserDOMServiceImpl;

import by.htp.user.User;

public class LoginCommandAction implements СommandAction {

	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response) {
		String page = null;
		String login = request.getParameter("login");
		String password = request.getParameter("pass");
		if ("user".equals(login) && "user".equals(password)) {
			page = "/equipment.jsp";
			
			ParserDOMServiceImpl parserService = new ParserDOMServiceImpl();
			List<RentUnit> equipments= parserService.getEquipment();         //EMPTY!!!!
			// показать список всего оборудования из XML
			request.setAttribute("list", equipments);

		} else if ("admin".equals(login) && "admin".equals(password)) {
			page = "/admin.jsp";
			List<User> users= new ArrayList<User>();
			users.add(new User("login_admin1", "password_admin1", true));
			users.add(new User("login_admin2", "password_admin2", true));
			users.add(new User("login_admin3", "password_admin3", true));
			// дома показать список оборудования из XML арендованного юзером
			request.setAttribute("list", users);
			
		} else {
			page = "/error.jsp";
		}

		return page;
	}

}
