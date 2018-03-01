package services;

public class FileInfoService {
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
