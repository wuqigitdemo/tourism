package org.honor.tourism.controller;


import static org.junit.Assert.assertEquals;

import java.util.HashMap;
import java.util.Map;

import org.hibernate.jpa.boot.internal.ParsedPersistenceXmlDescriptor;
import org.honor.tourism.Application;
import org.honor.tourism.entity.PriceInventory;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultHandlers;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

import com.fasterxml.jackson.databind.ObjectMapper;

import groovy.transform.stc.PickAnyArgumentHint;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringApplicationConfiguration(classes = Application.class)
@WebAppConfiguration
public class TestPriceInventoryController {

	@Autowired
	private WebApplicationContext context;

	private MockMvc mockMvc;

	@Before
	public void setupMockMvc() throws Exception {
		mockMvc = MockMvcBuilders.webAppContextSetup(context).build();
	}
	
	/**
	 * json提交方式
	 * @throws Exception
	 */
	@Test
	public void testSave2() throws Exception {
		PriceInventory pi = new PriceInventory();
		pi.setRegistrationTimeLimitPlaceholder(-20);

		Map<String, Object> map = new HashMap<>();
		map.put("priceInventory", pi);
		map.put("routeId", "402882a65949d34b015949d360560000");
		ObjectMapper mapper = new ObjectMapper();  
		MvcResult result = mockMvc.perform(
			MockMvcRequestBuilders.post("/PriceInventory/savePriceInventory?routeId=402882a65949d34b015949d360560000")
				.contentType(MediaType.APPLICATION_JSON_UTF8)
				.content(mapper.writeValueAsString(pi))
				)
				.andDo(MockMvcResultHandlers.print())
				.andReturn();
		 assertEquals("{\"success\":true}", result.getResponse().getContentAsString());
	}

}
