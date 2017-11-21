package cc.lasmgratel.opensimcity.api.event.client;

import cc.lasmgratel.opensimcity.api.event.Event;
import com.badlogic.gdx.Input;

/**
 * Key event fired by {@link com.badlogic.gdx.InputProcessor}.
 * @see com.badlogic.gdx.InputProcessor
 */
public class KeyEvent extends Event {
    /**
     * Defined in {@link Input.Keys}
     */
    private final int keycode;

    public KeyEvent(int keycode) {
        this.keycode = keycode;
    }

    public int getKeycode() {
        return keycode;
    }

    /**
     * @see com.badlogic.gdx.InputProcessor#keyDown(int)
     */
    public static class Down extends KeyEvent {
        public Down(int keycode) {
            super(keycode);
        }
    }

    /**
     * @see com.badlogic.gdx.InputProcessor#keyUp(int)
     */
    public static class Up extends KeyEvent {
        public Up(int keycode) {
            super(keycode);
        }
    }

    /**
     * @see com.badlogic.gdx.InputProcessor#keyTyped(char)
     */
    public static class Type extends KeyEvent {
        public Type(char character) {
            super(character);
        }

        public char getChar() {
            return (char) super.getKeycode();
        }
    }
}
