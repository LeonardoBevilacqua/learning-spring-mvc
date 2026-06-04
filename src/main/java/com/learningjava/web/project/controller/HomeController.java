package com.learningjava.web.project.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HomeController {
  /**
   * This method setups the route to '/', meaning 'http://localhost:8080' or
   * 'http://mywebsite.com'
   *
   * @return the return is a String value which represents a "VIEW" inside the
   *         template folder. In this case is the home.html.
   */
  @GetMapping("/")
  public String home() {
    return "home";
  }

}
