package org.koreait.member;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Data;
import org.koreait.member.contants.Authority;

import java.util.List;

@Data
@JsonIgnoreProperties(ignoreUnknown = true)
public class Member {
    private Long seq;
    private String email;
    private String name;
    private List<Authority> authorities;
}
