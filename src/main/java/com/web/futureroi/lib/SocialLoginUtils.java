package com.web.futureroi.lib;

import org.json.JSONObject;
import org.springframework.stereotype.Component;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

@Component
public class SocialLoginUtils {

    private static final String kakao_apiUrl = "https://kapi.kakao.com/v2/user/me";

    public String getKakaoInfo(String accessToken) throws IOException {

        // API 요청을 위한 URL 설정
        URL url = new URL(kakao_apiUrl);
        HttpURLConnection connection = (HttpURLConnection) url.openConnection();

        // HTTP GET 메소드 설정
        connection.setRequestMethod("GET");

        // Authorization 헤더에 Access Token 추가
        connection.setRequestProperty("Authorization", "Bearer " + accessToken);

        // 응답코드 확인
        int responseCode = connection.getResponseCode();
        String email = null;

        if (responseCode == HttpURLConnection.HTTP_OK) { // 요청이 성공적으로 처리되었을 경우
            // 응답 결과 읽기
            BufferedReader reader = new BufferedReader(new InputStreamReader(connection.getInputStream()));
            StringBuilder response = new StringBuilder();
            String line;

            while ((line = reader.readLine()) != null) {
                response.append(line);
            }

            reader.close();

            // 사용자 정보 출력
            JSONObject json = new JSONObject(response.toString());
            email = json.getJSONObject("kakao_account").getString("email");
        }

        // 연결 해제
        connection.disconnect();

        return email;
    }

}
