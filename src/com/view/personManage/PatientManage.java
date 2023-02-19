package com.view.personManage;

import com.view.start.MainApplication;
import com.view.tool.CommonAlert;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.control.cell.TextFieldTableCell;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;
import javafx.util.Callback;
import org.w3c.dom.Text;

import javax.print.PrintService;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

public class PatientManage {
//    初始化定义List
    public static TableView<Person> table=new TableView<>();

    //    array存储表格数据用来输出
    public static ArrayList<String> array=new ArrayList<String>();
    public static void patientmanage() {
//        主布局
        BorderPane root=new BorderPane();
        root.setPadding(new Insets(0,0,0,0));

//        顶部布局
        MenuBar top= com.view.menu.MenuView.menuBar();

//        中间子布局

//        向表格内添加数据
        ObservableList<Person> data= FXCollections.observableArrayList(
                new Person("小明","男","19","2002.4.6","158666112"),
                new Person("小梁","男","30","2001.2.3","13567895223"),
                new Person("笑脸","男","13","2004.2.5","18954624575")
        );
        table.setItems(data);
        table.setEditable(true);//表格设置为可编辑

//        生成列头
        TableColumn<Person,String> name=new TableColumn("姓名");
        TableColumn<Person,String> Sex=new TableColumn("性别");
        TableColumn<Person,String> Ago=new TableColumn("年龄");
        TableColumn<Person,String> Year=new TableColumn("出生日期");
        TableColumn<Person,String> Telephone=new TableColumn("电话");
        TableColumn<Person,String> Operation=new TableColumn("功能");

//        调用一个方法可以让列可以编辑
        name.setCellFactory(TextFieldTableCell.forTableColumn());
        Sex.setCellFactory(TextFieldTableCell.forTableColumn());
        Ago.setCellFactory(TextFieldTableCell.forTableColumn());
        Year.setCellFactory(TextFieldTableCell.forTableColumn());
        Telephone.setCellFactory(TextFieldTableCell.forTableColumn());


        //设置每个单元格可修改,并且可以监听到且修改Person里的数据！
        name.setOnEditCommit(
                (TableColumn.CellEditEvent<Person, String> t) -> {
                    ((Person) t.getTableView().getItems().get(
                            t.getTablePosition().getRow())
                    ).setName(t.getNewValue());
                });
        Sex.setOnEditCommit(
                (TableColumn.CellEditEvent<Person, String> t) -> {
                    ((Person) t.getTableView().getItems().get(
                            t.getTablePosition().getRow())
                    ).setSex(t.getNewValue());
                });
        Ago.setOnEditCommit(
                (TableColumn.CellEditEvent<Person, String> t) -> {
                    ((Person) t.getTableView().getItems().get(
                            t.getTablePosition().getRow())
                    ).setAgo(t.getNewValue());
                });
        Year.setOnEditCommit(
                (TableColumn.CellEditEvent<Person, String> t) -> {
                    ((Person) t.getTableView().getItems().get(
                            t.getTablePosition().getRow())
                    ).setYear(t.getNewValue());
                });
        Telephone.setOnEditCommit(
                (TableColumn.CellEditEvent<Person, String> t) -> {
                    ((Person) t.getTableView().getItems().get(
                            t.getTablePosition().getRow())
                    ).setTelephone(t.getNewValue());
                });





//        将表头用数据模型来表示？所以这里的name要和数据模型中的一致才能显示,我们也可以用回调函数来设置单一个单位
        name.setCellValueFactory(new PropertyValueFactory<>("name"));
        Sex.setCellValueFactory(new PropertyValueFactory<>("Sex"));
        Ago.setCellValueFactory(new PropertyValueFactory<>("Ago"));
        Year.setCellValueFactory(new PropertyValueFactory<>("Year"));
        Telephone.setCellValueFactory(new PropertyValueFactory<>("Telephone"));
        Operation.setCellFactory(new Callback<TableColumn<Person, String>, TableCell<Person, String>>() {
            @Override
            public TableCell<Person, String> call(TableColumn<Person, String> param) {

//                这里设置一个子布局，嵌入到单元格中
                HBox hBox = new HBox(10);
                hBox.setAlignment(Pos.CENTER);
                Button delete = new Button("删除");
                Button edit = new Button("编辑");
                hBox.getChildren().addAll(delete,edit);
//                这里还需要一个函数来放子布局并进行一些操作
                TableCell<Person, String> tableCell = new TableCell<>(){
                    @Override
                    protected void updateItem(String item, boolean empty) {
                        super.updateItem(item, empty);
//                        如果其他列的行为空,则不显示控件按钮
                        if(empty){
                            setGraphic(null);
                            setText(null);
                        }else {
                            delete.setOnAction(e->{
//                                user为当前行内容的对象
                                Person user = getTableView().getItems().get(getIndex());
                                System.out.println(user.toString());
                                CommonAlert.commonAlert("提示","删除成功!",null);
                                data.remove(user);
                            });
                            edit.setOnAction(e->{
                                Person user = getTableView().getItems().get(getIndex());
                                System.out.println(getTableView().getItems().get(getIndex()));
                            });
//                                设置布局
                            setGraphic(hBox);
                            setText(null);
                        }
                    }
                };
//                返回函数
                return tableCell;
            }
        });


//        表格响应式布局将表头单位添加到table中去
        name.prefWidthProperty().bind(table.widthProperty().multiply(0.2));
        Sex.prefWidthProperty().bind(table.widthProperty().multiply(0.2));
        Ago.prefWidthProperty().bind(table.widthProperty().multiply(0.1));
        Year.prefWidthProperty().bind(table.widthProperty().multiply(0.2));
        Telephone.prefWidthProperty().bind(table.widthProperty().multiply(0.2));
        Operation.prefWidthProperty().bind(table.widthProperty().multiply(0.1));
//        添加列信息到表格中
        table.getColumns().addAll(name,Sex,Ago,Year,Telephone,Operation);



//        底部布局
        VBox bottom=new VBox(5);
        bottom.setPadding(new Insets(20,5,0,5));
//        添加文字：
        HBox addText=new HBox();
        addText.setPadding(new Insets(1,0,5,0));
        Label text=new Label("添加数据 :");
        addText.getChildren().add(text);
//        添加文本域以及按钮
        HBox addHBox=new HBox(10);
        TextField addText1=new TextField();
        TextField addText2=new TextField();
        TextField addText3=new TextField();
        TextField addText4=new TextField();
        TextField addText5=new TextField();
        Button addbtn=new Button("添加");
        addbtn.setOnAction(e->{
//            不支持首空格和只有空格的文字
            if(!addText1.getText().trim().isEmpty() & !addText2.getText().trim().isEmpty() ){
                CommonAlert.commonAlert("提示","添加成功!",null);
                data.add(new Person(addText1.getText(), addText2.getText(),addText3.getText(),addText4.getText(),addText5.getText()));
                addText1.clear();
                addText2.clear();
            }
        });


        HBox fileUpload=new HBox();
        Button uploadBtn=new Button("导出表格");
        uploadBtn.setOnAction(e->{
            array.add("姓名"+'\t'+"性别"+'\t'+"年龄"+'\t'+"出生日期"+'\t'+"电话");
            for(int i=0;i<data.size();i++){
                array.add(data.get(i).toString());
            }
            try{
                BufferedWriter bw=new BufferedWriter(new FileWriter("患者信息表格.xls"));
                for(String s : array) {
                    bw.write(s);
                    bw.newLine();
                    bw.flush();
                }
                bw.close();
            }catch (IOException c){
                c.printStackTrace();
            }
            CommonAlert.commonAlert("提示","导出成功!",null);
        });
        fileUpload.getChildren().addAll(uploadBtn);



        HBox imageHBox=new HBox();
        imageHBox.prefWidthProperty().bind(table.widthProperty().multiply(1));
        imageHBox.setAlignment(Pos.CENTER_RIGHT);
        Label title=new Label("患者信息管理");
        title.setFont(Font.font("楷体",30));
        Image image = new Image("images\\bg.png");
        ImageView imageView=new ImageView(image);
        imageView.setFitWidth(100);
        imageView.setFitHeight(100);
        imageHBox.getChildren().addAll(title,imageView);


        addHBox.getChildren().addAll(addText1,addText2,addText3,addText4,addText5,addbtn);
        bottom.getChildren().addAll(addText,addHBox,fileUpload,imageHBox);

        root.setTop(top);
        root.setCenter(table);
        root.setBottom(bottom);
        Scene scene = new Scene(root, 1200, 532);
        MainApplication.setScene(scene);
        CommonAlert.commonAlert("提示","查询成功!",null);
    }



    //        首先构造一个数据模型来提供一个单位使用
    public static class Person{
        private  String name;
        private  String Sex;
        private String Ago;
        private String Year;
        private String Telephone;
        private String Operation;

        public Person(){}
        public Person(String name,String Sex,String Ago,String Year,String Telephone){
            this.name=name;
            this.Sex=Sex;
            this.Ago=Ago;
            this.Year=Year;
            this.Telephone=Telephone;
            this.Operation=Operation;
        }

        public String getName(){
            return name;
        }
        public String getSex(){
            return Sex;
        }

        public String getAgo() {
            return Ago;
        }

        public String getYear() {
            return Year;
        }

        public String getTelephone() {
            return Telephone;
        }


        public void setName(String name){
            this.name=name;
        }
        public void setSex(String charge){
            this.Sex=charge;
        }

        public void setAgo(String ago) {
            Ago = ago;
        }

        public void setYear(String year) {
            Year = year;
        }

        public void setTelephone(String telephone) {
            Telephone = telephone;
        }



        @Override
        public String toString(){
            return name+'\t'+Sex+
                    '\t'+Ago+'\t'+Year+'\t'+Telephone;
        }
    }
}
