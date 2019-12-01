package sample;

import javafx.beans.property.SimpleIntegerProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import sample.connectin.Connectin;
import sample.connectin.Connectinable;

import java.net.URL;
import java.time.LocalDate;
import java.util.ResourceBundle;

public class TableViewController implements Initializable , Connectinable {
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
    Connectin contin;

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

            tableview.setItems(getPeople());
    }
    @FXML public ObservableList<Person> getPeople(){
        //Add some elements to try, but make another method for adding stuff
            personList = FXCollections.observableArrayList();
            personList.add(new Person(1,"Philip","Ferguson","philipe.fergus@gmail.com","070xxxxxxxxx", "Granngatan 56", "Lappland"));
        return personList;
    }


    @Override
    public void setConnectin(Connectin contin) {
        this.contin = contin;
    }
}
