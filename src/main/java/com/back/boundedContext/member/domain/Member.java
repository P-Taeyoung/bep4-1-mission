package com.back.boundedContext.member.domain;

import com.back.shared.member.domain.SourceMember;

import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "MEMBER_MEMBER")
@Getter
@NoArgsConstructor
public class Member extends SourceMember {

	public Member(String userName, String password, String nickName) {
		super(userName, password, nickName);
	}

	public int increaseActivityScore(int amount) {
		setActivityScore(getActivityScore() + amount);

		return getActivityScore();
	}
}
