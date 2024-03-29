package sample;

import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ListView;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.text.Text;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileWriter;


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

    public void save(){
        String data = "";
        for(Product p: products.getItems()){
            data += p.toString() +"\n";
        }
        File dir = new File("test");
        dir.mkdirs();
        File testFile = new File( dir,"testFile.txt");
        try {
            testFile.createNewFile();
        }catch (Exception e){
            System.out.println("Couldn't create new file");
        }
        try {
            BufferedWriter writer = new BufferedWriter(new FileWriter(testFile));
            writer.write(data);

            writer.close();
        }catch(Exception e){
            System.out.println("Writing error");
        }
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

        oldPriceField.textProperty().addListener(new ChangeListener<String>() {
            @Override
            public void changed(ObservableValue<? extends String> observable, String oldValue, String newValue) {
                if (!newValue.matches("\\d{0,4}([\\.]\\d{0,2})?")) {
                    oldPriceField.setText(oldValue);
                }
            }
        });

        newPriceField.textProperty().addListener(new ChangeListener<String>() {
            @Override
            public void changed(ObservableValue<? extends String> observable, String oldValue, String newValue) {
                if (!newValue.matches("\\d0,4}([\\.]\\d{0,2})?")) {
                    newPriceField.setText(oldValue);
                }
            }
        });

        updateButton.setDisable(true);
    }

}
