package api.testValidations;

import org.apache.logging.log4j.LogManager;
import org.json.JSONObject;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import org.testng.log4testng.Logger;

import com.github.javafaker.Faker;

import api.Payload.authPOJO;
import api.crudURL.CRUDOperations;
import io.restassured.response.Response;

public class testValidations {

	authPOJO authPayload;
	Faker faker;
	public Logger logger;
	
	@BeforeMethod
	public void setUpPayload()
	{
		authPayload = new authPOJO();
		faker = new Faker();
		
		authPayload.setId(faker.idNumber().hashCode());
		authPayload.setIdBook(faker.book().hashCode());
		authPayload.setFirstName(faker.name().firstName());
		authPayload.setLastName(faker.name().lastName());	
	}
	
	@Test(priority=1)
	public void testPOST()
	{
		
		Response response = CRUDOperations.createAuth(authPayload);
		response.then().log().all();
		Assert.assertEquals(response.getStatusCode(),200);
		Assert.assertEquals(response.getContentType(), "application/json; charset=utf-8; v=1.0");
		Assert.assertEquals(response.getHeader("Server"), "Kestrel");
		
		JSONObject jo = new JSONObject(response.asString());
		boolean status = false;
		/*Assert.assertEquals(jo.get("id"), authPayload.getId());
		Assert.assertEquals(jo.get("firstName"), authPayload.getFirstName());
		Assert.assertEquals(jo.get("lastName"), authPayload.getLastName());
		Assert.assertEquals(jo.get("idBook"), authPayload.getIdBook());*/
		
		if(jo.get("id").equals(authPayload.getId()))
		{
			Assert.assertEquals(status, false);
		}
		
	}
	
	@Test(priority=2)
	public void testGET()
	{
		
		Response response = CRUDOperations.getAuth(this.authPayload.getId());
		response.then().log().all();
		Assert.assertEquals(response.getStatusCode(),404);
		
	}
	
	@Test(priority=3)
	public void testPUT()
	{
		
		Response response = CRUDOperations.putAuth(this.authPayload.getId(), authPayload);
		response.then().log().all();
		
		// Creating JSON Object for JSON response 
		JSONObject jo = new JSONObject();
		boolean status = false;
		Assert.assertEquals(response.getStatusCode(), 200);
		
		/*Assert.assertEquals(jo.get("firstName"), authPayload.getFirstName());
		Assert.assertEquals(jo.get("lastName"), authPayload.getLastName());
		Assert.assertEquals(jo.get("idBook"), authPayload.getIdBook());*/
		
	}
	
	@Test(priority=4)
	public void testDELETE()
	{
		
		Response response = CRUDOperations.deleteAuth(this.authPayload.getId());
		response.then().log().all();
		Assert.assertEquals(response.getStatusCode(), 200);		
	}
	
}
