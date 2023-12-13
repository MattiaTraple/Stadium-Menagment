package view;

import dao.CustomerDao;
import dao.ResultDao;
import entity.ResultDb;
import javafx.fxml.FXML;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
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
    private ComboBox<String> selection;

    @FXML
    private Label dataCustomers;

    @FXML
    private Label dataAvgTime;

    @FXML
    private Label dataSimulationTime;

    @FXML
    private void initialize() {
        ResultDao resultDao = new ResultDao();
        selection.getItems().addAll(resultDao.getId());

        if (!selection.getItems().isEmpty()) {
            selection.getSelectionModel().select(0);
            selection.setVisible(false);
            selector();
        }
    }


    @FXML
    public void selector(){
        ResultDao resultDao = new ResultDao();
        int id = resultDao.getId().indexOf(selection.getSelectionModel().getSelectedItem()) + 1;
        dataCustomers.setText(String.valueOf(resultDao.find(id).getCustomers()));
        dataAvgTime.setText(String.valueOf(resultDao.find(id).getAvgtime()));
        dataSimulationTime.setText(String.valueOf(resultDao.find(id).getTotalTime()));
        Q1.setText(String.valueOf(resultDao.find(id).getSecurity()));
        Q2.setText(String.valueOf(resultDao.find(id).getTicket()));
        Q3.setText(String.valueOf(resultDao.find(id).getCheckin()));
        Q4.setText(String.valueOf(resultDao.find(id).getCatering()));
    }
}
