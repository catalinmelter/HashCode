package services;

import lombok.Getter;
import lombok.Setter;
import models.Car;
import models.Ride;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

@Getter
@Setter
public class FileInfoService {
    private Integer rows;
    private Integer columns;
    private Integer vehiclesLength;
    private Integer ridesLength;
    private Integer bonus;
    private Integer steps;
    private List<Ride> rides = new ArrayList<>();
    private List<Car> cars = new ArrayList<>();

    private FileInfoService() {
    }

    private static class SingletonHolder {
        static final FileInfoService SINGLETON = new FileInfoService();
    }

    public static FileInfoService getFileInfo() {
        return SingletonHolder.SINGLETON;
    }

    public void logic() {
        //rides sorted
        rides.sort(Comparator.comparing(Ride::getEarliestStart));

        //

        boolean boleanSort = true;
        while (boleanSort) {
            boleanSort=false;
            for (Car car : getFileInfo().getCars()) {
                Ride lastRide = car.getRides().get(car.getRides().size() - 1);


                for (int rideIndex = 0; rideIndex < rides.size(); rideIndex++) {
                    Integer distanceBtw = getDistanceBetweenTwoRides(lastRide, rides.get(rideIndex));

                    if (lastRide.getRealFinish() + distanceBtw <= rides.get(rideIndex).getEarliestStart() &&
                            lastRide.getRealFinish() + distanceBtw + rides.get(rideIndex).getDistance() < rides.get(rideIndex).getLatestFinish()) {

                        if (rides.get(rideIndex).getLatestFinish() <= steps) {
                            rides.get(rideIndex).setRealFinish(lastRide.getRealFinish() + distanceBtw + rides.get(rideIndex).getDistance());
                            rides.get(rideIndex).setRealStart(lastRide.getRealFinish() + distanceBtw);
                            car.getRides().add(rides.get(rideIndex));

                            //System.out.println(car.getCarIndex() + "  " + rides.get(rideIndex).toString());
                            rides.remove(rides.get(rideIndex));
                            rideIndex =  rides.size();
                            boleanSort = true;
                            break;
                        }
                    }
                }
            }
        }
        for (Car car : getFileInfo().getCars()) {

            System.out.println(car.getCarIndex());
            for (Ride ride : car.getRides()) {
                System.out.print(" " + ride.getIndex());
            }
        }


    }

    public Integer getDistanceBetweenTwoRides(Ride r1, Ride r2) {
        return (Math.abs(r1.getXFinish() - r2.getXStart()) + Math.abs(r1.getYFinish() - r2.getYStart()));
    }


}
