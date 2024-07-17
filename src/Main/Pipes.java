/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Main;

import java.util.Random;
import java.awt.Color;
import java.util.Locale;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

/**
 *
 * @author hriverav
 */
public class Pipes implements Runnable {

    int[] size = {100, 150, 200, 250};
    JPanel top = new JPanel();
    JPanel bottom = new JPanel();
    Random rand = new Random();
    int x = 400;

    public Pipes(JFrame frame) {
        top.setBounds(x-100, -300, 100, size[rand.nextInt(4)]+300);
        top.setBackground(Color.green);
        int y = (top.getHeight()-300) + rand.nextInt(201) + 150;
        bottom.setBounds(x-100, y, 100, 500 - y+300);
        bottom.setBackground(Color.green);
        add(frame);
    }

    public int[] getSize() {
        return size;
    }

    public void setSize(int[] size) {
        this.size = size;
    }

    public JPanel getTop() {
        return top;
    }

    public void setTop(JPanel top) {
        this.top = top;
    }

    public JPanel getBottom() {
        return bottom;
    }

    public void setBottom(JPanel bottom) {
        this.bottom = bottom;
    }

    public void add(JFrame frame) {
        frame.add(top);
        frame.add(bottom);
    }

    public void move_x() {
        x -= 5;
        top.setLocation(x,top.getY());
        bottom.setLocation(x, bottom.getY());
    }

    public void move_y(int movement) {
        top.setLocation(top.getX(), top.getY()+movement);
        bottom.setLocation(bottom.getX(), bottom.getY()+movement);
    }

    @Override
    public void run() {
        boolean existing = true;
        int contador = 0;
        int movement = (rand.nextInt(2)+1 == 1 ? -1:1);
        System.out.println(movement);
        while (existing) {
            if (top.getX() + 100 != 0) {
                move_y(movement*5);
                move_x();
            } else {
                existing = false;
            }
            try {
                Thread.sleep(50);
                if (contador == 2000) {
                    movement*=-1;
                    contador = 0;
                }
                contador+=50;
            } catch (Exception e) {
                e.printStackTrace();
                System.out.println("Error-pipes");
            }
        }
        top.setVisible(false);
        bottom.setVisible(false);
    }

}
