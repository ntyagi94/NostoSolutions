package com.nosto.controller;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.hamcrest.Matchers;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.client.RestTemplate;

@RunWith(SpringJUnit4ClassRunner.class)
public class ConverterRestControllerTest {
	
	private MockMvc mockMvc;
	
	@Mock
    private RestTemplate restTemplate;
	
	@InjectMocks
	private ConverterRestController converterRestController;
	
	@Before
	public void setUp() throws Exception {
		mockMvc = MockMvcBuilders.standaloneSetup(converterRestController)
				.build();
	}
	
//	@Test
//	public void testGetConversion() throws Exception {
//		mockMvc.perform(get("/api/v1/hello"))
//		.andExpect(MockMvcResultMatchers.status().isOk())
//		.andExpect(MockMvcResultMatchers.content().string("Hello World"));
//	}
	
	@Test
	public void testTheResultGetConversion_whenWrongSourceIsPassed_shouldReturnErrors() throws Exception {
		mockMvc.perform(get("/api/v1/convert?source=USD&target=HKD&amount=100.25")
		.accept(MediaType.APPLICATION_JSON))
		.andExpect(status().is(400))
		.andExpect(jsonPath("$.errors", Matchers.is("[Wrong source input]")));
	}
	
//	@Test
//    public void testHelloWorldJson() throws Exception {
//        mockMvc.perform(get("/api/v1/json")
//                .accept(MediaType.APPLICATION_JSON))
//                .andExpect(status().isOk())
//                .andExpect(jsonPath("$.title", Matchers.is("Greetings")))
//                .andExpect(jsonPath("$.value", Matchers.is("Hello World")))
//                .andExpect(jsonPath("$.*", Matchers.hasSize(2)));
//    }


}
