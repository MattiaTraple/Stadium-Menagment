package simu.framework;

public class Event implements Comparable<Event> {

    private IEventType type;
    private double clock;

    public Event(IEventType type, double clock){
        this.type = type;
        this.clock = clock;
    }

    public void setType(IEventType type) {
        this.type = type;
    }
    public IEventType getType() {
        return type;
    }
    public void setClock(double clock) {
        this.clock = clock;
    }
    public double getClock() {
        return clock;
    }

    @Override
    public int compareTo(Event arg) {
        if (this.clock < arg.clock) return -1;
        else if (this.clock > arg.clock) return 1;
        return 0;
    }
}
