package com.example.demo;
import java.util.List;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import lombok.Data;

//@Data
@Controller
public class controller {
    
    List<AmortizationTableRow> table;

    @GetMapping("/landing")
    public String loanLanding(Model model) {
      //System.out.println("test");
      model.addAttribute("amortization", new Amortization());
      return "landing";
    }
    
    @PostMapping("/landing")
    public String loanSubmit(@ModelAttribute Amortization amortization, Model model) {
      table = amortization.getAmortizationTable();
      model.addAttribute("table", table);
      return "result";
    }


}
