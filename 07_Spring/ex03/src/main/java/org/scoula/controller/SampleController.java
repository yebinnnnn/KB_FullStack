package org.scoula.controller;

import lombok.extern.log4j.Log4j2;
import org.scoula.DTO.SampleDTO;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@RestController
@Log4j2
@RequestMapping("/sample")
public class SampleController {
    @RequestMapping("") // url : /sample
    public String basic() {

        log.info("basic............");
        return "Sample Controller";
    }
    @RequestMapping(value="/basic", method= {RequestMethod.GET, RequestMethod.POST}) // url: /sample/basic
    public void basicGet(){

        log.info("basic get............");

    }

    @GetMapping("/basicOnlyGet") // url: /sample/basicOnlyGet
    public void basicGet2(){

        log.info("basic get only get............");

    }
    @GetMapping("/ex01")
    public String ex01(SampleDTO dto) {
        log.info("" + dto);
        return "ex01";

    }

    @GetMapping("/ex04")
    public String ex04(SampleDTO dto, @ModelAttribute("page")int page) {
        log.info("dto: " + dto);
        log.info("page: " + page);
        return "sample/ex04";

    }

    @GetMapping("/exUpload")
    public void exUpload() {

        log.info("/exUpload..........");

    }
}
