package com.sparta.global.application.service;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.sparta.global.domain.entity.CodeValue;
import com.sparta.global.infrastructure.repository.CodeValueRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class CodeValueService {
    private final CodeValueRepository repository;
    private final ObjectMapper om;

    /**
     * 컬렉션 형태로 변환되는 값
     *
     * @param code
     * @return
     * @param <T>
     */
    public <T> T getValue(String code) {
        return getValue(code, null);
    }

    public <T> T getValue(String code, Class<T> clz)  {
        CodeValue codeValue = repository.findById(code).orElse(null);
        if (codeValue != null) {
            try {
                String jsonValue = codeValue.getValue();
                return clz == null ? om.readValue(jsonValue, new TypeReference<>() {}) : om.readValue(jsonValue, clz);
            } catch (JsonProcessingException e) {}
        }

        return null;
    }

    public void saveValue(String code, Object value) {
        try {
            String json = om.writeValueAsString(value);
            CodeValue codeValue = new CodeValue();
            codeValue.setCode(code);
            codeValue.setValue(json);

            repository.saveAndFlush(codeValue);
        } catch (JsonProcessingException e) {}
    }

    public void deleteValue(String code) {
        repository.deleteById(code);
        repository.flush();
    }

}
