package pages.casePage;

public class VehicleSearch {
    private static VehicleSearch vehicleSearchTab = null;

    private VehicleSearch() {}

    public static VehicleSearch getTabInstance(){
        if(vehicleSearchTab == null){
            vehicleSearchTab = new VehicleSearch();
        }
        return vehicleSearchTab;
    }
}
