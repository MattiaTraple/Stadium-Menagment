package view;

import controller.IControllerForM;
import controller.IControllerForV;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.control.Button;
import javafx.scene.control.MenuItem;
import javafx.scene.control.TextField;
import javafx.scene.image.ImageView;
import javafx.stage.Stage;
import simu.framework.IEngine;
import simu.framework.Clock;
import simu.framework.Trace;
import simu.model.Customer;
import simu.model.MyEngine;
import simu.model.ServicePoint;

import javafx.scene.canvas.Canvas;


public class Controller implements IControllerForM, IControllerForV {
    private Customer customer;
    private IEngine engine;
    private IController ui;
    private IControllerForV controller;

    @FXML
    private TextField textFieldTime;
    @FXML
    private TextField textFieldDelay;
    @FXML
    private Button buttonFaster;
    @FXML
    private Button buttonSlower;
    @FXML
    private Button buttonPlusSecurity;
    @FXML
    private Button buttonMinusSecurity;
    @FXML
    private Button buttonPlusTicketSells;
    @FXML
    private Button buttonMinusTicketSells;
    @FXML
    private Button buttonPlusCheck;
    @FXML
    private Button buttonMinusCheck;
    @FXML
    private Button buttonPlusCateringService;
    @FXML
    private Button buttonMinusCateringService;
    @FXML
    private ImageView security1;
    @FXML
    private ImageView security2;
    @FXML
    private ImageView security3;
    @FXML
    private ImageView security4;
    @FXML
    private ImageView security5;
    @FXML
    ImageView ticket1;
    @FXML
    ImageView ticket2;
    @FXML
    ImageView ticket3;
    @FXML
    ImageView ticket4;
    @FXML
    private ImageView checkin1;
    @FXML
    private ImageView checkin2;
    @FXML
    private ImageView checkin3;
    @FXML
    private ImageView checkin4;
    @FXML
    private ImageView checkin5;
    @FXML
    ImageView cashier1;
    @FXML
    ImageView cashier2;
    @FXML
    ImageView cashier3;
    @FXML
    ImageView cashier4;

    @FXML
    MenuItem startButton;

    @FXML
    MenuItem results;
    @FXML
    Canvas canvasy;


    int ticketTimes = 4;
    int securityTimes = 5;
    int checkinTimes = 5;
    int cateringTimes = 4;


    @FXML
    public synchronized void buttonMinusSecurity() {
        buttonMinusSecurity.setOnAction(e -> {
            if (securityTimes == 1) {
                security1.setVisible(false);
                System.out.println("Security minus button pressed " + securityTimes);
                securityTimes = 1;
            } else if (securityTimes == 2) {
                security2.setVisible(false);
                System.out.println("Security  minus button pressed " + securityTimes);
                securityTimes = 2;
            } else if (securityTimes == 3) {
                security3.setVisible(false);
                System.out.println("Security  minus button pressed " + securityTimes);
                securityTimes = 3;
            } else if (securityTimes == 4) {
                security4.setVisible(false);
                System.out.println("Security  minus button pressed " + securityTimes);
                securityTimes = 4;
            } else if (securityTimes == 5) {
                security5.setVisible(false);
                System.out.println("Security  minus button pressed " + securityTimes);
                securityTimes = 5;
            }
            if (securityTimes > 0) {
                securityTimes--;
            }
        });
    }

