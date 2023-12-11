package view;

import dao.CustomerDao;
import dao.ResultDao;
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
        ResultDao resultDao = new ResultDao();

        int id = 0;
        dataCustomers.setText(String.valueOf(resultDao.find(id).getCustomers()));
        dataVipCustomers.setText(String.valueOf(resultDao.find(id).getVip_customers()));
        dataSimulationTime.setText(String.valueOf(resultDao.find(id).getTotalTime()));
        Q1.setText(String.valueOf(resultDao.find(id).getSecurity()));
        Q2.setText(String.valueOf(resultDao.find(id).getTicket()));
        Q3.setText(String.valueOf(resultDao.find(id).getCheckin()));
        Q4.setText(String.valueOf(resultDao.find(id).getCatering()));
    }
}
