package com.abu.learn.HelloSpringBoot.controller;

import java.io.File;
import java.io.IOException;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HomeController {

	private final static Logger logger = LoggerFactory.getLogger(HomeController.class);
	
	@GetMapping("/")
    public String home() {
		logger.debug("xxxxxxxxxxxxx");
		logger.info("dddddddddd");
		logger.warn("warn");  
        logger.error("error"); 
        return "欢迎来到阿布的个人站点!^_^";
    }
	
	@GetMapping("/home")
    public String home2() {
		logger.debug("xxxxxxxxxxxxx");
		logger.info("dddddddddd");
		logger.warn("warn");  
        logger.error("error"); 
        return "欢迎来到阿布的个人站点!^_^-home";
    }
}
