package com.jiaty.demo.kindle;

/**
 * @program: practice
 * @description: kindle格式转换
 * @author: Jiaty
 * @create: 2020-08-11 15:45
 **/

// import Apache HTTP Client v 4.3
import org.apache.http.*;
import org.apache.http.auth.*;
import org.apache.http.client.*;
import org.apache.http.client.methods.*;
import org.apache.http.entity.*;
import org.apache.http.entity.mime.*;
import org.apache.http.entity.mime.content.*;
import org.apache.http.impl.client.*;
import org.apache.http.util.*;

// import JSON
import org.json.*;

// import from JDK
import java.io.*;

public class StartJob {

    public static void main(String[] args) throws Exception {
        String apiKey = "3f9cd010b82712b9aed30a465e55ca54c0359f5c1";
        String endpoint = "https://sandbox.zamzar.com/v1/jobs";
        String sourceFile = "/Users/jiatengyu/Downloads/avatar.png";
        String targetFormat = "jpg";

        // Create HTTP client and request object
        CloseableHttpClient httpClient = getHttpClient(apiKey);
        HttpEntity requestContent = MultipartEntityBuilder.create()
                .addPart("source_file", new FileBody(new File(sourceFile)))
                .addPart("target_format", new StringBody(targetFormat, ContentType.TEXT_PLAIN))
                .build();
        HttpPost request = new HttpPost(endpoint);
        request.setEntity(requestContent);

        // Make request
        CloseableHttpResponse response = httpClient.execute(request);

        // Extract body from response
        HttpEntity responseContent = response.getEntity();
        String result = EntityUtils.toString(responseContent, "UTF-8");

        // Parse result as JSON
        JSONObject json = new JSONObject(result);

        // Print result
        System.out.println(json);

        // Finalise response and client
        response.close();
        httpClient.close();
    }

    // Creates a HTTP client object that always makes requests
    // that are signed with the specified API key via Basic Auth
    private static CloseableHttpClient getHttpClient(String apiKey) {
        CredentialsProvider credentialsProvider = new BasicCredentialsProvider();
        credentialsProvider.setCredentials(AuthScope.ANY,
                new UsernamePasswordCredentials(apiKey, ""));

        CloseableHttpClient httpClient = HttpClientBuilder.create()
                .setDefaultCredentialsProvider(credentialsProvider)
                .build();

        return httpClient;
    }
}