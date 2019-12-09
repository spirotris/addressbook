package main.java.se.lernia.addressbook.javaFX.src.sample;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;

import java.net.URL;
import java.time.LocalDate;
import java.util.ResourceBundle;

public class TableViewController extends Controller implements Initializable {
    //TableView and Columns
    @FXML private TableView<Person> tableview;
    @FXML private TableColumn<Person, Integer> idColumn;
    @FXML private TableColumn<Person, String> firstnameColumn;
    @FXML private TableColumn<Person, String> lastnameColumn;
    @FXML private TableColumn<Person, String> mailColumn;
    @FXML private TableColumn<Person, String> telephonenumberColumn;
    @FXML private TableColumn<Person, String> addressColumn;
    @FXML private TableColumn<Person, String> countyColumn;
    @FXML private TableColumn<Person, LocalDate> timestampColumn;
    @FXML public ObservableList<Person> personList;
    //Buttons and Textfields for adding a person
    @FXML public TextField firstnameTextField;
    @FXML public TextField lastnameTextField;
    @FXML public TextField mailTextField;
    @FXML public TextField telephonenumberTextField;
    @FXML public TextField addressTextField;
    @FXML public TextField countyTextField;
    @FXML public Button addPersonButton;
    @FXML public Button clearTextFieldsButton;

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        idColumn.setCellValueFactory(new PropertyValueFactory<Person, Integer>("id"));
        firstnameColumn.setCellValueFactory(new PropertyValueFactory<Person, String>("firstName"));
        lastnameColumn.setCellValueFactory(new PropertyValueFactory<Person, String>("lastName"));
        mailColumn.setCellValueFactory(new PropertyValueFactory<Person, String>("Mail"));
        telephonenumberColumn.setCellValueFactory(new PropertyValueFactory<Person, String>("Telephone"));
        addressColumn.setCellValueFactory(new PropertyValueFactory<Person, String>("Address"));
        countyColumn.setCellValueFactory(new PropertyValueFactory<Person, String>("County"));
        timestampColumn.setCellValueFactory(new PropertyValueFactory<Person, LocalDate>("Timestamp"));
        configureAllButtons();
        tableview.setItems(getPeople());
    }
    @FXML public ObservableList<Person> getPeople(){
        //Add some elements to try, but make another method for adding stuff
            personList = FXCollections.observableArrayList();
            personList.add(new Person(1,"Philip","Ferguson","philipe.fergus@gmail.com","070xxxxxxxxx", "Granngatan 56", "Lappland"));
        return personList;
    }
    public void configureAllButtons(){
        //ClearTextField Button
        clearTextFieldsButton.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                firstnameTextField.clear();
                lastnameTextField.clear();
                mailTextField.clear();
                telephonenumberTextField.clear();
                addressTextField.clear();
                countyTextField.clear();
            }
        });
        //AddPerson Button
        addPersonButton.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                //Things happen here
            }
        });
    }
}
