package com.devops.skeletor;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;


import java.util.Map;

@Controller
public class WebController {

  private static final Logger logger = LoggerFactory
          .getLogger(WebController.class);

  @RequestMapping("/")
  String index(Map<String, Object> model) {
    logger.info("requested /");
    return "index.html";
  }
}

