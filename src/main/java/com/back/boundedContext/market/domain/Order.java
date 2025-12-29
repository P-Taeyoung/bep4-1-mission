package com.back.boundedContext.market.domain;

import java.util.ArrayList;
import java.util.List;

import com.back.global.jpa.entity.BaseIdAndTime;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "MARKET_ORDER")
@NoArgsConstructor
@Getter
public class Order extends BaseIdAndTime {
	@ManyToOne(fetch = FetchType.LAZY)
	private MarketMember buyer;
	private long price;
	private long salePrice;

	@OneToMany(mappedBy = "order", cascade = {CascadeType.PERSIST, CascadeType.REMOVE}, orphanRemoval = true)
	private List<OrderItem> items = new ArrayList<>();

	public Order(Cart cart) {
		this.buyer = cart.getBuyer();

		cart.getItems().forEach(item -> {
			addItem(item.getProduct());
		});
	}

	public void addItem(Product product) {
		OrderItem orderItem = new OrderItem(
			this,
			product,
			product.getName(),
			product.getPrice(),
			product.getSalePrice()
		);

		items.add(orderItem);

		price += product.getPrice();
		salePrice += product.getSalePrice();
	}
}
