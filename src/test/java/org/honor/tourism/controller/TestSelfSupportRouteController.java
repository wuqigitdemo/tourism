package org.honor.tourism.controller;

import static org.junit.Assert.assertEquals;

import org.honor.tourism.Application;
import org.honor.tourism.entity.TourismTheme;
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

@RunWith(SpringJUnit4ClassRunner.class)
@SpringApplicationConfiguration(classes = Application.class)
@WebAppConfiguration
public class TestSelfSupportRouteController {

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
		ObjectMapper mapper = new ObjectMapper();  
		MvcResult result = mockMvc.perform(
			MockMvcRequestBuilders.post("/SelfSupportRoute/deleteTest")
				.contentType(MediaType.APPLICATION_JSON_UTF8)
				.content(mapper.writeValueAsString("行程信息测试"))
				)
				.andDo(MockMvcResultHandlers.print())
				.andReturn();
		 assertEquals("{\"success\":true}", result.getResponse().getContentAsString());
	}
	
	
}
