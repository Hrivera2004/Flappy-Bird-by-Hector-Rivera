/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Main;

import java.awt.Color;
import javax.swing.JFrame;
import javax.swing.JPanel;

/**
 *
 * @author hriverav
 */
public class character implements Runnable{
    JPanel flappy = new JPanel();
    int posY = 250;
    boolean alive = true;
    
    public character(JFrame frame) {
        flappy.setSize(10, 10);
        frame.add(flappy);
        flappy.setLocation(200,posY);
        flappy.setBackground(Color.red);
        
    }
    public void hop(){
        if (posY-40>=0) {
            posY-=100;
            flappy.setLocation(200,posY); 
        } 
    }
    @Override
    public void run() {
            while(alive){
                if (posY<490) {
                    posY+=10;
                    flappy.setLocation(200,posY); 
                }else{
                    posY = 490;
                    flappy.setLocation(200,posY); 
                }
                
                try{
                    Thread.sleep(50);
                }catch(Exception x){
                    x.printStackTrace();
                }
            }
    }
    
    
}
