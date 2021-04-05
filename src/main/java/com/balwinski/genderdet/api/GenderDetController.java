package com.balwinski.genderdet.api;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/genderdet")
public class GenderDetController {

    @GetMapping
    public String getGender() {
        return "Gender controller works";
    }
}
