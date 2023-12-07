package simu.model;

import controller.IControllerForM;
import eduni.distributions.Negexp;
import eduni.distributions.Normal;
import entity.ResultDb;
import simu.framework.Clock;
import simu.framework.IEngine;
import simu.framework.Engine;
import simu.framework.ArrivalProcess;
import simu.framework.Event;
import dao.*;
import entity.*;
import view.IController;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;


public class MyEngine extends Engine{

    private ArrivalProcess arrivalProcess;

    private ResultDao ResultDao;

    private ResultDb ResultDb;

    private CustomerDao CustomerDao;

    private ServicePoint[] servicePoints;

    private int[] settings = {0,0,0,0}; // this will define how many servers


    public MyEngine(IControllerForM controller){

        super(controller);

        servicePoints = new ServicePoint[18];

        servicePoints[0]=new Security(new Normal(10,6), eventList, EventType.SECURITY1, 321, 392);
        servicePoints[1]=new Security(new Normal(10,6), eventList, EventType.SECURITY2, 265, 423);
        servicePoints[2]=new Security(new Normal(10,6), eventList, EventType.SECURITY3, 328, 430);
        servicePoints[3]=new Security(new Normal(10,6), eventList, EventType.SECURITY4, 270, 457);

        servicePoints[4]=new Ticket(new Normal(10,6), eventList, EventType.TICKET_SELL1, 263, 360);
        servicePoints[5]=new Ticket(new Normal(10,6), eventList, EventType.TICKET_SELL2, 234, 373);
        servicePoints[6]=new Ticket(new Normal(10,6), eventList, EventType.TICKET_SELL3, 201, 389);
        servicePoints[7]=new Ticket(new Normal(10,6), eventList, EventType.TICKET_SELL4, 166, 404);

        servicePoints[8]=new CheckIn(new Normal(10,6), eventList, EventType.CHECK_IN1, 308, 524);
        servicePoints[9]=new CheckIn(new Normal(10,6), eventList, EventType.CHECK_IN2, 324, 517);
        servicePoints[10]=new CheckIn(new Normal(10,6), eventList, EventType.CHECK_IN3, 342, 505);
        servicePoints[11]=new CheckIn(new Normal(10,6), eventList, EventType.CHECK_IN4, 387, 481);
        servicePoints[12]=new CheckIn(new Normal(10,6), eventList, EventType.CHECK_IN5, 387 , 481);

        servicePoints[13]=new Catering(new Normal(10,6), eventList, EventType.CATERING1, 321, 250);
        servicePoints[14]=new Catering(new Normal(10,6), eventList, EventType.CATERING2, 201, 389);
        servicePoints[15]=new Catering(new Normal(10,6), eventList, EventType.CATERING3, 166, 404);
        servicePoints[16]=new Catering(new Normal(10,6), eventList, EventType.CATERING4, 134, 422);

        servicePoints[17]=new NormalCustomer(new Normal(10,6), eventList, EventType.CUSTOMER_ARRIVAL, 257, 157);
        servicePoints[18]=new VipCustomer(new Normal(10,6), eventList, EventType.VIP_CUSTOMER_ARRIVAL, 51, 359);

        arrivalProcess = new ArrivalProcess(new Negexp(15,5), eventList, EventType.ARR1);

    }

    public void setSettings(int[] settings) {
        this.settings = settings;
    }

    public int[] getSettings() {
        return settings;
    }

    @Override
    public int getSimulationTime() {
        return 0;
    }


    @Override
    protected void covers() {
        arrivalProcess.generateNextEvent(); // First arrival to Simulation
        ResultDao = new ResultDao();
        Date date = Calendar.getInstance().getTime();
        DateFormat dateFormat = new SimpleDateFormat("yyyy-mm-dd hh:mm:ss");
        String strDate = dateFormat.format(date);
        ResultDb = new ResultDb(settings, strDate);
        ResultDao.persist(ResultDb);
        CustomerDao = new CustomerDao();
    }

