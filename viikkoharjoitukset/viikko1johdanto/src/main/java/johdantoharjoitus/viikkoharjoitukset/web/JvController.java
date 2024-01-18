package johdantoharjoitus.viikkoharjoitukset.web;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class JvController {

    @RequestMapping("index")
    @ResponseBody
    public String returnMessageIndex() {
        return "This is the main page";
    }

    @RequestMapping("contact")
    @ResponseBody
    public String returnMessageContact() {
        return "This is the contact page";
    }

    @RequestMapping("hello")
    @ResponseBody
    public String returnMessageHello(@RequestParam String location, String name) {
        return "Welcome to the " + location + " " + name + "!";
    }

}
