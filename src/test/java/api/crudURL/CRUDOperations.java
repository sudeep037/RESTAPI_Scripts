package api.crudURL;

import static io.restassured.RestAssured.*;
import static io.restassured.matcher.RestAssuredMatchers.*;
import static org.hamcrest.Matchers.*;

import api.Payload.authPOJO;
import io.restassured.http.ContentType;
import io.restassured.response.Response;

public class CRUDOperations {

	public static Response createAuth(authPOJO Payload)
	{
		Response response = given()
		 .contentType(ContentType.JSON)
		 .body(Payload)
		 
		.when()
		 .post(apiEndpoints.postURI);
		
		return response;
	}
	
	public static Response getAuth(int authID)
	{
		Response response = given()
		 .contentType(ContentType.JSON)
		 .pathParam("authID", authID)
		 
		.when()
		 .get(apiEndpoints.getURI);
		
		return response;
	}
	
	public static Response putAuth(int authID, authPOJO Payload)
	{
		Response response = given()
				.contentType(ContentType.JSON)
				.pathParam("authID", authID)
				.body(Payload)
				
			.when()
			 .put(apiEndpoints.putURI);
		
		return response;
	}
	
	public static Response deleteAuth(int authID)
	{
		Response response = given()
				.contentType(ContentType.JSON)
				.pathParam("authID", authID)
				
			.when()
			 .delete(apiEndpoints.deleteURI);
		
		return response;
	}
}
