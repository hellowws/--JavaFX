package com.view.booking;

import com.view.home.Home;
import com.view.start.MainApplication;
import com.view.tool.CommonAlert;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.HBox;


public class Success {
    public static void start(){
        CommonAlert.commonAlert("提示","预约挂号成功!",null);
        HBox hBox = new HBox(20);
        Button back=new Button("返回");
        back.setOnAction(e->{
            Home.first();
        });
        Image image = new Image("images/success.png");
        ImageView imageView = new ImageView(image);

        imageView.setFitWidth(800);
        imageView.setFitHeight(400);

        hBox.getChildren().addAll(back,imageView);

        Scene scene = new Scene(hBox,935,400);

        MainApplication.setScene(scene);

    }



}
