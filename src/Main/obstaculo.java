/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Main;
import java.util.Random;
import java.awt.Color;
import java.util.Locale;
import javax.swing.JFrame;
import javax.swing.JPanel;

/**
 *
 * @author hriverav
 */
public class obstaculo implements Runnable{
    int[] size = {100,150,200,250};
    JPanel top = new JPanel();
    JPanel bottom = new JPanel();
    Random rand = new Random();
    int x = 400;
    
    public obstaculo(JFrame frame) {
        top.setBounds(x, 0, 100, size[rand.nextInt(4)]);
        top.setBackground(Color.green);
        int y = top.getHeight()+rand.nextInt(201)+100;
        bottom.setBounds(x, y,100,500-y);
        bottom.setBackground(Color.green);
        frame.add(top);
        frame.add(bottom);
    }
    @Override
    public void run() {
        while (x>0) {
                x-=10;   
                top.setLocation(x, 0);
                bottom.setLocation(x, bottom.getY());
            try {
                Thread.sleep(300);
            } catch (Exception x) {
                x.printStackTrace();
            }
        }
    }
}
