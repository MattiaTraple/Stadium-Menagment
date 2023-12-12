package simu.model;

import eduni.distributions.ContinuousGenerator;
import simu.framework.EventList;

public class Catering extends ServicePoint {

    public Catering(ContinuousGenerator generator, EventList eventList, EventType eventType, int x, int y) {
        super(generator, eventList, eventType, x, y);
    }

    @Override
    public void StartService() {
        System.out.println("Catering: ");
        super.StartService();
    }
}
