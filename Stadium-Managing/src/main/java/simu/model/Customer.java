package simu.model;

import simu.framework.Clock;
import simu.framework.Trace;
import view.Controller;


// TODO:
public class Customer {
    private static int index = 1;
    private ServicePoint p;
    private Controller controller = new Controller();
    private double arrivetime;
    private double finistime;
    private int id;
    private static int i = 1;
    private static long sum = 0;
    public boolean ticket = true;

    public boolean vipcustomer;

    public Customer() {
        id = i++;
        arrivetime = Clock.getInstance().getClock();
        Trace.out(Trace.Level.INFO, "New Customer:" + id + ":" + arrivetime);
        vipcustomer = true;
    }

    public boolean isTicket() {
        return ticket;
    }

    public boolean isVipCustomer() {
        return vipcustomer;
    }

    public static int getCount() {
        return i;
    }

    public int getId() {
        return id;
    }

    public double getFinistime() {
        return finistime;
    }

    public void setFinistime(double finistime) {
        this.finistime = finistime;
    }

    public double getArrivetime() {
        return arrivetime;
    }

    public void setArrivetime(int arrivetime) {
        this.arrivetime = arrivetime;
    }

    public int raport() {
        Trace.out(Trace.Level.INFO, "Customer " + id + " Arrived: " + arrivetime);
        Trace.out(Trace.Level.INFO, "Customer " + id + " Exits: " + finistime);

        double stayTime = finistime - arrivetime;
        Trace.out(Trace.Level.INFO, "Customer " + id + " Stayed for: " + stayTime);

        sum += stayTime;

        System.out.println("Customer " + id + " TotalTime: " + stayTime);

        return (int) stayTime;
    }

}