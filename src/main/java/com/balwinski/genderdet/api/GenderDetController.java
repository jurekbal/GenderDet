package com.balwinski.genderdet.api;

import com.balwinski.genderdet.services.FirstTokenGenderDetector;
import com.balwinski.genderdet.services.GenderDetector;
import com.balwinski.genderdet.services.MultiTokenGenderDetector;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/genderdet")
public class GenderDetController {

    private GenderDetector detector;

    @GetMapping("/first/{name}")
    public String firstTokenEndpoint(@PathVariable(name = "name", required = false) String name){
        if (name == null) {
            return "INCONCLUSIVE";
        } else {
            detector = new FirstTokenGenderDetector();
            return detector.detect(name);
        }
    }

    @GetMapping("/multi/{name}")
    public String multiTokenEndpoint(@PathVariable(name = "name", required = false) String name){
        if (name == null) {
            return "INCONCLUSIVE";
        } else {
            detector = new MultiTokenGenderDetector();
            return detector.detect(name);
        }
    }
}
