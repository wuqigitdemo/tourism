package org.honor.tourism.controller;

import static org.junit.Assert.assertEquals;
import org.honor.tourism.Application;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultHandlers;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

/**
 * 作者:修罗大人
 * 日期:Feb 9, 2017
 * 时间:11:26:51 AM
 */
@RunWith(SpringJUnit4ClassRunner.class)
@SpringApplicationConfiguration(classes = Application.class)
@WebAppConfiguration
public class TestSysRoleController {

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
					MockMvcRequestBuilders.post("/SysRole/save")
						.param("name", "xiuluo"+i)
						.param("roleNumber", "00"+i)
						.param("sort", ""+i)
						.param("state", "1")
						)
						.andDo(MockMvcResultHandlers.print())
						.andReturn();
				 assertEquals("{\"success\":true}", result.getResponse().getContentAsString());
		}
	}
	
	@Test
	public void testFindOne() throws Exception {

	MvcResult result = mockMvc.perform(
			MockMvcRequestBuilders.post("/SysRole/findOne")
				.param("id", "40283f815a447f34015a4483462e0002")
				)
				.andDo(MockMvcResultHandlers.print())
				.andReturn();
		 assertEquals("{\"success\":true}", result.getResponse().getContentAsString());
	}
}
