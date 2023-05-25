package javafinalproject;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import javax.swing.JTextField.*;

public class showResult extends JFrame{
    private JPanel resultPanel;
    private JLabel resultLabel1;
    private JLabel resultLabel2;
    private JLabel resultLabel3;
    private JLabel resultLabel4;
    private JTextField textField1=new JTextField();
    private JTextField textField2=new JTextField();
    private JTextField textField3=new JTextField();
    private JTextField textField4=new JTextField();
    private JLabel winnerLabel;

    public showResult(String nameA, String nameB, int numA,int numB, int winnerParameter,voteCounter counter){
        super("投票結果");
        setLayout(new GridLayout(3,1));
        //show result
        resultPanel=new JPanel();
        resultPanel.setLayout(new GridLayout(2,2));
        resultLabel1=new JLabel(nameA+":");
        resultLabel2=new JLabel(nameB+":");
        textField1.setText(String.valueOf(numA));
        textField2.setText(String.valueOf(numB));
        textField1.setEditable(false);
        textField2.setEditable(false);
        resultPanel.add(resultLabel1);
        resultPanel.add(resultLabel2);
        resultPanel.add(textField1);
        resultPanel.add(textField2);
        if(winnerParameter==0){
            winnerLabel=new JLabel("得票最高的是: "+nameA+nameB);
            winnerLabel.setFont(new Font("TimesRoman",Font.BOLD,18));
        }
        else if(winnerParameter==1){
            winnerLabel=new JLabel("得票最高的是: "+nameA);
            winnerLabel.setFont(new Font("TimesRoman",Font.BOLD,18));
        }
        else if(winnerParameter==2){
            winnerLabel=new JLabel("得票最高的是: "+nameB);
            winnerLabel.setFont(new Font("TimesRoman",Font.BOLD,18));
        }
        add(resultPanel);
        add(winnerLabel);
    }
    public showResult(String nameA, String nameB, String nameC, int numA,int numB, int numC, int winnerParameter,voteCounter counter){
        super("投票結果");
        setLayout(new GridLayout(3,1));
        //show result
        resultPanel=new JPanel();
        resultPanel.setLayout(new GridLayout(2,2));
        resultLabel1=new JLabel(nameA+":");
        resultLabel2=new JLabel(nameB+":");
        resultLabel3=new JLabel(nameC+":");
        textField1.setText(String.valueOf(numA));
        textField2.setText(String.valueOf(numB));
        textField3.setText(String.valueOf(numC));
        textField1.setEditable(false);
        textField2.setEditable(false);
        textField3.setEditable(false);
        resultPanel.add(resultLabel1);
        resultPanel.add(resultLabel2);
        resultPanel.add(resultLabel3);
        resultPanel.add(textField1);
        resultPanel.add(textField2);
        resultPanel.add(textField3);

        if(winnerParameter==0){
            int []winners=counter.getWinners();
            String []names={nameA,nameB,nameC};
            String finalString="";
            for(int i=0;i<4;i++){
                if(winners[i]==1){
                    if(finalString==""){
                        finalString+=names[i];
                    }
                    else{
                        finalString=finalString+" 與 "+names[i];
                    }
                }
            }
            winnerLabel=new JLabel("得票最高的是: "+finalString);
            winnerLabel.setFont(new Font("TimesRoman",Font.BOLD,18));
        }
        else if(winnerParameter==1){
            winnerLabel=new JLabel("得票最高的是: "+nameA);
            winnerLabel.setFont(new Font("TimesRoman",Font.BOLD,18));
        }
        else if(winnerParameter==2){
            winnerLabel=new JLabel("得票最高的是: "+nameB);
            winnerLabel.setFont(new Font("TimesRoman",Font.BOLD,18));
        }
        else if(winnerParameter==3){
            winnerLabel=new JLabel("得票最高的是: "+nameC);
            winnerLabel.setFont(new Font("TimesRoman",Font.BOLD,18));
        }
        add(resultPanel);
        add(winnerLabel);
    }
    public showResult(String nameA, String nameB, String nameC, String nameD, int numA,int numB, int numC, int numD, int winnerParameter,voteCounter counter){
        super("投票結果");
        setLayout(new GridLayout(3,1));
        //show result
        resultPanel=new JPanel();
        resultPanel.setLayout(new GridLayout(2,2));
        resultLabel1=new JLabel(nameA+":");
        resultLabel2=new JLabel(nameB+":");
        resultLabel3=new JLabel(nameC+":");
        resultLabel4=new JLabel(nameD+":");
        textField1.setText(String.valueOf(numA));
        textField2.setText(String.valueOf(numB));
        textField3.setText(String.valueOf(numC));
        textField4.setText(String.valueOf(numD));
        textField1.setEditable(false);
        textField2.setEditable(false);
        textField3.setEditable(false);
        textField4.setEditable(false);
        resultPanel.add(resultLabel1);
        resultPanel.add(resultLabel2);
        resultPanel.add(resultLabel3);
        resultPanel.add(resultLabel4);
        resultPanel.add(textField1);
        resultPanel.add(textField2);
        resultPanel.add(textField3);
        resultPanel.add(textField4);
        if(winnerParameter==0){
            int []winners=counter.getWinners();
            String []names={nameA,nameB,nameC,nameD};
            String finalString="";
            for(int i=0;i<4;i++){
                if(winners[i]==1){
                    if(finalString==""){
                        finalString+=names[i];
                    }
                    else{
                        finalString=finalString+" 與 "+names[i];
                    }
                }
            }
            winnerLabel=new JLabel("得票最高的是: "+finalString);
            winnerLabel.setFont(new Font("TimesRoman",Font.BOLD,18));
        }
        else if(winnerParameter==1){
            winnerLabel=new JLabel("得票最高的是: "+nameA);
            winnerLabel.setFont(new Font("TimesRoman",Font.BOLD,18));
        }
        else if(winnerParameter==2){
            winnerLabel=new JLabel("得票最高的是: "+nameB);
            winnerLabel.setFont(new Font("TimesRoman",Font.BOLD,18));
        }
        else if(winnerParameter==3){
            winnerLabel=new JLabel("得票最高的是: "+nameC);
            winnerLabel.setFont(new Font("TimesRoman",Font.BOLD,18));
        }
        else if(winnerParameter==4){
            winnerLabel=new JLabel("得票最高的是: "+nameD);
            winnerLabel.setFont(new Font("TimesRoman",Font.BOLD,18));
        }
        add(resultPanel);
        add(winnerLabel);
        
    }
}