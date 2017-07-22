package pawnApp;


import javafx.stage.*;
import javafx.scene.*;
import javafx.scene.layout.*;
import javafx.scene.control.*;
import javafx.geometry.*;

public class ResultBox {

    public static void display(String fname, String id,String noitems,int itemno,String itemname,String itemtype,double result) {
        Stage window = new Stage();

        //Block events to other windows
        window.initModality(Modality.APPLICATION_MODAL);
        window.setTitle("Welcome "+fname);
        window.setMinWidth(250);

        Label label = new Label();
        Label label2 = new Label();
       // Label label3 = new Label();
       // Label label4 = new Label();
       // Label label5 = new Label();
        label.setText("Hello "+fname+" \n Your ID:"+id+"\n"+"No. Of Items Pawned:"+noitems+"\n Item Name"+itemname+"\nItem type"+itemtype);
        label2.setText("The amount to be given to you for this item is RS:"+result);
        Button closeButton = new Button("Close this window");
        closeButton.setOnAction(e -> window.close());

        VBox layout = new VBox(10);
        layout.getChildren().addAll(label, closeButton);
        layout.setAlignment(Pos.CENTER);

        //Display window and wait for it to be closed before returning
        Scene scene = new Scene(layout);
        window.setScene(scene);
        window.showAndWait();
    }
}