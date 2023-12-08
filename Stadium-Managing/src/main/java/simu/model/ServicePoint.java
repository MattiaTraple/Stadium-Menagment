package simu.model;

import eduni.distributions.ContinuousGenerator;
import simu.framework.Clock;
import simu.framework.Event;
import simu.framework.EventList;
import simu.framework.Trace;

import java.util.LinkedList;

// TODO:
public class ServicePoint {

    private final LinkedList<Customer> line = new LinkedList<>();
    private final ContinuousGenerator generator;
    private final EventList eventList;
    private final EventType eventType;
    private int x, y; // Service points location
    private boolean reserved = false;

    public ServicePoint(ContinuousGenerator generator, EventList eventList, EventType eventType, int x, int y){
        this.eventList = eventList;
        this.generator = generator;
        this.eventType = eventType;
        this.x = x;
        this.y = y;
    }

    public void AddToTheLine(Customer a){
        line.add(a);
    }


    public Customer TakeFromTheLine(){  // Poistetaan palvelussa ollut
        reserved = false;
        return line.poll();
    }


    public void StartService(){

        Trace.out(Trace.Level.INFO, "Making new server for customer " + line.peek().getId());

        reserved = true;
        double servicetime = generator.sample();
        EventList.add(new Event(eventType, Clock.getInstance().getClock()+servicetime));
    }

    public boolean isReserved(){
        return reserved;
    }

    public boolean isOnQueue(){
        return line.size() != 0;
    }

    public int GetLineSize() {
        return line.size();
    }

    public LinkedList<Customer> getLineCustomers() {
        return line;
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }
}