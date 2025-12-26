package com.back.shared.cash.dto;

import java.time.LocalDateTime;

import com.back.boundedContext.cash.domain.CashMember;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public class CashMemberDto {
	private final int id;
	private final LocalDateTime createTime;
	private final LocalDateTime modifyTime;
	private final String userName;
	private final String nickName;
	private int activityScore;

	public CashMemberDto(CashMember cashMember) {
		this(
			cashMember.getId(),
			cashMember.getCreateTime(),
			cashMember.getModifyTime(),
			cashMember.getUserName(),
			cashMember.getNickName(),
			cashMember.getActivityScore()
		);
	}
}
