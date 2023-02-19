package com.view.data;

import com.view.menu.MenuView;
import com.view.start.MainApplication;
import javafx.scene.Scene;
import javafx.scene.chart.CategoryAxis;
import javafx.scene.chart.LineChart;
import javafx.scene.chart.NumberAxis;
import javafx.scene.chart.XYChart;
import javafx.scene.control.MenuBar;
import javafx.scene.layout.BorderPane;

public class LineChartViewScene {

    public static void lineChart(){
        BorderPane borderPane = new BorderPane();
        MenuBar menuBar = MenuView.menuBar();

        borderPane.setTop(menuBar);

        CategoryAxis xAxis = new CategoryAxis();
        NumberAxis yAxis = new NumberAxis();
        xAxis.setLabel("Month");

        final LineChart<String, Number> lineChart =

                new LineChart<String, Number>(xAxis, yAxis);


        lineChart.setTitle("Stock Monitoring, 2022");


        XYChart.Series<String, Number> series1 = new XYChart.Series<String, Number>();

        series1.setName("Portfolio 1");


        series1.getData().add(new XYChart.Data<String, Number>("Jan", 23));

        series1.getData().add(new XYChart.Data("Feb", 14));

        series1.getData().add(new XYChart.Data("Mar", 15));

        series1.getData().add(new XYChart.Data("Apr", 24));

        series1.getData().add(new XYChart.Data("May", 34));

        series1.getData().add(new XYChart.Data("Jun", 36));

        series1.getData().add(new XYChart.Data("Jul", 22));

        series1.getData().add(new XYChart.Data("Aug", 45));

        series1.getData().add(new XYChart.Data("Sep", 43));

        series1.getData().add(new XYChart.Data("Oct", 17));

        series1.getData().add(new XYChart.Data("Nov", 29));

        series1.getData().add(new XYChart.Data("Dec", 25));


        XYChart.Series<String, Number> series2 = new XYChart.Series<String, Number>();

        series2.setName("Portfolio 2");

        series2.getData().add(new XYChart.Data("Jan", 33));

        series2.getData().add(new XYChart.Data("Feb", 34));

        series2.getData().add(new XYChart.Data("Mar", 25));

        series2.getData().add(new XYChart.Data("Apr", 44));

        series2.getData().add(new XYChart.Data("May", 39));

        series2.getData().add(new XYChart.Data("Jun", 16));

        series2.getData().add(new XYChart.Data("Jul", 55));

        series2.getData().add(new XYChart.Data("Aug", 54));

        series2.getData().add(new XYChart.Data("Sep", 48));

        series2.getData().add(new XYChart.Data("Oct", 27));

        series2.getData().add(new XYChart.Data("Nov", 37));

        series2.getData().add(new XYChart.Data("Dec", 29));


        XYChart.Series<String, Number> series3 = new XYChart.Series<String, Number>();

        series3.setName("Portfolio 3");

        series3.getData().add(new XYChart.Data("Jan", 44));

        series3.getData().add(new XYChart.Data("Feb", 35));

        series3.getData().add(new XYChart.Data("Mar", 36));

        series3.getData().add(new XYChart.Data("Apr", 33));

        series3.getData().add(new XYChart.Data("May", 31));

        series3.getData().add(new XYChart.Data("Jun", 26));

        series3.getData().add(new XYChart.Data("Jul", 22));

        series3.getData().add(new XYChart.Data("Aug", 25));

        series3.getData().add(new XYChart.Data("Sep", 43));

        series3.getData().add(new XYChart.Data("Oct", 44));

        series3.getData().add(new XYChart.Data("Nov", 45));

        series3.getData().add(new XYChart.Data("Dec", 44));

        lineChart.getData().addAll(series1, series2, series3);

        borderPane.setCenter(lineChart);

        Scene scene = new Scene(borderPane, 900, 500);
        MainApplication.setScene(scene);


    }

}
