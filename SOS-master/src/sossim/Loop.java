
package sossim;

import static sossim.Library.*;


import static sossim.Catch.*;

/**
 * loop with 14ms delay
 * @author Walker
 */

public class Loop {

    static SOSSim sos = new SOSSim();
    static Library lib = new Library();
    
    
    public static void loop() throws InterruptedException {
        //print("term: loop active");
        while (true) {
            Thread.sleep(14);
            //--gravity--
            if (inAir) {y -= a;a-=g;inAir = true;}
            
            //-------------------------------------------------------------
            //--changing pos according to movement booleans + removing down key--
            if (mUp) {y -= vVel;}
            if (mDo) {inAir = true;}
            if (mLe) {x -= hVel;}
            if (mRi) {x += hVel;}
            
            //-------------------------------------------------------------
            //--denial for offscreen movement--
            if (x < 0) {x = sideR - 6;}
            if (x > sideR) {x = 0;}
            if (rx < 0) {rx = sideR - 6;}
            if (rx > sideR) {rx = 0;}
            
            //-------------------------------------------------------------
            //--character collision denial[GLITCHED]--
            //--ryoko pushes player only from left--
            
//            if (HaruhiR() >= RyokoL() && HaruhiR() < RyokoR() && inAir == false) { //hr - rl
//                x = (RyokoL() - 35);
//            }
//            if (HaruhiL() <= RyokoR() && HaruhiL() > RyokoL() && inAir == false) { //hl - rr
//                x = (RyokoR());
//            }

            if (RyokoR() >= HaruhiL() && RyokoR() < HaruhiR() && inAir == false) { //rr - hl
                rx = (HaruhiL() - 28);
                //x = (RyokoL() - 35);
                touching = true;
            } else {
                touching = false;
            }
            if (RyokoL() <= HaruhiR() && RyokoL() > HaruhiL() && inAir == false) { //rl - hr
                rx = HaruhiR();
                //x = RyokoR();
                touching = true;
            } else {
                touching = false;
            }
            
            //-------------------------------------------------------------
            //--contact--
            for (int i = 0; i < panel.length; i++) {
                //--panel x--
                if (HaruhiL() < PanelR(i) && HaruhiL() > PanelL(i) || HaruhiR() > PanelL(i) && HaruhiR() < PanelR(i)) {
                    panelcontactx = true;
                } else {
                    panelcontactx = false;
                }
                //--panel y--
                if (HaruhiB() > (PanelT(i) - 1) && HaruhiB() < PanelB(i)) {
                    panelcontacty = true;
                } else {
                    panelcontacty = false;
                }
                //--panel contact--
                if (panelcontactx && panelcontacty) {
                    y = PanelT(i) - 91;
                    inAir = false;
                    entitycontact = true;
                } else {
                    entitycontact = false;
                }
            }
            //--floor contact--
            if(y > (floor - 1)) {
                floorcontact = true;
            } else {
                floorcontact = false;
            }
            
            //--contact responses--
            if (floorcontact || entitycontact){
                inAir = false;
            } else {
                inAir = true;
            }
            
            if (floorcontact) {y = floor;}
            //else if (entitycontact) {y = PanelT(0) - 91;}
            
            //--AI movement--
            if (touching == false) {
                if (getDist() > (sideR / 2)) {
                    if (rx < x) {
                        rx -= 1;
                        setChar(2,ryokoLeft);
                    }
                    else if (rx > x) {
                        rx += 1;
                        setChar(2,ryokoRight);
                    }
                }
                else if (rx < x) {
                    rx += 1;
                    setChar(2,ryokoRight);
                }
                else if (rx > x) {
                    rx -= 1;
                    setChar(2,ryokoLeft);
                }
                
            }
            
        }
        
    }
    
}
