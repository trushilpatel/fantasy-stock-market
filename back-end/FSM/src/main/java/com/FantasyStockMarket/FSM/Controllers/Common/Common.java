package com.FantasyStockMarket.FSM.Controllers.Common;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/")
public class Common {

    @GetMapping("")
    public String home() {
        return "Welcome to FSM back end";
    }

    @RequestMapping(value = "/**/{[path:[^\\.]*}")
    @GetMapping("errors")
    public String error() {
        return "ERROR: 404";
    }
}
