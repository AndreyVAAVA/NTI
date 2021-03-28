import com.google.gson.Gson;
import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.chart.NumberAxis;
import javafx.scene.chart.PieChart;
import javafx.scene.chart.XYChart;
import javafx.stage.Stage;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;

import java.io.IOException;
import java.net.URL;
import java.net.URLConnection;

public class LineChart extends Application {

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) throws IOException {
        URL weather = new URL("https://api.openweathermap.org/data/2.5/forecast?q=Moscow&units=metric&cnt=5&appid=ec68664030634f2f21d3161c49b05b41");
        URLConnection api = weather.openConnection();
        BufferedReader in = new BufferedReader(
                new InputStreamReader(
                        api.getInputStream()));
        String inputLine;
        Gson gson = new Gson();
        MyModel model = null;
        while ((inputLine = in.readLine()) != null)
            model =  gson.fromJson(inputLine, MyModel.class);
        ArrayList<Double> temp = new ArrayList<>();
        ArrayList<Double> spd = new ArrayList<>();
        int oi = 0;

        model.getLis().forEach(x -> temp.add(x.getMan().getTemp()));
        model.getLis().forEach(x -> spd.add(x.getWin().getSpeed()));
        double med_temp = temp.get(Math.round(temp.size()/2));
        double z = 0;
        int p = 0;
        for (double elem:temp) {
            z+=elem;
            p++;
        }
        int count = 0;
        double mid_temp = z/p;
        for (double elem:spd) {
            if (elem > 1)
                count++;
        }
        System.out.println(med_temp);
        System.out.println(mid_temp);
        System.out.println(count);
        in.close();

        primaryStage.setTitle("Line Chart");
        //defining the axes
        final NumberAxis xAxis = new NumberAxis();
        final NumberAxis yAxis = new NumberAxis();
        xAxis.setLabel("Days");
        yAxis.setLabel("Temperature");
        //creating the chart
        final javafx.scene.chart.LineChart<Number, Number> lineChart = new javafx.scene.chart.LineChart<>(xAxis,yAxis);

        lineChart.setTitle("График средней температуры по дням");
        //defining a series
        XYChart.Series series = new XYChart.Series();
        series.setName("Temperature");
        //populating the series with data
        series.getData().add(new XYChart.Data(1, temp.get(0)));
        series.getData().add(new XYChart.Data(2, temp.get(1)));
        series.getData().add(new XYChart.Data(3, temp.get(2)));
        series.getData().add(new XYChart.Data(4, temp.get(3)));
        series.getData().add(new XYChart.Data(5, temp.get(4)));

        // Bigger resolution, could mean better quality. I select 1280*720, because my computer can handle that
        Scene scene  = new Scene(lineChart,1280,720);
        lineChart.getData().add(series);

        primaryStage.setScene(scene);
        primaryStage.show();
    }
}
