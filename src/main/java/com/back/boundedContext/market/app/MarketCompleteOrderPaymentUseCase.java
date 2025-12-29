package com.back.boundedContext.market.app;

import org.springframework.stereotype.Service;

import com.back.boundedContext.market.domain.Order;
import com.back.boundedContext.market.out.OrderRepository;
import com.back.shared.cash.event.CashOrderPaymentSucceededEvent;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class MarketCompleteOrderPaymentUseCase {
	private final OrderRepository orderRepository;

	public void handle(CashOrderPaymentSucceededEvent event) {
		Order order = orderRepository.findById(event.getOrderDto().getId()).get();

		order.completePayment();
	}
}
