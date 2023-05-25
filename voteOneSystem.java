package javafinalproject;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class voteOneSystem extends JFrame{
    public JPanel sideA;
    public JPanel insideSideA;
    private JButton confirmButton;
    private JLabel labelA;
    private JRadioButton choiceA;
    private JRadioButton choiceB;
    private JRadioButton choiceC;
    private ButtonGroup choices;
    public voteOneSystem(){
        super("voteOneSystem");
        MyEventListener listener=new MyEventListener();
        setLayout(new BorderLayout());
        sideA=new JPanel();
        sideA.setLayout(new BorderLayout());
        insideSideA=new JPanel();
        insideSideA.setLayout(new FlowLayout());
        sideA.setPreferredSize(new Dimension(250, 125));
        labelA=new JLabel("選擇投票形式：");
        labelA.setFont(new Font("TimesRoman",Font.BOLD,18));
        choiceA=new JRadioButton("二選一");
        choiceB=new JRadioButton("三選一");
        choiceC=new JRadioButton("四選一");
        insideSideA.add(choiceA);
        insideSideA.add(choiceB);
        insideSideA.add(choiceC);
        choices=new ButtonGroup();
        choices.add(choiceA);
        choices.add(choiceB);
        choices.add(choiceC);

        confirmButton=new JButton("確認");
        confirmButton.addActionListener(listener);

        add(sideA,BorderLayout.NORTH);
        sideA.add(labelA,BorderLayout.NORTH);
        sideA.add(insideSideA,BorderLayout.CENTER);
        sideA.add(confirmButton,BorderLayout.SOUTH);
    }
    
    
    private class MyEventListener implements ActionListener{
        public void actionPerformed(ActionEvent event){
            if(event.getSource()==confirmButton){
                // try
                // {
                    if(choiceA.isSelected()){
                        TwoCOne newWindow=new TwoCOne();
                        newWindow.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
                        newWindow.setSize(300,320);
                        newWindow.setVisible(true);
                    }
                    else if(choiceB.isSelected()){
                        ThreeCOne newWindow=new ThreeCOne();
                        newWindow.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
                        newWindow.setSize(300,320);
                        newWindow.setVisible(true);
                    }
                    else if(choiceC.isSelected()){
                        FourCOne newWindow=new FourCOne();
                        newWindow.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
                        newWindow.setSize(300,320);
                        newWindow.setVisible(true);
                    }
                // }
                // catch(Exception e){
                //     System.out.print("aaa");
                //     JOptionPane.showMessageDialog(new JFrame("SoMething Wrong"),"請做出選擇后繼續","Dialog",JOptionPane.ERROR_MESSAGE);
                // }
            }
            
        }

    
    }



}

