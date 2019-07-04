package com.bone.common;

import com.bone.models.ApiResponse;
import com.fasterxml.jackson.databind.JsonNode;
import org.springframework.http.HttpStatus;

import java.util.HashMap;
import java.util.Map;

public class DocoHelpers {

    public static JsonNode response(Map<String,String> body, int status)
    {
        Map metadata = new HashMap();
        metadata.put("status", status);
        metadata.put("message", HttpStatus.valueOf(status).getReasonPhrase());

        JsonNode result = ResponseApi.toJson((ApiResponse.builder()
                .metadata(metadata)
                .response(body)
                .build()
        ));
        return  result;
    }
}
