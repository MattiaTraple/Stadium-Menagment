package simu.model;

import eduni.distributions.ContinuousGenerator;
import simu.framework.Clock;
import simu.framework.Event;
import simu.framework.EventList;
import simu.framework.Trace;

import java.util.LinkedList;

/**
 * The ServicePoint class represents a service point in a simulation. Service points
 * serve customers in a First-Come-First-Served (FCFS) manner. Each service point has
 * a line of customers waiting for service and is associated with a continuous generator
 * for generating service times.
 */
public class ServicePoint {

    private final LinkedList<Customer> line = new LinkedList<>();
    private final ContinuousGenerator generator;
    private final EventList eventList;
    private final EventType eventType;
    private int x, y; // Service point's location
    private boolean reserved = false;

    /**
     * Constructs a new ServicePoint with the specified continuous generator, event list,
     * event type, and location.
     *
     * @param generator The continuous generator for service times.
     * @param eventList The event list for managing events in the simulation.
     * @param eventType The event type associated with this service point.
     * @param x         The x-coordinate of the service point's location.
     * @param y         The y-coordinate of the service point's location.
     */
    public ServicePoint(ContinuousGenerator generator, EventList eventList, EventType eventType, int x, int y) {
        this.eventList = eventList;
        this.generator = generator;
        this.eventType = eventType;
        this.x = x;
        this.y = y;
    }

    /**
     * Adds a customer to the line at this service point.
     *
     * @param a The customer to be added to the line.
     */
    public void AddToTheLine(Customer a) {
        line.add(a);
    }

    /**
     * Takes a customer from the line at this service point.
     *
     * @return The customer taken from the line.
     */
    public Customer TakeFromTheLine() {
        reserved = false;
        return line.poll();
    }

    /**
     * Starts serving the next customer in line by creating a new service event
     * with the appropriate service time.
     */
    public void StartService() {
        Trace.out(Trace.Level.INFO, "Making new server for customer " + line.peek().getId());

        reserved = true;
        double servicetime = generator.sample();
        EventList.add(new Event(eventType, Clock.getInstance().getClock() + servicetime));
    }

    /**
     * Checks if the service point is currently reserved for serving a customer.
     *
     * @return True if the service point is reserved, false otherwise.
     */
    public boolean isReserved() {
        return reserved;
    }

    /**
     * Checks if there are customers waiting in line at this service point.
     *
     * @return True if there are customers in line, false otherwise.
     */
    public boolean isOnQueue() {
        return line.size() != 0;
    }

    /**
     * Gets the current size of the line at this service point.
     *
     * @return The size of the line.
     */
    public int GetLineSize() {
        return line.size();
    }

    /**
     * Gets the list of customers currently waiting in line at this service point.
     *
     * @return The list of customers in line.
     */
    public LinkedList<Customer> getLineCustomers() {
        return line;
    }

    /**
     * Gets the x-coordinate of the service point's location.
     *
     * @return The x-coordinate of the service point's location.
     */
    public int getX() {
        return x;
    }

    /**
     * Gets the y-coordinate of the service point's location.
     *
     * @return The y-coordinate of the service point's location.
     */
    public int getY() {
        return y;
    }
}
