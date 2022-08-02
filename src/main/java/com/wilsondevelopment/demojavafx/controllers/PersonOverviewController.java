package com.wilsondevelopment.demojavafx.controllers;

import com.wilsondevelopment.demojavafx.HelloApplication;
import com.wilsondevelopment.demojavafx.models.Persona;
import com.wilsondevelopment.demojavafx.utils.DateUtil;
import javafx.beans.property.StringProperty;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;

public class PersonOverviewController {
    @FXML
    private TableView<Persona> personTable;
    @FXML
    private TableColumn<Persona, String> firstNameColumn;
    @FXML
    private TableColumn<Persona, String> lastNameColumn;

    @FXML
    private Label firstNameLabel;
    @FXML
    private Label lastNameLabel;
    @FXML
    private Label streetLabel;
    @FXML
    private Label postalCodeLabel;
    @FXML
    private Label cityLabel;
    @FXML
    private Label birthDateLabel;

    private HelloApplication helloApplication;

    public PersonOverviewController () {

    }

    @FXML
    private void initialize() {
        firstNameColumn.setCellValueFactory(cellData -> cellData.getValue().firstNameProperty());
        lastNameColumn.setCellValueFactory(cellData -> cellData.getValue().lastNameProperty());

        // Inicializamos los Labels
        muestraDetallesPersona(null);

        personTable.getSelectionModel().selectedItemProperty().addListener(
                (observable, personaAnterior, nuevaPersona)->muestraDetallesPersona(nuevaPersona)
        );
    }

    private void muestraDetallesPersona(Persona persona) {
        if (persona != null) {
            firstNameLabel.setText(persona.getFirstName());
            lastNameLabel.setText(persona.getLastName());
            streetLabel.setText(persona.getStreet());
            postalCodeLabel.setText(Integer.toString(persona.getPostalCode()));
            cityLabel.setText(persona.getCity());
            birthDateLabel.setText(DateUtil.format(persona.getBirthdate()));
        } else {
            firstNameLabel.setText("");
            lastNameLabel.setText("");
            streetLabel.setText("");
            postalCodeLabel.setText("");
            cityLabel.setText("");
            birthDateLabel.setText("");
        }
    }

    public void setMainApp(HelloApplication helloApplication) {
        this.helloApplication = helloApplication;
        ObservableList<Persona> personas = helloApplication.getListaPersonas();

        if (personas.size()> 0)
            personTable.setItems(personas);
        else
            personTable.setPlaceholder(new Label("No hay contenido..."));
    }


}
