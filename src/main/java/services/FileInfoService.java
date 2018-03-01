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
        for (Car car : getFileInfo().getCars()) {
            Ride lastRide = car.getRides().get(car.getRides().size() - 1);


            for (int rideIndex = 0; rideIndex < rides.size(); rideIndex++) {
                Integer distanceBtw = getDistanceBetweenTwoRides(lastRide, rides.get(rideIndex));

                if (lastRide.getRealFinish() + distanceBtw <= rides.get(rideIndex).getEarliestStart()) {
                    rides.get(rideIndex).setRealFinish(lastRide.getRealFinish() + distanceBtw + rides.get(rideIndex).getDistance());
                    rides.get(rideIndex).setRealStart(rides.get(rideIndex).getEarliestStart());
                    car.getRides().add(rides.get(rideIndex));
                    rides.remove(rides.get(rideIndex));
                    rideIndex = 0;
                    System.out.println(rides.get(rideIndex).toString());
                }

            }
        }

    }

    public Integer getDistanceBetweenTwoRides(Ride r1, Ride r2) {
        return (Math.abs(r1.getXFinish() - r2.getXStart()) + Math.abs(r1.getYFinish() - r2.getYStart()));
    }


}
