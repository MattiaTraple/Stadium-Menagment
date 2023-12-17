package view;

import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.image.Image;
import javafx.scene.paint.Color;
import simu.model.Customer;
import simu.model.ServicePoint;

/**
 * The NewCustomer class is responsible for managing the display of customers
 * on the simulation canvas. It implements the INewCustomer interface and
 * works in conjunction with a Controller to obtain information about the
 * service points and their customers.
 */
public class NewCustomer implements INewCustomer {
    Controller controller;
    private final Canvas canvas;
    private final GraphicsContext gc;

    /**
     * Constructs a new NewCustomer instance with the specified controller
     * and canvas for displaying customers.
     *
     * @param controller The controller managing the simulation.
     * @param canvas     The canvas for displaying customers.
     */
    public NewCustomer(Controller controller, Canvas canvas) {
        this.controller = controller;
        this.canvas = canvas;
        gc = this.canvas.getGraphicsContext2D();
    }

    /**
     * Gets the graphics context associated with the canvas.
     *
     * @return The GraphicsContext for the canvas.
     */
    public GraphicsContext getGc() {
        return gc;
    }

    /**
     * Fills the entire canvas with a yellow color, representing an empty screen.
     */
    public void emptyscreen() {
        gc.setFill(Color.YELLOW);
    }

    /**
     * Displays new customers on the canvas based on the current state of
     * the service points and their customer queues.
     */
    public void CustomerNew() {
        int index = 1;
        int x = 0;
        int y = 0;

        for (ServicePoint p : controller.getservicePoints()) {
            for (Customer customer : p.getLineCustomers()) {
                customer.draw(gc, p.getX() + x, p.getY() + y);
                x += 8;
                y += 3;
                customer.removeDraw(gc, p.getX() + x, p.getY() + y);
            }
        }
    }
}
