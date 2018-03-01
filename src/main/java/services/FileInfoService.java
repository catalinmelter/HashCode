package services;

import lombok.Getter;
import lombok.Setter;
import models.Ride;

import java.util.ArrayList;
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

    private FileInfoService() {}
    private static class SingletonHolder {
        static final FileInfoService SINGLETON = new FileInfoService();
    }
    public static FileInfoService getFileInfo(){
        return SingletonHolder.SINGLETON;
    }

    public void logic(){
        //logic in here
    }
}
