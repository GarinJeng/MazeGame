import java.util.Random;
import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
import java.awt.geom.Line2D;
import java.net.URL;
import java.util.ArrayList;
class Main {
  public static void main(String[] args) {
    int[][] P1Feild = {{0,9,9,9,9,9,9,9,9,9,9,9,9,9,9,9,9,9,9,9,9,0},{0,9,9,9,9,9,9,9,9,9,9,9,9,9,9,9,9,9,9,9,9,0},{0,9,9,9,9,9,9,9,9,9,9,9,9,9,9,9,9,9,9,9,9,0},{0,9,9,9,9,9,9,9,9,9,9,9,9,9,9,9,9,9,9,9,9,0},{0,9,9,9,9,9,9,9,9,9,9,9,9,9,9,9,9,9,9,9,9,0},{0,9,9,9,9,9,9,9,9,9,9,9,9,9,9,9,9,9,9,9,9,0},{0,9,9,9,9,9,9,9,9,9,9,9,9,9,9,9,9,9,9,9,9,0},{0,9,9,9,9,9,9,9,9,9,9,9,9,9,9,9,9,9,9,9,9,0},{0,9,9,9,9,9,9,9,9,9,9,9,9,9,9,9,9,9,9,9,9,0},{0,9,9,9,9,9,9,9,9,9,9,9,9,9,9,9,9,9,9,9,9,0}};
     int[][] P2Feild = {{0,9,9,9,9,9,9,9,9,9,9,9,9,9,9,9,9,9,9,9,9,0},{0,9,9,9,9,9,9,9,9,9,9,9,9,9,9,9,9,9,9,9,9,0},{0,9,9,9,9,9,9,9,9,9,9,9,9,9,9,9,9,9,9,9,9,0},{0,9,9,9,9,9,9,9,9,9,9,9,9,9,9,9,9,9,9,9,9,0},{0,9,9,9,9,9,9,9,9,9,9,9,9,9,9,9,9,9,9,9,9,0},{0,9,9,9,9,9,9,9,9,9,9,9,9,9,9,9,9,9,9,9,9,0},{0,9,9,9,9,9,9,9,9,9,9,9,9,9,9,9,9,9,9,9,9,0},{0,9,9,9,9,9,9,9,9,9,9,9,9,9,9,9,9,9,9,9,9,0},{0,9,9,9,9,9,9,9,9,9,9,9,9,9,9,9,9,9,9,9,9,0},{0,9,9,9,9,9,9,9,9,9,9,9,9,9,9,9,9,9,9,9,9,0}};
    //int[][] P1Feild = Feild.clone();
    //int[][] P2Feild = Feild.clone();

    //comment out here
   ///*
    Game g = new Game(P1Feild, P2Feild, -1, false);
    CreatePath p = new CreatePath();
    CreatePath p1 = new CreatePath();
    P1Feild = p.createPath(P1Feild);
    P2Feild = p1.createPath(P2Feild);
    Bnum b = new Bnum();
    P1Feild = b.bnum(P1Feild);
    P2Feild = b.bnum(P2Feild);
    printfeild(P1Feild, P2Feild);
    g.start();
    //*/
    //to here to test and uncoment below
    /*
    tester t = new tester();
    t.test();
    */

  }

  public static void printfeild(int[][] p1, int[][] p2){
    for(int i = 0; i< 10; i++){
      for(int j = 0; j < 22; j++){
        System.out.print(p1[i][j]);
      }
      System.out.println();
    }
     System.out.println("----------------------");
    for(int i = 0; i< 10; i++){
      for(int j = 0; j < 22; j++){
          System.out.print(p2[i][j]);
      }
      System.out.println();
    }
  }
}