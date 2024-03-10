package com.littleheap;

public class Part {
    public int Part_ID;
    public String Part_name;
    public String Part_type;
    public long parts_image_data ;

    public int getPart_ID() {
        return Part_ID;
    }

    public String getPart_name() {
        return Part_name;
    }

    public String getPart_type() {
        return Part_type;
    }

    public long getParts_image_data() {
        return parts_image_data;
    }

    public void setPart_ID(int part_ID) {
        Part_ID = part_ID;
    }

    public void setPart_name(String part_name) {
        Part_name = part_name;
    }

    public void setPart_type(String part_type) {
        Part_type = part_type;
    }

    public void setParts_image_data(long parts_image_data) {
        this.parts_image_data = parts_image_data;
    }
}
