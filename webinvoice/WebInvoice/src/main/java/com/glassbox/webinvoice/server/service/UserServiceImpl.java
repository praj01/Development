//package com.glassbox.webinvoice.server.service;
//
//import java.util.Date;
//
//import javax.servlet.http.HttpServletRequest;
//
//import org.apache.log4j.Logger;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.stereotype.Service;
//import org.springframework.transaction.annotation.Transactional;
//
//import com.glassbox.webinvoice.client.service.UserService;
//import com.glassbox.webinvoice.server.DTOFactory;
//import com.glassbox.webinvoice.server.dataaccess.UserDAO;
//import com.glassbox.webinvoice.shared.DTOentity.PersonDTO;
//import com.glassbox.webinvoice.shared.entity.Address;
//import com.glassbox.webinvoice.shared.entity.AuState;
//import com.glassbox.webinvoice.shared.entity.Email;
//import com.glassbox.webinvoice.shared.entity.Person;
//import com.glassbox.webinvoice.shared.entity.RoleType;
//import com.glassbox.webinvoice.shared.entity.State;
//import com.glassbox.webinvoice.shared.entity.Suburb;
//import com.glassbox.webinvoice.shared.entity.User;
//
//import com.google.gwt.user.server.rpc.RemoteServiceServlet;
//
//@SuppressWarnings("serial")
//@Transactional(rollbackFor = Exception.class)
//@Service("userService")
//public class UserServiceImpl extends RemoteServiceServlet implements
//		UserService {
//
//	private static Logger logger = Logger.getLogger(UserServiceImpl.class);
//
//	@Autowired(required=false)
//	private UserDAO userDAO;
//
//	@Autowired
//	private HttpServletRequest request;
//
//	@Autowired
//	private DTOFactory dtf;
//
//
//	public String registerUser(String firstName, String lastName,
//			String[] emails, String password, AuState auState, int postCode,
//			String suburbName) throws RuntimeException {
//
//		Person p = new Person();
//
//		for (String s : emails) {
//			if (userDAO.findUser(s) != null)
//				throw new RuntimeException("This email is resitered!");
//			Email e = new Email();
//			e.setEmailAddress(s);
//			p.addEmail(e);
//		}
//
//		State state = new State();
//		Suburb suburb = new Suburb();
//		Address address = new Address();
//
//		p.setFirstname(firstName);
//		p.setLastname(lastName);
//		p.setPassword(password);
//		p.setRole(RoleType.USER);
//		p.setLogintime(new Date());
//
//		state.setId(auState);
//		suburb.setPostcode(postCode);
//		suburb.setSuburb(suburbName);
//		address.setState(state);
//		address.setSuburb(suburb);
//		p.addAddress(address);
//
//		//return (String) userDAO.saveEntity(p);
//                return null;
//	}
//
//
//	public PersonDTO findUser(String email, String password)
//			throws RuntimeException {
//		System.out.println(request.getSession().getAttribute("currentUser"));
//		User person = userDAO.findUser(email);
//
//		if (person == null)
//			throw new NullPointerException("Unable to find user");
//
//		else if (!person.getPassword().equals(password))
//			throw new NullPointerException("Incorrect Password");
//		
//		//person.setLogintime(new Date());
//		request.getSession().setAttribute("currentUser", person);
//		
//		return null;
//	}
//
//	
//
//}
