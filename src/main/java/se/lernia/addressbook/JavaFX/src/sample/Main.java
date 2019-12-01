package sample;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import sample.connectin.Connectin;

import java.io.IOException;

public class Main extends Application {
    Stage primaryStage;
    Parent root;
    Connectin contin;
    @Override
    public void start(Stage primaryStage) throws Exception{
        this.primaryStage = primaryStage;
        this.primaryStage.setTitle("Addressbook");
        contin = Connectin.getInstance();
        chooseTableView();
    }
    public void chooseTableView() throws IOException { //swap over to TableView
        FXMLLoader loader = new FXMLLoader();
        loader.setLocation(getClass().getResource("sample.fxml")); //Cannot make static because of this :(

        this.root = loader.load(); //must load first otherwise code below will return as null
        TableViewController tvController = loader.getController();
        tvController.setConnectin(contin);

        this.primaryStage.setScene(new Scene(this.root, 1000, 800));
        this.primaryStage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }

}
