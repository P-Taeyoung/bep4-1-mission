package com.back.boundedContext.cash.domain;

import com.back.global.jpa.entity.BaseManualAndTime;

import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "CASH_WALLET")
@NoArgsConstructor
@Getter
public class Wallet extends BaseManualAndTime {
	@ManyToOne(fetch = FetchType.LAZY)
	private CashMember holder;

	public Wallet(CashMember holder) {
		super(holder.getId());
		this.holder = holder;
	}
}
