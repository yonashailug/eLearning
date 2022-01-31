package edu.hahu.gateway;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpRequest;
import org.springframework.http.client.ClientHttpRequestExecution;
import org.springframework.http.client.ClientHttpRequestInterceptor;
import org.springframework.http.client.ClientHttpResponse;

import java.io.IOException;
import java.util.Collections;
import java.util.List;

public class HeaderInterceptor implements ClientHttpRequestInterceptor {
    @Override
    public ClientHttpResponse intercept(HttpRequest request, byte[] body, ClientHttpRequestExecution execution) throws IOException {
        HttpHeaders headers = request.getHeaders();
//        List<String> authorization = HeaderThreadLocal.getAuthorization();
//        List<String> accept = HeaderThreadLocal.getAuthorization();
//
//        headers.addAll("Authorization", authorization);
        headers.addAll("userId", Collections.singletonList("45"));
        return execution.execute(request, body);
    }
}
