package simu.model;

import javafx.scene.canvas.GraphicsContext;
import javafx.scene.image.Image;
import javafx.scene.paint.Color;
import simu.framework.Clock;
import simu.framework.Trace;
import view.Controller;
import view.NewCustomer;

public class Customer {
    private ServicePoint p;
    private Controller controller = new Controller();
    private NewCustomer gc;
    private double arrivetime;
    private double finistime;
    private int id;
    private static int i = 1;
    private static long sum = 0;
    private boolean ticket = true;
    private boolean normalcustomer;

    public Customer() {
        id = i++;
        arrivetime = Clock.getInstance().getClock();
        Trace.out(Trace.Level.INFO, "New Customer:" + id + ":" + arrivetime );
        normalcustomer = true;
    }

    public boolean isTicket() {
        return ticket;
    }

    public boolean isNormalCustomer() {
        return normalcustomer;
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
        double average = (double) sum / i;
        System.out.println("Average " + average);
        return average;
    }


    public void draw(GraphicsContext gc, int x, int y) {
        if (normalcustomer) {
            gc.setStroke(Color.GREEN);
            gc.strokeLine(x + 5, y, x + 5, y + 20);

            gc.setFill(Color.GREEN);
            gc.fillOval(x + 2, y - 5, 6, 6);

            gc.setStroke(Color.GREEN);
            gc.setLineWidth(2);
            gc.strokeLine(x + 5, y + 5, x - 3, y + 10);
            gc.strokeLine(x + 5, y + 5, x + 13, y + 10);

            gc.setStroke(Color.GREEN);
            gc.setLineWidth(2);
            gc.strokeLine(x + 5, y + 20, x + 3, y + 30);
            gc.strokeLine(x + 5, y + 20, x + 7, y + 30);
        } else {
            gc.setFill(Color.RED);
        }
        gc.fillOval(x, y, 10, 10);
    }

    public void removeDraw(GraphicsContext gc, int x, int y) {
        gc.setFill(Color.TRANSPARENT);
        gc.fillOval(x, y, 1, 1);
        gc.setFill(Color.TRANSPARENT);
    }

}
