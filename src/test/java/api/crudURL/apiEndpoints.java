package api.crudURL;


// Keeping base URI along with Request URI 

public class apiEndpoints {

	public static String baseURI = "";
	
	public static String postURI = baseURI;
	public static String getURI = baseURI+"/{authID}";
	public static String putURI = baseURI+"/{authID}";
	public static String deleteURI = baseURI+"/{authID}";
}
