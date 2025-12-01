package Frontend.eventfinder;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.stage.Stage;

import java.io.IOException;

public class SearchController {

    @FXML
    Label resultLabel;

    public void displayResult(String search){
        resultLabel.setText("Results for " + search);
    }


    private Stage stage;
    private Scene scene;
    private Parent root;

    @FXML
    public void switchToEvent(ActionEvent event) throws IOException {

        Parent root = FXMLLoader.load(getClass().getResource("event.fxml"));
        stage = (Stage)((Node)event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }
}
