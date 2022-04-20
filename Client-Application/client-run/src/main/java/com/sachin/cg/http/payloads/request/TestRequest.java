package com.sachin.cg.http.payloads.request;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Data;

/**
 * @author Sachin.Shakya
 * @since 19-Apr-2022, Tuesday 6:40 PM
 */
@Data
@JsonInclude(JsonInclude.Include.NON_EMPTY)
public class TestRequest {

    private String name;

}
