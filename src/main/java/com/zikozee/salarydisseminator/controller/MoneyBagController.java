package com.zikozee.salarydisseminator.controller;

import com.zikozee.salarydisseminator.model.MoneyBag;
import com.zikozee.salarydisseminator.model.enumModel.BankingAccountClass;
import com.zikozee.salarydisseminator.model.enumModel.BudgetType;
import com.zikozee.salarydisseminator.service.MoneyBagService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.annotation.PostConstruct;
import java.util.HashMap;
import java.util.Map;

@Controller
public class MoneyBagController {

    private final MoneyBagService moneyBagService;
    private Map<String,Enum> budgetChooser = new HashMap<>();
    private Map<String,Enum> bankType = new HashMap<>();

    public MoneyBagController(MoneyBagService moneyBagService) {
        this.moneyBagService = moneyBagService;
    }

    @GetMapping({"/", "/index.html", "/index", "homePage"})
    public String getHomepage(Model model){

        model.addAttribute("moneyBag", moneyBagService.findAll());
        return "moneyBaggee/index";
    }

    @GetMapping("/showFormForAdd")
    public String showFormForAdd(Model theModel){

        //create model attribute to bind form data
        MoneyBag theMoneyBag = new MoneyBag();

        theModel.addAttribute("aMoneyBag", theMoneyBag);
        theModel.addAttribute("budgetChooser", budgetChooser);
        theModel.addAttribute("bankType", bankType);

        return "moneyBaggee/addForm";
    }

    @GetMapping("/showFormForUpdate")
    public String showFormForUpdate(@RequestParam("moneyBagId") Long theId, Model theModel){

        // get the employee from the service
        MoneyBag moneyBag = moneyBagService.findById(theId);

        //set employee as a model attribute to pre-populate  the form
        theModel.addAttribute("aMoneyBag", moneyBag);
        theModel.addAttribute("budgetChooser", budgetChooser);
        theModel.addAttribute("bankType", bankType);

        // send over to our form
        return "moneyBaggee/addForm";
    }

    @PostMapping("/save")
    public String saveEmployee(@ModelAttribute("aMoneyBag") MoneyBag theMoneyBag){

        // save the Employee
        moneyBagService.save(theMoneyBag);
        // use a redirect to prevent duplicate submissions
        return "redirect:/";
    }

    @GetMapping("/delete")
    public String showFormForDelete(@RequestParam("moneyBagId") Long theId){

        // delete the employee
        moneyBagService.deleteById(theId);

        // redirect to /employee/list
        return "redirect:/";
    }

    @PostConstruct
    public void initData(){
        budgetChooser.put("Expenses", BudgetType.EXPENSES);
        budgetChooser.put("Savings",  BudgetType.SAVINGS);
        budgetChooser.put("Spend Later", BudgetType.SPEND_LATER);
        budgetChooser.put("Miscellaneous",  BudgetType.MISCELLANEOUS);

        bankType.put("Current", BankingAccountClass.CURRENT);
        bankType.put("Savings",  BankingAccountClass.SAVINGS);
    }
}
