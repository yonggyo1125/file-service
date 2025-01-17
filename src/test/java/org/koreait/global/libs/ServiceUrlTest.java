package org.koreait.global.libs;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.ContextConfiguration;

@SpringBootTest
@ActiveProfiles({"default", "test", "dev"})
@ContextConfiguration
public class ServiceUrlTest {

    @Autowired
    private Utils utils;

    @Test
    void urlTest() {
        String url = utils.serviceUrl("file-service", "/upload");
        System.out.println(url);
        //System.out.println("test");
    }
}
