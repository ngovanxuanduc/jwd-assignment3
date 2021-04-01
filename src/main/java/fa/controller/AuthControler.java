package fa.controller;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import fa.entity.MemberEntity;
import fa.payload.request.LoginReq;
import fa.payload.request.RegisterReq;
import fa.service.MemberService;

@Controller
@RequestMapping("/auth")
public class AuthControler {
	@Autowired
	private MemberService memberService;

	@PostMapping("/login")
//	curl -d "userName=duc&password=123" http://localhost:8080/assignment3/member/login
//	curl -c cookies.txt -d "userName=uname-1617177569687&password=pass-1617177569687" http://localhost:8080/assignment3/member/login
	public String login(HttpSession session, Model model, @Valid @ModelAttribute LoginReq loginInfor) {
//		System.out.println("co loi khong: " + br.hasErrors()); , 		BindingResult br
//		if (br.hasErrors()) {
//			br.getAllErrors().forEach(System.out::println);
//		}
		String userName = loginInfor.getUserName();
		String password = loginInfor.getPassword();
		System.out.println("----------------------------------");
		System.err.println("User Name: " + userName);
		System.err.println("Password: " + password);
		System.out.println("----------------------------------");
		MemberEntity user = memberService.login(userName, password);
		if (user != null) {
			session.setAttribute("user", user);
		} else {
			session.removeAttribute("user");
			model.addAttribute("errors", true);
			return "redirect:login";
		}
		System.out.println(user);
		return "hello";
	}

	@GetMapping("/login")
	public String getPageLogin() {
		return "login";
	}

	@GetMapping("/logout")
	public String logout(HttpSession session) {
		session.removeAttribute("user");
		return "redirect:login";
	}

	@GetMapping("/register")
	public String getPageRegister() {
		return "register";
	}

	@PostMapping("/register")
	public String register(@ModelAttribute RegisterReq registerInfo, Model model) {
		String userName = registerInfo.getUserName();
		String password = registerInfo.getPassword();
		String email = registerInfo.getEmail();
		System.out.println("----------------------------------");
		System.err.println("User Name: " + userName);
		System.err.println("Password: " + password);
		System.err.println("Email: " + email);
		System.out.println("----------------------------------");
		MemberEntity userRegister = memberService.register(userName, password, email);
		if (userRegister == null) {
			model.addAttribute("errors", true);
			return "redirect:register";
		}
		return "redirect:login";
	}

}
//https://mkyong.com/spring/curl-post-request-examples/
