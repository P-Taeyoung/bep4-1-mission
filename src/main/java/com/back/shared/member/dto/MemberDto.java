package com.back.shared.member.dto;

import java.time.LocalDateTime;

import com.back.boundedContext.member.domain.Member;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public class MemberDto {
	private final int id;
	private final LocalDateTime createTime;
	private final LocalDateTime modifyTime;
	private final String userName;
	private final String nickName;

	public MemberDto(Member member) {
		this(
			member.getId(),
			member.getCreateTime(),
			member.getModifyTime(),
			member.getUserName(),
			member.getNickName()
		);
	}
}
