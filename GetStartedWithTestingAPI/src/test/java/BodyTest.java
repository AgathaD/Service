import entities.BaseClass;
import entities.NotFound;
import entities.User;
import org.testng.annotations.Test;

import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClientBuilder;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;


import java.io.IOException;

import static org.testng.AssertJUnit.assertEquals;

public class BodyTest extends BaseClass {
    CloseableHttpClient client;
    CloseableHttpResponse response;

    @BeforeMethod
    public void setup() {
        client = HttpClientBuilder.create().build();
    }

    @AfterMethod
    public void closeResources() throws IOException {
        client.close();
        response.close();
    }


    @Test
    public void returnsCorrectLogin() throws IOException {
        HttpGet get = new HttpGet(BASE_ENDPOINT + "/users/AgathaD");
        response = client.execute(get);
        User user = ResponseUtils.unmarshallGeneric(response, User.class);
        assertEquals(user.getLogin(), "AgathaD");
    }
}

