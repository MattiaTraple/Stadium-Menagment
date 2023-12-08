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
        CustomerDb e;
        boolean linecheck;
        int j;
        switch ((EventType) t.getType()) {

            case ARR1:
                linecheck = true;
                j=0;
                while (linecheck) {

                    for (int i = 0; i < settings[0]; i++) {
                        if (servicePoints[i].GetLineSize() == j) {
                            servicePoints[i].AddToTheLine(new Customer());
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
                a = (Customer) servicePoints[0].TakeFromTheLine(); //Customer moves from security to tickets
                if(!a.isVipCustomer()) {
                linecheck = true;
                j=0;
                while (linecheck) {

                    for (int i = 5; i < (5+settings[1]); i++) {
                        if (servicePoints[i].GetLineSize() == j) {
                            servicePoints[i].AddToTheLine(a);
                            System.out.println("Customer Added to Security number" + i);
                            linecheck = false;
                            break;
                        }
                    }
                    j++;
                }} else {
                    servicePoints[8].AddToTheLine(a);
                }
                break;
            case SECURITY2:
                a = (Customer) servicePoints[1].TakeFromTheLine(); //Customer moves from security to tickets
                if(!a.isVipCustomer()) {
                    linecheck = true;
                    j=0;
                    while (linecheck) {

                        for (int i = 5; i < (5+settings[1]); i++) {
                            if (servicePoints[i].GetLineSize() == j) {
                                servicePoints[i].AddToTheLine(a);
                                System.out.println("Customer Added to Security number" + i);
                                linecheck = false;
                                break;
                            }
                        }
                        j++;
                    }} else {
                    servicePoints[8].AddToTheLine(a);
                }
                break;
            case SECURITY3:
                a = (Customer) servicePoints[2].TakeFromTheLine(); //Customer moves from security to tickets
                if(!a.isVipCustomer()) {
                    linecheck = true;
                    j=0;
                    while (linecheck) {

                        for (int i = 5; i < (5+settings[1]); i++) {
                            if (servicePoints[i].GetLineSize() == j) {
                                servicePoints[i].AddToTheLine(a);
                                System.out.println("Customer Added to Security number" + i);
                                linecheck = false;
                                break;
                            }
                        }
                        j++;
                    }} else {
                    servicePoints[8].AddToTheLine(a);
                }
                break;
            case SECURITY4:
                a = (Customer) servicePoints[3].TakeFromTheLine(); //Customer moves from security to tickets
                if(!a.isVipCustomer()) {
                    linecheck = true;
                    j=0;
                    while (linecheck) {

                        for (int i = 5; i < (5+settings[1]); i++) {
                            if (servicePoints[i].GetLineSize() == j) {
                                servicePoints[i].AddToTheLine(a);
                                System.out.println("Customer Added to Security number" + i);
                                linecheck = false;
                                break;
                            }
                        }
                        j++;
                    }} else {
                    servicePoints[8].AddToTheLine(a);
                }
                break;
            case TICKET_SELL1:
                a = (Customer) servicePoints[4].TakeFromTheLine(); //Customer moves from Tickets to checkin
                if(!a.isVipCustomer()) {
                    linecheck = true;
                    j=0;
                    while (linecheck) {

                        for (int i = 10; i < (10+settings[2]); i++) {
                            if (servicePoints[i].GetLineSize() == j) {
                                servicePoints[i].AddToTheLine(a);
                                System.out.println("Customer added to Ticket Sells number" + i);
                                linecheck = false;
                                break;
                            }
                        }
                        j++;
                    }} else {
                    servicePoints[8].AddToTheLine(a);
                }
                break;
            case TICKET_SELL2:
                a = (Customer) servicePoints[5].TakeFromTheLine(); //Customer moves from Tickets to checkin
                if(!a.isVipCustomer()) {
                    linecheck = true;
                    j=0;
                    while (linecheck) {

                        for (int i = 10; i < (10+settings[2]); i++) {
                            if (servicePoints[i].GetLineSize() == j) {
                                servicePoints[i].AddToTheLine(a);
                                System.out.println("Customer added to Ticket Sells number" + i);
                                linecheck = false;
                                break;
                            }
                        }
                        j++;
                    }} else {
                    servicePoints[8].AddToTheLine(a);
                }
                break;

            case TICKET_SELL3:
                a = (Customer) servicePoints[6].TakeFromTheLine(); //Customer moves from Tickets to checkin
                if(!a.isVipCustomer()) {
                    linecheck = true;
                    j=0;
                    while (linecheck) {

                        for (int i = 10; i < (10+settings[2]); i++) {
                            if (servicePoints[i].GetLineSize() == j) {
                                servicePoints[i].AddToTheLine(a);
                                System.out.println("Customer added to Ticket Sells number" + i);
                                linecheck = false;
                                break;
                            }
                        }
                        j++;
                    }} else {
                    servicePoints[8].AddToTheLine(a);
                }
                break;

            case TICKET_SELL4:
                a = (Customer) servicePoints[7].TakeFromTheLine(); //Customer moves from Tickets to checkin
                if(!a.isVipCustomer()) {
                linecheck = true;
                j=0;
                while (linecheck) {

                    for (int i = 10; i < (10+settings[2]); i++) {
                        if (servicePoints[i].GetLineSize() == j) {
                            servicePoints[i].AddToTheLine(a);
                            System.out.println("Customer added to Ticket Sells number" + i);
                            linecheck = false;
                            break;
                        }
                    }
                    j++;
                }} else {
                    servicePoints[8].AddToTheLine(a);
                }
                break;

            case CHECK_IN1:
                a = (Customer) servicePoints[8].TakeFromTheLine(); //Customer moves from checkin to catering
                    linecheck = true;
                    j=0;
                    while (linecheck) {

                        for (int i = 10; i < (10+settings[3]); i++) {
                            if (servicePoints[i].GetLineSize() == j) {
                                servicePoints[i].AddToTheLine(a);
                                System.out.println("Customer Added to Check In number" + i);
                                linecheck = false;
                                break;
                            }
                        }
                        j++;
                }
                break;
            case CHECK_IN2:
                a = (Customer) servicePoints[9].TakeFromTheLine(); //Customer moves from checkin to catering
                linecheck = true;
                j=0;
                while (linecheck) {

                    for (int i = 10; i < (10+settings[3]); i++) {
                        if (servicePoints[i].GetLineSize() == j) {
                            servicePoints[i].AddToTheLine(a);
                            System.out.println("Customer Added to Check In number" + i);
                            linecheck = false;
                            break;
                        }
                    }
                    j++;
                }
                break;

            case CHECK_IN3:
                a = (Customer) servicePoints[10].TakeFromTheLine(); //Customer moves from checkin to catering
                linecheck = true;
                j=0;
                while (linecheck) {

                    for (int i = 10; i < (10+settings[3]); i++) {
                        if (servicePoints[i].GetLineSize() == j) {
                            servicePoints[i].AddToTheLine(a);
                            System.out.println("Customer Added to Check In number" + i);
                            linecheck = false;
                            break;
                        }
                    }
                    j++;
                }
                break;

            case CHECK_IN4:
                a = (Customer) servicePoints[11].TakeFromTheLine(); //Customer moves from checkin to catering
                linecheck = true;
                j=0;
                while (linecheck) {

                    for (int i = 10; i < (10+settings[3]); i++) {
                        if (servicePoints[i].GetLineSize() == j) {
                            servicePoints[i].AddToTheLine(a);
                            System.out.println("Customer Added to Check In number" + i);
                            linecheck = false;
                            break;
                        }
                    }
                    j++;
                }
                break;

            case CHECK_IN5:
                a = (Customer) servicePoints[12].TakeFromTheLine(); //Customer moves from checkin to catering
                linecheck = true;
                j=0;
                while (linecheck) {

                    for (int i = 10; i < (10+settings[3]); i++) {
                        if (servicePoints[i].GetLineSize() == j) {
                            servicePoints[i].AddToTheLine(a);
                            System.out.println("Customer Added to Check In number" + i);
                            linecheck = false;
                            break;
                        }
                    }
                    j++;
                }
                break;
            case CATERING1:
                a = (Customer) servicePoints[13].TakeFromTheLine();
                if (!a.isVipCustomer()) {
                    servicePoints[17].AddToTheLine(a);
                } else {
                    servicePoints[18].AddToTheLine(a);
                }
                break;
            case CATERING2:
                a = (Customer) servicePoints[14].TakeFromTheLine();
                if (!a.isVipCustomer()) {
                    servicePoints[17].AddToTheLine(a);
                } else {
                    servicePoints[18].AddToTheLine(a);
                }
                break;
            case CATERING3:
                a = (Customer) servicePoints[15].TakeFromTheLine();
                if (!a.isVipCustomer()) {
                    servicePoints[17].AddToTheLine(a);
                } else {
                    servicePoints[18].AddToTheLine(a);
                }
                break;
            case CATERING4:
                a = (Customer) servicePoints[16].TakeFromTheLine();
                if (!a.isVipCustomer()) {
                    servicePoints[17].AddToTheLine(a);
                } else {
                    servicePoints[18].AddToTheLine(a);
                }
                break;
            case CUSTOMER_ARRIVAL:
                a = (Customer) servicePoints[17].TakeFromTheLine(); //Customer Removed from Simulator
                a.setFinistime(Clock.getInstance().getClock());
                e = new CustomerDb(a, this.ResultDb.getId());
                CustomerDao.persist(e);
                a.raport();
            case VIP_CUSTOMER_ARRIVAL:
                a = (Customer) servicePoints[18].TakeFromTheLine(); //Customer Removed from Simulator
                a.setFinistime(Clock.getInstance().getClock());
                e = new CustomerDb(a, this.ResultDb.getId());
                CustomerDao.persist(e);
                ResultDb.setTotalTime(a.raport());
                ResultDb.setCustomers(Customer.getCount());
                ResultDb.setTotalTime(Clock.getInstance().getClock());
                ResultDao.update(ResultDb);
                a.raport();

        }
    }

    @Override
    protected void tryCEvents(){
        for (ServicePoint p: servicePoints){
            if (!p.isReserved() && p.isOnQueue()){
                p.StartService();
            }
        }
    }

    public ServicePoint[] getservicePoints() {
        return servicePoints;
    }

    @Override
    protected void results() {
        System.out.println("Simulation ended at " + Clock.getInstance().getClock());
        System.out.println("Results ... ");
        System.out.println("Number of the customers " + Customer.getCount());

        controller.showtotaltime(Clock.getInstance().getClock());
    }
}