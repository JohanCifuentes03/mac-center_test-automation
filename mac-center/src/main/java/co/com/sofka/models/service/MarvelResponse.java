package co.com.sofka.models.service;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public class MarvelResponse {
    private int code;
    private String status;
    private Data data;

    public MarvelResponse() {
    }

    public MarvelResponse(int code, String status, Data data) {
        this.code = code;
        this.status = status;
        this.data = data;
    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public Data getData() {
        return data;
    }

    public void setData(Data data) {
        this.data = data;
    }

    @Override
    public String toString() {
        return "MarvelResponse{" +
                "code=" + code +
                ", status='" + status + '\'' +
                ", data=" + data +
                '}';
    }
}
