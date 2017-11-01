package cc.lasmgratel.opensimcity.api.event;

public class Event {
    private Result result;

    public Result getResult() {
        return result;
    }

    public void setResult(Result result) {
        this.result = result;
    }

    public void setResult(ResultType resultType) {
        this.result = new Result(resultType);
    }
}
