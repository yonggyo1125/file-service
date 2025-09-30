package com.sparta.board.domain.entity;

import com.sparta.board.presentation.dto.BoardDataResponse;
import com.sparta.member.domain.entity.Users;
import jakarta.persistence.*;
import lombok.Data;
import org.modelmapper.ModelMapper;
import org.modelmapper.convention.MatchingStrategies;

import java.util.UUID;

@Data
@Entity
@Table(name="P_BOARD_DATA")
public class BoardData {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID uid;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name="u_uid")
    private Users users;

    private String poster;
    private String subject;
    @Lob
    private String content;

    public BoardDataResponse toDto() {
        ModelMapper mapper = new ModelMapper();
        mapper.getConfiguration().setMatchingStrategy(MatchingStrategies.STRICT);
        BoardDataResponse response = mapper.map(this, BoardDataResponse.class);
        Users users = getUsers();
        response.setEmail(users.getEmail());
        response.setName(users.getName());
        response.setUserSeq(users.getSeq());

        return response;
    }
}
