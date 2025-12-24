package com.back.boundedContext.post.domain;

import com.back.global.jpa.entity.BaseIdAndTimeManual;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;

@Entity
@Table(name = "POST_MEMBER")
public class PostMember extends BaseIdAndTimeManual {
	@Column(unique = true)
	private String userName;
	private String password;
	private String nickName;
	private int activityScore;
}
