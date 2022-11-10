package com.sameer.spring.votingapp.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.sameer.spring.votingapp.entities.Users;
import com.sameer.spring.votingapp.entities.result;
import com.sameer.spring.votingapp.services.UserService;

@Controller
//@RequestMapping("/public")
public class UserController {
	int countCan1 = 0,countCan2 = 0,countCan3 = 0,countCan4 = 0, countofCan1 = 0, countofCan2 = 0, countofCan3 = 0, countofCan4 = 0;

	// @Autowired(required = true)
	result res = new result();

	@Autowired(required = true)
	private UserService service;

	@RequestMapping(value = "registrationPage")
	public String showRegistrationPage(ModelMap model) {
		// model.addAttribute("user",new Users());
		return "userReg";
	}

	@RequestMapping(value = "registerUser", method = RequestMethod.POST)
	public String registerUser(@ModelAttribute("users") Users users, ModelMap model) {
		int result = service.save(users);
		model.addAttribute("result", "Registration Successfull please login");

		return "userReg";
	}

	@RequestMapping(value="/",method = RequestMethod.GET)
	public String showLoginPage() {
		return "login";
	}

	@RequestMapping(value = "loginUser", method = RequestMethod.POST)
	public String loginUser(@RequestParam("username") String username, @RequestParam("password") String password,
			ModelMap model, HttpServletResponse response, HttpServletRequest req) throws IOException {
		// PrintWriter out = response.getWriter();
		try {
			Users user = service.loginCheck(username, password);
			// model.addAttribute("result1", user.getStatus());

			// Users userAdmin = service.adminloginCheck(username, password);
			if (user.getUsername().equals("admin") && user.getPassword().equals("admin")) {

				List<result> result = service.findAll(res);
				model.addAttribute("result", result);
				System.out.println(result);
				return "displayResult";
			}
			else {
			HttpSession session = req.getSession();
			session.setAttribute("user", user);
			session.setAttribute("res", "Welcome"+" "+user.getUsername());
			return "vote";
			}
		} catch (Exception e) {
			// String message = e.getMessage();

			model.addAttribute("result", "Invalid Credentials");
			return "login";
		}

	}

	@RequestMapping("votePage")
	public String showVotePage() {
		return "vote";
	}

	@RequestMapping("loginPage")
	public String showlogPage() {
		return "login";
	}

	@RequestMapping(value = "voteOpeariton", method = RequestMethod.POST)
	public String showVoteResult(@RequestParam("group") String can1, @RequestParam("group") String can2,
			@RequestParam("group") String can3, @RequestParam("group") String can4, HttpServletResponse response,
			HttpServletRequest req, ModelMap model) {
		/*HttpSession session1 = req.getSession();
		Users user1 = (Users) session1.getAttribute("user");
		String votedTo2 = user1.getVotedTo();*/
		try {
		HttpSession session = req.getSession();
		Users user = (Users) session.getAttribute("user");

		System.out.println(user.getStatus());
		if ((user.getStatus() == null)) {
			
			
			
			
			System.out.println(user.getStatus());
			String name = user.getUsername();
			int i = service.updateStatus(name);
			if (i > 0) {
				model.addAttribute("res", "Vote given Successfully");
				//count++;
				//System.out.println("Count" + count);
				
				

				boolean a = can1.equals("can1");
				boolean b = can2.equals("can2");
				boolean c = can3.equals("can3");
				boolean d = can4.equals("can4");
				System.out.println(a);
				System.out.println(b);

				if (a || b || c || d) {
					if (can1.equals("can1")) {
						//user.setVotedTo(can1);
						service.updateVoteResult(name, "Candidate 1");
						
						/*countCan1++;
						countofCan1 = countCan1;
						service.updateResult("Candidate 1", countofCan1);
						System.out.println("Count of Candidate 1: " + countofCan1);*/
					}
					if (can2.equals("can2")) {
						service.updateVoteResult(name, "Candidate 2");
						/*countCan2++;
						countofCan2 = countCan2;
						service.updateResult("Candidate 2", countofCan2);
						System.out.println("Count of Candidate 2: " + countofCan2);*/
					}
					if (can3.equals("can3")) {
						service.updateVoteResult(name, "Candidate 3");
						/*countCan3++;
						countofCan3 = countCan3;
						service.updateResult("Candidate 3", countofCan3);
						System.out.println("Count of Candidate 3: " + countofCan3);*/
					}
					if (can4.equals("can4")) {
						service.updateVoteResult(name, "Candidate 4");
						/*countCan4++;
						countofCan4 = countCan4;
						service.updateResult("Candidate 4", countofCan4);
						System.out.println("Count of Candidate 4: " + countofCan4);*/
					}
				} else {
					//System.out.println("Already Voted");
					//String votedTo = user.getVotedTo();
					//System.out.println(votedTo);
					String votedTo = user.getVotedTo();
					model.addAttribute("res", "Already Voted to"+" "+votedTo);
					return "vote";
				}
				
				session.invalidate();
				
				
				return "vote";
			}

		} else {

			//System.out.println("Voted already");
			//String votedTo = user.getVotedTo();
			/*Users voteTo = service.readVoteTo(user.getUsername(), user.getPassword());
			System.out.println(voteTo);*/
			
			String votedTo = user.getVotedTo();
			model.addAttribute("res", "Already Voted to"+" "+votedTo);
			
		}
		
		}catch(Exception e) {
			//System.out.println("Voted already");
		/*	HttpSession session = req.getSession();
			Users user = (Users) session.getAttribute("user");
			String votedTo = user.getVotedTo();*/
			
		//service.readVoteTo(can3, can4);
			model.addAttribute("res", "Already Voted");
				//session.invalidate();
			
			return "vote";
		}
		


		return "vote";
	}

	@RequestMapping("resultPage")
	public String showResultPage() {
		return "result";
	}

	public UserService getService() {
		return service;
	}

	// @Qualifier("service")
	public void setService(UserService service) {
		this.service = service;
	}

}