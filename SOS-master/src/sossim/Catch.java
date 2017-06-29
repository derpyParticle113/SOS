
package sossim;

import static sossim.Library.*;

import static java.lang.Math.abs;

/**
 * shortcuts for variable requests
 * @author walker
 */
public class Catch {
    
    //--variables and equations shortened to names--
    static int getMatrixAspect(int x, int y) {
        return panel[x][y];
    }//shortcut panel:matrixasp
    static int PanelR(int x) {
        return (getMatrixAspect(x,0) + getMatrixAspect(x,2));
    }
    static int PanelL(int x) {
        return getMatrixAspect(x,0);
    }
    static int PanelT(int x) {
        return getMatrixAspect(x,1);
    }
    static int PanelB(int x) {
        return (getMatrixAspect(x,1) + getMatrixAspect(x,3));
    }
    static void printMatrix() {
        for (int i=0;i<panel.length;i++) {
            System.out.format("%d,%d,%d,%d\n",getMatrixAspect(i,0),getMatrixAspect(i,1),getMatrixAspect(i,2),getMatrixAspect(i,3));
        }
    }
    static int getDist() {
        return abs(x - rx);
    }
    static int HaruhiR() {
        return (x + 35);
    }
    static int HaruhiL() {
        return x;
    }
    static int HaruhiT() {
        return y;
    }
    static int HaruhiB() {
        return (y + 91);
    }
    static int RyokoR() {
        return (rx + 29);
    }
    static int RyokoL() {
        return rx;
    }
    static int RyokoT() {
        return (floor - 91);
    }
    static int RyokoB() {
        return floor;
    }
    
}
