package com.root.blog.Controller;

import java.security.Principal;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.root.blog.Model.Roletype;
import com.root.blog.Model.User;
import com.root.blog.Repository.UserRepository;

@Controller
public class UserController {
	
	@Autowired
	UserRepository userRepository;
	

	@Autowired
	BCryptPasswordEncoder bCryptPasswordEncoder; 
	// SecurityConfig에 BCryPass~를 반환하는 메서드를 생성한다. 그러면 해당 리턴값을 IoC에 등록한다.
	
	// 두개의 빈은 동일한 인터페이스를 가지고 있음. 그래서 빈 등록시 "명시적으로 구분"을 한다.
	
	

	@GetMapping({"/",""}) // localhost:8000 or localhost:8000/
	public String index() {
		// jsp가 아니고!, mustache를 사용
		// src/main/resources가 기본경로.
		// 뷰리졸버 설정: templates(prefix), mustache(suffix) -> 생략
		return "index";
	}
	
	@GetMapping("/user")
	public String user(Principal principal, Model model) {
		model.addAttribute("principal", principal);
		return "user";
	}
	


	// 스프링 시큐리티가 해당주소(/login)을 낚아챈다. -> SecurityConfig를  빈에 등록한 이후, 더이상 낚아채지 않음!
	@GetMapping("/auth/loginForm")
	public String loginForm(Model model,@RequestParam(value = "error", required = false) String error, 
			@RequestParam(value = "exception", required = false) String exception) {
		model.addAttribute("error", error);
		model.addAttribute("exception", exception);
		return "loginForm";
	}
	
	
	@PostMapping("/join")
	public String join(User user) { // 실제로 회원가입을 한다.
		// @RequestBody: JSON -> Java(자료구조 Map을 이용)
		user.setRole(Roletype.ROLE_USER);
		
		String rawPwd = user.getPassword();
		String ecnPwd =bCryptPasswordEncoder.encode(rawPwd);
		user.setPassword(ecnPwd);
		
		
		userRepository.save(user);// 비밀번호를 암호화 안하고, 그대로 로그인을 할 경우 -> 시큐리티 로그인이 불가능하다!
														  // 그래서, 반드시 암호화가 필요하다.
		
		return "redirect:/loginForm";
	}
	
	@GetMapping("/joinForm")
	public String joinForm() { // 회원가입 페이지로 이동을 한다.
		return "joinForm";
	}
			
}
