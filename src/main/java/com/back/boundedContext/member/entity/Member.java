package com.back.boundedContext.member.entity;

import com.back.global.jpa.entity.BaseIdAndTime;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Entity
@NoArgsConstructor
@Getter
public class Member extends BaseIdAndTime {

	@Column(unique = true)
	private String userName;
	private String password;
	private String nickName;
	private int activityScore;

	public Member(String userName, String password, String nickName) {
		this.userName = userName;
		this.password = password;
		this.nickName = nickName;
	}

	public void increaseActivityScore(int amount) {
		this.activityScore += amount;
	}
}
