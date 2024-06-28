package com.example.springsecurityclient.entity;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.http.HttpInputMessage;
import org.springframework.http.HttpOutputMessage;
import org.springframework.http.MediaType;
import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.util.Collections;
import java.util.List;
import java.util.Map;

@Component
public class CustomTextHtmlHttpMessageConverter implements HttpMessageConverter<Map<String, Object>> {

    @Override
    public boolean canRead(Class<?> clazz, MediaType mediaType) {
        return Map.class.isAssignableFrom(clazz) && MediaType.TEXT_HTML.isCompatibleWith(mediaType);
    }

    @Override
    public boolean canWrite(Class<?> clazz, MediaType mediaType) {
        return false; // We only handle reading, not writing
    }

    @Override
    public List<MediaType> getSupportedMediaTypes() {
        return Collections.singletonList(MediaType.TEXT_HTML);
    }

    @Override
    public Map<String, Object> read(Class<? extends Map<String, Object>> clazz, HttpInputMessage inputMessage)
            throws IOException, HttpMessageNotReadableException {
        // Parse the HTML response into a Map
        // For simplicity, assuming the response is a JSON string inside an HTML body
        // You can use Jsoup or a similar library to parse the HTML content if needed
        String body = new String(inputMessage.getBody().readAllBytes());
        // Assuming the body contains JSON string in HTML
        // Implement your parsing logic here
        // Example: extract JSON part from HTML and convert to Map
        // Assuming the JSON part is in <pre> tag or similar
        String json = extractJsonFromHtml(body);
        return new ObjectMapper().readValue(json, Map.class);
    }

    private String extractJsonFromHtml(String html) {
        // Implement logic to extract JSON from HTML
        // Example: using regex or a library like Jsoup to parse HTML
        return html; // Simplified: just return html as is
    }

    @Override
    public void write(Map<String, Object> map, MediaType contentType, HttpOutputMessage outputMessage)
            throws IOException {
        throw new UnsupportedOperationException("Not supported");
    }
}