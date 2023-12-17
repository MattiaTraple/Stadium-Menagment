package simu.model;

import javafx.scene.canvas.GraphicsContext;
import javafx.scene.paint.Color;
import simu.framework.Clock;
import simu.framework.Trace;
import view.Controller;
import view.NewCustomer;

/**
 * The Customer class represents a customer in a simulation. Customers can be either
 * normal or VIP and are associated with a service point. It provides methods for
 * tracking arrival and finish times, drawing the customer on a graphics context, and
 * calculating and reporting delays.
 */
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
    private boolean normalCustomer;
    private boolean vipCustomer;

    /**
     * Constructs a new Customer with a specified customer type (VIP or normal).
     *
     * @param isVIP True if the customer is VIP, false if the customer is normal.
     */
    public Customer(boolean isVIP) {
        id = i++;
        arrivetime = Clock.getInstance().getClock();
        Trace.out(Trace.Level.INFO, "New Customer:" + id + ":" + arrivetime);
        normalCustomer = !isVIP;
        vipCustomer = isVIP;
    }

    /**
     * Checks if the customer has a ticket.
     *
     * @return True if the customer has a ticket, false otherwise.
     */
    public boolean isTicket() {
        return ticket;
    }

    /**
     * Checks if the customer is a normal customer.
     *
     * @return True if the customer is normal, false if the customer is VIP.
     */
    public boolean isNormalCustomer() {
        return normalCustomer;
    }

    /**
     * Checks if the customer is a VIP customer.
     *
     * @return True if the customer is VIP, false if the customer is normal.
     */
    public boolean isVIPCustomer() {
        return vipCustomer;
    }

    /**
     * Gets the total number of customers created.
     *
     * @return The total number of customers.
     */
    public static int getCount() {
        return i;
    }

    /**
     * Gets the unique identifier of the customer.
     *
     * @return The customer's identifier.
     */
    public int getId() {
        return id;
    }

    /**
     * Gets the finish time of the customer.
     *
     * @return The finish time of the customer.
     */
    public double getFinistime() {
        return finistime;
    }

    /**
     * Sets the finish time of the customer.
     *
     * @param finistime The new finish time of the customer.
     */
    public void setFinistime(double finistime) {
        this.finistime = finistime;
    }

    /**
     * Gets the arrival time of the customer.
     *
     * @return The arrival time of the customer.
     */
    public double getArrivetime() {
        return arrivetime;
    }

    /**
     * Sets the arrival time of the customer.
     *
     * @param arrivetime The new arrival time of the customer.
     */
    public void setArrivetime(double arrivetime) {
        this.arrivetime = arrivetime;
    }

    /**
     * Calculates and reports the delay of the customer and updates the average delay.
     *
     * @return The average delay of all customers.
     */
    public double raport() {
        Trace.out(Trace.Level.INFO, "Customer " + id + " arrived:" + arrivetime);
        Trace.out(Trace.Level.INFO, "Customer " + id + " finished:" + finistime);
        Trace.out(Trace.Level.INFO, "Customer " + id + " delay:" + (finistime - arrivetime));
        sum += (finistime - arrivetime);
        double average = (double) sum / i;
        System.out.println("Average " + average);
        return average;
    }

    /**
     * Draws the customer on the specified graphics context at the specified location.
     *
     * @param gc The graphics context on which to draw the customer.
     * @param x  The x-coordinate of the drawing location.
     * @param y  The y-coordinate of the drawing location.
     */
    public void draw(GraphicsContext gc, int x, int y) {
        if (normalCustomer) {
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
        } else if (vipCustomer) {
            gc.setStroke(Color.GOLD);
            gc.strokeLine(x + 5, y, x + 5, y + 20);

            gc.setFill(Color.GOLD);
            gc.fillOval(x + 2, y - 5, 6, 6);

            gc.setStroke(Color.GOLD);
            gc.setLineWidth(2);
            gc.strokeLine(x + 5, y + 5, x - 3, y + 10);
            gc.strokeLine(x + 5, y + 5, x + 13, y + 10);

            gc.setStroke(Color.GOLD);
            gc.setLineWidth(2);
            gc.strokeLine(x + 5, y + 20, x + 3, y + 30);
            gc.strokeLine(x + 5, y + 20, x + 7, y + 30);
        }
    }

    /**
     * Removes the drawing of the customer on the specified graphics context
     * at the specified location.
     *
     * @param gc The graphics context from which to remove the drawing.
     * @param x  The x-coordinate of the removal location.
     * @param y  The y-coordinate of the removal location.
     */
    public void removeDraw(GraphicsContext gc, int x, int y) {
        gc.setFill(Color.TRANSPARENT);
        gc.fillOval(x, y, 5, 5);
        gc.setFill(Color.TRANSPARENT);
    }
}
