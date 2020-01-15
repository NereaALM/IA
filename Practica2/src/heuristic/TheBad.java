package heuristic;

import structure.State;

public class TheBad implements Heuristic {
    @Override
    public float heuristic (State state) {
        return 0;
    }
}
