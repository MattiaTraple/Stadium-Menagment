package simu.framework;

/**
 * The Event class represents an event in a simulation. Events have a type
 * (IEventType) and occur at a specific simulation time (clock).
 * It implements Comparable to allow comparison based on simulation time.
 */
public class Event implements Comparable<Event> {

    private IEventType type;
    private double clock;

    /**
     * Constructs a new Event with the specified event type and simulation time.
     *
     * @param type  The type of the event.
     * @param clock The simulation time at which the event occurs.
     */
    public Event(IEventType type, double clock) {
        this.type = type;
        this.clock = clock;
    }

    /**
     * Sets the type of the event.
     *
     * @param type The new event type.
     */
    public void setType(IEventType type) {
        this.type = type;
    }

    /**
     * Gets the type of the event.
     *
     * @return The type of the event.
     */
    public IEventType getType() {
        return type;
    }

    /**
     * Sets the simulation time at which the event occurs.
     *
     * @param clock The new simulation time for the event.
     */
    public void setClock(double clock) {
        this.clock = clock;
    }

    /**
     * Gets the simulation time at which the event occurs.
     *
     * @return The simulation time of the event.
     */
    public double getClock() {
        return clock;
    }

    /**
     * Compares this event with another event based on their simulation times.
     * Used for sorting events in ascending order of simulation time.
     *
     * @param arg The event to be compared.
     * @return -1 if this event's time is less than arg's time,
     *         1 if this event's time is greater than arg's time,
     *         0 if both events occur at the same time.
     */
    @Override
    public int compareTo(Event arg) {
        if (this.clock < arg.clock) return -1;
        else if (this.clock > arg.clock) return 1;
        return 0;
    }
}
