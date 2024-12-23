package org.haigh.processbar.worker;

import org.haigh.processbar.ui.ProgressBarCircleDialog;

import javax.swing.*;
import java.awt.*;

public abstract class ProgressBarCircleWorker<T,D> extends SwingWorker<T, D>{
    private ProgressBarCircleDialog progressBarCircleDialog;
    public ProgressBarCircleWorker(JFrame frame,Dimension dimensionDialog) {
        progressBarCircleDialog = new ProgressBarCircleDialog(frame,dimensionDialog);
    }
    public ProgressBarCircleWorker(ProgressBarCircleDialog progressBarCircleDialog){
       this.progressBarCircleDialog = progressBarCircleDialog;
    }

    @Override
    protected void done() {
        progressBarCircleDialog.dispose();
    }

    public final void executeProgress(){
        execute();
        progressBarCircleDialog.showProgress(true);
    }
    public ProgressBarCircleDialog getProgressBarCircleDialog(){
        return progressBarCircleDialog;
    }
}
