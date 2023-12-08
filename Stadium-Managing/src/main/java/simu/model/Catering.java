package simu.model;

import eduni.distributions.ContinuousGenerator;
import simu.framework.EventList;

public class Catering extends ServicePoint {
    private static int cashers = 0;

    public Catering(ContinuousGenerator generator, EventList eventList, EventType eventType, int x, int y) {
        super(generator, eventList, eventType, x, y);
        cashers++;
    }

    @Override
    public void StartService() {
        System.out.println("Catering: ");
        super.StartService();
    }
}
