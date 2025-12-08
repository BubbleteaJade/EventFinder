package Frontend.eventfinder;

import Backend.Event;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.stage.Stage;

import java.io.IOException;
import java.util.ArrayList;

public class SearchController {

    @FXML
    Label resultLabel;

    @FXML
    private ListView<String> listView;

    public void displayResult(String search, ArrayList<Event> events){

        search = search.replaceAll("concert", "");

        // Trim the string using trim() method
        search = search.trim();

        resultLabel.setText("Results for " + search);


        listView.getItems().clear();

        for (Event event : events) {
            String location = event.getLocation();
            listView.getItems().add(location);

        }




//
//    @FXML
//    void search(ActionEvent event) {
//        listView.getItems().clear();
//        listView.getItems().addAll(searchList(searchBar.getText(),words));
//    }

//    @Override
//    public void initialize(URL url, ResourceBundle resourceBundle) {
//        listView.getItems().addAll(words);
//    }
//
//    private List<String> searchList(String searchWords, List<String> listOfStrings) {
//
//        List<String> searchWordsArray = Arrays.asList(searchWords.trim().split(" "));
//
//        return listOfStrings.stream().filter(input -> {
//            return searchWordsArray.stream().allMatch(word ->
//                    input.toLowerCase().contains(word.toLowerCase()));
//        }).collect(Collectors.toList());
//    }



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
