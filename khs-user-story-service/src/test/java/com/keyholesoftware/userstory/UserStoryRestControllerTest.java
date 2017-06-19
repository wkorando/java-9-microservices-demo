package com.keyholesoftware.userstory;

import static org.hamcrest.Matchers.hasSize;
import static org.hamcrest.Matchers.is;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.test.web.servlet.setup.MockMvcBuilders.webAppContextSetup;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.hateoas.MediaTypes;
import org.springframework.http.MediaType;
import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.http.converter.json.MappingJackson2HttpMessageConverter;
import org.springframework.mock.http.MockHttpOutputMessage;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.web.context.WebApplicationContext;

import com.keyholesoftware.userstory.model.UserStory;
import com.keyholesoftware.userstory.model.UserStoryRepository;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringApplicationConfiguration(classes = UserStoryApp.class)
@WebAppConfiguration
public class UserStoryRestControllerTest {

	private MediaType contentType = MediaTypes.HAL_JSON;

	private MockMvc mockMvc;

	// private String userName = "bdussault";

	@SuppressWarnings("rawtypes")
	private HttpMessageConverter mappingJackson2HttpMessageConverter;

	// private UserStory userStory;

	private List<UserStory> userStoryList = new ArrayList<UserStory>();

	@Autowired
	private UserStoryRepository userStoryRepository;

	@Autowired
	private WebApplicationContext webApplicationContext;

	@Autowired
	void setConverters(HttpMessageConverter<?>[] converters) {

		this.mappingJackson2HttpMessageConverter = Arrays.asList(converters).stream().filter(hmc -> hmc instanceof MappingJackson2HttpMessageConverter).findAny().get();

		Assert.assertNotNull("the JSON message converter must not be null", this.mappingJackson2HttpMessageConverter);
	}

	@Before
	public void setup() throws Exception {
		this.mockMvc = webAppContextSetup(webApplicationContext).build();

		// this.userStoryRepository.deleteAllInBatch();
		// this.accountRepository.deleteAllInBatch();

		// this.userStory = accountRepository.save(new Account(userName,
		// "password"));

		UserStory userStory = new UserStory();
		userStory.setId(1L);
		userStory.setName("User Story 1");
		userStory.setDescription("Description 1");
		userStory.setEstimate(5);
		userStory.setProjectId(1L);
		userStory.setSprint("1");
		this.userStoryList.add(userStoryRepository.save(userStory));
	}

	@Test
	public void readSingleUserStory() throws Exception {
		mockMvc.perform(get("/userStories/" + this.userStoryList.get(0).getId()))
					.andExpect(status().isOk())
					.andExpect(content().contentType(contentType))
					.andExpect(jsonPath("$.id", is(this.userStoryList.get(0).getId().intValue())));
	}

	@Test
    public void readBookmarks() throws Exception {
        mockMvc.perform(get("/userStories"))
                .andExpect(status().isOk())
                .andExpect(content().contentType(contentType))
        		.andExpect(jsonPath("$._embedded.userStories", hasSize(7)))
                .andExpect(jsonPath("$._embedded.userStories[0].id", is(this.userStoryList.get(0).getId().intValue())));
    }

	@Test
	 public void createUserStory() throws Exception {
		UserStory userStory = new UserStory();
		userStory.setName("User Story X");
		userStory.setDescription("Description X");
		userStory.setEstimate(20);
		userStory.setProjectId(1L);
		userStory.setSprint("1");
		String userStoryJson = json(userStory);
		this.mockMvc.perform(post("/userStories")
						.contentType(contentType)
						.content(userStoryJson))
						.andExpect(status().isCreated());
 	}

	@SuppressWarnings("unchecked")
	protected String json(Object o) throws IOException {
		MockHttpOutputMessage mockHttpOutputMessage = new MockHttpOutputMessage();
		this.mappingJackson2HttpMessageConverter.write(o, MediaType.APPLICATION_JSON, mockHttpOutputMessage);
		return mockHttpOutputMessage.getBodyAsString();
	}
}
