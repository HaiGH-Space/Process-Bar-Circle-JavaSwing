package org.haigh.processbar.ui;

import javax.swing.*;
import javax.swing.plaf.basic.BasicProgressBarUI;
import java.awt.*;
import java.awt.geom.Arc2D;
import java.awt.geom.Area;
import java.awt.geom.Ellipse2D;
import java.awt.geom.RoundRectangle2D;

public class ProgressBarCircleUI extends BasicProgressBarUI {
    private int paddingT, size;
    private Color background, foreground,circleColor;
    String text = "Loading";
    public ProgressBarCircleUI(int sizeCircle,int paddingT){
        this.size = sizeCircle;
        this.paddingT =paddingT;
    }
    public ProgressBarCircleUI(Color background, Color foreground,Color circleColor, int sizeCircle, int paddingT) {
        this.background = background;
        this.paddingT = paddingT;
        this.circleColor = circleColor;
        this.size = sizeCircle;
        this.foreground = foreground;
    }


    @Override
    public Dimension getPreferredSize(JComponent c) {
        Dimension d = super.getPreferredSize(c);
        int v = Math.max(d.width, d.height);
        d.setSize(v, v);
        return d;
    }

    @Override
    public void paint(Graphics g, JComponent c) {

        Insets b = progressBar.getInsets(); // area for border
        int barRectWidth = size;
        int barRectHeight = size;
        if (barRectWidth <= 0 || barRectHeight <= 0) {
            return;
        }

        g.setColor(background);
        RoundRectangle2D roundedRectangle = new RoundRectangle2D.Double(0, 0, progressBar.getWidth(), progressBar.getHeight(), 30, 30);
        ((Graphics2D) g).fill(roundedRectangle);
        // draw the cells
        Graphics2D g2 = (Graphics2D) g.create();
        g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING,
                RenderingHints.VALUE_ANTIALIAS_ON);
        g2.fillRoundRect(0, 0, barRectWidth, barRectHeight, 30, 30);
        g2.setPaint(circleColor);
        double degree = 360 * progressBar.getPercentComplete();
        double sz = Math.min(barRectWidth, barRectHeight);
        double cx = progressBar.getWidth() * .5;
        double cy = progressBar.getHeight() * .5;
        double or = sz * .5;
        double ir = or * .6; //or - 20;
        Shape inner = new Ellipse2D.Double(cx - ir, cy - ir + paddingT, ir * 2, ir * 2);
        Shape outer = new Arc2D.Double(
                cx - or, cy - or + paddingT, sz, sz, 90 - degree, degree, Arc2D.PIE);
        Area area = new Area(outer);
        area.subtract(new Area(inner));
        g2.fill(area);

        g2.dispose();
        if (progressBar.isStringPainted()) {
            g.setFont(new Font("Arial", Font.BOLD, 13));
            FontMetrics fm = g.getFontMetrics();
            int textWidth = fm.stringWidth(text);
            int x = (progressBar.getWidth() - textWidth) / 2;
            int y = (paddingT);
            g.setColor(foreground); // Màu chữ
            g.drawString(text, x, y);
        }

    }

    public int getPaddingT() {
        return paddingT;
    }

    public void setPaddingT(int paddingT) {
        this.paddingT = paddingT;
    }

    public int getSize() {
        return size;
    }

    public void setSize(int size) {
        this.size = size;
    }

    public Color getBackground() {
        return background;
    }

    public void setBackground(Color background) {
        this.background = background;
    }

    public Color getForeground() {
        return foreground;
    }

    public void setForeground(Color foreground) {
        this.foreground = foreground;
    }

    public Color getCircleColor() {
        return circleColor;
    }

    public void setCircleColor(Color circleColor) {
        this.circleColor = circleColor;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }
}
