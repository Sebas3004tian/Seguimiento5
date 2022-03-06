package control;

import java.io.IOException;
import java.net.URL;
import java.time.LocalDate;
import java.util.ResourceBundle;

import javafx.application.Platform;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.MenuItem;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;
import main.Main;
import model.BankDetails;
import model.Record;

public class Modulo1 implements Initializable{
	
	
	
	@FXML
    private TableView<Record> dataTable;

    @FXML
    private TableColumn<Record, Double> montoCol;

    @FXML
    private TableColumn<Record, String> tipoCol;

    @FXML
    private TableColumn<Record, LocalDate> fechaCol;
    
    @FXML
    private TableColumn<Record, String> infoCol;
    
    @FXML
    private MenuItem registrarMI;

    @FXML
    private MenuItem filtrarMI;

    @FXML
    private MenuItem eliminarRegistroMI;

    @FXML
    private MenuItem eliminarTodoMI;

    @FXML
    private MenuItem salirMI;
    
    @FXML
    private MenuItem restablecerMI;
    
    @FXML
    private TextField ingresosTF;

    @FXML
    private TextField balanceTF;

    @FXML
    private TextField gastosTF;
    
    @FXML
    private Button actualizarBTN;

    private Record stClicked;

	@Override
	public void initialize(URL location, ResourceBundle resources) {
	 	montoCol.setCellValueFactory(new PropertyValueFactory<>("monto"));
       	tipoCol.setCellValueFactory(new PropertyValueFactory<>("tipo"));
       	fechaCol.setCellValueFactory(new PropertyValueFactory<>("fecha"));
       	infoCol.setCellValueFactory(new PropertyValueFactory<>("informacion"));
       	
   		
       	dataTable.setItems(BankDetails.data);
       
       	
       	
   		
       	dataTable.setOnMouseClicked(event -> {
   			stClicked = dataTable.getSelectionModel().getSelectedItem();
   		});
       	
	}
	@FXML
    void eliminarRegistro(ActionEvent event) {
    	BankDetails.data.remove(stClicked);
    }

    @FXML
    void eliminarTodo(ActionEvent event) {
    	BankDetails.data.clear();
    }

    @FXML
    void filtrar(ActionEvent event) throws IOException {
    	FXMLLoader loader = new FXMLLoader(Main.class.getResource("../ui/Filtrar.fxml"));
		loader.setController(new Filtrar());
		Parent parent = (Parent) loader.load();
		Stage stage = new Stage();
		Scene scene = new Scene(parent);
		stage.setScene(scene);
		stage.show();
		
		
		BankDetails.dataFiltrada.clear();
		dataTable.setItems(BankDetails.dataFiltrada);
    }

    @FXML
    void registrar(ActionEvent event) throws IOException {
    	FXMLLoader loader = new FXMLLoader(Main.class.getResource("../ui/Registrar.fxml"));
		loader.setController(new Registrar());
		Parent parent = (Parent) loader.load();
		Stage stage = new Stage();
		Scene scene = new Scene(parent);
		stage.setScene(scene);
		stage.show();
    }

    @FXML
    void salir(ActionEvent event) {
    	Platform.exit();
    	System.exit(0);
    }
    
    @FXML
    void restablecer(ActionEvent event) {
    	dataTable.setItems(BankDetails.data);
    }
    
    @FXML
    void actualizar(ActionEvent event) {
    	if(dataTable.getItems().equals(BankDetails.data)) {
    		
    		double ingresos=0;
    		double gastos=0;
    		double balance=0;
    		for(int i=0;i<BankDetails.data.size();i++) {
    			if(BankDetails.data.get(i).getTipo().equals("Ingreso")) {
    				ingresos+=BankDetails.data.get(i).getMonto();
    			}else if(BankDetails.data.get(i).getTipo().equals("Gasto")) {
    				gastos+=BankDetails.data.get(i).getMonto();
    			}
    		}
    		balance=ingresos-gastos;
    		ingresosTF.setText(ingresos+"");
    		gastosTF.setText(gastos+"");
    		balanceTF.setText(balance+"");
    		
    		
    	}else if(dataTable.getItems().equals(BankDetails.dataFiltrada)) {
    		
    		double ingresos=0;
    		double gastos=0;
    		double balance=0;
    		for(int i=0;i<BankDetails.dataFiltrada.size();i++) {
    			if(BankDetails.dataFiltrada.get(i).getTipo().equals("Ingreso")) {
    				ingresos+=BankDetails.dataFiltrada.get(i).getMonto();
    			}else if(BankDetails.dataFiltrada.get(i).getTipo().equals("Gasto")) {
    				gastos+=BankDetails.dataFiltrada.get(i).getMonto();
    			}
    		}
    		balance=ingresos-gastos;
    		ingresosTF.setText(ingresos+"");
    		gastosTF.setText(gastos+"");
    		balanceTF.setText(balance+"");
    		
    	}else {
    	}
    }
   

}

