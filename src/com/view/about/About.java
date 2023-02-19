package com.view.about;

import com.view.menu.MenuView;
import com.view.start.MainApplication;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.MenuBar;
import javafx.scene.layout.BorderPane;
import javafx.scene.paint.Color;
import javafx.stage.Stage;

public class About {

    public static void about() {
        BorderPane borderPane = new BorderPane();
        borderPane.setStyle("-fx-background-image: url('/images/about.png');-fx-background-position: center center;-fx-background-repeat: no-repeat;-fx-background-attachment: fixed;-fx-background-size: cover;");
//        顶部控件
        MenuBar menuBar = MenuView.menuBar();

//        中间控件返回菜单点击事件
//        StackPane Content=;

        borderPane.setTop(menuBar);
        Scene scene = new Scene(borderPane, 935, 532, Color.WHITE);
        MainApplication.setScene(scene);
    }
}
