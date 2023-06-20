package in.vasanth.rest;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import org.springframework.test.web.servlet.ResultActions;
import org.springframework.test.web.servlet.request.MockHttpServletRequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import com.fasterxml.jackson.databind.ObjectMapper;

import in.vasanth.binding.CreateApplication;
import in.vasanth.restcontroller.RegistrationApi;
import in.vasanth.service.RegistrationService;

@WebMvcTest(value = RegistrationApi.class)
@AutoConfigureMockMvc(addFilters = false)
public class RegistrationControllerTest {

	@MockBean
	private RegistrationService regService;

	@Autowired
	private MockMvc mockMvc;
	@Test
	public void testSaveCitizen() throws Exception {
		CreateApplication data = new CreateApplication("frauhn", "frauhn@gmail.com", "657893021", "male", "01/09/97",
				"567890345");
		when(regService.restCall(Mockito.any())).thenReturn("contact saved");

		MockHttpServletRequestBuilder post = MockMvcRequestBuilders.post("/register").
												content(asJsonString(data))
												.contentType(MediaType.APPLICATION_JSON);

		ResultActions perform = mockMvc.perform(post);
		int status = perform.andReturn().getResponse().getStatus();
		
		assertEquals(201, status);

	}
	public static String asJsonString(final Object obj) {
        try {
            return new ObjectMapper().writeValueAsString(obj);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

}
