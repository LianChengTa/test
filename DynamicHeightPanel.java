package javafinalproject;

import javax.swing.*;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;
import java.awt.*;

public class DynamicHeightPanel extends JPanel {
    private JLabel label;
    private JSlider rangeSlider;
    private JScrollPane scrollPane;

    public DynamicHeightPanel(String question, JSlider slider) {
        super(new BorderLayout());
        setPreferredSize(new Dimension(500, 0)); // Set fixed width

        // Initialize elements
        label = new JLabel(question);

        scrollPane = new JScrollPane(label);
        scrollPane.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_ALWAYS);

        rangeSlider = slider;

        // Add a ChangeListener to track the changes in the slider
        rangeSlider.addChangeListener(new ChangeListener() {
            @Override
            public void stateChanged(ChangeEvent e) {
                int value = rangeSlider.getValue();
                System.out.println("Selected range: " + value);
            }
        });

        add(scrollPane, BorderLayout.NORTH);
        add(rangeSlider, BorderLayout.CENTER);
    }

    @Override
    public Dimension getPreferredSize() {
        int totalHeight = scrollPane.getPreferredSize().height + rangeSlider.getPreferredSize().height;
        return new Dimension(500, totalHeight);
    }
}
