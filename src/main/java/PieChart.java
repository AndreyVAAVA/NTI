import com.google.gson.Gson;
import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;
import java.util.ArrayList;

public class PieChart extends Application {

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

        Scene scene = new Scene(new Group());
        primaryStage.setTitle("Соотношение дней в которых скорость ветра больше 1м/c и меньше");
        primaryStage.setWidth(1280);
        primaryStage.setHeight(720);

        ObservableList<javafx.scene.chart.PieChart.Data> pieChartData =
                FXCollections.observableArrayList(
                        new javafx.scene.chart.PieChart.Data("With Wind > 1", count),
                        new javafx.scene.chart.PieChart.Data("With Wind <= 1", 5-count));
        final javafx.scene.chart.PieChart chart = new javafx.scene.chart.PieChart(pieChartData);
        chart.setTitle("Скорости ветра");

        ((Group) scene.getRoot()).getChildren().add(chart);
        primaryStage.setScene(scene);
        primaryStage.show();
    }
}
