package com.gest_empl.gest_empl.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class ForwardController {
    
    /**
     * Forward all non-API routes to index.html for React Router handling
     * Excludes /api/* paths and static resources
     */
    @RequestMapping(value = { "/", "/{path:^(?!api|assets|.*\\.).*$}" })
    public String redirect() {
        return "forward:/index.html";
    }
}

