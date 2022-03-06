package control;

import java.net.URL;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ResourceBundle;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.control.Button;
import javafx.scene.control.DatePicker;
import javafx.stage.Stage;
import model.BankDetails;
import model.Record;

public class Filtrar implements Initializable{
	
	private LocalDate dateInicial;
	private LocalDate dateFinal;

    @FXML
    private DatePicker fechaFinalDP;

    @FXML
    private DatePicker fechaInicialDP;

    @FXML
    private Button hechoBTN;

    @FXML
    void hecho(ActionEvent event) {
    	BankDetails.dataFiltrada.clear();
    	DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy:MM:dd");
    	LocalDate dateInicial = fechaInicialDP.getValue();
    	LocalDate dateFinal = fechaFinalDP.getValue();
    	
    	for(int i=0;i<BankDetails.data.size();i++) {
    		if(BankDetails.data.get(i).getFecha().isAfter(dateInicial) && BankDetails.data.get(i).getFecha().isBefore(dateFinal)) {
    			BankDetails.dataFiltrada.add(BankDetails.data.get(i));
        	}
    	}
    	
    	Node source = (Node) event.getSource();
	    Stage stage = (Stage) source.getScene().getWindow();
	    stage.close();
    }

	@Override
	public void initialize(URL location, ResourceBundle resources) {
		fechaInicialDP.setDisable(false);
		fechaFinalDP.setDisable(false);
		
	}
    

}

