
package sossim;

import static sossim.Library.*;

import java.awt.Graphics;
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;
import javax.swing.JComponent;
import javax.swing.JFrame;

import static sossim.Loop.*;
import static sossim.Catch.*;


/**
 * main; rendering and frame specifications
 * @author Walker
 */

public class SOSSim {
    //frame titles
    public static JFrame frame = new JFrame("SOS Brigade Simulator");
    public static JFrame menu = new JFrame("Menu");
    
    

    
    public static void main(String[] args) throws IOException, InterruptedException {
        //--setting matrix vars--
        lib.matrix();
        
        //--setting sprite images--
        sprite = ImageIO.read(new File(haruhiRight));
        enemy = ImageIO.read(new File(ryokoLeft));
        
        //--catching bg img file
        bg = ImageIO.read(new File(grassyBg));

        //--drawing images--
        JComponent draw = new JComponent() {
            @Override
            public void paintComponent(Graphics g) {
                g.drawImage(bg, 0, 0, this);
                //--dimentions: 35x91px--
                g.drawImage(sprite, x, y, this);
                g.drawImage(enemy, rx, floor, this);
                
                //--forloop rendering panels--
                for (int i = 0; i < panel.length; i++) {
                    g.fillRect(getMatrixAspect(i,0),getMatrixAspect(i,1),getMatrixAspect(i,2),getMatrixAspect(i,3));
                }
                
                //--printing booleans[DEBUG]--
                if (debug) {
                    g.drawString("mUp: " + String.valueOf(mUp), 20, 20);
                    g.drawString("inAir: " + String.valueOf(inAir),20,30);
                    g.drawString("x: " + x, 55, 40);
                    g.drawString("y: " + y, 20, 40);
                    g.drawString("floor: " + String.valueOf(floorcontact), 20, 60);
                    g.drawString("f: " + floor, 20, 70);
                    g.drawString("C: " + String.valueOf(entitycontact), 20, 90); 
                    g.drawString("X: " + String.valueOf(panelcontactx), 20, 100);
                    g.drawString("Y: " + String.valueOf(panelcontacty), 20, 110);
                }
                repaint();
            }
        };

        //--creating frames--
        frame.setSize(1152,864);
        frame.addKeyListener(new GameListener());
        frame.add(draw);
        frame.setLocationRelativeTo(null);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);
        
        
        menu.setSize(310,240);
        menu.add(new FrameAspects());
        menu.setLocationRelativeTo(null);
        menu.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        menu.setVisible(false);
        
        //--debug function--
        //debug();
        
        //--initiating loop--
        //--note: nothing can be run after this statement--
        Loop.loop();

    }
    
    //--debug--
    static void debug() {
        printMatrix();
        //print(panel.length);
    }
    
}