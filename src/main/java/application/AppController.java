package application;

import gnu.io.CommPortIdentifier;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import javax.servlet.http.HttpServletRequest;
import java.io.IOException;

@RestController
public class AppController {

    private ArduinoConnection arduinoConnection;

    @Autowired
    public AppController(ArduinoConnection arduinoConnection)
    {
        this.arduinoConnection = arduinoConnection;
    }

    @RequestMapping("/")
    @ResponseBody
    public String mainPage()
    {
        return "Main page";
    }

    @RequestMapping("/get/{num}")
    @ResponseBody //for test
    public String getNumber(@PathVariable("num") Long number)
    {
        return "Entered numer: " + number;
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

    @RequestMapping("/get/value")
    @ResponseBody
    public String getValue() throws IOException {
        return "Value: " + arduinoConnection.getLineInteger();
    }

    @RequestMapping("/get/ports")
    @ResponseBody
    public String getPorts()
    {
        return arduinoConnection.getAvailablePorts();
    }
}
