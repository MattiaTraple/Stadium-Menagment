package simu.framework;

/**
 * The Clock class represents the simulation clock, providing a centralized mechanism
 * to keep track of the current simulation time.
 */
public class Clock {
    private static Clock instance;
    private double clock;

    /**
     * Private constructor to enforce the singleton pattern.
     */
    private Clock() { }

    /**
     * Gets the singleton instance of the Clock class.
     *
     * @return The singleton instance of the Clock class.
     */
    public static Clock getInstance() {
        if (instance == null)
            instance = new Clock();
        return instance;
    }

    /**
     * Sets the simulation clock to the specified value.
     *
     * @param clock The new value for the simulation clock.
     */
    public void setClock(double clock) {
        this.clock = clock;
    }

    /**
     * Gets the current value of the simulation clock.
     *
     * @return The current value of the simulation clock.
     */
    public double getClock() {
        return clock;
    }
}
