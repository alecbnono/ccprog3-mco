package model;

public class Milk implements Liquid {
    private final double volumeinflOz = 640;

    @Override
    public double getVolumeinflOz() {
        return volumeinflOz;
    }
}
