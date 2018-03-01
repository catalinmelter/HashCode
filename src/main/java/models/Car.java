package models;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.LinkedList;
import java.util.List;

@Getter
@Setter
@NoArgsConstructor
public class Car {
    private int x;
    private int y;
    private int distanceToStart;
    private List<Ride> rides = new LinkedList<>();
}
