package sample;

import javafx.fxml.FXML;
import javafx.scene.control.TextField;
import javafx.scene.text.Text;

import javax.swing.text.html.ListView;


public class Controller {

    public void printField(){
        System.out.println(productNameField.getText());
    }

    public void populateForm(){
        int selected = products.getSelectionModel().getSelectedIndex();
    }


    @FXML
    private TextField productNameField;

    @FXML
    private TextField quantityField;

    @FXML
    private TextField oldPriceField;

    @FXML
    private TextField newPriceField;

    @FXML
    private ListView products;

}
