package com.example.masterdemo.common;

import java.util.List;

public class GetAllRoomsResponse {

    private List<Items> items;
    private boolean secure;

    public GetAllRoomsResponse(List<Items> items, boolean secure) {
        this.items = items;
        this.secure = secure;
    }

    public List<Items> getItems() {
        return items;
    }

    public void setItems(List<Items> items) {
        this.items = items;
    }

    public boolean isSecure() {
        return secure;
    }

    public void setSecure(boolean secure) {
        this.secure = secure;
    }
}
