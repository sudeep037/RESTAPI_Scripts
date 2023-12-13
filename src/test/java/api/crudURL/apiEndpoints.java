package api.crudURL;

public class apiEndpoints {

	public static String baseURI = "https://fakerestapi.azurewebsites.net/api/v1/Authors";
	
	public static String postURI = baseURI;
	public static String getURI = baseURI+"/{authID}";
	public static String putURI = baseURI+"/{authID}";
	public static String deleteURI = baseURI+"/{authID}";
}
