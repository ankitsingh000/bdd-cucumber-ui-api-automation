package stepDefs;

import ApiUtils.RestAssuredExtension;
//import ApiUtils.*;
import io.cucumber.java.After;
import io.cucumber.java.Before;

import utils.DriverFactory;
import utils.AssertionsUtility;

import static utils.AssertionsUtility.completeAssertions;
import static utils.AssertionsUtility.initSoftAssert;

public class Hooks extends DriverFactory {

	@Before ("@front-end")
	public void setup() {
		initWebDriver();
		initSoftAssert();

	}

	@After("@front-end")
	public void tearDown() {
		tearDownDrivers();
		completeAssertions();
	}

	@Before("@back-end")
	public void TestSetup() {
		RestAssuredExtension RestAssuredExtension = new RestAssuredExtension();
		initSoftAssert();
	}

	@After("@back-end")
	public void apiTearDown() {
		completeAssertions();
	}

}
