package com.currencyfair.marketrade.api;

import static org.junit.Assert.assertEquals;

import java.math.BigDecimal;
import java.net.URL;
import java.util.Date;
import java.util.HashMap;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;

import com.currencyfair.marketrade.model.Trade;

@RunWith(SpringJUnit4ClassRunner.class)
@WebAppConfiguration
@SpringBootTest
public class TradeContrallerTest {

	private int port=8081;

	private TestRestTemplate template;

	@Before
	public void before() throws Exception {
		template = new TestRestTemplate();
	}

	@Test
	public void endpointResponse400() throws Exception {
		URL url = new URL("http://localhost:" + port + "/api/trades");

		Trade trade = new Trade();

		ResponseEntity<Trade> response = template.postForEntity(url.toString(), trade, Trade.class,
				new HashMap<>());

		assertEquals("400", response.getStatusCode().toString());
	}

	@Test
	public void endpointResponse201() throws Exception {
		URL url = new URL("http://localhost:" + port + "/api/trades");

		Trade trade = buildValidatedTrade();
		ResponseEntity<Trade> response = template.postForEntity(url.toString(), trade, Trade.class,
				new HashMap<>());

		assertEquals("201", response.getStatusCode().toString());
	}

	private Trade buildValidatedTrade() {
		Trade trade = new Trade();
		trade.setUserId("123456");
		trade.setCurrencyFrom("EUR");
		trade.setCurrencyTo("GBP");
		trade.setAmountSell(new BigDecimal(1000));
		trade.setAmountBuy(new BigDecimal(747.10));
		trade.setRate(new BigDecimal(0.741));
		trade.setTimePlaced(new Date("24-JAN-15 10:27:44"));
		trade.setOriginatingCountry("FR");
		return trade;
	}
}
