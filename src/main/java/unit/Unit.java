package unit;

import java.util.ArrayList;
import java.util.HashSet;

public class Unit {
    public final HashSet<String> connectedUnitsSet = new HashSet<>();
    public final ArrayList<Node> connectedUnits = new ArrayList<>();

    public Unit() {
    }
}
