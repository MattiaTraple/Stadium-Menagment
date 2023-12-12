package entity;

import jakarta.persistence.*;
import simu.model.*;

@Entity
@Table(name="customer")
public class CustomerDb {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id_db;
    @Column(name = "id")
    private int id;
    @Column(name = "id_sim")
    private int id_sim;
    @Column(name = "arrive")
    private double arrivetime;
    @Column(name = "finish")
    private double finish;


    public CustomerDb(Customer a, int id_sim) {
        super();
        this.id = a.getId();
        this.id_sim = id_sim;
        this.arrivetime = a.getArrivetime();
        this.finish = a.getFinistime();
    }

    public CustomerDb() {

    }

    public int getDb_id() {
        return id_db;
    }

    public void setId_db(int id_db) {
        this.id_db = id_db;
    }

    public int getId_sim() {
        return id_sim;
    }

    public void setId_sim(int id_sim) {
        this.id_sim = id_sim;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public double getArrivalTime() {
        return arrivetime;
    }

    public void setArrivalTime(double arrivetime) {
        this.arrivetime = arrivetime;
    }

    public double getFinishTime() {
        return finish;
    }

    public void setFinishTime(double finish) {
        this.finish = finish;
    }

}


