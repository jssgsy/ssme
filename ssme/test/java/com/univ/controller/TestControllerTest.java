package com.univ.controller;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.ResultActions;
import org.springframework.test.web.servlet.ResultMatcher;
import org.springframework.web.context.WebApplicationContext;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultHandlers;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

@RunWith(SpringJUnit4ClassRunner.class)
@WebAppConfiguration 
@ContextConfiguration("file:src/main/webapp/WEB-INF/springMVC-servlet.xml")
public class TestControllerTest {

	@Autowired	 
	private WebApplicationContext wac;	//不需要在配置文件中配置 
	private MockMvc mockMvc;  //不需要配置，通过静态方法获得
	 
	@Before	 
	public void setup() throws Exception {	 
		this.mockMvc = MockMvcBuilders.webAppContextSetup(this.wac).build();//初始化	 
	}
	
	/**
	 * perform的参数类型是org.springframework.test.web.servlet.RequestBuilder
	 * addExpect的参数类型是org.springframework.test.web.servlet.ResultMatcher
	 * andDo的参数类型是org.springframework.test.web.servlet.ResultHandler
	 * @throws Exception
	 */
	@Test
	public void testHome() throws Exception {
		this.mockMvc.perform(MockMvcRequestBuilders.get("/test/home").param("id", "1"))	
		.andExpect(MockMvcResultMatchers.status().isOk())	
		.andExpect(MockMvcResultMatchers.view().name("test/home"))
		.andDo(MockMvcResultHandlers.print());//很有用，可以在控制台上输出许多请求响应的信息	
	}
	
	/**ResultActions接口总共就三个方法
	 * andExpect()返回ResultActions接口实例
	 * andDo()返回ResultActions接口实例
	 * andReturn()返回MvcResult实例
	 * @throws Exception
	 */
	@Test
	public void testDB() throws Exception{
		ResultActions rs = this.mockMvc.perform(MockMvcRequestBuilders.post("/db/query"));
		rs.andExpect(MockMvcResultMatchers.status().isOk());
		rs.andExpect(MockMvcResultMatchers.view().name("ok"));
		rs.andDo(MockMvcResultHandlers.print());
	}

}
