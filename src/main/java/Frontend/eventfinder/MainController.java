package Frontend.eventfinder;

import Backend.APIIntegration;
import Backend.Event;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import java.io.IOException;
import java.util.ArrayList;

public class MainController {
//    ArrayList<String> words = new ArrayList<>(
//            Arrays.asList("test", "dog","Human", "Days of our life", "The best day",
//                    "Friends", "Animal", "Human", "Humans", "Bear", "Life",
//                    "This is some text", "Words", "222", "Bird", "Dog", "A few words",
//                    "Subscribe!", "SoftwareEngineeringStudent", "You got this!!",
//                    "Super Human", "Super", "Like")
//    );

    @FXML
    private TextField searchBar;

//    @FXML
//    private ListView<String> listView;
//
//    @FXML
//    void search(ActionEvent event) {
//        listView.getItems().clear();
//        listView.getItems().addAll(searchList(searchBar.getText(),words));
//    }

//    @Override
//    public void initialize(URL url, ResourceBundle resourceBundle) {
//        listView.getItems().addAll(words);
////    }
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



    private Stage stage;
    private Scene scene;
    private Parent root;

    @FXML
    public void switchToSearchResult(ActionEvent event) throws IOException {

        String searchResult = searchBar.getText() + " concert";

        //APIIntegretaion (Searc)
        ArrayList<Event> events =APIIntegration.Search(searchResult);
//

        FXMLLoader loader = new FXMLLoader(getClass().getResource("search.fxml"));
        root = loader.load();

        SearchController searchController = loader.getController();
        searchController.displayResult(searchResult, events);

//        Parent root = FXMLLoader.load(getClass().getResource("search.fxml"));
        stage = (Stage)((Node)event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }

}