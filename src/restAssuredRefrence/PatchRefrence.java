package restAssuredRefrence;
import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;
import org.testng.Assert;
import static io.restassured.RestAssured.given;

public class PatchRefrence {

	public static void main(String[] args) {
		 
		// Step 1: Declare Base URL
		RestAssured.baseURI="https://reqres.in/";
		
	  // Step 2: Configure RequestBody
		int statusCode=given().header("Content-Type","application/json").body("{\r\n"
				+ "    \"name\": \"morpheus\",\r\n"
				+ "    \"job\": \"zion resident\"\r\n"
				+ "}").log().all().when().patch("/api/users/2").then().log().all().extract().statusCode();
		String responseBody = given().header("Content-Type","application/json").body("{\r\n"
				+ "    \"name\": \"morpheus\",\r\n"
				+ "    \"job\": \"zion resident\"\r\n"
				+ "}").log().all().when().patch("/api/users/2").then().log().all().extract().response().asString();
		
		// Step 3: Parse the ResponseBody
		JsonPath jsp = new JsonPath(responseBody);
		String res_name=jsp.getString("name");
		String res_job=jsp.getString("job");
		
		//Step 4 : Validate the ResponseBody Parameters
		Assert.assertEquals(statusCode, 200);
		Assert.assertEquals(res_name,"morpheus");
		Assert.assertEquals(res_job,"zion resident");
		

	}

}
	


