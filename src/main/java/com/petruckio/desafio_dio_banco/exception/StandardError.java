package com.petruckio.desafio_dio_banco.exception;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonFormat.Shape;
import com.petruckio.desafio_dio_banco.util.DateType;
import com.petruckio.desafio_dio_banco.util.TimeZoneType;

import java.io.Serializable;
import java.time.Instant;

public class StandardError implements Serializable {

    @JsonFormat(shape = Shape.STRING, pattern = DateType.ISO_8601, timezone = TimeZoneType.GMT)
    private Instant timestamp;
    private Integer status;
    private String error;
    private String message;

    public StandardError() {
    }

    public StandardError(Instant timestamp, Integer status, String error, String message) {
        this.timestamp = timestamp;
        this.status = status;
        this.error = error;
        this.message = message;
    }

    public Instant getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(Instant timestamp) {
        this.timestamp = timestamp;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public String getError() {
        return error;
    }

    public void setError(String error) {
        this.error = error;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
