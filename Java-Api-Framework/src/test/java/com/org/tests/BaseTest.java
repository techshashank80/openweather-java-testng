package com.org.tests;

import io.restassured.config.JsonConfig;
import io.restassured.path.json.config.JsonPathConfig;
import org.testng.annotations.BeforeClass;
import com.org.framework.BaseConfiguration;
import io.restassured.RestAssured;
import static io.restassured.RestAssured.enableLoggingOfRequestAndResponseIfValidationFails;

public class BaseTest {
	
	protected static final String API_KEY = "e4cf307afc5a0a3bbc0921c6418f1cc2";
		
	@BeforeClass
	public void setUp() {
		RestAssured.baseURI = BaseConfiguration.getBaseUri();
		enableLoggingOfRequestAndResponseIfValidationFails();
		JsonConfig jsonConfig = JsonConfig.jsonConfig()
				.numberReturnType(JsonPathConfig.NumberReturnType.DOUBLE);
       // Added to handle the double type values
		RestAssured.config = RestAssured.config()
				.jsonConfig(jsonConfig);
	}
}
