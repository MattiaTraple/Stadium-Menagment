package view;

import dao.CustomerDao;
import dao.ResultDao;
import entity.ResultDb;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.text.Text;

public class ControllerResult {

    @FXML
    private Text Q1;

    @FXML
    private Text Q2;

    @FXML
    private Text Q3;

    @FXML
    private Text Q4;

    @FXML
    private Label dataCustomers;

    @FXML
    private Label dataVipCustomers;

    @FXML
    private Label dataSimulationTime;




    @FXML
    private void initialize() {
        CustomerDao customerDao = new CustomerDao();
        ResultDao resultDao = new ResultDao();
    }

    @FXML
    public void selector(){
        CustomerDao customerDao = new CustomerDao();
        ResultDb resultDao = new ResultDb();

        int id = 0;
        dataCustomers.setText(String.valueOf(resultDao.getCustomers()));
        dataVipCustomers.setText(String.valueOf(resultDao.getVip_customers()));
        dataSimulationTime.setText(String.valueOf(resultDao.getTotalTime()));
        Q1.setText(String.valueOf(resultDao.getSecurity()));
        Q2.setText(String.valueOf(resultDao.getTicket()));
        Q3.setText(String.valueOf(resultDao.getCheckin()));
        Q4.setText(String.valueOf(resultDao.getCatering()));
    }
}
