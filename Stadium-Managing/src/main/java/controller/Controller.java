package controller;

import javafx.application.Platform;
import simu.framework.IEngine;
import simu.model.MyEngine;
import view.IController;
public class Controller implements IControllerForM, IControllerForV {
    private IEngine engine;
    private IController ui;

    public Controller(IController ui) {
        this.ui = ui;

    }

    @Override
    public void startsimulation() {
        engine = new MyEngine(this);
        engine.setSimulationTime(ui.getClock());
        engine.setDelay(ui.getDelay());
        ((Thread)engine).start();
    }

    @Override
    public void slower() {
        engine.setDelay((long)(engine.getDelay()*1.10));
    }

    @Override
    public void faster() {
        engine.setDelay((long)(engine.getDelay()*0.9));
    }

    @Override
    public void showtotaltime(double time) {
        Platform.runLater(()->ui.setTotalTime(time));
    }
}

