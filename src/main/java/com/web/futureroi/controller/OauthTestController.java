package com.web.futureroi.controller;

import com.web.futureroi.common.CommController;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequiredArgsConstructor
@RequestMapping("/oauth")
public class OauthTestController extends CommController {


    @GetMapping("test")
    public ResponseEntity test(){
        return SuccessReturn("future roi is a good serive");
    }

}
