package com.back.boundedContext.market.app;

import java.util.Optional;

import org.springframework.stereotype.Service;

import com.back.boundedContext.market.domain.MarketMember;
import com.back.boundedContext.market.out.MarketMemberRepository;
import com.back.boundedContext.market.out.ProductRepository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class MarketSupport {
	private final ProductRepository productRepository;
	private final MarketMemberRepository marketMemberRepository;

	public long countProducts() {
		return productRepository.count();
	}

	public Optional<MarketMember> findMemberByUserName(String userName) {
		return marketMemberRepository.findByUserName(userName);
	}
}
