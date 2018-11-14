package application;

import gnu.io.NRSerialPort;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;

@Component
public class ArduinoConnection {
    private NRSerialPort serial;

    @PostConstruct
    public void connect()
    {
        serial = new NRSerialPort("COM3", 9600);
        serial.connect();

        if(serial.isConnected())
        {
            System.out.println("Connected to Arduino");
        }
    }

    @PreDestroy
    public void disconnect()
    {
        if(serial.isConnected() && serial != null)
        {
            serial.disconnect();

            if(!serial.isConnected())
                System.out.println("Connection closed");
        }
    }

    public int getLineInteger() throws IOException {
        DataInputStream inputStream = new DataInputStream(serial.getInputStream());
        DataOutputStream outputStream = new DataOutputStream(serial.getOutputStream());
        outputStream.write('g');
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
