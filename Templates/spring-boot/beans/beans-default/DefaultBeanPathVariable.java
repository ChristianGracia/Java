package com.site;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class DisplayMessageController {

    @GetMapping(path = "/user/{name}")
    public DisplayMessageBean sendMessagePathVariable(@PathVariable String name) {
        return new DisplayMessageBean(String.format("Call us %s", name));

    }

}