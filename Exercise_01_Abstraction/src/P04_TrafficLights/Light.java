package P04_TrafficLights;

public class Light {
    private Signal signal;

    public void changeSignal() {

        if (this.signal.name().equals("RED")) {
            this.signal = Signal.GREEN;
        } else if (this.signal.name().equals("YELLOW")) {
            this.signal = Signal.RED;
        } else if (this.signal.name().equals("GREEN")) {
            this.signal = Signal.YELLOW;
        }
    }


    public Light(Signal signal) {
        this.signal = signal;
    }

    @Override
    public String toString() {
        return signal.name();
    }
}
