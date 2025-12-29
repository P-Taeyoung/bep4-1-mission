package com.back.boundedContext.market.app;

import org.springframework.stereotype.Service;

import com.back.boundedContext.market.domain.Order;
import com.back.boundedContext.market.out.OrderRepository;
import com.back.shared.cash.event.CashOrderPaymentFailedEvent;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class MarketCancelOrderRequestPaymentUseCase {
	private final OrderRepository orderRepository;

	public void handle(CashOrderPaymentFailedEvent event) {
		Order order = orderRepository.findById(event.getOrderDto().getId()).get();

		order.cancelRequestPayment();
	}
}
