
public class Airport {

    private String id;

    private String name;

    private String city;

    private String country;

    private String code;

    private String icaoCode;

    private String locationX;

    private String locationY;

    private String elevationFt;

    private String elevationM;

    private String index;

    private String port;



    public Airport(String id, String name, String city, String country, String code, String icaoCode, String locationX, String locationY, String elevationFt, String elevationM, String index, String port) {
        this.id = id;
        this.name = name;
        this.city = city;
        this.country = country;
        this.code = code;
        this.icaoCode = icaoCode;
        this.locationX = locationX;
        this.locationY = locationY;
        this.elevationFt = elevationFt;
        this.elevationM = elevationM;
        this.index = index;
        this.port = port;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getIcaoCode() {
        return icaoCode;
    }

    public void setIcaoCode(String icaoCode) {
        this.icaoCode = icaoCode;
    }

    public String getLocationX() {
        return locationX;
    }

    public void setLocationX(String locationX) {
        this.locationX = locationX;
    }

    public String getLocationY() {
        return locationY;
    }

    public void setLocationY(String locationY) {
        this.locationY = locationY;
    }

    public String getElevationFt() {
        return elevationFt;
    }

    public void setElevationFt(String elevationFt) {
        this.elevationFt = elevationFt;
    }

    public String getElevationM() {
        return elevationM;
    }

    public void setElevationM(String elevationM) {
        this.elevationM = elevationM;
    }

    public String getIndex() {
        return index;
    }

    public void setIndex(String index) {
        this.index = index;
    }

    public String getPort() {
        return port;
    }

    public void setPort(String port) {
        this.port = port;
    }


    @Override
    public String toString() {
        return  id + " " +
                name + " " +
                city + " " +
                country + " " +
                code + " " +
                icaoCode + " " +
                locationX + " " +
                locationY + " " +
                elevationFt + " " +
                elevationM + " " +
                index + " " +
                port;
    }


}
