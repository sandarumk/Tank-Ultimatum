/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package gametanks;

import java.io.IOException;
import java.net.UnknownHostException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Dinu
 */
// make a connection thread 
public class ConnectionThread extends Thread {

    private MainFrame mainframe;

    public ConnectionThread(MainFrame frame) {
        mainframe = frame;
    }

    @Override
    public void run() {
        try {
            Connection cnt = new Connection(mainframe);
            cnt.joingame();
            System.out.println("connection Thread Started");
        } catch (UnknownHostException ex) {
            Logger.getLogger(ConnectionThread.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(ConnectionThread.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
