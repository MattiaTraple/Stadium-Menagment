package simu.framework;

import controller.IControllerForM;
import view.IController;

/**
 * The Engine class is an abstract class representing the core simulation engine.
 * It extends Thread to allow concurrent execution and implements the IEngine interface
 * to define the simulation engine's behavior.
 */
public abstract class Engine extends Thread implements IEngine {

    private double simulationtime = 0;
    private long delay = 0;

    private Clock clock;

    protected EventList eventList;

    protected IControllerForM controller;

    /**
     * Constructs a new Engine with the specified controller for the model (IControllerForM).
     *
     * @param controller The controller for the model associated with this simulation engine.
     */
    public Engine(IControllerForM controller) {
        this.controller = controller;

        clock = Clock.getInstance();

        eventList = new EventList();
    }

    /**
     * Sets the simulation time for the engine.
     *
     * @param time The new simulation time.
     */
    @Override
    public void setSimulationTime(double time) {
        simulationtime = time;
    }

    /**
     * Sets the delay between simulation steps.
     *
     * @param delay The delay between simulation steps.
     */
    @Override
    public void setDelay(long delay) {
        this.delay = delay;
    }

    /**
     * Gets the current delay between simulation steps.
     *
     * @return The current delay between simulation steps.
     */
    @Override
    public long getDelay() {
        return delay;
    }

    /**
     * Runs the simulation engine.
     */
    @Override
    public void run() {
        covers();
        while (simulating()) {
            delay();
            clock.setClock(present());
            executeBEvents();
            tryCEvents();
        }
        results();
    }

    private void executeBEvents() {
        while (eventList.getNextTime() == clock.getClock()) {
            executeEvents(eventList.remove());
        }
    }

    /**
     * Defines the behavior for handling conditional events (C-Events).
     * Subclasses must implement this method to specify the conditions and actions
     * associated with conditional events in the simulation.
     */
    protected abstract void tryCEvents();

    private double present() {
        return eventList.getNextTime();
    }

    private boolean simulating() {
        Trace.out(Trace.Level.INFO, "Time is: " + clock.getClock());
        return clock.getClock() < simulationtime;
    }

    private void delay() {
        Trace.out(Trace.Level.INFO, "Delay " + delay);
        try {
            sleep(delay);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    /**
     * Defines the initial setup and covers for the simulation.
     * Subclasses must implement this method to perform the necessary setup
     * before the simulation starts.
     */
    protected abstract void covers();

    /**
     * Defines the behavior for executing events in the simulation.
     * Subclasses must implement this method to specify the actions associated
     * with different types of events in the simulation.
     *
     * @param t The event to be executed.
     */
    protected abstract void executeEvents(Event t);

    /**
     * Defines the behavior for handling simulation results.
     * Subclasses must implement this method to specify the actions
     * to be taken after the simulation completes.
     */
    protected abstract void results();
}
