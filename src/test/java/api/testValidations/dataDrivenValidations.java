package api.testValidations;

import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import UtilityFiles.dataProvider;
import api.Payload.authPOJO;
import api.crudURL.CRUDOperations;
import io.restassured.response.Response;

public class dataDrivenValidations {

	@Test(priority=1, dataProvider = "Data", dataProviderClass = dataProvider.class)
	public void testPOST(String authID, String bookID, String FN, String LN)
	{
		authPOJO payLoad = new authPOJO();
		payLoad.setId(Integer.parseInt(authID));
		payLoad.setIdBook(Integer.parseInt(bookID));
		payLoad.setFirstName(FN);
		payLoad.setLastName(LN);
		
		Response response = CRUDOperations.createAuth(payLoad);
		Assert.assertEquals(response.getStatusCode(), 200);
	}
	
	@Test(priority=2, dataProvider = "authID", dataProviderClass = dataProvider.class)
	public void testGET(String authID)
	{
		Response response = CRUDOperations.getAuth(Integer.parseInt(authID));
		Assert.assertEquals(response.getStatusCode(), 200);
	}
	
	
	
	@Test(priority=3, dataProvider = "authID", dataProviderClass = dataProvider.class)
	public void testDELETE(String authID)
	{
		Response response = CRUDOperations.deleteAuth(Integer.parseInt(authID));
		Assert.assertEquals(response.getStatusCode(), 200);
	}
}