    @Override
    protected void executeEvents(Event t) {
        Customer a;
        CustomerDao e;
        boolean linecheck;
        int j;
        switch ((EventType) t.getType()) {

            case ARR1:
                linecheck = true;
                j=0;
                while (linecheck) {

                    for (int i = 0; i < settings[0]; i++) {
                        if (servicePoints[i].GetJonoSize() == j) {
                            servicePoints[i].lisaaJonoon(new Customer());
                            System.out.println("Customer Added to line" + i);
                            linecheck = false;
                            break;
                        }
                    }
                    j++;
                }
                arrivalProcess.generateNextEvent();
                break;
            case SECURITY1:
                a = (Customer) servicePoints[0].otaJonosta(); //Customer moves from security to tickets
                if(!a.isVipCustomer()) {
                linecheck = true;
                j=0;
                while (linecheck) {

                    for (int i = 5; i < (5+settings[1]); i++) {
                        if (servicePoints[i].GetJonoSize() == j) {
                            servicePoints[i].lisaaJonoon(a);
                            System.out.println("Customer Added to Security number" + i);
                            linecheck = false;
                            break;
                        }
                    }
                    j++;
                }} else {
                    servicePoints[8].lisaaJonoon(a);
                }
                break;
            case SECURITY2:
                a = (Customer) servicePoints[1].otaJonosta(); //Customer moves from security to tickets
                if(!a.isVipCustomer()) {
                    linecheck = true;
                    j=0;
                    while (linecheck) {

                        for (int i = 5; i < (5+settings[1]); i++) {
                            if (servicePoints[i].GetJonoSize() == j) {
                                servicePoints[i].lisaaJonoon(a);
                                System.out.println("Customer Added to Security number" + i);
                                linecheck = false;
                                break;
                            }
                        }
                        j++;
                    }} else {
                    servicePoints[8].lisaaJonoon(a);
                }
                break;
            case SECURITY3:
                a = (Customer) servicePoints[2].otaJonosta(); //Customer moves from security to tickets
                if(!a.isVipCustomer()) {
                    linecheck = true;
                    j=0;
                    while (linecheck) {

                        for (int i = 5; i < (5+settings[1]); i++) {
                            if (servicePoints[i].GetJonoSize() == j) {
                                servicePoints[i].lisaaJonoon(a);
                                System.out.println("Customer Added to Security number" + i);
                                linecheck = false;
                                break;
                            }
                        }
                        j++;
                    }} else {
                    servicePoints[8].lisaaJonoon(a);
                }
                break;
            case SECURITY4:
                a = (Customer) servicePoints[3].otaJonosta(); //Customer moves from security to tickets
                if(!a.isVipCustomer()) {
                    linecheck = true;
                    j=0;
                    while (linecheck) {

                        for (int i = 5; i < (5+settings[1]); i++) {
                            if (servicePoints[i].GetJonoSize() == j) {
                                servicePoints[i].lisaaJonoon(a);
                                System.out.println("Customer Added to Security number" + i);
                                linecheck = false;
                                break;
                            }
                        }
                        j++;
                    }} else {
                    servicePoints[8].lisaaJonoon(a);
                }
                break;
            case TICKET_SELL1:
                a = (Customer) servicePoints[4].otaJonosta(); //Customer moves from Tickets to checkin
                if(!a.isVipCustomer()) {
                    linecheck = true;
                    j=0;
                    while (linecheck) {

                        for (int i = 10; i < (10+settings[2]); i++) {
                            if (servicePoints[i].GetJonoSize() == j) {
                                servicePoints[i].lisaaJonoon(a);
                                System.out.println("Customer added to Ticket Sells number" + i);
                                linecheck = false;
                                break;
                            }
                        }
                        j++;
                    }} else {
                    servicePoints[8].lisaaJonoon(a);
                }
                break;
            case TICKET_SELL2:
                a = (Customer) servicePoints[5].otaJonosta(); //Customer moves from Tickets to checkin
                if(!a.isVipCustomer()) {
                    linecheck = true;
                    j=0;
                    while (linecheck) {

                        for (int i = 10; i < (10+settings[2]); i++) {
                            if (servicePoints[i].GetJonoSize() == j) {
                                servicePoints[i].lisaaJonoon(a);
                                System.out.println("Customer added to Ticket Sells number" + i);
                                linecheck = false;
                                break;
                            }
                        }
                        j++;
                    }} else {
                    servicePoints[8].lisaaJonoon(a);
                }
                break;

            case TICKET_SELL3:
                a = (Customer) servicePoints[6].otaJonosta(); //Customer moves from Tickets to checkin
                if(!a.isVipCustomer()) {
                    linecheck = true;
                    j=0;
                    while (linecheck) {

                        for (int i = 10; i < (10+settings[2]); i++) {
                            if (servicePoints[i].GetJonoSize() == j) {
                                servicePoints[i].lisaaJonoon(a);
                                System.out.println("Customer added to Ticket Sells number" + i);
                                linecheck = false;
                                break;
                            }
                        }
                        j++;
                    }} else {
                    servicePoints[8].lisaaJonoon(a);
                }
                break;

            case TICKET_SELL4:
                a = (Customer) servicePoints[7].otaJonosta(); //Customer moves from Tickets to checkin
                if(!a.isVipCustomer()) {
                linecheck = true;
                j=0;
                while (linecheck) {

                    for (int i = 10; i < (10+settings[2]); i++) {
                        if (servicePoints[i].GetJonoSize() == j) {
                            servicePoints[i].lisaaJonoon(a);
                            System.out.println("Customer added to Ticket Sells number" + i);
                            linecheck = false;
                            break;
                        }
                    }
                    j++;
                }} else {
                    servicePoints[8].lisaaJonoon(a);
                }
                break;

            case CHECK_IN1:
                a = (Customer) servicePoints[8].otaJonosta(); //Customer moves from checkin to catering
                    linecheck = true;
                    j=0;
                    while (linecheck) {

                        for (int i = 10; i < (10+settings[3]); i++) {
                            if (servicePoints[i].GetJonoSize() == j) {
                                servicePoints[i].lisaaJonoon(a);
                                System.out.println("Customer Added to Check In number" + i);
                                linecheck = false;
                                break;
                            }
                        }
                        j++;
                }
                break;
            case CHECK_IN2:
                a = (Customer) servicePoints[9].otaJonosta(); //Customer moves from checkin to catering
                linecheck = true;
                j=0;
                while (linecheck) {

                    for (int i = 10; i < (10+settings[3]); i++) {
                        if (servicePoints[i].GetJonoSize() == j) {
                            servicePoints[i].lisaaJonoon(a);
                            System.out.println("Customer Added to Check In number" + i);
                            linecheck = false;
                            break;
                        }
                    }
                    j++;
                }
                break;

            case CHECK_IN3:
                a = (Customer) servicePoints[10].otaJonosta(); //Customer moves from checkin to catering
                linecheck = true;
                j=0;
                while (linecheck) {

                    for (int i = 10; i < (10+settings[3]); i++) {
                        if (servicePoints[i].GetJonoSize() == j) {
                            servicePoints[i].lisaaJonoon(a);
                            System.out.println("Customer Added to Check In number" + i);
                            linecheck = false;
                            break;
                        }
                    }
                    j++;
                }
                break;

            case CHECK_IN4:
                a = (Customer) servicePoints[11].otaJonosta(); //Customer moves from checkin to catering
                linecheck = true;
                j=0;
                while (linecheck) {

                    for (int i = 10; i < (10+settings[3]); i++) {
                        if (servicePoints[i].GetJonoSize() == j) {
                            servicePoints[i].lisaaJonoon(a);
                            System.out.println("Customer Added to Check In number" + i);
                            linecheck = false;
                            break;
                        }
                    }
                    j++;
                }
                break;

            case CHECK_IN5:
                a = (Customer) servicePoints[12].otaJonosta(); //Customer moves from checkin to catering
                linecheck = true;
                j=0;
                while (linecheck) {

                    for (int i = 10; i < (10+settings[3]); i++) {
                        if (servicePoints[i].GetJonoSize() == j) {
                            servicePoints[i].lisaaJonoon(a);
                            System.out.println("Customer Added to Check In number" + i);
                            linecheck = false;
                            break;
                        }
                    }
                    j++;
                }
                break;
            case CATERING1:
                a = (Customer) servicePoints[13].otaJonosta();
                if (!a.isVipCustomer()) {
                    servicePoints[17].lisaaJonoon(a);
                } else {
                    servicePoints[18].lisaaJonoon(a);
                }
                break;
            case CATERING2:
                a = (Customer) servicePoints[14].otaJonosta();
                if (!a.isVipCustomer()) {
                    servicePoints[17].lisaaJonoon(a);
                } else {
                    servicePoints[18].lisaaJonoon(a);
                }
                break;
            case CATERING3:
                a = (Customer) servicePoints[15].otaJonosta();
                if (!a.isVipCustomer()) {
                    servicePoints[17].lisaaJonoon(a);
                } else {
                    servicePoints[18].lisaaJonoon(a);
                }
                break;
            case CATERING4:
                a = (Customer) servicePoints[16].otaJonosta();
                if (!a.isVipCustomer()) {
                    servicePoints[17].lisaaJonoon(a);
                } else {
                    servicePoints[18].lisaaJonoon(a);
                }
                break;
            case CUSTOMER_ARRIVAL:
                a = (Customer) servicePoints[17].otaJonosta(); //Customer Removed from Simulator
                a.setRemovalTime(Clock.getInstance().getClock());
                e = new CustomerDao(a, this.ResultDb.getId());
                CustomerDao.persist(e);
                a.raportti();
            case VIP_CUSTOMER_ARRIVAL:
                a = (Asiakas) servicePoints[18].otaJonosta(); //Customer Removed from Simulator
                a.setRemovalTime(Clock.getInstance().getClock());
                e = new AsiakasE(a, this.simulaatio.getId());
                AsiakasDao.persist(e);
                simulaatio.setAv_time(a.raportti());
                simulaatio.setCustomers(Asiakas.getCount());
                simulaatio.setTime(Kello.getInstance().getAika());
                SimuDao.update(simulaatio);
                a.raportti();

        }
    }

    @Override
    protected void yritaCTapahtumat(){
        for (Palvelupiste p: servicePoints){
            if (!p.onVarattu() && p.onJonossa()){
                p.aloitaPalvelu();
            }
        }
    }

    public Palvelupiste[] getservicePoints() {
        return servicePoints;
    }

    @Override
    protected void tulokset() {
        System.out.println("Simulointi päättyi kello " + Kello.getInstance().getAika());
        System.out.println("Tulokset ... puuttuvat vielä");
        System.out.println("Asiakkaita saapui " + Asiakas.getCount());

        // UUTTA graafista
        kontrolleri.naytaLoppuaika(Kello.getInstance().getAika());
    }
}