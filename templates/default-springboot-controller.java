package com.site

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class DisplayMessageController {

    @RequestMapping(method = RequestMethod.GET, path = "/call-us")
    public String sendMessage() {
        return "Call us 403-293-3943";

    }

}