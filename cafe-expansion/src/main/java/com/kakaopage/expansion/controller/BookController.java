package com.kakaopage.expansion.controller;

import java.util.List;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.kakaopage.expansion.service.BookService;
import com.kakaopage.expansion.service.KakaoApiService;
import com.kakaopage.expansion.vo.BookVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * 추가 기능: DB의 thumbnail 컬럼을 카카오 API에서 채우는 엔드포인트
 */
@RestController
@RequestMapping("/api/books")
public class BookController {

    @Autowired
    private BookService bookService;

    @Autowired
    private KakaoApiService kakaoApiService;

    private final ObjectMapper mapper = new ObjectMapper();

    /**
     * GET /api/books/fetch-thumbnails
     * thumbnail이 비어 있는 책들을 조회 → 카카오 도서 검색 API 호출 → DB 업데이트
     */
    @GetMapping("/fetch-thumbnails")
    public String fetchThumbnails() throws Exception {
        List<BookVO> list = bookService.getAllBooks();
        int updated = 0;

        for (BookVO book : list) {
            if (book.getThumbnail() == null || book.getThumbnail().isEmpty()) {
                String json = kakaoApiService.searchBook(book.getTitle());
                JsonNode doc = mapper.readTree(json)
                                     .path("documents")
                                     .get(0);
                if (doc != null && doc.has("thumbnail")) {
                    String thumb = doc.path("thumbnail").asText();
                    bookService.updateThumbnail(book.getId(), thumb);
                    updated++;
                }
            }
        }
        return "썸네일 업데이트 완료: " + updated + "건";
    }
}
