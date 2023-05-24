package restAssuredRefrence;
import static io.restassured.RestAssured.given;
import io.restassured.RestAssured;
public class DeleteReference {

	public static void main(String[] args) 
	{
		// Step 1 :Declare BaseURL
      RestAssured.baseURI="https://reqres.in/";
      
     // Step 2:Configure Response Body
      int statusCode= given().header("Content_Type","application/json").body("").log().all().when().delete("api/users/2").then().extract().statusCode();
      System.out.println(statusCode);
      String responseBody=given().header("Content_Type","application/json").body("").log().all().when().delete("api/users/2").then().extract().response().asString();
      System.out.println(responseBody);
	}

}
