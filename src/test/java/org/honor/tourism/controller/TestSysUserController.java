package org.honor.tourism.controller;

import static org.junit.Assert.assertEquals;

import java.util.HashMap;
import java.util.Map;

import org.honor.tourism.Application;
import org.honor.tourism.entity.PriceInventory;
import org.honor.tourism.entity.SysUser;
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

/**
 * 作者:修罗大人
 * 日期:Feb 9, 2017
 * 时间:11:26:51 AM
 */
@RunWith(SpringJUnit4ClassRunner.class)
@SpringApplicationConfiguration(classes = Application.class)
@WebAppConfiguration
public class TestSysUserController {

	@Autowired
	private WebApplicationContext context;

	private MockMvc mockMvc;

	@Before
	public void setupMockMvc() throws Exception {
		mockMvc = MockMvcBuilders.webAppContextSetup(context).build();
	}
	
	@Test
	public void testSave() throws Exception {

		for (int i = 0; i < 30; i++) 
		{
			MvcResult result = mockMvc.perform(
					MockMvcRequestBuilders.post("/SysUserController/save")
						.param("username", "xiuluo"+i)
						.param("name", "xl"+i)
						)
						.andDo(MockMvcResultHandlers.print())
						.andReturn();
				 assertEquals("{\"success\":true}", result.getResponse().getContentAsString());
		}
	}
}
