package com.jiaty.demo.kindle;

/**
 * @program: practice
 * @description: 下载
 * @author: Jiaty
 * @create: 2020-08-11 15:33
 **/

// import Apache HTTP Client v 4.3
import org.apache.http.*;
import org.apache.http.auth.*;
import org.apache.http.client.*;
import org.apache.http.client.methods.*;
import org.apache.http.impl.client.*;
import org.apache.http.util.*;

// import JSON
import org.json.*;

public class Job {

    public static void main(String[] args) throws Exception {
        int jobId = 14253087;
        String apiKey = "3f8cd010b8272b9aed30a465e55ca54c0359f15c1";
        String endpoint = "https://api.zamzar.com/v1/jobs/" + jobId;

        // Create HTTP client and request object
        CloseableHttpClient httpClient = getHttpClient(apiKey);
        HttpGet request = new HttpGet(endpoint);

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