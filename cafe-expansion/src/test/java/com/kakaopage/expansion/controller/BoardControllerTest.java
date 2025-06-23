package com.kakaopage.expansion.controller;

import com.kakaopage.expansion.service.BoardService;
import com.kakaopage.expansion.service.CommentService;
import com.kakaopage.expansion.vo.BoardVO;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import java.util.List;

import static org.mockito.BDDMockito.given;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

/**
 * 순수 Spring MVC 환경에서 Controller만 standaloneSetup으로 테스트
 */
class BoardControllerTest {

    @Mock
    private BoardService boardService;

    @Mock
    private CommentService commentService;

    @InjectMocks
    private BoardController boardController;

    private MockMvc mvc;

    @BeforeEach
    void setUp() {
        // Mockito @Mock, @InjectMocks 초기화
        MockitoAnnotations.openMocks(this);
        // Controller 단독으로 MockMvc 설정
        mvc = MockMvcBuilders.standaloneSetup(boardController).build();
    }

    @Test
    void GET_boards_shouldRenderListView() throws Exception {
        // given: boardService.getAll() 호출 시 더미 리스트 반환
        BoardVO sample = new BoardVO();
        sample.setId(1L);
        sample.setTitle("테스트 글");
        given(boardService.getAll()).willReturn(List.of(sample));

        // when & then: GET /boards → 200, 뷰 이름은 "boardList", 모델에 "boards" 속성
        mvc.perform(get("/boards"))
           .andExpect(status().isOk())
           .andExpect(view().name("boardList"))
           .andExpect(model().attributeExists("boards"));
    }

    @Test
    void GET_boardDetail_shouldRenderDetailView() throws Exception {
        // given: boardService.get(1L), commentService.getByBoard(1L) 설정
        BoardVO sample = new BoardVO();
        sample.setId(1L);
        sample.setTitle("디테일 페이지 테스트");
        given(boardService.get(1L)).willReturn(sample);
        given(commentService.getByBoard(1L)).willReturn(List.of());

        // when & then: GET /boards/1 → 200, 뷰 이름 "boardDetail", 모델 속성 존재
        mvc.perform(get("/boards/1"))
           .andExpect(status().isOk())
           .andExpect(view().name("boardDetail"))
           .andExpect(model().attributeExists("board", "comments", "newComment"));
    }
}
