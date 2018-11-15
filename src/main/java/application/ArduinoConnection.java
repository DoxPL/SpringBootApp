package application;

import gnu.io.NRSerialPort;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;

@Component
public class ArduinoConnection {
    private NRSerialPort serial;
    @Value("${conn.port}")
    private String connectionPort;
    @Value("${conn.bauds}")
    private int connectionBauds;
    @Value("${request.char}")
    private char reqChar;

    @PostConstruct
    public void connect()
    {
        serial = new NRSerialPort(connectionPort, connectionBauds);
        serial.connect();

        if(serial.isConnected())
        {
            System.out.println("Connected to Arduino");
        }
    }

    @PreDestroy
    public void disconnect()
    {
        if(serial != null && serial.isConnected())
        {
            serial.disconnect();

            if(!serial.isConnected())
                System.out.println("Connection closed");
        }
    }

    public int getLineInteger() throws IOException {
        DataInputStream inputStream = new DataInputStream(serial.getInputStream());
        DataOutputStream outputStream = new DataOutputStream(serial.getOutputStream());
        outputStream.write(reqChar);
        return inputStream.read();
    }

    public String getAvailablePorts()
    {
        String message = "";
        for(String port : NRSerialPort.getAvailableSerialPorts())
        {
            message += port + "\n";
        }
        return message;
    }
}
