package com.challenge.utils;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.Data;
import lombok.SneakyThrows;
import org.springframework.stereotype.Component;
import java.io.IOException;
import java.io.InputStream;

@Data
@Component
@JsonIgnoreProperties(ignoreUnknown = true)

public class DtoHelper {

    @SneakyThrows(IOException.class)
    private static <T> T createDTO(Class<T> dtoClass, String jsonFilePath) throws IOException {
        ObjectMapper objectMapper = new ObjectMapper();
        objectMapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);

        try (InputStream inJson = dtoClass.getClassLoader().getResourceAsStream(jsonFilePath)) {
             return objectMapper.readValue( inJson, dtoClass);
        }
    }

    public static <T> T createDtoFromJsonFile(Class<T> dtoClass, String jsonFilePath) {
        try {
			return createDTO(dtoClass, jsonFilePath);
		} catch (IOException e) {
			e.printStackTrace();
			return null;
		}
    }

    @SneakyThrows(IOException.class)
    public static <T> T createDtoFromJsonResponse(Class<T> dtoClass, String response) throws IOException {
        ObjectMapper objectMapper = new ObjectMapper();
        return objectMapper.readValue(response, dtoClass);
    }

}