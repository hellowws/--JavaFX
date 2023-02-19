package com.view.data;

import com.view.menu.MenuView;
import com.view.start.MainApplication;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.Scene;
import javafx.scene.chart.PieChart;
import javafx.scene.control.MenuBar;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.StackPane;

public class UserDataViewScene {

    public static void user(){
        BorderPane borderPane = new BorderPane();

        MenuBar menuBar = MenuView.menuBar();

        PieChart pieChart = new PieChart();
        pieChart.setData(getChartData());

        StackPane root = new StackPane();
        root.getChildren().add(pieChart);

        borderPane.setTop(menuBar);
        borderPane.setCenter(root);

        Scene scene = new Scene(borderPane, 900, 500);

        MainApplication.setScene(scene);
    }

    private static ObservableList<PieChart.Data> getChartData() {
        ObservableList<PieChart.Data> answer = FXCollections.observableArrayList();
        answer.addAll(new PieChart.Data("线上预约", 10.30),new PieChart.Data("线下预约", 39.70));
        return answer;
    }
}
