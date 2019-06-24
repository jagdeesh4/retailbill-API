package com.retail.retailWebsite;

import static org.junit.Assert.assertEquals;

import java.math.BigDecimal;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.mock.web.MockHttpServletResponse;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.RequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import com.retail.retailWebsite.controller.NetAmountOnBillController;
import com.retail.retailWebsite.service.NetAmountOnBillServiceImpl;

@RunWith(SpringRunner.class)
@WebMvcTest(value = NetAmountOnBillController.class)
public class RetailWebsiteControllerTest {

	@Autowired
	private MockMvc mockMvc;
	
	@MockBean
	NetAmountOnBillServiceImpl netAmountOnBillService;
	
	
	BigDecimal bill=new BigDecimal(1000);
	
	String exampleCourseJson = "{\"user\":{\"id\":\"1\",\"username\":\"Jasu\",\"firstName\":\"Jags\",\"lastName\":\"Supp\",\"type\":\"CUSTOMER\","
			+ "\"joinDate\":\"2015-06-06\"},\"bill\":{\"id\":\"1\",\"items\":[{\"price\":\"100\",\"name\":\"dhdh\",\"type\":\"GROCERY\"},"
			+ "{\"price\":\"100\",\"name\":\"dhdh\",\"type\":\"CLOTHING\"}]}}";
	
	@Test
	public void retrieveDetailsForCourse() throws Exception {

		Mockito.when(
				netAmountOnBillService.fetchBillAmount(Mockito.any(),Mockito.any())).thenReturn(bill);

		RequestBuilder requestBuilder = MockMvcRequestBuilders.post("/getNetBillAmount").accept(MediaType.APPLICATION_JSON).content(exampleCourseJson).contentType(MediaType.APPLICATION_JSON);

		MvcResult result = mockMvc.perform(requestBuilder).andReturn();
		MockHttpServletResponse response=result.getResponse();
		assertEquals(HttpStatus.OK.value(), response.getStatus());
		
	}


}
