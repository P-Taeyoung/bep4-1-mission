package com.back.boundedContext.market.app;

import java.util.Optional;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.back.boundedContext.market.domain.Cart;
import com.back.boundedContext.market.domain.MarketMember;
import com.back.boundedContext.market.domain.Product;
import com.back.global.RsData.RsData;
import com.back.shared.market.dto.MarketMemberDto;
import com.back.shared.member.dto.MemberDto;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class MarketFacade {
	private final MarketSyncMemberUseCase marketSyncMemberUseCase;
	private final MarketSupport marketSupport;
	private final MarketCreateProductUseCase marketCreateProductUseCase;
	private final MarketCreateCartUseCase marketCreateCartUseCase;

	@Transactional
	public MarketMember syncMember(MemberDto memberDto) {
		return marketSyncMemberUseCase.syncMember(memberDto);
	}

	@Transactional(readOnly = true)
	public long productsCount() {
		return marketSupport.countProducts();
	}

	public Product createProduct(
		MarketMember seller,
		String sourceTypeCode,
		int sourceId,
		String name,
		String description,
		int price,
		int salePrice
	) {
		return marketCreateProductUseCase.createProduct(
			seller,
			sourceTypeCode,
			sourceId,
			name,
			description,
			price,
			salePrice
		);
	}

	@Transactional(readOnly = true)
	public Optional<MarketMember> findMemberByUserName(String userName) {
		return marketSupport.findMemberByUserName(userName);
	}

	@Transactional
	public RsData<Cart> createCart(MarketMemberDto buyer) {
		return marketCreateCartUseCase.createCart(buyer);
	}

	@Transactional(readOnly = true)
	public Optional<Cart> findCartByBuyer(MarketMember buyer) {
		return marketSupport.findCartByBuyer(buyer);
	}

	@Transactional(readOnly = true)
	public Optional<Product> findProductById(int id) {
		return marketSupport.findProductById(id);
	}

}
