package com.wilsondevelopment.demojavafx;

import com.wilsondevelopment.demojavafx.controllers.PersonOverviewController;
import com.wilsondevelopment.demojavafx.models.Persona;
import javafx.application.Application;
import javafx.beans.property.SimpleObjectProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;

import java.io.IOException;
import java.time.LocalDate;

public class HelloApplication extends Application {
    private Stage primaryStage;
    private BorderPane rootLayout;

    // Se define vacia una lista observable de personas
    private ObservableList<Persona> listaPersonas = FXCollections.observableArrayList();

    public HelloApplication () {
        listaPersonas.add(new Persona
                ("Wilson1","Perez2","Volcanes",83200,"Hermosillo",LocalDate.of(2022,7,12)));
        listaPersonas.add(new Persona("Wilson2","Perez2","Popocatepetl",83200,"Hermosillo",LocalDate.of(2022,7,12)));
        listaPersonas.add(new Persona("Wilson3","Perez3","Pico de Orizaba",83200,"Hermosillo",LocalDate.of(2022,7,12)));
        listaPersonas.add(new Persona("Wilson4","Perez4","Paricutin",83200,"Hermosillo",LocalDate.of(2022,7,12)));
        listaPersonas.add(new Persona("Wilson5","Perez5","Iztachihuatl",83200,"Hermosillo",LocalDate.of(2022,7,12)));
    }

    @Override
    public void start(Stage primaryStage) throws IOException {
        /*
        FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("hello-view.fxml"));
        Scene scene = new Scene(fxmlLoader.load(), 320, 240);
        stage.setTitle("Hello!");
        stage.setScene(scene);
        stage.show(); */
        this.primaryStage = primaryStage;
        this.primaryStage.setTitle("Control de Personal");

        // Carga un BorderPan con un MenuBar
        initRootLayout();

        // Carga el SplitPane con la Table y con los Labels
        showPersonOverview();
    }

    public ObservableList<Persona> getListaPersonas() {
        return listaPersonas;
    }

    private void initRootLayout() {
        try {
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(HelloApplication.class.getResource("RootLayout.fxml"));
            rootLayout = (BorderPane) loader.load();

            Scene scene = new Scene(rootLayout);
            primaryStage.setScene(scene);
            primaryStage.show();
        } catch(IOException e) {
            e.printStackTrace();
        }
    }

    public void showPersonOverview() {
        try {
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(HelloApplication.class.getResource("PersonOverview.fxml"));
            AnchorPane personOverview = (AnchorPane) loader.load();

            rootLayout.setCenter(personOverview);

            PersonOverviewController controller = loader.getController();
            controller.setMainApp(this);
        } catch(IOException e) {
            e.printStackTrace();
        }
    }

    public Stage getPrimaryStage() {
        return primaryStage;
    }

    public static void main(String[] args) {
        launch(args);
    }
}