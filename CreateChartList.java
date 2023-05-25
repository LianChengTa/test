package javafinalproject;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.util.ArrayList;

import javax.swing.JPanel;

public class CreateChartList extends JPanel{
    private ArrayList<String> questionsList;
    private int totalHeight = 0;

    public CreateChartList(ArrayList<String> questions, int[][] data) {
        super(new FlowLayout());
        setPreferredSize(new Dimension(500, 0));
        setBackground(Color.gray);

        this.questionsList = questions;

        int count = 0;
        System.out.println(questions.size());
        while(count < questions.size()) {
            JPanel chartPanel = new DynamicHeightPanel4Chart(questionsList.get(count), data[count]);
            totalHeight += chartPanel.getPreferredSize().height + 10;
            add(chartPanel);

            count++;
        }
    }

    @Override
    public Dimension getPreferredSize() {
        return new Dimension(500, totalHeight);
    }
}
