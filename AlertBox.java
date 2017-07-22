package pawnApp;
import javafx.stage.*;
import javafx.scene.*;
import javafx.scene.layout.*;
import javafx.scene.control.*;
import javafx.geometry.*;

public class AlertBox {

    public static void display(String title, double d ) {
        Stage window = new Stage();

        //Block events to other windows
        window.initModality(Modality.APPLICATION_MODAL);
        window.setTitle(title);
        window.setMinWidth(250);

        Label label = new Label();
        label.setText("The amount to be returned is "+d);
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
    public static void display(String message, int count){
        Stage window = new Stage();

    	//Block events to other windows
        window.initModality(Modality.APPLICATION_MODAL);
        if (count==0)
        window.setTitle("Pawn  items");
        else if (count==1)
        	window.setTitle("Removed items");
        window.setMinWidth(250);

        Label label = new Label();
        label.setText(message);
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
	public static void displayy(String message) {
		// TODO Auto-generated method stub
	     Stage window = new Stage();

	    	//Block events to other windows
	        window.initModality(Modality.APPLICATION_MODAL);
	        window.setTitle("Items");
	        window.setMinWidth(250);

	        Label label = new Label();
	        label.setText(message);
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