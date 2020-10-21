import constants.UrlConstants;
import io.restassured.RestAssured;
import io.restassured.response.ValidatableResponse;
import org.junit.jupiter.api.Test;

import java.util.List;
import java.util.concurrent.TimeUnit;
import java.util.regex.Pattern;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class TestsAPI {

    @Test
    public void checkTerm() {
        ValidatableResponse response = RestAssured.given().get(UrlConstants.WEB_APP_SEARCH_API_URL).then();
        List<String> results = response.statusCode(200)
                .extract().body().jsonPath().get("suggestions.term");
        assertEquals(results.size(), 4);
        for (String result : results) {
            String pattern = "^<span class=\"search-highlight\">java<\\/span>.*";
            assertTrue(Pattern.matches(pattern, result));
        }
        List<String> results2 = response
                .extract().body().jsonPath().get("pages.title");
        for (String result : results2) {
            assertTrue(result.contains("Wiley"));
        }
    }

    @Test
    public void checkDelay() {
        String DELAY = "delay/";
        assertEquals(RestAssured.given().baseUri(UrlConstants.DELAY_TEST_URL).post(DELAY+4).getTimeIn(TimeUnit.SECONDS), 4);
    }

    @Test
    public void chectContentType() {
        String CONTENT_TYPE = "image/png";
        RestAssured.given().baseUri(UrlConstants.DELAY_TEST_URL).get(CONTENT_TYPE).then().contentType(CONTENT_TYPE).statusCode(200);

    }
}