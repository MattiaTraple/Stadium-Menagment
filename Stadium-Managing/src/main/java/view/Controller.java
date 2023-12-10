package view;

import controller.IControllerForM;
import controller.IControllerForV;
import javafx.animation.TranslateTransition;
import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.control.Button;
import javafx.scene.control.MenuButton;
import javafx.scene.control.MenuItem;
import javafx.scene.control.TextField;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.scene.shape.Circle;
import javafx.stage.Stage;
import javafx.stage.WindowEvent;
import javafx.util.Duration;
import simu.framework.IEngine;
import simu.framework.Clock;
import simu.framework.Trace;
import simu.model.Customer;
import simu.model.MyEngine;
import simu.model.ServicePoint;
import java.awt.*;
import javafx.scene.canvas.Canvas;


public class Controller implements IControllerForM, IControllerForV {
    private Customer customer;
    private IEngine engine;
    private IController ui;
    private IControllerForV controller;

    @FXML
    private TextField textFieldAika;
    @FXML
    private TextField textFieldViive;
    @FXML
    private Button buttonNopeuta;
    @FXML
    private Button buttonHidasta;
    @FXML
    private Button buttonKaynnista;
    @FXML
    private Button buttonPlus;
    @FXML
    private Button buttonMinus;
    @FXML
    private Button buttonPlusSecurity;
    @FXML
    private Button buttonMinusSecurity;
    @FXML
    private Button buttonPlusPassport;
    @FXML
    private Button buttonPlusDutyFree;
    @FXML
    private Button buttonMinusDutyFree;
    @FXML
    private Button buttonMinusPassport;
    @FXML
    private ImageView counter1;
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
    private ImageView security6;
    @FXML
    private ImageView counter2;
    @FXML
    private ImageView counter3;
    @FXML
    private ImageView counter4;
    @FXML
    MenuButton Selection;
    @FXML
    MenuItem CheckINSelection;
    @FXML
    MenuItem SecuritySelection;
    @FXML
    MenuItem PassportSelection;
    @FXML
    MenuItem DutySelection;
    @FXML
    AnchorPane ContentSecurity;
    @FXML
    AnchorPane ContentDuty;
    @FXML
    AnchorPane checkinContent;
    @FXML
    AnchorPane ContentPassport;
    @FXML
    ImageView cashier1;
    @FXML
    ImageView cashier2;
    @FXML
    ImageView cashier3;
    @FXML
    ImageView cashier4;

