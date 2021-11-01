package com.org.tests;

import com.org.framework.BasePath;
import com.org.dataprovider.DataProviderWeather;
import io.restassured.http.ContentType;
import org.apache.http.HttpStatus;
import org.testng.annotations.Test;
import org.apache.logging.log4j.Logger;
import org.apache.logging.log4j.LogManager;
import static io.restassured.RestAssured.given;
import static org.hamcrest.CoreMatchers.equalTo;

public class WeatherTest extends BaseTest {

    private static final Logger logger = LogManager.getLogger(WeatherTest.class.getName());
    /***
     * GET Request: /weather?q={city name} & appid={api key}
     * Response: JSON format
     */
    @Test(dataProviderClass = DataProviderWeather.class, dataProvider = "searchByCityName")
    public void searchByCityName(String cityName) {

        given()
                .accept(ContentType.JSON)
                .queryParam("q", cityName)
                .queryParam("appid", API_KEY)
                .when()
                .get(BasePath.WEATHER.getValue())
                .then()
                .statusCode(HttpStatus.SC_OK)
                .body("name", equalTo(cityName));

    }

    /**
     * GET Request: /weather?lat={lat}&lon={lon}& appid={api key}
     * Response: JSON format
     */
    @Test(dataProviderClass = DataProviderWeather.class, dataProvider = "searchByGeoCoordinates")
    public void searchByGeoCoordinates(double lat, double lon) {

        given()
                .accept(ContentType.JSON)
                .queryParam("lat", lat)
                .queryParam("lon", lon)
                .queryParam("appid", API_KEY)
                .when()
                .get(BasePath.WEATHER.getValue())
                .then()
                .statusCode(HttpStatus.SC_OK)
                .body("coord.lat",equalTo(lat))
                .body("coord.lon",equalTo(lon));


    }


    /**
     * GET Request: /weather?zip={zip code},{country code}&appid={api key}
     * Response: JSON format
     */
    @Test(dataProviderClass = DataProviderWeather.class, dataProvider = "searchByZip")
    public void searchByZip(int zipCode, String countryCode) {

        given()
                .accept(ContentType.JSON)
                .queryParam("zip", String.valueOf(zipCode).concat(",").concat(countryCode))
                .queryParam("appid", API_KEY)
                .when()
                .get(BasePath.WEATHER.getValue())
                .then()
                .statusCode(HttpStatus.SC_OK)
                .body("name",equalTo("Mountain View"));




    }

}
