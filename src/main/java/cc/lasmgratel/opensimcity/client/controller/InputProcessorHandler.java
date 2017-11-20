package cc.lasmgratel.opensimcity.client.controller;

import cc.lasmgratel.opensimcity.api.event.Event;
import cc.lasmgratel.opensimcity.api.event.ResultType;
import cc.lasmgratel.opensimcity.api.event.client.KeyEvent;
import cc.lasmgratel.opensimcity.api.event.client.ScrollEvent;
import cc.lasmgratel.opensimcity.api.event.client.TouchEvent;
import com.badlogic.gdx.InputProcessor;

import static cc.lasmgratel.opensimcity.client.OpenSimCityClient.getEventBus;

public class InputProcessorHandler implements InputProcessor {
    @Override
    public boolean keyDown(int keycode) {
        Event event = new KeyEvent.Down(keycode);
        getEventBus().post(event);
        return event.getResult().getResultType() != ResultType.DENY;
    }

    @Override
    public boolean keyUp(int keycode) {
        Event event = new KeyEvent.Up(keycode);
        getEventBus().post(event);
        return event.getResult().getResultType() != ResultType.DENY;
    }

    @Override
    public boolean keyTyped(char character) {
        Event event = new KeyEvent.Type(character);
        getEventBus().post(event);
        return event.getResult().getResultType() != ResultType.DENY;
    }

    @Override
    public boolean touchDown(int screenX, int screenY, int pointer, int button) {
        Event event = new TouchEvent.Down(screenX, screenY, pointer, button);
        getEventBus().post(event);
        return event.getResult().getResultType() != ResultType.DENY;
    }

    @Override
    public boolean touchUp(int screenX, int screenY, int pointer, int button) {
        Event event = new TouchEvent.Up(screenX, screenY, pointer, button);
        getEventBus().post(event);
        return event.getResult().getResultType() != ResultType.DENY;
    }

    @Override
    public boolean touchDragged(int screenX, int screenY, int pointer) {
        Event event = new TouchEvent.Drag(screenX, screenY, pointer);
        getEventBus().post(event);
        return event.getResult().getResultType() != ResultType.DENY;
    }

    @Override
    public boolean mouseMoved(int screenX, int screenY) {
        Event event = new TouchEvent.MouseMove(screenX, screenY);
        getEventBus().post(event);
        return event.getResult().getResultType() != ResultType.DENY;
    }

    @Override
    public boolean scrolled(int amount) {
        Event event = new ScrollEvent(amount);
        getEventBus().post(event);
        return event.getResult().getResultType() != ResultType.DENY;
    }
}
