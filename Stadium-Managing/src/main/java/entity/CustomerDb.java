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
    private int arrive;
    @Column(name = "finish")
    private int finish;
    @Column(name = "total")
    private int total;


    public CustomerDb(Customer a, int id_sim) {
        super();
        this.id = a.getId();
        this.id_sim = id_sim;
        this.arrive = (int) a.getArrivalTime();
        this.finish = a.getFinishTime();
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

    public int getArrivalTime() {
        return arrive;
    }

    public void setArrivalTime(int arrive) {
        this.arrive = arrive;
    }

    public int getFinishTime() {
        return finish;
    }

    public void setFinishTime(int finish) {
        this.finish = finish;
    }

}


