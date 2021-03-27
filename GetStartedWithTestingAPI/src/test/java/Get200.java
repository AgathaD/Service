import entities.BaseClass;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClientBuilder;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.io.IOException;

import static org.testng.AssertJUnit.assertEquals;

/**
 * Scenario1 - baseUrlReturns200
 *
 * 1) Input url  -  https://api.github.com/emojis
 * 2) Send HTTP client "Get" request
 * 3) Verify that status code in response is "200"
 *
 *
 */

public class Get200 extends BaseClass {


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

    @Test
    public void Returns200() throws IOException {
        HttpGet get = new HttpGet(BASE_ENDPOINT + "/emojis");
        response = client.execute(get);
        int actualStatus = response.getStatusLine().getStatusCode();
        assertEquals(actualStatus,200);
    }

}
