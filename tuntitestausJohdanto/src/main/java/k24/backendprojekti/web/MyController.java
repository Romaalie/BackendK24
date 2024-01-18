package k24.backendprojekti.web;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class MyController {
    
    @RequestMapping("hello")
    @ResponseBody
    public String returnMessage() {
        return "Hello World!";
    }

    @RequestMapping("main")
    @ResponseBody
    public String returnNamedMessage(@RequestParam (name="nimesi", required=false, defaultValue="Muumi") String etunimi, @RequestParam int age) {
        return "Hello " + etunimi + " " + age + " vuotta";
    }


}
