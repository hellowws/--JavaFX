package com.view.login;



import com.view.home.Home;
import com.view.start.MainApplication;
import com.view.tool.CommonAlert;
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;

import java.util.List;

public class Login {

    public static void login(){
        GridPane gridPane = new GridPane();
        //css样式设置背景图 是否平铺等
        gridPane.setStyle("-fx-background-image:url('images/login2.png'); -fx-background-repeat: no-repeat;-fx-background-size: 935 532; -fx-background-position: center center;");

        //居中
        gridPane.setAlignment(Pos.CENTER);

        gridPane.setVgap(10);//垂直间距10
//
        Text text = new Text("           ");
        text.setFont(Font.font("华文新魏", FontWeight.BOLD,30));
        text.setFill(Color.rgb(0,123,250));

        gridPane.add(text,0,0,2,1);

        Label userName = new Label("用户名：");
        userName.setFont(Font.font("宋体",FontWeight.NORMAL,15));
        userName.setTextFill(Color.rgb(0,123,250));

        gridPane.add(userName,2,1);

        TextField userNameField = new TextField();
        userNameField.setFont(Font.font("宋体",FontWeight.NORMAL,15));
        userNameField.setMinHeight(40);
        userNameField.setMinWidth(250);
        userNameField.setStyle("-fx-background-color: rgba(255, 255, 255, .5);-fx-border-style: solid;-fx-border-color: grey");
        gridPane.add(userNameField,3,1);

        Label password = new Label("密码：");
        password.setFont(Font.font("宋体",FontWeight.NORMAL,15));
        password.setTextFill(Color.rgb(0,123,250));

        gridPane.add(password,2,2);

        PasswordField passwordField = new PasswordField();
        passwordField.setFont(Font.font("宋体",FontWeight.BOLD,15));
        passwordField.setMinHeight(40);
        passwordField.setMinWidth(250);
        passwordField.setStyle("-fx-background-color: rgba(255, 255, 255, .5);-fx-border-style: solid;-fx-border-color: grey");

        gridPane.add(passwordField,3,2);

        Button loginButton = new Button("登录");
        loginButton.setMinWidth(120);
        loginButton.setMinHeight(30);
        loginButton.setStyle(
                "-fx-background-color:#00BFFF;"+         //设置背景颜色
                        "-fx-background-radius:20;"+     //设置背景圆角
                        "-fx-text-fill:#fdfdfe;");

        Button registButton = new Button("注册");
        registButton.setOnAction(e-> Register.regist());
        registButton.setMinWidth(120);
        registButton.setMinHeight(30);
        registButton.setStyle(
                "-fx-background-color:#00BFFF;"+         //设置背景颜色
                        "-fx-background-radius:20;"+     //设置背景圆角
                        "-fx-text-fill:#ffffff;");

        loginButton.setOnAction(new EventHandler<ActionEvent>() {
            //登录进入按钮事件--------

            @Override
            public void handle(ActionEvent event) {


                //获得输入的账号密码
                String userName = userNameField.getText();
                String password = passwordField.getText();

                if(isexistuser(Register.getList(),userName,password)){
                    CommonAlert.commonAlert("提示","登录成功!",null);
                    Home.first();
                }else {
                    CommonAlert.commonAlert("提示","用户或密码不正确",null);
                    userNameField.clear();
                    passwordField.clear();
                    System.out.println("账号或密码有误");
                }

            }

            private boolean isexistuser(List<User> list ,String username,String password) {
                if(username.equals("a") & password.equals("1") ){
                    return true;
                }
                for (int i = 0; i < list.size(); i++) {
                    if(username.equals(list.get(i).getUsername()) & password.equals(list.get(i).getPassword())){
                        return true;
                    }
                }
                return false;
            }
        });
        HBox hBox = new HBox(5);

        hBox.getChildren().addAll(loginButton,registButton);
        hBox.setAlignment(Pos.BOTTOM_CENTER);

        gridPane.add(hBox,3,3);

        Scene scene = new Scene(gridPane,935,532);
        MainApplication.setScene(scene);
    }
}
