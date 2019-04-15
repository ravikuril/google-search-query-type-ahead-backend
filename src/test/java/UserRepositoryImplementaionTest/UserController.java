/*package UserRepositoryImplementaionTest;
import static org.hamcrest.CoreMatchers.equalTo;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertThat;

import java.io.IOException;

import org.apache.http.HttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpUriRequest;
import org.apache.http.entity.ContentType;
import org.apache.http.impl.client.HttpClientBuilder;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.skyscreamer.jsonassert.JSONAssert;
import org.skyscreamer.jsonassert.JSONCompareMode;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.telstra.restservice.repository.TaskRepository;
import com.telstra.restservice.service.TaskRepositoryImplementation;


//@ContextConfiguration({ "file:src/main/webapp/WEB-INF/dispatcher-servlet.xml" })
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration
public class UserController{
		
	   @InjectMocks 
	   UserController usercontroller;
	   
	   private MockMvc mockmvc;
	   
	   
	   @Autowired
	   TaskRepository userrepository;
		
	   @Autowired
	   TaskRepositoryImplementation userrepositoryimplementation;

	   
	   
	   
	   @Before
	   public void setUp() throws Exception
	   {
		   MockMvc=MockMvcBuilders.standaloneSetup(UserController)
				   .build();
	   }


	   // test for checking that path is okey
	   @Test
	   public void TestStatusCode()
	     throws IOException {
	      HttpUriRequest request = new HttpGet( "https://localhost:8080/users");
	      HttpResponse httpResponse = HttpClientBuilder.create().build().execute( request );
	      assertThat(
	        httpResponse.getStatusLine().getStatusCode(),equalTo(HttpStatus.NOT_FOUND));
	   }

	   
	   // test to check that /users is returning the JSON data
	   @Test
	   public void testJSONData() throws Exception
	   {
		   String jsonMimeType = "application/json";
		   HttpUriRequest request = new HttpGet( "https://localhost:8080/users" );
		   HttpResponse response = HttpClientBuilder.create().build().execute( request );
		   String mimeType = ContentType.getOrDefault(response.getEntity()).getMimeType();
		   assertEquals( jsonMimeType, mimeType );
	   }
	   
	   //Test for Searching the username 
	   @Test
	   public void testSearchByUsername() throws Exception
	   {
		   //		   mockMvc.perform(get("/users"))
		   //  			.andexcept(status().isOk());
		   //		   
		   //assertTrue(userrepositoryimplementation.RetriveAllUserData(userrepository));	
		   
		   String actual = "{username: \"User2\",password: \"userpassword\",name: \"Amit\",\r\n" + 
		   		"email: \"amit13@gmail.com\"}";
		   JSONAssert.assertNotEquals(
				   userrepositoryimplementation.SearchByUsername("User2", userrepository).toString(), actual, JSONCompareMode.LENIENT);
		  
		   assertTrue(userrepositoryimplementation.InsertUserData(User user, userrepository));
		   assertTrue(userrepositoryimplementation.DeleteUsername("User3", userrepository));
	   }
	   
}
	*/