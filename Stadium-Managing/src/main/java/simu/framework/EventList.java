package simu.framework;

import java.util.PriorityQueue;

public class EventList {
    private static PriorityQueue<Event> list = new PriorityQueue<Event>();

    public EventList(){
    }

    public Event remove(){
        return list.remove();
    }

    public static void add(Event t){
        list.add(t);
    }

    public double getNextTime(){
        return list.peek().getClock();
    }
}
