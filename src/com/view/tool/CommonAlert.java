package com.view.tool;
import javafx.scene.control.Alert;

public class CommonAlert {
    public static void commonAlert(String title,String headText,String contentText){
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle(title);
        alert.setHeaderText(headText);
        alert.setContentText(contentText);
        alert.showAndWait();
    }
}
