package cc.lasmgratel.opensimcity.api.event.client;

import cc.lasmgratel.opensimcity.api.event.Event;

public class ScrollEvent extends Event {
    private final int amount;

    public ScrollEvent(int amount) {
        this.amount = amount;
    }

    public int getAmount() {
        return amount;
    }
}
