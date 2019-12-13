package sample;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.util.ArrayList;
import java.util.HashMap;

public class Main extends Application {
    private static HashMap<Integer,Product> products = new HashMap<Integer, Product>();

    @Override
    public void start(Stage primaryStage) throws Exception{
        Parent root = FXMLLoader.load(getClass().getResource("sample.fxml"));
        root.getStylesheets().add("/sample/style.css");
        primaryStage.setTitle("Supermarket Discount System");
        primaryStage.setScene(new Scene(root));
        primaryStage.show();
    }


    public static void main(String[] args) {
        products.put(0, new Product("Schafskaese Salakis", "200g Packung", 2.49f,2.19f,"cheese_salakis__600x600.jpg"));
        products.put(1, new Product("Pfeffer", "90g Muehle", 3.49f,2.69f,"pfeffer__600x600.jpg"));
        products.put(2, new Product("Voesslauer Minealwasser", "Six-Pack 1,5l", 2.00f,1.50f,"voslauer__600x600.jpg"));
        products.put(3, new Product("Zucker", "1kg", 0.49f,0.89f,"zucker__600x600.jpg"));
        launch(args);
    }

    public static HashMap<Integer,Product> getProducts() {
        return products;
    }
}
