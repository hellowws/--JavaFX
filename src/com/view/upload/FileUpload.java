package com.view.upload;
import com.view.personManage.EmployeeManage;
import com.view.start.MainApplication;
import javafx.scene.Scene;
import javafx.scene.control.MenuBar;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

public class FileUpload {
    public static void fileupload(ArrayList<String> data) throws Exception{
        // 创建缓冲输出流
        try{
            BufferedWriter bw=new BufferedWriter(new FileWriter("a.txt"));
            for(String s : data) {
                bw.write(s);
                bw.write('\n');
                bw.newLine();
                bw.flush();
            }
            bw.close();
    }catch (IOException e){
            e.printStackTrace();
        }
    }
}
