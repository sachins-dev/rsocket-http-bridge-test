package com.sachin.cg.transformer;

import com.sachin.cg.http.payloads.request.TestRequest;
import com.sachin.cg.http.payloads.response.TestResponse;
import com.sachin.protobuf.payloads.request.SimpleRequest;
import com.sachin.protobuf.payloads.response.SimpleResponse;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.NullValueCheckStrategy;

/**
 * @author Sachin.Shakya
 * @since 03-Apr-2022, Sunday 11:48 PM
 */
@Mapper(componentModel = "spring",
        nullValueCheckStrategy = NullValueCheckStrategy.ALWAYS)
public interface TestReqResTransformer {

    @Mapping(source = "name", target = "requestMessage", defaultValue = "")
    SimpleRequest getSimpleRequest(TestRequest testRequest);

    @Mapping(source = "responseMessage", target = "message")
    TestResponse getTestResponse(SimpleResponse simpleResponse);

}