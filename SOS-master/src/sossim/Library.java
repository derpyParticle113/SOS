
package sossim;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.imageio.ImageIO;


/**
 * storage of all collective variables
 * @author derpy
 */
public class Library {
    static Scanner read = new Scanner(System.in);
    
    //--sprite image placers--
    static BufferedImage sprite,enemy,bg;
    
    static String
            //--console input holder--
            input,
            //--active sprite directories--
            activeEnemy, activeBg,
            //--main image directories--
            grassyBg = (".\\resources\\backgrounds\\grassyBG.jpg"),
            overgrownBg = (".\\resources\\backgrounds\\overgrownBG.png"),
            templeBg = (".\\resources\\backgrounds\\templeBG.png"),
            forestBg = (".\\resources\\backgrounds\\forestBG.png"),
            haruhiLeft = (".\\resources\\chars\\lHaruhi.gif"),
            haruhiRight = (".\\resources\\chars\\rHaruhi.gif"),
            ryokoLeft = (".\\resources\\chars\\lRyoko.gif"),
            ryokoRight = (".\\resources\\chars\\rRyoko.gif"),
            //--extra image directories--
            kyon = (".\\resources\\chars\\Kyon.gif"),
            yuki = (".\\resources\\chars\\Yuki.gif"),
            mikuru = (".\\resources\\chars\\Mikuru.gif"),
            koizumi = (".\\resources\\chars\\Koizumi.gif"),
            tsuruya = (".\\resources\\chars\\Tsuruya.gif"),
            strawberry = (".\\resources\\chars\\strawberry.gif");
    
    static boolean
        //--char is not on surface--
        inAir = false,
        //--defualt debug aspects on game frame--
        debug = false,
        //--movement holders--
        mUp,mDo,mLe,mRi,
        //--entity contact--
        floorcontact, touching, panelcontactx = false, panelcontacty = false, entitycontact = false,
        //--confirming rendering of panels--
        render = true;
    
    //--functional integers--
    static int
            //--pos of char--
            x = 250,y = 600,
            //--x pos of ryoko (y not needed yet)--
            rx = 350,
            //--acceleration--
            a,
            //--gravity intensity--
            g = 1,
            //--horizontal movement intensity--
            hVel = 4,
            //--vertical movement intensity--
            vVel = 3,
            //--screen dim--
            floor = 600, sideR = 1110;
            
    //--matrix for panels--
    static int[][] panel = new int[4][50];
    //--adding to matrix--
    public void matrix() { //--xpos, ypos, xsize, ysize --
        panel[0][0] = 70;panel[0][1] = 625;panel[0][2] = 100;panel[0][3] = 12;
        panel[1][0] = 400;panel[1][1] = 645;panel[1][2] = 100;panel[1][3] = 12;
        panel[2][0] = 805;panel[2][1] = 620;panel[2][2] = 100;panel[2][3] = 12;
        panel[3][0] = 230;panel[3][1] = 650;panel[3][2] = 100;panel[3][3] = 12;
    }
    
    //setting images
    static void setChar(int i, String c) {
        if (i == 1) {
            try {
                sprite = ImageIO.read(new File(c));
            } catch (IOException ex) {
                Logger.getLogger(GameListener.class.getName()).log(Level.SEVERE, null, ex);
            }
        } else if (i == 2) {
            try {
                enemy = ImageIO.read(new File(c));
            } catch (IOException ex) {
                Logger.getLogger(GameListener.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        
        
    }
    static void setBg() {
        print("setBg");
        try {
            bg = ImageIO.read(new File(activeBg));
        } catch (IOException ex) {
            Logger.getLogger(GameListener.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    //--console shortcuts--
    static void catchIn(String s) {System.out.print(s);input = read.nextLine();}
    static void print(Object o) {System.out.println(o);}
    static void clear(Object o) {System.out.print("\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n");}
}
