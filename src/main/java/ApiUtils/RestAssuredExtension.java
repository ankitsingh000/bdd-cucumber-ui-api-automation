package ApiUtils;

import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.response.ResponseOptions;
import io.restassured.specification.RequestSpecification;

import java.net.URI;
import java.net.URISyntaxException;
import java.util.Map;

import io.restassured.RestAssured;
import io.restassured.builder.RequestSpecBuilder;
import utils.ReadConfigFile;

public class RestAssuredExtension {


	RequestSpecBuilder builder = new RequestSpecBuilder();
	public static RequestSpecification Request;

	static String resourcePath;

	static String baseURI = ReadConfigFile.readConfig("baseURI");
	static String basePath = ReadConfigFile.readConfig("basePath");

	public RestAssuredExtension() {
		builder.setBaseUri(baseURI);
		builder.setBasePath(basePath);
		builder.setContentType(ContentType.JSON);

		RequestSpecification requestSpec = builder.build();
		Request = RestAssured.given().spec(requestSpec);
	}



	public static void setUrl(String arg0) {

			resourcePath= arg0;

	}

	public static ResponseOptions<Response> putWithPathParameterAndBody(String pathParameterKey, String pathParameterValue, Map<String, String> body) {
		Request.pathParam(pathParameterKey,pathParameterValue);
		Request.body(body);

		return Request.put(RestAssuredExtension.getUrl());
	}

	public static String getUrl(){
		return resourcePath;
	}

	public static ResponseOptions<Response> deleteOpsWithPathParams(String pathParams) {
		Request.pathParam("id",pathParams);
		return Request.delete(RestAssuredExtension.getUrl());
	}

	public static ResponseOptions<Response> createUsers(Map<String, String> body) {
		return Request.body(body).post(RestAssuredExtension.getUrl());

	}
}
