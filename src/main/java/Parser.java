
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.squareup.okhttp.OkHttpClient;
import org.omg.CORBA.Request;

import javax.xml.ws.Response;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.lang.reflect.Type;
import java.net.URL;
import java.net.URLConnection;
import java.util.ArrayList;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;



public class Parser {
    public static void main(String[] args) throws IOException {
        URL weather = new URL("https://api.openweathermap.org/data/2.5/forecast?q=Moscow&cnt=5&appid=ec68664030634f2f21d3161c49b05b41");
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
    }

}
