package models;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Ride {
    int xStart;
    int yStart;

    int xFinish;
    int yFinish;

    int distance;

    int earliestStart;
    int latestFinish;

}
