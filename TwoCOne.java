package javafinalproject;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;


public class TwoCOne extends JFrame{
    private JLabel labelA;
    private JLabel labelB;
    private JLabel cntLabel;
    private JPanel sideA;
    private JPanel sideB;
    private JPanel cntPanel;
    private JTextField cntField;
    private JTextField A;
    private JTextField B;
    private JButton confirmButton;
    private JRadioButton firstChoice;
    private JRadioButton secondChoice;
    private int participant=0;
    public TwoCOne(){
        super("投票内容設定");
        MyEventListener listener=new MyEventListener();
        setLayout(new GridLayout(4,1));
        sideA=new JPanel();
        sideB=new JPanel();
        labelA=new JLabel("選擇一:");
        labelB=new JLabel("選擇二:");
        sideA.setLayout(new FlowLayout());
        sideB.setLayout(new FlowLayout());
        A=new JTextField(15);
        B=new JTextField(15);
        
        sideA.add(labelA);
        sideA.add(A);
        sideB.add(labelB);
        sideB.add(B);
        cntPanel=new JPanel();
        cntPanel.setLayout(new FlowLayout());
        cntLabel=new JLabel("參與投票人數:");
        cntField=new JTextField(10);
        cntPanel.add(cntLabel);
        cntPanel.add(cntField);

        confirmButton=new JButton("確認");
        confirmButton.addActionListener(listener);
        add(sideA);
        add(sideB);
        add(cntPanel);
        add(confirmButton);
    }

    private class MyEventListener implements ActionListener{
        public void actionPerformed(ActionEvent event){
            if(event.getSource()==confirmButton){
                try
                {   
                    firstChoice=new JRadioButton(A.getText());
                    secondChoice=new JRadioButton(B.getText());
                    participant=Integer.valueOf(cntField.getText());
                    twoCOneWindows voter=new twoCOneWindows();
                    voter.setSize(300,320);
                    voter.setVisible(true);
                    voter.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
                }
                catch(Exception e){
                    JOptionPane.showMessageDialog(new JFrame(),"請輸入投票内容后繼續！！","是不是少做了什麽？",JOptionPane.ERROR_MESSAGE);
                }
            }
        }
    }
    private class twoCOneWindows extends JFrame{
        private JPanel twoCOnePanel;
        private JLabel twoCOneLabel;
        private ButtonGroup choices;
        private JButton confirmButton;
        private voteCounter counter;
        public twoCOneWindows(){
            super("投票選擇");
            MyCOneVoter myVoter=new MyCOneVoter();
            counter=new voteCounter(participant);
            setLayout(new GridLayout(5,1));
            counter=new voteCounter(participant);
            choices=new ButtonGroup();
            choices.add(firstChoice);
            choices.add(secondChoice);
            twoCOnePanel=new JPanel();
            twoCOnePanel.setLayout(new FlowLayout());
            twoCOnePanel.add(firstChoice);
            twoCOnePanel.add(secondChoice);
            confirmButton=new JButton("確認");
            confirmButton.addActionListener(myVoter);
            twoCOneLabel=new JLabel("選項:");
            add(twoCOneLabel);
            add(twoCOnePanel);
            add(confirmButton);

        }
        private class MyCOneVoter implements ActionListener{
            public void actionPerformed(ActionEvent event){
                if(event.getSource()==confirmButton){
                    boolean isEnd=false;
                    try
                    {
                        if(firstChoice.isSelected()){
                            isEnd=counter.add(1);
                            if(!isEnd){
                                JOptionPane.showMessageDialog(new JFrame(),"投票成功！","通知",JOptionPane.WARNING_MESSAGE);
                            }
                        }
                        else if(secondChoice.isSelected()){
                            isEnd=counter.add(2);
                            if(!isEnd){
                                JOptionPane.showMessageDialog(new JFrame(),"投票成功！","通知",JOptionPane.WARNING_MESSAGE);
                            }
                        }
                        if(isEnd){
                            showResult resultWindow=new showResult(A.getText(),B.getText(),counter.getA(),counter.getB(),counter.getWinnerNum()+1,counter);//show result
                            resultWindow.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
                            resultWindow.setVisible(true);
                            resultWindow.setSize(300,320);
                        }
                    }
                    catch(Exception e){
                        JOptionPane.showMessageDialog(new JFrame(),"請輸入選項内容后繼續！！","Something Wrong",JOptionPane.ERROR_MESSAGE);
                    }
                }
            }
        }
    }
}