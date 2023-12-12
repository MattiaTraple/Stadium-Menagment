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

    public void setArrivetime(double arrivetime) {
        this.arrivetime = arrivetime;
    }


    public double raport() {
        Trace.out(Trace.Level.INFO, "Customer " + id + " arrived:" + arrivetime);
        Trace.out(Trace.Level.INFO, "Customer " + id + " finished:" + finistime);
        Trace.out(Trace.Level.INFO, "Customer " + id + " delay:" + (finistime - arrivetime));
        sum += (finistime - arrivetime);
        double average = sum / id / 2;
        System.out.println("Average " + average);
        return average;
    }

}