    @FXML
    public synchronized void buttonPlusSecurity() {
        buttonPlusSecurity.setOnAction(e -> {
            if (securityTimes == 5) {
                security5.setVisible(true);
                System.out.println("Security  plus button pressed " + securityTimes);
                securityTimes = 5;
            } else if (securityTimes == 4) {
                security4.setVisible(true);
                System.out.println("Security  plus button pressed " + securityTimes);
                securityTimes = 4;
            } else if (securityTimes == 3) {
                security3.setVisible(true);
                System.out.println("Security  plus button pressed " + securityTimes);
                securityTimes = 3;
            } else if (securityTimes == 2) {
                security2.setVisible(true);
                System.out.println("Security  plus button pressed "  + securityTimes);
                securityTimes = 2;
            } else if (securityTimes == 1) {
                security1.setVisible(true);
                System.out.println("Security  plus button pressed " + securityTimes);
                securityTimes = 1;
            }
            if (securityTimes < 5) {
                securityTimes++;
            }
        });
    }
    @FXML
    public synchronized void buttonMinusCatering() {
        buttonMinusCateringService.setOnAction(e -> {
            if (cateringTimes == 1) {
                cashier1.setVisible(false);
                System.out.println("Catering minus button pressed " + cateringTimes);
                cateringTimes = 1;
            } else if (cateringTimes == 2) {
                cashier2.setVisible(false);
                System.out.println("Catering minus button pressed " + cateringTimes);
                cateringTimes = 2;
            } else if (cateringTimes == 3) {
                cashier3.setVisible(false);
                System.out.println("Catering minus button pressed " + cateringTimes);
                cateringTimes = 3;
            } else if (cateringTimes == 4) {
                cashier4.setVisible(false);
                System.out.println("Catering minus button pressed " + cateringTimes);
                cateringTimes = 4;
            }
            if (cateringTimes > 0) {
                cateringTimes--;
            }
        });
    }
    @FXML
    public synchronized void buttonPlusCatering() {
        buttonPlusCateringService.setOnAction(e -> {
            if (cateringTimes == 4) {
                cashier4.setVisible(true);
                System.out.println("Catering plus button pressed " + cateringTimes);
                cateringTimes = 4;
            } else if (cateringTimes == 3) {
                cashier3.setVisible(true);
                System.out.println("Catering plus button pressed " + cateringTimes);
                cateringTimes = 3;
            } else if (cateringTimes == 2) {
                cashier2.setVisible(true);
                System.out.println("Catering plus button pressed " + cateringTimes);
                cateringTimes =2;
            } else if (cateringTimes == 1) {
                cashier1.setVisible(true);
                System.out.println("Catering plus button pressed " + cateringTimes);
                cateringTimes = 1;
            }
            if (cateringTimes < 5) {
                cateringTimes++;
            }
        });
    }



    @FXML
    public synchronized void ButtonMinusCheckIn() {
        buttonMinusCheck.setOnAction(e -> {
            if (checkinTimes == 1) {
                checkin1.setVisible(false);
                System.out.println("Check-IN minus button pressed" + checkinTimes);
                checkinTimes = 1;
            } else if (checkinTimes == 2) {
                checkin2.setVisible(false);
                System.out.println("Check-IN minus button pressed" + checkinTimes);
                checkinTimes = 2;
            } else if (checkinTimes == 3) {
                checkin3.setVisible(false);
                System.out.println("Check-IN minus button pressed" + checkinTimes);
                checkinTimes = 3;
            } else if (checkinTimes == 4) {
                checkin4.setVisible(false);
                System.out.println("Check-IN minus button pressed" + checkinTimes);
                checkinTimes = 4;
            } else if (checkinTimes == 5) {
                checkin5.setVisible(false);
                System.out.println("Check-IN minus button pressed" + checkinTimes);
                checkinTimes = 5;
            }
            if (checkinTimes > 0) {
                checkinTimes--;
            }
        });
    }

    @FXML
    public synchronized void ButtonPlusCheckIn() {
        buttonPlusCheck.setOnAction(e -> {
            if (checkinTimes == 1) {
                checkin1.setVisible(true);
                checkinTimes = 1;
                System.out.println("Check-IN plus button pressed" + checkinTimes);
            } else if (checkinTimes == 2) {
                checkin2.setVisible(true);
                checkinTimes = 2;
                System.out.println("Check-IN plus button pressed" + checkinTimes);
            } else if (checkinTimes == 3) {
                checkin3.setVisible(true);
                checkinTimes = 3;
                System.out.println("Check-IN plus button pressed" + checkinTimes);
            } else if (checkinTimes == 4) {
                checkin4.setVisible(true);
                checkinTimes = 4;
                System.out.println("Check-IN plus button pressed" + checkinTimes);
            } else if (checkinTimes == 5) {
                checkin5.setVisible(true);
                checkinTimes = 5;
                System.out.println("Check-IN plus button pressed" + checkinTimes);
            }
            if (checkinTimes < 5) {
                checkinTimes++;
            }
        });
    }

