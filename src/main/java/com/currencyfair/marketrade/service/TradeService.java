package com.currencyfair.marketrade.service;

import com.currencyfair.marketrade.model.Trade;

public interface TradeService {
	
	
	/**
     * Save the trade.
     * 
     * @param trade The trade object.
     *
     */
	public void pushTrade(Trade trade);
	
	public Trade popTrade();

}
