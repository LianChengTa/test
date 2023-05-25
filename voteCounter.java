package javafinalproject;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;


public class voteCounter{
    private int n;
    private int numberOfA;
    private int numberOfB;
    private int numberOfC;
    private int numberOfD;
    public voteCounter(int n){
        this.n=n;
        this.numberOfA=0;
        this.numberOfB=0;
        this.numberOfC=0;
        this.numberOfD=0;
    }
    public boolean add(int parameter){
        
        if(parameter==1){
            numberOfA++;
        }
        else if(parameter==2){
            numberOfB++;
        }
        else if(parameter==3){
            numberOfC++;
        }
        else if(parameter==4){
            numberOfD++;
        }
        if(n==getSum()){
            JOptionPane.showMessageDialog(new JFrame(),"所有人已完成投票，投票結束！！","投票結束",JOptionPane.WARNING_MESSAGE);
            return true;    
        }
        return false;
    }
    public int getA(){
        return numberOfA;
    }
    public int getB(){
        return numberOfB;
    }
    public int getC(){
        return numberOfC;
    }
    public int getD(){
        return numberOfD;
    }
    public int getSum(){
        return numberOfA+numberOfB+numberOfC+numberOfD;
    }
    public int getWinnerNum(){
        int a[]={numberOfA,numberOfB,numberOfC,numberOfD};
        int maxValue=0;
        int repeatCounter=0;
        for(int i=0;i<a.length;i++){
            maxValue=Math.max(maxValue,a[i]);
        }
        for(int i=0;i<4;i++){
            if(maxValue==a[i]){
                repeatCounter++;
            }
        }
        if(repeatCounter==1){
            for(int i=0;i<4;i++){
                if(maxValue==a[i]){
                    return i;
                }
            }
        }
        if(repeatCounter>1){
            return -1;
        }
        return 0;
    }

    public int[] getWinners(){
        int a[]={numberOfA,numberOfB,numberOfC,numberOfD};
        int[] winners=new int[4];
        int maxValue=0;
        for(int i=0;i<a.length;i++){
            maxValue=Math.max(maxValue,a[i]);
        }
        for(int i=0;i<4;i++){
            if(maxValue==a[i]){
                winners[i]++;
            }
        }
        return winners;
    }
}