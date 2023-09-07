package com.root.blog.config.auth;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.root.blog.Model.User;
import com.root.blog.Repository.UserRepository;

@Service // 문제의 원인: 바로 @Service를 쓰지 않아서 발생이 되었다.
public class PrincipalDetailsService implements UserDetailsService {
	@Autowired
	UserRepository userRepository;

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		// 이전에 오류가 발생한 지점
		// username이 혹시 password로 간건가???
		User user = userRepository.findByUsername(username);
		
		if(user != null) {
			return new PrincipalDetails(user);
		}

		return null;
	}

}
