package simu.model;

import eduni.distributions.ContinuousGenerator;
import simu.framework.EventList;

public class Ticket extends ServicePoint {
    private static int counters = 0;

    public Ticket(ContinuousGenerator generator, EventList eventList, EventType eventType, int x, int y) {
        super(generator, eventList, eventType, x, y);
    }

    @Override
    public void StartService() {
        System.out.println("Ticket Control: ");
        super.StartService();
    }

}
