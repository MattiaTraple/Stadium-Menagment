package entity;

import jakarta.persistence.*;

@Entity
@Table(name="result")
public class ResultDb {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "total")
    private int total;

    @Column(name = "customers")
    private int customers;

    @Column(name = "vip_customers")
    private int vip_customers;

    public ResultDb(int[] settings) {
        super();
        this.total = settings[0];
        this.vip_customers = settings[2];
        this.customers = settings[1];
    }

    public ResultDb() {

    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getTotal() {
        return total;
    }

    public void setTotal(int total) {
        this.total = total;
    }

    public int getCustomers() {
        return customers;
    }

    public void setCustomers(int customers) {
        this.customers = customers;
    }

    public int getVip_customers() {
        return vip_customers;
    }

    public void setVip_customers(int vip_customers) {
        this.vip_customers = vip_customers;
    }
}
