package com.jiaty.demo.kindle;

/**
 * @program: practice
 * @description: xiazai
 * @author: Jiaty
 * @create: 2020-08-11 15:56
 **/

// import Apache HTTP Client v 4.3
import org.apache.http.*;
import org.apache.http.auth.*;
import org.apache.http.client.*;
import org.apache.http.client.methods.*;
import org.apache.http.impl.client.*;

// import from JDK
import java.io.*;

public class DownloadFile {

    public static void main(String[] args) throws Exception {
        int fileId = 84179051;
        String apiKey = "3f9cd010b8272b9aed30a465e55ca54c0359f5c1";
        String endpoint = "https://sandbox.zamzar.com/v1/files/" + fileId + "/content";
        String localFilename = "/Users/jiatengyu/Desktop/avatar.jpg";

        // Create HTTP client and request object
        CloseableHttpClient httpClient = getHttpClient(apiKey);
        HttpGet request = new HttpGet(endpoint);

        // Make request
        CloseableHttpResponse response = httpClient.execute(request);

        // Extract body from response
        HttpEntity responseContent = response.getEntity();

        // Save response content to file on local disk
        BufferedInputStream bis = new BufferedInputStream(responseContent.getContent());
        BufferedOutputStream bos = new BufferedOutputStream(new FileOutputStream(localFilename));
        int inByte;
        while((inByte = bis.read()) != -1) {
            bos.write(inByte);
        }

        // Print success message
        System.out.println("File downloaded");

        // Finalise response, client and streams
        response.close();
        httpClient.close();
        bos.close();
        bis.close();
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