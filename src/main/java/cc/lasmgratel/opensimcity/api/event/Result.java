package cc.lasmgratel.opensimcity.api.event;

import cc.lasmgratel.opensimcity.api.ingredient.SimpleIngredientEntry;

/**
 * An event's result with ingredients.
 */
public class Result extends SimpleIngredientEntry {
    private ResultType resultType = ResultType.PASS;

    public Result() {}

    public Result(ResultType resultType) {
        this.resultType = resultType;
    }

    public ResultType getResultType() {
        return resultType;
    }

    public void setResultType(ResultType resultType) {
        this.resultType = resultType;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;

        Result result = (Result) o;

        return resultType == result.resultType;
    }

    @Override
    public int hashCode() {
        int result = super.hashCode();
        result = 31 * result + (resultType != null ? resultType.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return "Result{" +
                "resultType=" + resultType + "," +
                "ingredients=" + super.toString() +
                '}';
    }
}
