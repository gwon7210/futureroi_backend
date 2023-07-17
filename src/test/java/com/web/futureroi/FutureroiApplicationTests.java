package com.web.futureroi;

import org.json.JSONObject;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

@SpringBootTest
class FutureroiApplicationTests {

    @Test
    void contextLoads() throws IOException {
        //test
        String accessToken = "SBauJj9dwg8e4Pt-Oonmb4Li0-pqKSxhpAoMchc_Cj1zGAAAAYlIhRyz";
        String apiUrl = "https://kapi.kakao.com/v2/user/me";

        // API 요청을 위한 URL 설정
        URL url = new URL(apiUrl);
        HttpURLConnection connection = (HttpURLConnection) url.openConnection();

        // HTTP GET 메소드 설정
        connection.setRequestMethod("GET");

        // Authorization 헤더에 Access Token 추가
        connection.setRequestProperty("Authorization", "Bearer " + accessToken);

        // 응답코드 확인
        int responseCode = connection.getResponseCode();

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
            String email = json.getJSONObject("kakao_account").getString("email");
            System.out.println(email);


        } else { // 요청이 실패한 경우
            System.out.println("API 요청 실패: " + responseCode);
        }

        // 연결 해제
        connection.disconnect();
    }

}
