package com.view.start;

import com.view.login.Login;
import javafx.application.Application;
import javafx.geometry.Rectangle2D;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.stage.Screen;
import javafx.stage.Stage;

public class MainApplication extends Application {

    private static Stage stage;

    @Override
    public void start(Stage stage) throws Exception {
        //获得屏幕宽度、高度
        Rectangle2D screenRectangle = Screen.getPrimary().getBounds();
        double width = screenRectangle.getWidth();
        double height = screenRectangle.getHeight();

        stage.setX(width / 6);
        stage.setY(height / 6);
        //将舞台设置为静态变量:缓存
        MainApplication.stage = stage;

        //stage.initStyle(StageStyle.UNDECORATED);
        //图标
        stage.getIcons().add(new Image("/images/icon.png"));
        stage.setTitle("医院信息管理系统");

        Login.login();

        stage.show();
    }

    public static void setScene(Scene scene){
        MainApplication.stage.setScene(scene);
    }

    public static void main(String[] args) {
        launch(args);
    }

}
