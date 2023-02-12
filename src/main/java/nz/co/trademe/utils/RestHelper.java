package nz.co.trademe.utils;

import java.util.HashMap;
import java.util.Map;
import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import static io.restassured.RestAssured.baseURI;
import static io.restassured.RestAssured.given;

public class RestHelper {

private RequestSpecification request;
private Response response;

public RestHelper() {
        // Trust all hosts
        RestAssured.useRelaxedHTTPSValidation();
        }

/**
 * Construct request headers.
 *
 * @param headerMap map of the headers
 */
public void constructHeaders(final Map<String, String> headerMap) {

        request = given();
        Map<String, String> headers = new HashMap<>();
        for (String name : headerMap.keySet()) {
        headers.put(name, headerMap.get(name));
        }
        request.headers(headers);
        }

/**
 * Construct request body.
 *
 * @param object request body
 */
public void constructRequestBody(final Object object) {
        request.contentType("application/json");
        request.body(object);
        }

/**
 * Send HTTP request.
 * /* @param httpMethod
 *
 * @param uriKey incoming uri
 */
public void sendRequest(final String uriKey) {

        HttpMethod method = (uriKey.startsWith("get")) ? HttpMethod.GET
        : (uriKey.startsWith("post")) ? HttpMethod.POST
        : (uriKey.startsWith("put")) ? HttpMethod.PUT
        : (uriKey.startsWith("delete")) ? HttpMethod.DELETE
        : (uriKey.startsWith("patch")) ? HttpMethod.PATCH : HttpMethod.OPTIONS;

        String parameterUri = TestConfig.getEnvProperty(uriKey);
        request.log().all();

        switch (method) {
        case GET:
        response = request.when().get(baseURI + parameterUri);
        break;
        case PUT:
        response = request.when().put(baseURI + parameterUri);
        break;
        case POST:
        response = request.when().post(baseURI + parameterUri);
        break;
        case PATCH:
        response = request.when().patch(baseURI + parameterUri);
        break;
        case DELETE:
        response = request.when().delete(baseURI + parameterUri);
        break;
        case OPTIONS:
        response = request.when().options(baseURI + parameterUri);
        break;
default:
        break;
        }
        response.then().log().all();
        }

/**
 * Enum class to hold all HTTP methods for RESTful web services.
 */
private enum HttpMethod {
    /**
     * HTTP GET.
     */
    GET,

    /**
     * HTTP PUT.
     */
    PUT,

    /**
     * HTTP POST.
     */
    POST,

    /**
     * HTTP PATCH.
     */
    PATCH,

    /**
     * HTTP DELETE.
     */
    DELETE,

    /**
     * HTTP OPTIONS.
     */
    OPTIONS,
}

}
