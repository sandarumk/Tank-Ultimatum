
package gametanks;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.net.UnknownHostException;
import java.util.Timer;
import java.util.TimerTask;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Connection {

    private BufferedWriter write;
    private BufferedReader read;
    private ServerSocket clientserversoc;

    public void joingame() throws UnknownHostException, IOException {
        Socket serversoc = new Socket("127.0.0.1", 6000);
        Timer timer = new Timer();

        write = new BufferedWriter(new OutputStreamWriter(serversoc.getOutputStream()));
        write.write("JOIN#");
        write.close();

        clientserversoc = new ServerSocket(7000);

        timer.scheduleAtFixedRate(new TimerTask() {

            @Override
            public void run() {
                try {
                    Socket clientsoc = clientserversoc.accept();
                    read = new BufferedReader(new InputStreamReader(clientsoc.getInputStream()));
                    String s = read.readLine();

                    System.out.println(s);
                    read.close();;

                } catch (IOException ex) {
                    Logger.getLogger(Connection.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }, 0, 100);




    }
}
