package application;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;

@org.springframework.stereotype.Controller
public class AppController {
    @RequestMapping("/")
    @ResponseBody
    public String mainPage()
    {
        return "application.Main page";
    }

    @RequestMapping("/get/{num}")
    @ResponseBody
    public String getNumber(@PathVariable("num") Long number)
    {
        return "Podany numer: " + number;
    }

    @RequestMapping("/get/info")
    @ResponseBody
    public String getInfo(HttpServletRequest request)
    {
        String browser = request.getHeader("User-Agent");
        String server = request.getHeader("Host");
        String ipAddress = request.getRemoteAddr();
        return "User browser: " + browser + System.lineSeparator() +
                "Host: " + server + System.lineSeparator() +
                "User IP Address: " + ipAddress;
    }
}
