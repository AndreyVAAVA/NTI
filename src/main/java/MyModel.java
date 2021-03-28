import com.google.gson.annotations.SerializedName;

import java.util.ArrayList;
import java.util.List;

public class MyModel {

    private String cod;
    private int message;
    private int cnt;
    @SerializedName("list")
    private ArrayList<list> lis = new ArrayList<>();
    @SerializedName("city")
    private city cit;

    public String getCod() {
        return cod;
    }

    public void setCod(String cod) {
        this.cod = cod;
    }

    public int getMessage() {
        return message;
    }

    public void setMessage(int message) {
        this.message = message;
    }

    public int getCnt() {
        return cnt;
    }

    public void setCnt(int cnt) {
        this.cnt = cnt;
    }

    public ArrayList<list> getLis() {
        return lis;
    }

    public void setLis(ArrayList<list> lis) {
        this.lis = lis;
    }

    public city getCit() {
        return cit;
    }

    public void setCit(city cit) {
        this.cit = cit;
    }
}
class list{
    private int dt;
    @SerializedName("main")
    private main man;
    @SerializedName("weather")
    private ArrayList<weather> weath;
    @SerializedName("clouds")
    private clouds cld;
    @SerializedName("wind")
    private wind win;
    private String visibility;
    private String pop;
    @SerializedName("sys")
    private sys s;
    private String dt_txt;

    public int getDt() {
        return dt;
    }

    public void setDt(int dt) {
        this.dt = dt;
    }

    public main getMan() {
        return man;
    }

    public void setMan(main man) {
        this.man = man;
    }

    public ArrayList<weather> getWeath() {
        return weath;
    }

    public void setWeath(ArrayList<weather> weath) {
        this.weath = weath;
    }

    public clouds getCld() {
        return cld;
    }

    public void setCld(clouds cld) {
        this.cld = cld;
    }

    public wind getWin() {
        return win;
    }

    public void setWin(wind win) {
        this.win = win;
    }

    public String getVisibility() {
        return visibility;
    }

    public void setVisibility(String visibility) {
        this.visibility = visibility;
    }

    public String getPop() {
        return pop;
    }

    public void setPop(String pop) {
        this.pop = pop;
    }

    public sys getS() {
        return s;
    }

    public void setS(sys s) {
        this.s = s;
    }

    public String getDt_txt() {
        return dt_txt;
    }

    public void setDt_txt(String dt_txt) {
        this.dt_txt = dt_txt;
    }
}
class main{
    private double temp;
    private double feels_like;
    private double temp_min;
    private double temp_max;
    private int pressure;
    private int sea_level;
    private int grnd_lvl;
    private int humidity;
    private double temp_kf;

    public double getTemp() {
        return temp;
    }

    public void setTemp(double temp) {
        this.temp = temp;
    }

    public double getFeels_like() {
        return feels_like;
    }

    public void setFeels_like(double feels_like) {
        this.feels_like = feels_like;
    }

    public double getTemp_min() {
        return temp_min;
    }

    public void setTemp_min(double temp_min) {
        this.temp_min = temp_min;
    }

    public double getTemp_max() {
        return temp_max;
    }

    public void setTemp_max(double temp_max) {
        this.temp_max = temp_max;
    }

    public int getPressure() {
        return pressure;
    }

    public void setPressure(int pressure) {
        this.pressure = pressure;
    }

    public int getSea_level() {
        return sea_level;
    }

    public void setSea_level(int sea_level) {
        this.sea_level = sea_level;
    }

    public int getGrnd_lvl() {
        return grnd_lvl;
    }

    public void setGrnd_lvl(int grnd_lvl) {
        this.grnd_lvl = grnd_lvl;
    }

    public int getHumidity() {
        return humidity;
    }

    public void setHumidity(int humidity) {
        this.humidity = humidity;
    }

    public double getTemp_kf() {
        return temp_kf;
    }

    public void setTemp_kf(double temp_kf) {
        this.temp_kf = temp_kf;
    }
}
class weather{
    @SerializedName("id")
    private int id;
    @SerializedName("main")
    private String really;
    @SerializedName("description")
    private String description;
    @SerializedName("icon")
    private String icon;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getReally() {
        return really;
    }

    public void setReally(String really) {
        this.really = really;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getIcon() {
        return icon;
    }

    public void setIcon(String icon) {
        this.icon = icon;
    }
}
class clouds{
    private int all;

    public int getAll() {
        return all;
    }

    public void setAll(int all) {
        this.all = all;
    }
}
class sys{
    private String pod;

    public String getPod() {
        return pod;
    }

    public void setPod(String pod) {
        this.pod = pod;
    }
}
class wind{
    private double speed;
    private int deg;

    public double getSpeed() {
        return speed;
    }

    public void setSpeed(double speed) {
        this.speed = speed;
    }

    public int getDeg() {
        return deg;
    }

    public void setDeg(int deg) {
        this.deg = deg;
    }
}
class city{
    private int id;
    private String name;
    private coord cord;
    private String country;
    private int population;
    private int timezone;
    private int sunrise;
    private int sunset;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public coord getCord() {
        return cord;
    }

    public void setCord(coord cord) {
        this.cord = cord;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public int getPopulation() {
        return population;
    }

    public void setPopulation(int population) {
        this.population = population;
    }

    public int getTimezone() {
        return timezone;
    }

    public void setTimezone(int timezone) {
        this.timezone = timezone;
    }

    public int getSunrise() {
        return sunrise;
    }

    public void setSunrise(int sunrise) {
        this.sunrise = sunrise;
    }

    public int getSunset() {
        return sunset;
    }

    public void setSunset(int sunset) {
        this.sunset = sunset;
    }
}
class coord{
    private double lat;
    private double lon;

    public double getLat() {
        return lat;
    }

    public void setLat(double lat) {
        this.lat = lat;
    }

    public double getLon() {
        return lon;
    }

    public void setLon(double lon) {
        this.lon = lon;
    }
}

