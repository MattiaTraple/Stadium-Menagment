package view;

import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.image.Image;
import javafx.scene.paint.Color;
import simu.model.Customer;
import simu.model.ServicePoint;

public class NewCustomer implements INewCustomer {
    Controller controller;
    private final Canvas canvas;
    private final GraphicsContext gc;

    public NewCustomer(Controller controller, Canvas canvas) {
        this.controller = controller;
        this.canvas = canvas;
        gc = this.canvas.getGraphicsContext2D();
    }

    public GraphicsContext getGc() {
        return gc;
    }

    public void emptyscreen() {
        gc.setFill(Color.YELLOW);
    }

    public void CustomerNew() {
        int index = 1;
        int x = 0;
        int y = 0;

        for (ServicePoint p : controller.getservicePoints()) {
            for (Customer customer : p.getLineCustomers()) {
                customer.draw(gc, p.getX() + x, p.getY() + y);
                x+= 8;
                y+= 3;
                customer.removeDraw(gc, p.getX() + x, p.getY() + y);
            }
        }
    }
}
