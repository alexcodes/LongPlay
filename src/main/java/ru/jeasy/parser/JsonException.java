package ru.jeasy.parser;

public class JsonException extends Exception {
    private Throwable cause;

    public JsonException(String paramString) {
        super(paramString);
    }

    public JsonException(Throwable paramThrowable) {
        super(paramThrowable.getMessage());
        this.cause = paramThrowable;
    }

    public Throwable getCause() {
        return this.cause;
    }
}