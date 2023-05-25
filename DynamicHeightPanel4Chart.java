package javafinalproject;

import javax.swing.*;
import java.awt.*;

public class DynamicHeightPanel4Chart extends JPanel {
    private JLabel label;
    private JPanel chartPanel;
    private JScrollPane scrollPane;

    public DynamicHeightPanel4Chart(String question, int[] array) {
        super(new BorderLayout());
        setPreferredSize(new Dimension(500, 0)); // Set fixed width

        // Initialize elements
        label = new JLabel(question);

        scrollPane = new JScrollPane(label);
        scrollPane.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_ALWAYS);

        chartPanel = SmoothBarChart.createBarChart(array);

        add(scrollPane, BorderLayout.NORTH);
        add(chartPanel, BorderLayout.CENTER);
    }

    @Override
    public Dimension getPreferredSize() {
        int totalHeight = scrollPane.getPreferredSize().height + chartPanel.getPreferredSize().height;
        return new Dimension(500, totalHeight);
    }
}
