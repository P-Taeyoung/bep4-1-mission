package com.back.entity;

import com.back.jpa.entity.BaseIdAndTime;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import lombok.NoArgsConstructor;

@Entity
@NoArgsConstructor
public class Member extends BaseIdAndTime {

	@Column(unique = true)
	private String userName;
	private String password;
	private String nickName;

	public Member(String userName, String password, String nickName) {
		this.userName = userName;
		this.password = password;
		this.nickName = nickName;
	}
}
