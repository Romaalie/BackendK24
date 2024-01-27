package modelandview.web;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class ModelandviewController {

    @RequestMapping("/hello")
    public String showHelloPage() {
        return "hello";
    }

    @RequestMapping("/agetest")
    public String showGreetingTest(@RequestParam String name, String age, Model modelName, Model modelAge) {
        modelName.addAttribute("name", name);
        modelAge.addAttribute("age", age);

        return "agetest";
    }

    @RequestMapping("/studentlist")
    public String showStudentList() {
        return "studentlist";
    }

}