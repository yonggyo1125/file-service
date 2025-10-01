package com.sparta.global;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.sparta.global.application.service.CodeValueService;
import com.sparta.global.domain.entity.CodeValue;
import com.sparta.global.infrastructure.repository.CodeValueRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

@SpringBootTest
//@ActiveProfiles("test")
public class CodeValueTest {
    @Autowired
    CodeValueRepository repository;

    @Autowired
    ObjectMapper om;

    @Autowired
    CodeValueService service;

    @Test
    void test1() throws Exception{
        List<String> categories = List.of("한식", "중식", "양식");
        String jsonValue = om.writeValueAsString(categories);

        CodeValue item = new CodeValue();
        item.setCode("STORE_CATEGORY");
        item.setValue(jsonValue);

        repository.saveAndFlush(item);
    }

    @Test
    void test2() throws Exception {

        CodeValue codeValue = repository.findById("STORE_CATEGORY").orElse(null);

        String jsonValue = codeValue.getValue();
        List<String> categories = om.readValue(jsonValue, new TypeReference<>() {});
    }

    @Test
    void test3() {
        List<String> categories = service.getValue("STORE_CATEGORY");
    }

    @Test
    void test4() {
        service.saveValue("STORE_CATEGORY", List.of("한식", "중식", "양식"));
    }
}
