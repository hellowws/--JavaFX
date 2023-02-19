package com.view.menu;

import com.view.about.About;
import com.view.booking.Fail;
import com.view.booking.Success;
import com.view.data.AnimationViewScene;
import com.view.data.StackedBarChartViewScene;
import com.view.data.UserDataViewScene;
import com.view.home.Home;
import com.view.personManage.EmployeeManage;
import com.view.personManage.PatientManage;
import javafx.application.Platform;
import javafx.scene.control.Menu;
import javafx.scene.control.MenuBar;
import javafx.scene.control.MenuItem;

public class MenuView {

    //这里是写死的 备份 暂时没用的
    public static MenuBar menuBar(){
        MenuBar menuBar = new MenuBar();


//        系统设置
        Menu sysMenu = new Menu("系统设置");
        MenuItem about=new MenuItem("关于我们");
        about.setOnAction(e->{
            About.about();
        });
        MenuItem home = new MenuItem("主页");
        home.setOnAction(e-> Home.first());
        MenuItem exit = new MenuItem("退出");
        exit.setOnAction(actionEvent -> Platform.exit());
        //配置系统设置菜单:关于我们退出
        sysMenu.getItems().addAll(home,about,exit);


//        基本信息管理
        Menu basicMenu = new Menu("基本信息管理");
        MenuItem employeManage = new MenuItem("职工信息管理");
        employeManage.setOnAction(e->{
            System.out.println("这是职工信息管理");
            EmployeeManage.table.getColumns().clear();
            EmployeeManage.table.getItems().clear();
            PatientManage.table.getColumns().clear();
            PatientManage.table.getItems().clear();
            EmployeeManage.employeemanage();
        });
        MenuItem patientMange = new MenuItem("患者信息管理");
        patientMange.setOnAction(e->{
            System.out.println("这是患者信息管理");
            EmployeeManage.table.getColumns().clear();
            EmployeeManage.table.getItems().clear();
            PatientManage.table.getColumns().clear();
            PatientManage.table.getItems().clear();
            PatientManage.patientmanage();
        });

        basicMenu.getItems().addAll(employeManage,patientMange);


//        文件上传s
        Menu registration = new Menu("挂号");
        MenuItem booking=new MenuItem("预约挂号");
        booking.setOnAction(e-> Success.start());

        MenuItem cancel=new MenuItem("取消挂号");
        cancel.setOnAction(e-> Fail.start());
        registration.getItems().addAll(booking,cancel);


//        数据分析
        Menu dataAnalysis = new Menu("数据分析");

        MenuItem userDataAnalysis = new MenuItem("用户分析");
        userDataAnalysis.setOnAction(e-> UserDataViewScene.user());

        MenuItem animationDataAnalysis = new MenuItem("动态图形");
        animationDataAnalysis.setOnAction(e-> AnimationViewScene.animation());

        MenuItem stackedBarChartDataAnalysis = new MenuItem("柱状图");
        stackedBarChartDataAnalysis.setOnAction(e-> StackedBarChartViewScene.stackedBarChart());

        //配置数据分析:用户分析、动态图形、折线图、柱状图
        dataAnalysis.getItems().addAll(userDataAnalysis,animationDataAnalysis,stackedBarChartDataAnalysis);

        //配置菜单导航栏:系统设置、基本信息管理、商品管理、数据分析
        menuBar.getMenus().addAll(sysMenu, basicMenu,registration,dataAnalysis);

        return menuBar;
    }

}
