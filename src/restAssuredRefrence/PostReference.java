package restAssuredRefrence;
import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;
import org.testng.Assert;
import static io.restassured.RestAssured.given;

public class PostReference {

	public static void main(String[] args) {
	    
		// Step 1: Declare Base URL
		RestAssured.baseURI="https://reqres.in/";
		
		// Step 2: Configure RequestBody
		int statuscode=given().header("Content-Type","application/json").body("{\r\n"
				+ "    \"name\": \"morpheus\",\r\n"
				+ "    \"job\": \"leader\"\r\n"
				+ "}").log().all().when().post("/api/users").then().extract().statusCode();
	
		String responseBody=given().header("Content-Type","application/json").body("{\r\n"
				+ "    \"name\": \"morpheus\",\r\n"
				+ "    \"job\": \"leader\",\r\n"
				+ "    \"id\": \"148\",\r\n"
				+ "    \"createdAt\": \"2023-05-05T08:28:13.425Z\"\r\n"
				+ "}").log().all().when().post("/api/users").then().log().all().extract().response().asString();
		System.out.println(responseBody);
		
		// Step 3: Parse the ResponseBody
		JsonPath jsp=new JsonPath(responseBody);
		String res_name=jsp.getString("name");
		String res_job=jsp.getString("job");
		String res_id=jsp.getString("id");
		String res_createdAt=jsp.getString("createdAt");
		//System.out.println(res_name);

	 // Step 4: Validate Responsebody 
      Assert.assertEquals(statuscode,201);
	  Assert.assertEquals(res_name,"morpheus");
	  Assert.assertEquals(res_job,"leader");
	  Assert.assertNotNull(res_id,"15");
	  Assert.assertNotNull(res_createdAt,"2023-05-05T08:28:13.425Z");
	}
}
