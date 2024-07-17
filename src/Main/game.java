/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Main;

import javax.swing.JFrame;

/**
 *
 * @author hriverav
 */
public class game extends Thread{
    JFrame mainFrame;

    public game(JFrame mainFrame) {
        this.mainFrame = mainFrame;
    }
    
    
    
    @Override
    public void run() {
       while(true){
           
            try {
                Thread.sleep(1000);
            } catch (Exception x) {
                x.printStackTrace();
            }
       }
    }
}
