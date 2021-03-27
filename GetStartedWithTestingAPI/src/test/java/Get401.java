import entities.BaseClass;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClientBuilder;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.io.IOException;

import static org.testng.AssertJUnit.assertEquals;

/**
 * Scenario2 - baseUrlReturns401
 *
 * 1) Input url  -  https://api.github.com/user/followers
 * 2) Send HTTP "Get" request
 * 3) Verify that status code in response is "401"
 *
 *
 */

public class Get401 extends BaseClass {

    CloseableHttpClient client;
    CloseableHttpResponse response;

    @BeforeMethod
    public void setup(){
        client = HttpClientBuilder.create().build();
    }

    @AfterMethod
    public void closeResources() throws IOException {
        client.close();
        response.close();
    }

    @DataProvider
    private Object[][] endpoints(){
        return new Object[][]{
                {
                        "/user/followers"
                }
        };
    }

    @Test(dataProvider = "endpoints")
    public void Returns401(String endpoint) throws IOException {
        HttpGet get = new HttpGet(BASE_ENDPOINT);

        response = client.execute(get);
        int statusCode = response.getStatusLine().getStatusCode();
        assertEquals(401,statusCode);
    }
}
