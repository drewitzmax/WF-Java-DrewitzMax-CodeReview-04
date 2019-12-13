package sample;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ListView;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.text.Text;

import java.io.FileInputStream;


public class Controller {

    public void update(){
        int selected = products.getSelectionModel().getSelectedIndex();
        Product temp = products.getItems().get(selected);
        try {
            temp.setNewPrice(Float.parseFloat(newPriceField.getText()));
        } catch (Exception e){
            System.out.println("No number in new Price Field");
        }
        try {
            temp.setOldPrice(Float.parseFloat(oldPriceField.getText()));
        } catch (Exception e){
            System.out.println("No number in old Price Field");
        }

        products.refresh();
    }

    public void populateForm(){
        int selected = products.getSelectionModel().getSelectedIndex();

        Product temp = products.getItems().get(selected);

        productNameField.setText(temp.getProductName());
        quantityField.setText(temp.getQuantity());
        oldPriceField.setText(Float.toString(temp.getOldPrice()));
        newPriceField.setText(Float.toString(temp.getNewPrice()));
        describtion.setText(Product.getDescription());

        try {
            FileInputStream in = new FileInputStream(temp.getImgPath());
            Image img = new Image(in);
            productImg.setImage(img);
        }catch (Exception e){
            System.out.println("File not found");
            productImg.setImage(null);
        }

        productNameField.setDisable(true);
        quantityField.setDisable(true);
        updateButton.setDisable(false);
        addButton.setDisable(true);
    }

    public void clear(){
        productNameField.clear();
        quantityField.clear();
        oldPriceField.clear();
        newPriceField.clear();
        describtion.clear();
        productImg.setImage(null);

        products.getSelectionModel().select(-1);

        productNameField.setDisable(false);
        quantityField.setDisable(false);
        updateButton.setDisable(true);
        addButton.setDisable(false);
    }

    public void add(){
        products.getItems().add(new Product(
                productNameField.getText(),
                quantityField.getText(),
                Float.parseFloat(oldPriceField.getText()),
                Float.parseFloat(newPriceField.getText())
        ));
        products.refresh();
        clear();
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
    private ListView<Product> products;

    @FXML
    private ImageView productImg;

    @FXML
    private TextArea describtion;

    @FXML
    private Button clearButton;

    @FXML
    private Button updateButton;

    @FXML
    private Button addButton;

    @FXML
    private void initialize(){
        products.getItems().addAll(Main.getProducts().values());
        products.refresh();

        updateButton.setDisable(true);
    }

}
