package com.web.futureroi.controller;

import com.web.futureroi.common.CommController;
import com.web.futureroi.service.MindTestService;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
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
