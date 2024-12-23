package org.haigh.processbar;

import org.haigh.processbar.worker.ProgressBarCircleWorker;

import javax.swing.*;
import java.awt.*;

public class Test {
    public static void main(String[] args) {
        JFrame fa = new JFrame();
        fa.setSize(1000, 800);
        fa.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        fa.setLocationRelativeTo(null);
        fa.setVisible(true);

        ProgressBarCircleWorker<String, Void> progressBarCircleWorker = new ProgressBarCircleWorker<String, Void>(fa,new Dimension(300,300)) {
            @Override
            protected String doInBackground() throws Exception {

                Thread.sleep(5000);
                return "Đã thực thi xong";
            }

            @Override
            protected void done() {
                super.done();

            }
        };
        progressBarCircleWorker.getProgressBarCircleDialog().setDelay(10);
      progressBarCircleWorker.executeProgress();
    }
}
