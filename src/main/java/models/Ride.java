package models;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public class Ride {
    int xStart;
    int yStart;

    int xFinish;
    int yFinish;

    int earliestStart;
    int latestFinish;

    int distance;
}
