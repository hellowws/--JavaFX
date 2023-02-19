package com.view.data;

import com.view.menu.MenuView;
import com.view.start.MainApplication;
import javafx.collections.FXCollections;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.chart.CategoryAxis;
import javafx.scene.chart.NumberAxis;
import javafx.scene.chart.StackedBarChart;
import javafx.scene.chart.XYChart;
import javafx.scene.control.MenuBar;
import javafx.scene.layout.BorderPane;

import java.util.Arrays;

public class StackedBarChartViewScene {

    public static void stackedBarChart(){
        BorderPane borderPane = new BorderPane();
        MenuBar menuBar = MenuView.menuBar();

        borderPane.setTop(menuBar);

        Group root = new Group();

        final CategoryAxis xAxis = new CategoryAxis();
        final NumberAxis yAxis = new NumberAxis();

        xAxis.setLabel("Month");
        xAxis.setCategories(FXCollections.<String> observableArrayList(Arrays.asList(
                "January",
                "February",
                "March")));
        yAxis.setLabel("Value");

        final StackedBarChart<String,Number> stackedBarChart = new StackedBarChart<String,Number>(xAxis,yAxis);
        stackedBarChart.setTitle("就诊人数对比");

        XYChart.Series<String,Number> series1 = new XYChart.Series();
        series1.setName("线下预约就诊人数");

        series1.getData().add(new XYChart.Data("January", 70));
        series1.getData().add(new XYChart.Data("February", 200));
        series1.getData().add(new XYChart.Data("March", 80));

        XYChart.Series<String,Number> series2 = new XYChart.Series();
        series2.setName("线上预约就诊人数");

        series2.getData().add(new XYChart.Data("January", 150));
        series2.getData().add(new XYChart.Data("February", 70));
        series2.getData().add(new XYChart.Data("March", 110));

        stackedBarChart.getData().addAll(series1, series2);

        root.getChildren().addAll(stackedBarChart);

        borderPane.setCenter(root);

        Scene scene = new Scene(borderPane, 900, 500);
        MainApplication.setScene(scene);
    }

}
