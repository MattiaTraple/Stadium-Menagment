package simu.framework;

import java.util.PriorityQueue;

/**
 * The EventList class represents a priority queue of events in a simulation.
 * It is used to maintain a sorted list of events based on their simulation times.
 */
public class EventList {
    private static PriorityQueue<Event> list = new PriorityQueue<Event>();

    /**
     * Constructs a new EventList.
     */
    public EventList() {
    }

    /**
     * Removes and returns the next event in the list.
     *
     * @return The next event in the list.
     */
    public Event remove() {
        return list.remove();
    }

    /**
     * Adds a new event to the list.
     *
     * @param t The event to be added to the list.
     */
    public static void add(Event t) {
        list.add(t);
    }

    /**
     * Gets the simulation time of the next event in the list without removing it.
     *
     * @return The simulation time of the next event.
     */
    public double getNextTime() {
        return list.peek().getClock();
    }
}
