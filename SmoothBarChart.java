package javafinalproject;

import javax.swing.*;
import java.awt.*;

public class SmoothBarChart {
    public static JPanel createBarChart(int[] data) {
        JPanel chartPanel = new JPanel() {
            @Override
            protected void paintComponent(Graphics g) {
                super.paintComponent(g);
                Graphics2D g2d = (Graphics2D) g;

                int width = getWidth();
                int height = getHeight();

                int numBars = data.length;
                int barSpacing = 10; // Spacing between bars
                int maxYValue = 20;

                int totalSpacing = (numBars - 1) * barSpacing;
                int barWidth = (width - 80 - totalSpacing) / numBars; // Adjusted bar width to include spacing
                int scaleFactor = (height - 60) / maxYValue;

                g2d.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);

                // Draw the bars
                for (int i = 0; i < numBars; i++) {
                    int barHeight = data[i] * scaleFactor;
                    int x = 50 + i * (barWidth + barSpacing); // Adjusted x position to include spacing
                    int y = height - 50 - barHeight;
                    g2d.setColor(Color.gray);
                    g2d.fillRoundRect(x, y, barWidth, barHeight, 10, 10);
                }

                // Draw the axis lines
                g2d.setColor(Color.BLACK);
                g2d.drawLine(50, height - 50, width - 30, height - 50);
                g2d.drawLine(50, height - 50, 50, 10);

                // Draw the labels
                g2d.setFont(new Font("Arial", Font.PLAIN, 12));
                for (int i = 0; i < numBars; i++) {
                    int x = 50 + i * (barWidth + barSpacing) + 10;
                    int y = height - 35;
                    g2d.drawString(String.valueOf(i + 1), x, y);
                }

                // Draw the y-axis labels
                g2d.setFont(new Font("Arial", Font.PLAIN, 12));
                int yLabelSpacing = 2; // Adjusted spacing for y-axis labels
                int numLabels = maxYValue / yLabelSpacing;
                for (int i = 0; i <= numLabels; i++) {
                    int labelValue = Math.abs((maxYValue - i * yLabelSpacing) - 20);
                    String label = String.valueOf(labelValue);
                    int labelWidth = g2d.getFontMetrics().stringWidth(label);
                    int x = 40 - labelWidth;
                    int y = height - 50 - (i * yLabelSpacing * scaleFactor) + 5; // Adjusted y position for y-axis labels
                    g2d.drawString(label, x, y);
                }
            }
        };

        chartPanel.setPreferredSize(new Dimension(400,300));

        return chartPanel;
    }

    private static int getMaxValue(int[] data) {
        int max = Integer.MIN_VALUE;
        for (int value : data) {
            if (value > max) {
                max = value;
            }
        }
        return max;
    }

    // public static void main(String[] args) {
    //     SwingUtilities.invokeLater(() -> {
    //         int[] data = {3, 5, 10, 20, 12, 0, 0, 0, 0, 0}; // Sample data for the chart
    //         JPanel chartPanel = createBarChart(data);

    //         JFrame frame = new JFrame("Smooth Bar Chart");
    //         frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    //         frame.setSize(400, 300);
    //         frame.setLocationRelativeTo(null);
    //         frame.setContentPane(chartPanel);
    //         frame.setVisible(true);
    //     });
    // }
}
