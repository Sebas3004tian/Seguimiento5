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
import javafx.scene.control.ComboBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import model.BankDetails;
import model.Record;

public class Registrar implements Initializable{
	
	private String amountString;
	private String type;
	private LocalDate localDate;
	private String informacion;
	

	@FXML
    private TextField montoTF;

    @FXML
    private DatePicker fechaDP;

    @FXML
    private ComboBox<String> tipoCB;
    
    @FXML
    private TextArea descripcionTA;

    @FXML
    private Button hechoBTN;
    
	@Override
	public void initialize(URL location, ResourceBundle resources) {
		tipoCB.getItems (). addAll ("Ingreso", "Gasto");
		fechaDP.setDisable(false);
		
	}
    
    @FXML
    void hecho(ActionEvent event) throws Exception {
    
    	amountString = montoTF.getText();
    	double amount=Double.parseDouble(amountString);
    	type=tipoCB.getValue();
    	
    	
    	DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy:MM:dd");
    	LocalDate localDate = fechaDP.getValue();
    	
    	informacion=descripcionTA.getText();
    	
    	Record record = new Record(amount, type, localDate,informacion);
    	BankDetails.data.add(record);
    	
    	
    	Node source = (Node) event.getSource();
	    Stage stage = (Stage) source.getScene().getWindow();
	    stage.close();
    }

	

}

