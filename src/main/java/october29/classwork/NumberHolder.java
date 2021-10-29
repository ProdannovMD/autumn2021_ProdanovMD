package october29.classwork;

public class NumberHolder<T extends Number> {
    private T value;

    public NumberHolder(T value) {
        this.value = value;
    }

    public T getValue() {
        return value;
    }

    public void setValue(T value) {
        this.value = value;
    }

    public Float getValueAsFloat() {

        return this.value.floatValue();
    }

    public Double getValueAsDouble() {
        return this.value.doubleValue();
    }

    public String getValueAsString() {
        return this.value.toString();
    }

    public Byte getValueAsByte() {
        return this.value.byteValue();
    }

    public Integer getValueAsInteger() {
        return this.value.intValue();
    }

    public Long getValueAsLong() {
        return this.value.longValue();
    }

    public Short getValueAsShort() {
        return this.value.shortValue();
    }
}
