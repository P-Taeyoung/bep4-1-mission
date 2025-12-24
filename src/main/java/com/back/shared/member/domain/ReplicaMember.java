package com.back.shared.member.domain;

import java.time.LocalDateTime;

import jakarta.persistence.Id;
import jakarta.persistence.MappedSuperclass;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@MappedSuperclass
@Getter
@Setter(value = AccessLevel.PROTECTED)
@NoArgsConstructor
public abstract class ReplicaMember extends BaseMember{
	@Id
	private int id;
	private LocalDateTime createTime;
	private LocalDateTime modifyTime;

	public ReplicaMember(String userName, String password, String nickName) {
		super(userName, password, nickName);
	}
}
