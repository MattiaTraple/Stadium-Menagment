package simu.framework;

import controller.IControllerForM; // UUSI
import view.IController;

public abstract class Engine extends Thread implements IEngine{

    private double simulationtime = 0;
    private long delay = 0;

    private Clock clock;

    protected EventList eventList;

    protected IControllerForM controller; // UUSI


    public Engine(IControllerForM controller){  // UUSITTU
        this.controller = controller;  //UUSI

        clock = Clock.getInstance(); // Otetaan kello muuttujaan yksinkertaistamaan koodia

        eventList = new EventList();
    }

    @Override
    public void setSimulationTime(double time) {
        simulationtime = time;
    }

    @Override
    public void setDelay(long delay) {
        this.delay = delay;
    }

    @Override // UUSI
    public long getDelay() {
        return delay;
    }

    @Override
    public void run(){ // Entinen aja()
        covers(); // luodaan mm. ensimmäinen tapahtuma
        while (simulating()){
            delay(); // UUSI
            clock.setClock(present());
            executeBEvents();
            tryCEvents();
        }
        results();
    }

    private void executeBEvents(){
        while (eventList.getNextTime() == clock.getClock()){
            executeEvents(eventList.remove());
        }
    }

    protected abstract void tryCEvents();


    private double present(){
        return eventList.getNextTime();
    }

    private boolean simulating(){
        Trace.out(Trace.Level.INFO, "Time is: " + clock.getClock());
        return clock.getClock() < simulationtime;
    }


    private void delay() { // UUSI
        Trace.out(Trace.Level.INFO, "Delay " + delay);
        try {
            sleep(delay);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    protected abstract void covers(); // Määritellään simu.model-pakkauksessa Moottorin aliluokassa

    protected abstract void executeEvents(Event t);  // Määritellään simu.model-pakkauksessa Moottorin aliluokassa

    protected abstract void results(); // Määritellään simu.model-pakkauksessa Moottorin aliluokassa
}