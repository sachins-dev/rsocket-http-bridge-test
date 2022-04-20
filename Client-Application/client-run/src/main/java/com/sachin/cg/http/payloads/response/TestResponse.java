package com.sachin.cg.http.payloads.response;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Data;

/**
 * @author Sachin.Shakya
 * @since 19-Apr-2022, Tuesday 6:40 PM
 */
@Data
@JsonInclude(JsonInclude.Include.NON_EMPTY)
public class TestResponse {

    private String message;

}
