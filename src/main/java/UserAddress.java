public class UserAddress {
    private Integer id;
    private String cityName;
    private Integer zipCode;
    private String streetName;
    private Integer houseNumber;

    public UserAddress(Integer id, String cityName, Integer zipCode, String streetName, Integer houseNumber) {
        this.id = id;
        this.cityName = cityName;
        this.zipCode = zipCode;
        this.streetName = streetName;
        this.houseNumber = houseNumber;
    }

    public UserAddress(String cityName, Integer zipCode, String streetName, Integer houseNumber) {
        this.cityName = cityName;
        this.zipCode = zipCode;
        this.streetName = streetName;
        this.houseNumber = houseNumber;
    }

    public Integer getId() {
        return id;
    }

    public String getCityName() {
        return cityName;
    }

    public Integer getZipCode() {
        return zipCode;
    }

    public String getStreetName() {
        return streetName;
    }

    public Integer getHouseNumber() {
        return houseNumber;
    }

    @Override
    public String toString() {
        return "UserAdress{" +
                "id=" + id +
                ", cityName='" + cityName + '\'' +
                ", zipCode=" + zipCode +
                ", streetName='" + streetName + '\'' +
                ", houseNumber=" + houseNumber +
                "}\n";
    }
}
