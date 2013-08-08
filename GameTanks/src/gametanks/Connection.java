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
    private MainFrame mainFrame;

    public Connection(MainFrame frame) {
        mainFrame = frame;
    }

    public void joingame() throws UnknownHostException, IOException {
        Socket serversoc = new Socket("127.0.0.1", 6000);
        clientserversoc = new ServerSocket(7000);

//      initialize response handler
        ResponseHandler.init();
//      initialize Datastore
        DataStore.init();

        Timer timer = new Timer();

        write = new BufferedWriter(new OutputStreamWriter(serversoc.getOutputStream()));
        write.write("JOIN#");
        write.close();


        timer.scheduleAtFixedRate(new TimerTask() {
            @Override
            public void run() {
                try {
                    
                    Socket clientsoc = clientserversoc.accept();
                    read = new BufferedReader(new InputStreamReader(clientsoc.getInputStream()));
                    String s = read.readLine();
                    System.out.println(s);
//                  send the response from the server and update the game grid
                    ResponseHandler.handle(s);
                    DataStore.updateGrid();

//                  load the GUI if the game is started
                    if (DataStore.isStarted) {
                        mainFrame.loadImage(mainFrame.map);
                    }

                    if(!DataStore.isFinished){
//                  send the client response to the server
                    updateGame();
                    }

                    read.close();

                } catch (IOException ex) {
                    Logger.getLogger(Connection.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }, 0, 1000);




    }

    public void updateGame() throws UnknownHostException, IOException {

        Socket serversoc2;
        serversoc2 = new Socket("127.0.0.1", 6000);

        if (DataStore.isStarted && !DataStore.isFinished) {
            write = new BufferedWriter(new OutputStreamWriter(serversoc2.getOutputStream()));

            if (!DataStore.updateQue.isEmpty() && DataStore.updateQue != null) {
//          if the queue is not empty send the next command to the server
                String command = DataStore.updateQue.remove();
                System.out.println(DataStore.myLocation);
                System.out.println("Queue=" + command);
                write.write(command);

            } else if (DataStore.updateQue.isEmpty()) {
//             if the queue is empty take a new descion
                if (DataStore.isStarted) {
                    DataStore.d1.takeDescision();
                }
            }
        }
        write.close();

    }
}
