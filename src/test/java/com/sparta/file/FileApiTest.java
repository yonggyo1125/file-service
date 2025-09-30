package com.sparta.file;

import com.sparta.board.domain.entity.BoardData;
import com.sparta.global.domain.security.UserDetailsImpl;
import com.sparta.member.domain.entity.Users;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.web.servlet.MockMvc;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.multipart;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@AutoConfigureMockMvc
@ActiveProfiles("test")
public class FileApiTest {

    @Autowired
    MockMvc mockMvc;

    @Test
    void test1() throws Exception {
         mockMvc.perform(multipart("/v1/file/upload")
                 .param("gid", "testGid"))
                 .andDo(print())
                 .andExpect(status().is2xxSuccessful());
    }

    @Test
    void test2() {
        // 로그인한 사용자 정보
        UserDetailsImpl userDetails = (UserDetailsImpl) SecurityContextHolder.getContext().getAuthentication().getPrincipal();

        Users users = UserDetailsImpl.of(userDetails);

        BoardData item = new BoardData();
        item.setUsers(users);


    }
}
