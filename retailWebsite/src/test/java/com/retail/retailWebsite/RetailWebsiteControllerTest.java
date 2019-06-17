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
import com.retail.retailWebsite.service.NetAmountOnBillService;

@RunWith(SpringRunner.class)
@WebMvcTest(value = NetAmountOnBillController.class)
public class RetailWebsiteControllerTest {

	@Autowired
	private MockMvc mockMvc;
	
	@MockBean
	NetAmountOnBillService netAmountOnBillService;
	
	
	BigDecimal bill=new BigDecimal(1000);

	String exampleCourseJson = "{\"userType\":\"EMPLOYEE\",\"billAmount\":\"1000\",\"billType\":\"GROCERYY\"}";
	
	@Test
	public void retrieveDetailsForCourse() throws Exception {

		Mockito.when(
				netAmountOnBillService.fetchBillAmount(Mockito.anyString(),Mockito.anyString(),Mockito.any(BigDecimal.class))).thenReturn(bill);

		RequestBuilder requestBuilder = MockMvcRequestBuilders.post("/index").accept(MediaType.APPLICATION_JSON).content(exampleCourseJson).contentType(MediaType.APPLICATION_JSON);

		MvcResult result = mockMvc.perform(requestBuilder).andReturn();
		MockHttpServletResponse response=result.getResponse();
		assertEquals(HttpStatus.OK.value(), response.getStatus());
		
	}


}
