package com.back.boundedContext.member.service;

import java.util.Optional;

import org.springframework.stereotype.Service;

import com.back.boundedContext.member.entity.Member;
import com.back.global.exception.DomainException;
import com.back.boundedContext.member.repository.MemberRepository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class MemberService {

	private final MemberRepository memberRepository;

	public long count() {
		return memberRepository.count();
	}

	public Member join(String userName, String password, String nickName) {
		findByUserName(userName).ifPresent(member -> {
			throw new DomainException("409-1", "이미 존재하는 username 입니다.");
		});

		return memberRepository.save(new Member(userName, password, nickName));
	}

	public Optional<Member> findByUserName(String userName) {
		return memberRepository.findByUserName(userName);
	}

	public Optional<Member> findById(int id) {
		return memberRepository.findById(id);
	}
}
