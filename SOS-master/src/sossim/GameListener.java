
package sossim;

import static sossim.Library.*;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import static sossim.Catch.*;

/**
 * key listener and movement
 * @author Walker
 */
public class GameListener implements KeyListener {

    SOSSim sos = new SOSSim();
    Library lib = new Library();
        
    @Override
    public void keyTyped(KeyEvent e) {
    }

    //--key response--
    @Override
    public void keyPressed(KeyEvent e) {
        int key = e.getKeyCode();
        if (key == KeyEvent.VK_W && inAir == false || key == KeyEvent.VK_SPACE && inAir == false) {
            mUp = true; //--setting movement boolean--
            a = 10; //--setting velocity for gravity--
        }
        if (key == KeyEvent.VK_S) {mDo = true;}
        //--changes sprite according to walking direction--
        if (key == KeyEvent.VK_A) {mLe = true;setChar(1,haruhiLeft);}
        if (key == KeyEvent.VK_D) {mRi = true;setChar(1,haruhiRight);}
        //--quit key--
        if (key == KeyEvent.VK_END) {System.exit(0);}
        //--character selection keys (1-7) [WIP]--
        if (key == KeyEvent.VK_1) {setChar(1,haruhiLeft);}
        if (key == KeyEvent.VK_2) {setChar(1,kyon);}
        if (key == KeyEvent.VK_3) {setChar(1,yuki);}
        if (key == KeyEvent.VK_4) {setChar(1,mikuru);}
        if (key == KeyEvent.VK_5) {setChar(1,koizumi);}
        if (key == KeyEvent.VK_6) {setChar(1,ryokoLeft);}
        if (key == KeyEvent.VK_7) {setChar(1,tsuruya);}
        if (key == KeyEvent.VK_ESCAPE) {
            sos.menu.setVisible(true);
            //frameadapt();
        }
        //--easter egg character--
        if (key == KeyEvent.VK_NUM_LOCK) {
            sos.frame.setTitle("STRAWBERRIES");
            setChar(1,strawberry);
        }
        //--debug--
        if (key == KeyEvent.VK_NUMPAD4) {print(HaruhiL());print(PanelL(0));}
        if (key == KeyEvent.VK_NUMPAD6) {print(HaruhiR());print(PanelR(0));}
        if (key == KeyEvent.VK_NUMPAD8) {print(HaruhiT());print(PanelT(0));}
        if (key == KeyEvent.VK_NUMPAD2) {print(HaruhiB());print(PanelB(0));}
    }

    void frameadapt() {
        sos.frame.removeKeyListener(this);
        //sos.menu.addKeyListener(new MenuListener());
    }
    
    @Override
    public void keyReleased(KeyEvent e) {
        
        int key = e.getKeyCode();
        //--changing movement booleans--
        if (key == KeyEvent.VK_W || key == KeyEvent.VK_SPACE) {mUp = false;}
        if (key == KeyEvent.VK_S) {mDo = false;}
        if (key == KeyEvent.VK_A) {mLe = false;}
        if (key == KeyEvent.VK_D) {mRi = false;}
    }
    
}
