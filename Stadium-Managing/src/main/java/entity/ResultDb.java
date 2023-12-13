package entity;

import jakarta.persistence.*;

@Entity
@Table(name = "result")
public class ResultDb {
    private static int idCounter = 0;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "date")
    private String date;

    @Column(name = "totaltime")
    private double totaltime;

    @Column(name = "avgtime")
    private double avgtime;

    @Column(name = "customers")
    private int customers;

    @Column(name = "vip_customers")
    private int vip_customers;

    @Column(name = "security")
    private int security;

    @Column(name = "checkin")
    private int checkin;

    @Column(name = "ticket")
    private int ticket;

    @Column(name = "catering")
    private int catering;

    public ResultDb(int[] settings, String date) {
        super();
        this.date = date;
        this.totaltime = 0;
        this.avgtime = 0;
        this.vip_customers = 0;
        this.customers = 0;
        this.checkin = settings[2];
        this.security = settings[0];
        this.ticket = settings[1];
        this.catering = settings[3];
    }

    public ResultDb() {

    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public double getTotalTime() {
        return totaltime;
    }

    public void setTotalTime(double totaltime) {
        double scale = Math.pow(10, 2);
        double formattedNumber = Math.round(totaltime * scale) / scale;
        this.totaltime = formattedNumber;
    }

    public double getAvgtime() {
        return avgtime;
    }

    public void setAvgtime(double avgtime) {
        this.avgtime = avgtime;
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

    public int getCheckin() {
        return checkin;
    }

    public void setCheckin(int checkin) {
        this.checkin = checkin;
    }

    public int getSecurity() {
        return security;
    }

    public void setSecurity(int security) {
        this.security = security;
    }

    public int getTicket() {
        return ticket;
    }

    public void setTicket(int ticket) {
        this.ticket = ticket;
    }

    public int getCatering() {
        return catering;
    }

    public void setCatering(int catering) {
        this.catering = catering;
    }
}
