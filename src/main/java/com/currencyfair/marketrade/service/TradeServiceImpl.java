package com.currencyfair.marketrade.service;

import java.util.concurrent.ConcurrentLinkedQueue;

import org.springframework.stereotype.Service;

import com.currencyfair.marketrade.model.Trade;

@Service
public class TradeServiceImpl implements TradeService{
	private ConcurrentLinkedQueue<Trade> queue = new ConcurrentLinkedQueue<>();


	@Override
	public void pushTrade(Trade trade) {
		queue.add(trade);
	}
	
	public Trade popTrade() {
		return queue.poll();
	}
	
	int getTradeCount() {
		return queue.size();
	}

}
