import entities.BaseClass;
import entities.User;
import org.apache.http.HttpHeaders;
import org.apache.http.client.methods.HttpDelete;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.ContentType;
import org.apache.http.entity.StringEntity;
import org.testng.Assert;
import org.testng.annotations.Test;
import org.codehaus.plexus.util.Base64;

import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClientBuilder;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;


import java.io.IOException;
import java.nio.charset.Charset;


public class DeleteAndPost extends BaseClass{
CloseableHttpClient client;
CloseableHttpResponse response;
    String myToken= "***************";

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
    public void createRepository() throws IOException {
        HttpPost request = new HttpPost(BASE_ENDPOINT+"/user/repos");
        request.setHeader(HttpHeaders.AUTHORIZATION,"token "+myToken);
        String json = "{\"name\":\"deleteme\"}";
        request.setEntity(new StringEntity(json, ContentType.APPLICATION_JSON));
        response = client.execute(request);
        int actualStatusCode = response.getStatusLine().getStatusCode();
        Assert.assertEquals(actualStatusCode,201);
    }

    @Test
    public void deleteRepository() throws IOException {
        HttpDelete request = new HttpDelete(BASE_ENDPOINT+"/repos/AgathaD/deleteme");
        request.setHeader(HttpHeaders.AUTHORIZATION,"token "+myToken);
        response = client.execute(request);
        int actualStatusCode = response.getStatusLine().getStatusCode();
        Assert.assertEquals(actualStatusCode,204);

    }
}
