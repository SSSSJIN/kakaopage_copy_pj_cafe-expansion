package com.kakaopage.expansion.dao;

import com.kakaopage.expansion.vo.CommentVO;
import java.util.List;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

@Mapper
public interface CommentMapper {

    List<CommentVO> getCommentsByBookId(@Param("bookId") Long bookId);
    void add(CommentVO vo);
    void delete(@Param("commentId") Long commentId);
}
