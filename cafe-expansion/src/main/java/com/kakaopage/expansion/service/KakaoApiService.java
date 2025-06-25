package com.kakaopage.expansion.service;

import java.net.URLEncoder;
import java.nio.charset.StandardCharsets;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.*;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class KakaoApiService {

    @Value("${kakao.api.key}")
    private String kakaoApiKey;

    private final RestTemplate rest = new RestTemplate();

    /** 기존 로컬 검색 메서드 */

    /**
     * 도서 검색 API 호출 (카카오)
     * @param query 책 제목
     * @return JSON 문자열
     */
    public String searchBook(String query) {
        String url = "https://dapi.kakao.com/v3/search/book?query="
                   + URLEncoder.encode(query, StandardCharsets.UTF_8);
        HttpHeaders headers = new HttpHeaders();
        headers.set("Authorization", "KakaoAK " + kakaoApiKey);
        HttpEntity<Void> entity = new HttpEntity<>(headers);
        ResponseEntity<String> resp = rest.exchange(url, HttpMethod.GET, entity, String.class);
        return resp.getBody();
    }
}
