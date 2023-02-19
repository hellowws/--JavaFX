package com.view.login;

import com.view.start.MainApplication;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Register {
    public static List<User> list = new ArrayList<>();
    public static void regist(){

        GridPane gridPane = new GridPane();
        gridPane.setAlignment(Pos.CENTER);
        gridPane.setVgap(20);

        Text text = new Text("注册账户");
        text.setFont(Font.font("宋体", FontWeight.NORMAL,20));
        text.setFill(Color.WHITE);
        //int columnIndex, int rowIndex, int colspan, int rowspan
        //0 列
        //0 行
        //占用 2列
        //占用 1行
        gridPane.add(text,0,0,2,1);

        Label userName = new Label("用户名：");
        userName.setTextFill(Color.WHITE);
        gridPane.add(userName,0,1);

        TextField userNameField = new TextField();
        //userNameField.setBackground(Background.fill(Color.TRANSPARENT));
        gridPane.add(userNameField,1,1);

        Label password = new Label("密码：");
        password.setTextFill(Color.WHITE);
        gridPane.add(password,0,2);

        PasswordField passwordField = new PasswordField();
        gridPane.add(passwordField,1,2);

        Label repassword = new Label("确认密码：");
        repassword.setTextFill(Color.WHITE);
        gridPane.add(repassword,0,3);

        PasswordField repasswordField = new PasswordField();
        gridPane.add(repasswordField,1,3);

        Button loginButton = new Button("返回登录");
        loginButton.setMinWidth(100);
        loginButton.setStyle(
                "-fx-background-color:#00BFFF;"+         //设置背景颜色
                        "-fx-background-radius:20;"+     //设置背景圆角
                        "-fx-text-fill:#ffffff;");        //设置字体颜色
        loginButton.setOnAction(e->Login.login());


        //注册功能--------------------
        Button registButton = new Button("注册");

        registButton.setOnAction(e-> {
            //获得输入的账号密码
            String un = userNameField.getText();
            String pwd = passwordField.getText();
            String repwd = repasswordField.getText();

            if(un!=null && pwd.equals(repwd)){

                User user =new User("a","123456");
                list.add(user);
                System.out.println(list);
                User u = new User(userNameField.getText(),passwordField.getText());


                if(isexist(list,u)){
                    list.add(u);
                    AlertPage.alert(Alert.AlertType.INFORMATION,"提示","注册成功!","请返回重新登录");
                    for (User user1 : list) {
                        System.out.println(user1.getUsername());
                    }
                }else {
                    AlertPage.alert(Alert.AlertType.ERROR,"提示","该用户已经存在!","请重新输入用户名密码");
                }

            }else{
                AlertPage.alert(Alert.AlertType.ERROR,"提示","两次输入密码不匹配！","请重新输入用户名密码");
            }

        });



        registButton.setMinWidth(100);
        registButton.setStyle(
                "-fx-background-color:#00BFFF;"+         //设置背景颜色
                        "-fx-background-radius:20;"+     //设置背景圆角
                        "-fx-text-fill:#ffffff;");        //设置字体颜色

        //水平布局
        HBox hBox = new HBox(10);
        //添加到水平布局hBox中
        hBox.getChildren().addAll(loginButton,registButton);
        hBox.setAlignment(Pos.BOTTOM_CENTER);

        gridPane.add(hBox,1,4);
//        gridPane.setStyle("-fx-background-image: url(file:src/images/35.jpg);");
        gridPane.setStyle("-fx-background-image: url('/images/register1.png');-fx-background-position: center center;-fx-background-repeat: no-repeat;-fx-background-attachment: fixed;-fx-background-size: cover;");

        Scene scene = new Scene(gridPane,935,532);

        MainApplication.setScene(scene);

    }


    private static boolean isexist(List<User> list,User user) {
        for (int i = 0; i < list.size(); i++) {
            if(list.get(i).getUsername().equals(user.getUsername())){
                System.out.println("该用户已存在");
                return false;
            }
        }
        return true;
    }

    public static List<User> getList(){
        return list;
    }


}
