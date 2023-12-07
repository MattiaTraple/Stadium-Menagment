package simu.model;

import eduni.distributions.ContinuousGenerator;
import simu.framework.EventList;

public class CheckIn extends ServicePoint {
    private static int counters = 0;
    private static int customers = 0;
    public CheckIn(ContinuousGenerator generator, EventList eventList, EventType type, int x, int y) {
        super(generator, eventList, type, x, y);
        counters++;
    }

    public int CustomersServed() {
        return customers;
    }

    @Override
    public void BeginService() {
        System.out.println("Check-IN: ");
        super.BeginService();
    }
}
