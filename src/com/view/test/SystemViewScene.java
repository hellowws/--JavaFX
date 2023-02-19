package com.view.test;

import com.view.menu.MenuView;
import com.view.start.MainApplication;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.control.cell.TextFieldTableCell;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;
import javafx.util.Callback;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

public class SystemViewScene {

    public static void system(){
        BorderPane borderPane = new BorderPane();


        MenuBar menuBar = MenuView.menuBar();


        Pagination pagination  = new Pagination(10, 0);

        pagination.setMinWidth(800);
        pagination.setMinHeight(400);
        pagination.setPageFactory(pageIndex -> createPage(pageIndex));

        borderPane.setTop(menuBar);
        Group group = new Group();
        group.getChildren().add(pagination);
        borderPane.setCenter(group);

        Scene scene = new Scene(borderPane,935,532);
        MainApplication.setScene(scene);


    }


    public static VBox createPage(Integer pageIndex){

        TableView<User> tableView = new TableView<>();
        ObservableList<User> data = FXCollections.observableArrayList(
                new User(1L, LocalDateTime.now(),"张三","123456"),
                new User(2L,LocalDateTime.now(),"李四","123456"),
                new User(3L,LocalDateTime.now(),"王五","123456"),
                new User(4L,LocalDateTime.now(),"赵六","123456")
        );

        tableView.setItems(data);

        TableColumn id = new TableColumn("id");
        id.setCellValueFactory(new PropertyValueFactory<>("id"));

        TableColumn<User,LocalDateTime> addTime = new TableColumn("addTime");
        addTime.setCellValueFactory(new PropertyValueFactory<>("addTime"));
        addTime.setCellFactory(new Callback<TableColumn<User, LocalDateTime>, TableCell<User, LocalDateTime>>() {
            @Override
            public TableCell<User, LocalDateTime> call(TableColumn<User, LocalDateTime> param) {

                TableCell<User, LocalDateTime> tableCell = new TableCell<>(){
                    @Override
                    protected void updateItem(LocalDateTime item, boolean empty) {
                        super.updateItem(item, empty);
                        if(empty){
                            setText(null);
                            setGraphic(null);
                        }else {
                            String d = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss").format(item);
                            this.setText(d);
                        }
                    }
                };

                return tableCell;
            }
        });

        TableColumn userName = new TableColumn("userName");
        userName.setCellValueFactory(new PropertyValueFactory<>("userName"));

        TableColumn password = new TableColumn("password");
        password.setCellValueFactory(new PropertyValueFactory<>("password"));

        TableColumn<User,String> operation = new TableColumn("操作");
        operation.setCellFactory(new Callback<TableColumn<User, String>, TableCell<User, String>>() {
            @Override
            public TableCell<User, String> call(TableColumn<User, String> param) {

                Button delete = new Button("删除");
                Button edit = new Button("编辑");

                HBox hBox = new HBox(10);
                hBox.getChildren().addAll(delete,edit);

                TableCell<User, String> tableCell = new TableCell<>(){
                    @Override
                    protected void updateItem(String item, boolean empty) {
                        super.updateItem(item, empty);
                        if(empty){
                            setGraphic(null);
                            setText(null);
                        }else {
                            delete.setOnAction(e->{
                                User user = getTableView().getItems().get(getIndex());
                                data.remove(user);
                            });
                            setGraphic(hBox);
                            setText(null);
                        }
                    }
                };

                return tableCell;
            }
        });

        tableView.getColumns().addAll(id,addTime,userName,password,operation);

        VBox vBox = new VBox();
        vBox.getChildren().add(tableView);
//        vBox.setAlignment(Pos.CENTER);//内容居中

        return vBox;
    }

    public static class User{
        private Long id;
        private LocalDateTime addTime;
        private String userName;
        private String password;

        public User() {
        }

        public User(Long id, LocalDateTime addTime, String userName, String password) {
            this.id = id;
            this.addTime = addTime;
            this.userName = userName;
            this.password = password;
        }

        public Long getId() {
            return id;
        }

        public void setId(Long id) {
            this.id = id;
        }

        public LocalDateTime getAddTime() {
            return addTime;
        }

        public void setAddTime(LocalDateTime addTime) {
            this.addTime = addTime;
        }

        public String getUserName() {
            return userName;
        }

        public void setUserName(String userName) {
            this.userName = userName;
        }

        public String getPassword() {
            return password;
        }

        public void setPassword(String password) {
            this.password = password;
        }

        @Override
        public String toString() {
            return "User{" +
                    "id=" + id +
                    ", addTime=" + addTime +
                    ", userName='" + userName + '\'' +
                    ", password='" + password + '\'' +
                    '}';
        }
    }
}
