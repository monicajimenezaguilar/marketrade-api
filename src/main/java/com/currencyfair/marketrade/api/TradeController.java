package com.currencyfair.marketrade.api;

import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.currencyfair.marketrade.model.Trade;
import com.currencyfair.marketrade.service.TradeService;

/**
 *  Endpoint.
 */
@RestController
public class TradeController {
	
	private static final Logger LOGGER = LoggerFactory.getLogger(TradeController.class);
	 
	@Autowired
	private TradeService tradeService;
	
	@RequestMapping(method = {RequestMethod.POST }, path = "/api/trades", consumes = MediaType.APPLICATION_JSON_VALUE)
	@ResponseStatus(code=HttpStatus.CREATED)
	public Trade postTrade(@Validated @RequestBody final Trade trade, HttpServletResponse response) {
		LOGGER.info("POST:{}", trade.toString());
		
		tradeService.pushTrade(trade);
		response.setStatus(HttpServletResponse.SC_NO_CONTENT);
		return trade;
	}
	
	@RequestMapping(value = "/api/getTrade", method = RequestMethod.GET)
	public Trade getTrade() {
		Trade trade = tradeService.popTrade();
		
		if (trade != null) {
			LOGGER.info("GET:" + trade.toString());
		}
		return trade;
	}

		
}
