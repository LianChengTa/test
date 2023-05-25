package javafinalproject;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.util.ArrayList;

import javax.swing.JPanel;
import javax.swing.JSlider;

public class CreateQuestionsList extends JPanel{
    private ArrayList<String> questionsList;
    private static ArrayList<JSlider> sliders;
    private int totalHeight = 0;

    public CreateQuestionsList(ArrayList<String> questions) {
        super(new FlowLayout());
        setPreferredSize(new Dimension(500, 0));
        setBackground(Color.gray);

        this.questionsList = questions;
        sliders = createRangeSliders(questions.size());

        int count = 0;
        while(count < questions.size()) {
            JPanel quesPanel = new DynamicHeightPanel(questionsList.get(count), sliders.get(count));
            totalHeight += quesPanel.getPreferredSize().height + 8;
            add(quesPanel);

            count++;
        }
    }

    public static ArrayList<JSlider> createRangeSliders(int count) {
        ArrayList<JSlider> sliders = new ArrayList<>();

        for (int i = 0; i < count; i++) {
            JSlider slider = new JSlider(JSlider.HORIZONTAL, 0, 10, 5);
            slider.setMajorTickSpacing(1);
            slider.setPaintTicks(true);
            slider.setPaintLabels(true);

            sliders.add(slider);
        }

        return sliders;
    }
    
    public static ArrayList<JSlider> getSliders() {
        return sliders;
    }

    @Override
    public Dimension getPreferredSize() {
        return new Dimension(500, totalHeight);
    }
}
