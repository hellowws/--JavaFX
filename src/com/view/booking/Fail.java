package com.view.booking;

import com.view.home.Home;
import com.view.menu.MenuView;
import com.view.start.MainApplication;
import com.view.tool.CommonAlert;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.MenuBar;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;

public class Fail {
    public static void start(){

        CommonAlert.commonAlert("提示","取消挂号成功!",null);
        HBox hBox = new HBox(20);
        Image image = new Image("D:\\编程例子\\Java\\IDEA项目\\JavaFxDemo\\src\\images\\close.png");
        Button back=new Button("返回");
        back.setOnAction(e->{
            Home.first();
        });
        ImageView imageView = new ImageView(image);
        imageView.setFitWidth(800);
        imageView.setFitHeight(400);
        hBox.getChildren().addAll(back,imageView);

        Scene scene = new Scene(hBox,935,400);
        MainApplication.setScene(scene);

    }



}

