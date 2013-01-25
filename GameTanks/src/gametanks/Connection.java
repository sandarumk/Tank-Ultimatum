/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package gametanks;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.net.UnknownHostException;


public class Connection {
    private BufferedWriter write;
    private BufferedReader read;

    public void joingame() throws UnknownHostException, IOException{
Socket serversoc = new Socket("127.0.0.1", 6000);

write = new BufferedWriter(new OutputStreamWriter(serversoc.getOutputStream()));
write.write("JOIN#");
write.close();


ServerSocket clientserversoc = new ServerSocket(7000);
Socket clientsoc = clientserversoc.accept();
read = new BufferedReader(new InputStreamReader(clientsoc.getInputStream()));
System.out.println(read.readLine()); 
// send msgs according to the line we get. 
read.close();
}
}
