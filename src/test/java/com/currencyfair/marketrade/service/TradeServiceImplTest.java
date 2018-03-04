package com.currencyfair.marketrade.service;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;

import org.junit.Test;

import com.currencyfair.marketrade.model.Trade;

public class TradeServiceImplTest {
	
	@Test
	public void addTradeQueue() {
		TradeServiceImpl tradeService = new TradeServiceImpl();
		tradeService.pushTrade(new Trade());

		assertEquals(1, tradeService.getTradeCount());
	}

	@Test
	public void removeTradeQueue() {
		TradeServiceImpl tradeService = new TradeServiceImpl();
		tradeService.pushTrade(new Trade());
		tradeService.pushTrade(new Trade());
		tradeService.popTrade();

		assertEquals(1, tradeService.getTradeCount());
	}

	@Test
	public void nullWhenPopEmptyQueue() {
		TradeServiceImpl tradeService = new TradeServiceImpl();

		assertNull(tradeService.popTrade());
	}

}
