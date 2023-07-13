package com.web.futureroi;

import io.jsonwebtoken.io.IOException;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;


@SpringBootTest
class OseekApplication2Tests {
    private static final String API_KEY = "SBauJj9dwg8e4Pt-Oonmb4Li0-pqKSxhpAoMchc_Cj1zGAAAAYlIhRyz";

    @Test
    void contextLoads() throws java.io.IOException {
        String accessToken = "2pjEyvxfFqneHxwelEwy1Ron9nRdCBr4";
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
            System.out.println(response.toString());
        } else { // 요청이 실패한 경우
            System.out.println("API 요청 실패: " + responseCode);
        }

        // 연결 해제
        connection.disconnect();
    }





    public static void test() {
        double latitude = 37.5665; // 위도
        double longitude = 126.9780; // 경도

        try {
            String address = getAddressFromCoordinates(latitude, longitude);
            System.out.println("주소: " + address);
        } catch (IOException | java.io.IOException e) {
            System.err.println("주소 변환 중 오류가 발생했습니다: " + e.getMessage());
        }
    }

    private static String getAddressFromCoordinates(double latitude, double longitude) throws IOException, java.io.IOException {
        String apiUrl = "https://dapi.kakao.com/v2/local/geo/coord2address.json?x=" + longitude + "&y=" + latitude;

        URL url = new URL(apiUrl);
        HttpURLConnection conn = (HttpURLConnection) url.openConnection();
        conn.setRequestMethod("GET");
        conn.setRequestProperty("Authorization", "KakaoAK " + API_KEY);

        BufferedReader br = new BufferedReader(new InputStreamReader(conn.getInputStream()));
        StringBuilder response = new StringBuilder();
        String line;

        while ((line = br.readLine()) != null) {
            response.append(line);
        }

        br.close();

        // JSON 파싱 등을 통해 주소 추출
        // 주소 추출 예시:
        // String address = parseAddressFromResponse(response.toString());

        return response.toString();
    }

}
