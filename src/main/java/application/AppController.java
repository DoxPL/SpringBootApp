package application;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@org.springframework.stereotype.Controller
public class AppController {
    @RequestMapping("/")
    @ResponseBody
    public String mainPage()
    {
        return "application.Main page";
    }

    @RequestMapping("/about")
    @ResponseBody
    public String aboutPage()
    {
        return "About page";
    }

    @RequestMapping("/get/{num}")
    @ResponseBody
    public String getNumber(@PathVariable("num") Long number)
    {
        return "Podany numer: " + number;
    }
}
