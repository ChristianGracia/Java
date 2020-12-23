package com.site

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class DisplayMessageController {

    @GetMapping(path = "/call-us-bean")
    public DisplayMessageBean sendMessageBean() {
        return new DisplayMessageBean("Call us 403-293-3943");

    }

}
