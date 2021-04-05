package com.balwinski.genderdet.api;

import com.balwinski.genderdet.services.FirstTokenGenderDetector;
import com.balwinski.genderdet.services.GenderDetector;
import com.balwinski.genderdet.services.MultiTokenGenderDetector;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/genderdet")
public class GenderDetController {

    private GenderDetector detector;

    @GetMapping
    public String getGender(@RequestParam(value="name", defaultValue = "") String name,
                            @RequestParam(value = "method", defaultValue = "1") int method) {
        switch (method) {
            case 1: {
                detector = new FirstTokenGenderDetector();
                break;
            }
            case 2: {
                detector = new MultiTokenGenderDetector();
                break;
            }
            default: {
                detector = new FirstTokenGenderDetector();
            }
        }
        return detector.detect(name);
    }
}
