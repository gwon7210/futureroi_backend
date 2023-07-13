package com.web.futureroi.common.interceptor;


import lombok.extern.slf4j.Slf4j;
import org.springframework.web.servlet.HandlerInterceptor;

@Slf4j
public class LogInterceptor implements HandlerInterceptor {
    private final String POST = "POST";
//
//    // Success Return은 postHandle에서 Log 처리
//    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView mv) throws Exception {
//        ResponseDto responseDTO = getResponseBody(response);
//        if (responseDTO.getCode() == 200)
//            if (request.getMethod().equals(POST)) {
//                log.info("{} || Result : code = {} msg = {} \n Parameter : {} ", request.getRequestURI(), responseDTO.getCode(), responseDTO.getCodeMsg(), request.getAttribute("requestBody"));
//            } else
//                APILog.info(request, responseDTO.getCode(), responseDTO.getCodeMsg());
//    }
//
//    // Error Return은 afterCompletion Log 처리
//    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) throws Exception {
//        ResponseDto responseDTO = getResponseBody(response);
//        // Exception이 발생하면 postHandle을 타지 않는다.
//        if (responseDTO.getCode() != 200)
//            if (request.getMethod().equals(POST)) {
//                log.info("{} || Result : code = {} msg = {} \n Parameter : {} ", request.getRequestURI(), responseDTO.getCode(), responseDTO.getCodeMsg(), request.getAttribute("requestBody"));
//            } else
//                ERRLog.info(request, responseDTO.getCode(), responseDTO.getCodeMsg());
//    }
//
//
//    private ResponseDto getResponseBody(HttpServletResponse response) throws IOException {
//        ContentCachingResponseWrapper responseWrapper = getResponseWrapper(response);
//        ObjectMapper om = new ObjectMapper();
//        return om.readValue(responseWrapper.getContentAsByteArray(), ResponseDto.class);
//    }
//
//    private ContentCachingResponseWrapper getResponseWrapper(HttpServletResponse response) {
//        if (response instanceof ContentCachingResponseWrapper) {
//            return (ContentCachingResponseWrapper) response;
//        }
//        return new ContentCachingResponseWrapper(response);
//    }
}