package controller;

import javafx.application.Platform;
import simu.framework.IEngine;
import simu.model.MyEngine;
import view.IController;

/**
 * The Controller class implements the controllers for both the model (simulation engine)
 * and the view components. It handles user interactions and coordinates communication
 * between the simulation engine and the user interface.
 */
public class Controller implements IControllerForM, IControllerForV {
    private IEngine engine;
    private IController ui;

    /**
     * Constructs a new Controller with the specified user interface.
     *
     * @param ui The user interface controller associated with this simulation controller.
     */
    public Controller(IController ui) {
        this.ui = ui;
    }

    /**
     * Initiates the process of creating a new customer in the simulation.
     */
    @Override
    public void makenewcustomer() {
        Platform.runLater(new Runnable() {
            public void run() {
                ui.getNewCustomer().CustomerNew();
            }
        });
    }

    /**
     * Initiates the simulation by creating a new simulation engine, configuring its parameters,
     * and starting it as a separate thread.
     */
    @Override
    public void startsimulation() {
        engine = new MyEngine(this);
        engine.setSimulationTime(ui.getClock());
        engine.setDelay(ui.getDelay());
        ((Thread) engine).start();
    }

    /**
     * Slows down the simulation by increasing the delay between simulation steps.
     */
    @Override
    public void slower() {
        engine.setDelay((long) (engine.getDelay() * 1.10));
    }

    /**
     * Speeds up the simulation by decreasing the delay between simulation steps.
     */
    @Override
    public void faster() {
        engine.setDelay((long) (engine.getDelay() * 0.9));
    }

    /**
     * Updates the user interface with the total simulation time.
     *
     * @param time The total simulation time to be displayed.
     */
    @Override
    public void showtotaltime(double time) {
        Platform.runLater(() -> ui.setTotalTime(time));
    }
}
