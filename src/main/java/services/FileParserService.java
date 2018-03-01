package services;

import models.Car;
import models.Ride;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import static services.FileInfoService.getFileInfo;
import static java.lang.Integer.parseInt;

public class FileParserService {
    private FileParserService() {}
    private static class SingletonHolder {
        static final FileParserService SINGLETON = new FileParserService();
    }
    public static FileParserService getFileParser(){
        return SingletonHolder.SINGLETON;
    }

    public void parseFile(String fileName) {
        String line;
        String[] splited;
        try (BufferedReader br = new BufferedReader(new FileReader(new File(fileName)))) {
            // First Line
            line = br.readLine();
            splited = line.split("\\s+");
            getFileInfo().setRows(parseInt(splited[0]));
            getFileInfo().setColumns(parseInt(splited[1]));
            getFileInfo().setVehiclesLength(parseInt(splited[2]));
            getFileInfo().setRidesLength(parseInt(splited[3]));
            getFileInfo().setBonus(parseInt(splited[4]));
            getFileInfo().setSteps(parseInt(splited[5]));

            for(int i=0;i<getFileInfo().getRidesLength();i++){
                //parse ride
                line = br.readLine();
                splited = line.split("\\s+");

                int x0 = parseInt(splited[0]);
                int y0 = parseInt(splited[1]);
                int x1 = parseInt(splited[2]);
                int y1 = parseInt(splited[3]);
                int distance = Math.abs(x1-x0) + Math.abs(y1-y0);

                Ride ride = new Ride(i, x0, y0, x1, y1, parseInt(splited[4]), parseInt(splited[5]), distance);
                getFileInfo().getRides().add(ride);
            }

            List<Car> carList = new ArrayList<>();
            for(int i=0;i<getFileInfo().getVehiclesLength();i++){
                Car car = new Car();
                Ride ride = new Ride();
                ride.setDistance(0);
                ride.setLatestFinish(0);
                ride.setXFinish(0);
                ride.setYFinish(0);
                car.getRides().add(ride);
                carList.add(car);
            }
            getFileInfo().setCars(carList);

        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
    }
}