    @FXML
    ImageView control1;
    @FXML
    ImageView control2;
    @FXML
    ImageView control3;
    @FXML
    ImageView control4;
    @FXML
    ImageView control5;
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
                System.out.println("Check-IN minus button pressed" + securityTimes);
                securityTimes = 1;
            } else if (securityTimes == 2) {
                security2.setVisible(false);
                System.out.println("Check-IN minus button pressed" + securityTimes);
                securityTimes = 2;
            } else if (securityTimes == 3) {
                security3.setVisible(false);
                System.out.println("Check-IN minus button pressed" + securityTimes);
                securityTimes = 3;
            } else if (securityTimes == 4) {
                security4.setVisible(false);
                System.out.println("Check-IN minus button pressed" + securityTimes);
                securityTimes = 4;
            } else if (securityTimes == 5) {
                security5.setVisible(false);
                System.out.println("Check-IN minus button pressed" + securityTimes);
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
                System.out.println("Check-IN plus button pressed" + securityTimes);
                securityTimes = 5;
            } else if (securityTimes == 4) {
                security4.setVisible(true);
                System.out.println("Check-IN plus button pressed" + securityTimes);
                securityTimes = 4;
            } else if (securityTimes == 3) {
                security3.setVisible(true);
                System.out.println("Check-IN plus button pressed" + securityTimes);
                securityTimes = 3;
            } else if (securityTimes == 2) {
                security2.setVisible(true);
                System.out.println("Check-IN plus button pressed" + securityTimes);
                securityTimes = 2;
            } else if (securityTimes == 1) {
                security1.setVisible(true);
                System.out.println("Check-IN plus button pressed" + securityTimes);
                securityTimes = 1;
            }
            if (securityTimes < 5) {
                securityTimes++;
            }
        });
    }

    public synchronized void buttonMinusDuty() {
        buttonMinusDutyFree.setOnAction(e -> {
            if (cateringTimes == 1) {
                cashier1.setVisible(false);
                System.out.println("Check-IN minus button pressed" + cateringTimes);
                cateringTimes = 1;
            } else if (cateringTimes == 2) {
                cashier2.setVisible(false);
                System.out.println("Check-IN minus button pressed" + cateringTimes);
                cateringTimes = 2;
            } else if (cateringTimes == 3) {
                cashier3.setVisible(false);
                System.out.println("Check-IN minus button pressed" + cateringTimes);
                cateringTimes = 3;
            } else if (cateringTimes == 4) {
                cashier4.setVisible(false);
                System.out.println("Check-IN minus button pressed" + cateringTimes);
                cateringTimes = 4;
            }
            if (cateringTimes > 0) {
                cateringTimes--;
            }
        });
    }

    @FXML
    public synchronized void buttonPlusDuty() {
        buttonPlusDutyFree.setOnAction(e -> {
            if (ticketTimes == 0) {
                cashier1.setVisible(true);
                System.out.println("Duty plus button pressed" + ticketTimes);
            } else if (ticketTimes == 1) {
                cashier2.setVisible(true);
                System.out.println("Duty plus button pressed" + ticketTimes);
            } else if (ticketTimes == 2) {
                cashier3.setVisible(true);
                System.out.println("Duty plus button pressed" + ticketTimes);
            } else if (ticketTimes < 0) {
                ticketTimes = 0;
            }
            ticketTimes--;
        });
    }

    @FXML
    public synchronized void ButtonMinusCheckIn() {
        buttonMinus.setOnAction(e -> {
            if (checkinTimes == 1) {
                counter4.setVisible(false);
                checkinTimes = 1;
            } else if (checkinTimes == 2) {
                counter3.setVisible(false);
                checkinTimes = 2;
            } else if (checkinTimes == 3) {
                counter2.setVisible(false);
                checkinTimes = 3;
            } else if (checkinTimes == 4) {
                counter1.setVisible(false);
                checkinTimes = 4;
                System.out.println("Check-IN minus button pressed" + checkinTimes);
            } if (checkinTimes > 0) {
                checkinTimes--;
            }
        });
    }

    @FXML
    public synchronized void ButtonPlusCheckIn() {
        buttonPlus.setOnAction(e -> {
            if (checkinTimes == 1) {
                counter4.setVisible(true);
                checkinTimes = 1;
            } else if (checkinTimes == 2) {
                counter3.setVisible(true);
                checkinTimes = 2;
            } else if (checkinTimes == 3) {
                counter2.setVisible(true);
                checkinTimes = 3;
            } else if (checkinTimes == 4) {
                counter1.setVisible(true);
                checkinTimes = 4;
                System.out.println("Check-IN plus button pressed" + checkinTimes);
            } if (securityTimes < 5) {
                securityTimes++;
            }
        });
    }

    @FXML
    public synchronized void ButtonMinusPassport() {
        buttonMinusPassport.setOnAction(e -> {
            if (cateringTimes == 1) {
                control5.setVisible(false);
                cateringTimes = 1;
            } else if (cateringTimes == 2) {
                control4.setVisible(false);
                cateringTimes = 2;
            } else if (cateringTimes == 3) {
                control3.setVisible(false);
                cateringTimes = 3;
            } else if (cateringTimes == 4) {
                control2.setVisible(false);
                cateringTimes = 4;
            } else if (cateringTimes == 5) {
                control1.setVisible(false);
                cateringTimes = 5;
            } if (cateringTimes > 0) {
                cateringTimes--;
            }
        });
    }

    @FXML
    public synchronized void ButtonPlusPassport() {
        buttonPlusPassport.setOnAction(e -> {
            if (cateringTimes == 1) {
                control5.setVisible(true);
                cateringTimes = 1;
            } else if (cateringTimes == 2) {
                control4.setVisible(true);
                cateringTimes = 2;
            } else if (cateringTimes == 3) {
                control3.setVisible(true);
                cateringTimes = 3;
            } else if (cateringTimes == 4) {
                control2.setVisible(true);
                cateringTimes = 4;
            } else if (cateringTimes == 5) {
                control1.setVisible(true);
                cateringTimes = 5;
            } if (cateringTimes < 5) {
                cateringTimes++;
            }
        });
    }

    @FXML
    public void buttonHidasta() {
        buttonHidasta.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                slower();
            }
        });

    }
    @FXML
    public void buttonNopeuta() {
        buttonNopeuta.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                faster();
            }
        });
    }

    @FXML
    private void aloita(ActionEvent event) {
        Clock.getInstance().setClock(0);
        engine = new MyEngine(this);
        engine.setSimulationTime(Integer.parseInt(textFieldAika.getText()));
        engine.setDelay(Integer.parseInt(textFieldViive.getText()));
        engine.setSettings(new int[]{checkinTimes, securityTimes, cateringTimes});
        System.out.println(engine.getSettings()[0]);
        System.out.println(engine.getSettings()[1]);
        System.out.println(engine.getSettings()[2]);
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
    public void showtotaltime(double aika) {
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
