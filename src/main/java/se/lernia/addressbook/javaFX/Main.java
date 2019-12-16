package se.lernia.addressbook.javaFX;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import se.lernia.addressbook.entity.Person;
import se.lernia.addressbook.entity.dao.PersonRepository;
import se.lernia.addressbook.javaFX.connectin.Connectin;
import se.lernia.addressbook.service.PersonService;
import se.lernia.addressbook.service.PersonServiceImpl;

import java.io.IOException;
import java.util.List;
import java.util.Optional;

public class Main extends Application {
    Stage primaryStage;
    Parent root;
    //PersonService pService = Connectin.getInstance();
    //PersonService pService = new PersonServiceImpl().; //Fix with personrepos



    @Override
    public void start(Stage primaryStage) throws Exception {
        this.primaryStage = primaryStage;
        this.primaryStage.setTitle("Addressbook");
        chooseLoginView();
    }

    public void chooseTableView() throws IOException { //swap over to TableView
        FXMLLoader loader = new FXMLLoader();
        loader.setLocation(getClass().getResource("/TableView.fxml")); //Cannot make static because of this :(  // fxml. needs / to find in maven

        this.root = loader.load(); //must load first otherwise code below will return as null
        Controller controller = loader.getController();
        controller.setPersonService(pService);
        controller.setApp(this);
        this.primaryStage.setScene(new Scene(this.root, 1000, 800));
        this.primaryStage.show();
    }

    public void chooseLoginView() throws IOException {
        FXMLLoader loader = new FXMLLoader();
        loader.setLocation(getClass().getResource("/LoginView.fxml"));
        this.root = loader.load(); //must load first otherwise code below will return as null
        Controller controller = loader.getController();
        controller.setPersonService(pService);
        controller.setApp(this);
        this.primaryStage.setScene(new Scene(this.root, 1000, 800));
        this.primaryStage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }

}
