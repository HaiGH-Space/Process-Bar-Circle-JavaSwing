package org.haigh.processbar.ui;

import javax.swing.*;
import java.awt.*;

public class ProgressBarCircleDialog extends JDialog {
    private JProgressBar progressCircle;
    private ProgressBarCircleUI progressBarCircleUI;
    private Color background,foreground,circleColor;
    private int paddingT = 30,sizeCircle = 100;
    private String text = "Loading";
    private int speed =2,delay = 30;

    public ProgressBarCircleDialog(JFrame frame, Dimension sizeDialog) {
        super(frame, true);
        background = new Color(246,248,252);
        foreground = new Color(40,40,40);
        circleColor = new Color(34,75,251);
        progressBarCircleUI = new ProgressBarCircleUI(background,foreground,circleColor,sizeCircle,paddingT);
        this.setUndecorated(true);
        this.setSize(sizeDialog);
        this.setLocationRelativeTo(frame);
        init();
    }


    private void init() {
        progressCircle = new JProgressBar();
        progressCircle.setStringPainted(true);
        progressCircle.setUI(progressBarCircleUI);
        progressCircle.setBorder(BorderFactory.createEmptyBorder(3, 3, 3, 3));
        add(progressCircle);
    }

    public void showProgress(boolean isRun) {
        if (isRun) {
            (new Timer(delay, e -> {
                int iv = progressCircle.getValue() + speed;
                progressCircle.setValue(iv > 100 ? 0 : iv);
            })).start();
            this.setVisible(true);
        } else {
            this.setVisible(false);
        }
    }

    public void setBackgroundP(Color background) {
        progressBarCircleUI.setBackground(background);
    }

    public void setForegroundP(Color foreground) {
        progressBarCircleUI.setForeground(foreground);
    }

    public void setCircleColor(Color circleColor) {
        progressBarCircleUI.setCircleColor(circleColor);
    }

    public void setPaddingT(int paddingT) {
        progressBarCircleUI.setPaddingT(paddingT);
    }

    public void setSizeCircle(int sizeCircle) {
        progressBarCircleUI.setSize(sizeCircle);
    }

    public void setText(String text) {
        progressBarCircleUI.setText(text);
    }


    public void setSpeed(int speed) {
        this.speed = speed;
    }

    public void setDelay(int delay) {
        this.delay = delay;
    }
}
