package simu.model;

import eduni.distributions.ContinuousGenerator;
import simu.framework.EventList;

public class VipCustomer extends CheckIn {

    public VipCustomer(ContinuousGenerator generator, EventList eventList, EventType type, int x, int y) {
        super(generator, eventList, type, x, y);
    }

    @Override
    public void StartService() {
        super.StartService();
    }
}
