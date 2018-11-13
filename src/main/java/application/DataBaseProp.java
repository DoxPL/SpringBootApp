package application;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@ConfigurationProperties(prefix = "db")
public class DataBaseProp {
    private String host;
    private String username;
    private String password;
    private int port;

    public String getHost() {
        return host;
    }

    public void setHost(String host) {
        this.host = host;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public int getPort() {
        return port;
    }

    public void setPort(int port) {
        this.port = port;
    }

    @RequestMapping("/getConnectionInfo")
    public String displayConnectionInfo()
    {
        return "Host: " + this.host + System.lineSeparator() +
                "Username: " + this.username + System.lineSeparator() +
                "Password: " + this.password + System.lineSeparator() +
                "Port: " + this.port;
    }
}
