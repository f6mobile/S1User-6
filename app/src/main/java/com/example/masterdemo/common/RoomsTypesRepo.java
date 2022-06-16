package com.example.masterdemo.common;

import java.util.ArrayList;
import java.util.List;

public class RoomsTypesRepo {
    List<String> types;

    public RoomsTypesRepo() {
        this.types = new ArrayList<>();
        types.add("Kitchen");
        types.add("Bedroom");
        types.add("Bathroom");
        types.add("Office");
        types.add("TV Room");
        types.add("Living Room");
        types.add("Garage");
        types.add("Toilet");
        types.add("Kid Room");
    }

    public List<String> getTypes() {
        return types;
    }

    public void setTypes(List<String> types) {
        this.types = types;
    }
}