    @FXML
    public synchronized void ButtonMinusTicket() {
        buttonMinusTicketSells.setOnAction(e -> {
            if (ticketTimes == 1) {
                ticket1.setVisible(false);
                ticketTimes = 1;
                System.out.println("Ticket Sells minus button pressed" + ticketTimes);

            } else if (ticketTimes == 2) {
                ticket2.setVisible(false);
                ticketTimes = 2;
                System.out.println("Ticket Sells minus button pressed" + ticketTimes);

            } else if (ticketTimes == 3) {
                ticket3.setVisible(false);
                ticketTimes = 3;
                System.out.println("Ticket Sells minus button pressed" + ticketTimes);

            } else if (ticketTimes == 4) {
                ticket4.setVisible(false);
                ticketTimes = 4;
                System.out.println("Ticket Sells minus button pressed" + ticketTimes);

            } if (ticketTimes > 0) {
                ticketTimes--;
            }
        });
    }

    @FXML
    public synchronized void ButtonPlusTicket() {
        buttonPlusTicketSells.setOnAction(e -> {
            if (ticketTimes == 1) {
                ticket1.setVisible(true);
                ticketTimes = 1;
                System.out.println("Ticket Sells plus button pressed" + ticketTimes);

            } else if (ticketTimes == 2) {
                ticket2.setVisible(true);
                ticketTimes = 2;
                System.out.println("Ticket Sells plus button pressed" + ticketTimes);

            } else if (ticketTimes == 3) {
                ticket3.setVisible(true);
                ticketTimes = 3;
                System.out.println("Ticket Sells plus button pressed" + ticketTimes);

            } else if (ticketTimes == 4) {
                ticket4.setVisible(true);
                ticketTimes = 4;
                System.out.println("Ticket Sells plus button pressed" + ticketTimes);

            } if (ticketTimes < 5) {
                ticketTimes++;
            }
        });
    }

    @FXML
    public void buttonSlower() {
        buttonSlower.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                slower();
            }
        });

    }
    @FXML
    public void buttonFaster() {
        buttonFaster.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                faster();
            }
        });
    }

    public ServicePoint[] getservicePoints() {
        return ((MyEngine) engine).getservicePoints();
    }

    @FXML
    private void start(ActionEvent event) {
        Clock.getInstance().setClock(0);
        engine = new MyEngine(this);
        engine.setSimulationTime(Double.parseDouble(textFieldTime.getText()));
        engine.setDelay(Integer.parseInt(textFieldDelay.getText()));
        engine.setSettings(new int[]{securityTimes, ticketTimes, checkinTimes, cateringTimes});
        System.out.println(engine.getSettings()[0]);
        System.out.println(engine.getSettings()[1]);
        System.out.println(engine.getSettings()[2]);
        System.out.println(engine.getSettings()[3]);
        ((Thread) engine).start();
        Trace.setTraceLevel(Trace.Level.INFO);
        Thread thread = new Thread(new Runnable() {
            @Override
            public synchronized void run() {
                while (true) {
                    System.out.println("New Customer");
                    try {
                        Thread.sleep(1000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        });
        thread.start();
    }


    @FXML
    private void results(ActionEvent event){
        try {
            FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("/results.fxml"));
            Parent root1 = (Parent) fxmlLoader.load();
            Stage stage = new Stage();
            stage.setTitle("Results");
            stage.setScene(new javafx.scene.Scene(root1));
            stage.show();
        } catch(Exception e) {
            e.printStackTrace();
        }
    }



    @Override
    public void showtotaltime(double time) {
    }


    @Override
    public void startsimulation() {
    }


    @Override
    public void faster() {
        engine.setDelay((long) (engine.getDelay() * 0.9));
    }

    @Override
    public void slower() {
        engine.setDelay((long) (engine.getDelay() * 1.10));
    }
}

