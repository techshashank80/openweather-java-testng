package com.org.dataprovider;

import org.testng.annotations.DataProvider;

public class DataProviderWeather {
	
	@DataProvider(name = "searchByCityName")
	public static Object[][] cityName() {
		return new Object[][] {{"London"}};
	}
	
	@DataProvider(name = "searchByGeoCoordinates")
	public static Object[][] searchByGeoCoordinates() {
		return new Object[][] {{35.02, 139.01}};
	}
	
	@DataProvider(name = "searchByZip")
	public static Object[][] searchByZip() {
		return new Object[][] {{94040, "us"}};
	}

}
