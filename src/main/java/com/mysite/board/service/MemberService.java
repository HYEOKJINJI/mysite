package com.mysite.board.service;

import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.mysite.board.Entity.Member;
import com.mysite.board.repository.MemberRepository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class MemberService {
	
	private final MemberRepository memberRepository;
	private final PasswordEncoder passwordEncoder;
	
	public void createMember(String username, String password, String Mname, String birthday, Integer phonenum, String addr) {
		Member member = new Member();
		
		member.setUsername(username);
		member.setPassword(this.passwordEncoder.encode(password));
		member.setName(Mname);
		member.setBirthday(birthday);
		member.setPhonenum(phonenum);
		member.setAddr(addr);
		
		this.memberRepository.save(member);
	}

}
