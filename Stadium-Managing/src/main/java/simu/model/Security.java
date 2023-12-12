package simu.model;

import eduni.distributions.ContinuousGenerator;
import simu.framework.EventList;

public class Security extends ServicePoint {
    private static int security = 0;

    public Security(ContinuousGenerator generator, EventList eventList, EventType eventType, int x, int y) {
        super(generator, eventList, eventType, x, y);
        security++;
    }

    @Override
    public void StartService() {
        System.out.println("Security Control: ");
        super.StartService();
    }
}
