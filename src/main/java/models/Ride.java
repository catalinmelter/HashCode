package models;

import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@ToString
public class Ride {
    int index;
    int xStart;
    int yStart;

    int xFinish;
    int yFinish;

    int earliestStart;
    int latestFinish;

    int distance;

    int realStart;
    int realFinish;

    public Ride() {
    }

    public Ride(int index, int xStart, int yStart, int xFinish, int yFinish, int earliestStart, int latestFinish, int distance) {
        this.index = index;
        this.xStart = xStart;
        this.yStart = yStart;
        this.xFinish = xFinish;
        this.yFinish = yFinish;
        this.earliestStart = earliestStart;
        this.latestFinish = latestFinish;
        this.distance = distance;
    }
}
