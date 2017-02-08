package org.honor.tourism.controller;

import static org.junit.Assert.assertEquals;

import java.util.ArrayList;
import java.util.List;

import org.honor.tourism.Application;
import org.honor.tourism.entity.City;
import org.honor.tourism.entity.HotelLevel;
import org.honor.tourism.entity.HotelManagement;
import org.honor.tourism.entity.HotelProvideService;
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
public class TestHotelManagementController {

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
		HotelManagement tt = new HotelManagement();
		//City city = new City();
		//city.setId("402882bb5a17825e015a17c76bff0004");
		//tt.setCity(city);
		//tt.setHotelName("你好");
		//HotelLevel hotellevel = new HotelLevel();
		//hotellevel.setId("402882bb5a17210c015a1723340f0000");
		//tt.setHotelLevel(hotellevel);
		//tt.setPhone("13333333333");
		//tt.setBusinessDistrict("哈尔滨");
		List<HotelProvideService> list = new ArrayList<HotelProvideService>();
		HotelProvideService hp = new HotelProvideService();
		hp.setId("402882bb5a17825e015a17ddb6140005");
		list.add(hp);
		tt.setHotelProvideService(list);
		ObjectMapper mapper = new ObjectMapper();  
		MvcResult result = mockMvc.perform(
			MockMvcRequestBuilders.post("/HotelManagementInfo/save")
				.contentType(MediaType.APPLICATION_JSON_UTF8)
				.content(mapper.writeValueAsString(tt))
				)
				.andDo(MockMvcResultHandlers.print())
				.andReturn();
		 assertEquals("{\"success\":true}", result.getResponse().getContentAsString());
	}	
	
}
