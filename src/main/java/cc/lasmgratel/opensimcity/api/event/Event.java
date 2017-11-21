package cc.lasmgratel.opensimcity.api.event;

/**
 * An event.
 * Event may contain a result defined in {@link Result}, you may pass your variables into it.
 * You should always fire a event by using {@link cc.huajistudio.aeb.EventBus#post(Object)}.
 */
public class Event {
    private Result result = new Result();

    public Result getResult() {
        return result;
    }

    public void setResult(Result result) {
        this.result = result;
    }

    public void setResult(ResultType resultType) {
        setResult(new Result(resultType));
    }

    public void setResultType(ResultType resultType) {
        getResult().setResultType(resultType);
    }
}
