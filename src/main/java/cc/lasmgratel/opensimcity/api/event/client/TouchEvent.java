package cc.lasmgratel.opensimcity.api.event.client;

import cc.lasmgratel.opensimcity.api.event.Event;

/**
 * Key event fired by {@link com.badlogic.gdx.InputProcessor}.
 * @see com.badlogic.gdx.InputProcessor
 */
public class TouchEvent extends Event {
    private final int screenX, screenY;

    public TouchEvent(int screenX, int screenY) {
        this.screenX = screenX;
        this.screenY = screenY;
    }

    public int getScreenX() {
        return screenX;
    }

    public int getScreenY() {
        return screenY;
    }

    /**
     * Touch event with pointer passed.
     */
    private static class WithPointer extends TouchEvent {
        private final int pointer;

        public WithPointer(int screenX, int screenY, int pointer) {
            super(screenX, screenY);
            this.pointer = pointer;
        }

        public int getPointer() {
            return pointer;
        }
    }

    /**
     * @see com.badlogic.gdx.InputProcessor#touchDragged(int, int, int)
     */
    public static class Drag extends WithPointer {
        public Drag(int screenX, int screenY, int pointer) {
            super(screenX, screenY, pointer);
        }
    }

    /**
     * @see com.badlogic.gdx.InputProcessor#touchUp(int, int, int, int)
     */
    public static class Up extends WithPointer {
        /**
         * Defined in {@link com.badlogic.gdx.Input.Buttons}
         */
        private final int button;

        public Up(int screenX, int screenY, int pointer, int button) {
            super(screenX, screenY, pointer);
            this.button = button;
        }
    }

    /**
     * @see com.badlogic.gdx.InputProcessor#touchDown(int, int, int, int)
     */
    public static class Down extends WithPointer {
        /**
         * Defined in {@link com.badlogic.gdx.Input.Buttons}
         */
        private final int button;

        public Down(int screenX, int screenY, int pointer, int button) {
            super(screenX, screenY, pointer);
            this.button = button;
        }
    }

    /**
     * @see com.badlogic.gdx.InputProcessor#mouseMoved(int, int)
     */
    public static class MouseMove extends TouchEvent {
        public MouseMove(int screenX, int screenY) {
            super(screenX, screenY);
        }
    }
}
