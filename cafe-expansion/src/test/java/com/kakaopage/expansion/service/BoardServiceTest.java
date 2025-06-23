package com.kakaopage.expansion.service;

import static org.assertj.core.api.Assertions.*;
import static org.mockito.Mockito.*;

import java.util.List;

import com.kakaopage.expansion.dao.BoardDao;
import com.kakaopage.expansion.vo.BoardVO;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

@ExtendWith(MockitoExtension.class)
class BoardServiceTest {

    @Mock
    BoardDao boardDao;

    @InjectMocks
    BoardServiceImpl boardService;

    @Test
    void getAll_shouldReturnListFromDao() {
        // given
        BoardVO sample = new BoardVO();
        sample.setId(42L);
        sample.setTitle("테스트");
        when(boardDao.selectAll()).thenReturn(List.of(sample));

        // when
        List<BoardVO> result = boardService.getAll();

        // then
        assertThat(result).hasSize(1)
                          .first().extracting(BoardVO::getId)
                          .isEqualTo(42L);
        verify(boardDao).selectAll();
    }
}
