package com.sparta.board.presentation.dto;

import com.sparta.board.domain.entity.BoardData;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.UUID;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class BoardDataResponse {
    private UUID uid;
    private String poster;
    private String subject;
    private String content;

    private Long userSeq;
    private String email;
    private String name;


    public BoardDataResponse(BoardData item) {

    }
}
