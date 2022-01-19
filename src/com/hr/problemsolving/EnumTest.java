package com.hr.problemsolving;

public class EnumTest {

    public static void main(String[] args) {

        System.out.println(Color.getTypeFromId(3));

    }
}


enum Color
{
    RED(1), GREEN(2), BLUE(4);
    int id;

    Color(Integer id) {
        this.id = id;
    }

    public static Color getTypeFromId(Integer id) {

        for (Color type : Color.values()) {
            if (type.id == id.intValue()) {
                return type;
            }
        }
        throw new IllegalArgumentException("No such data format id: " + id);
    }

    public int getId() {
        return id;
    }
}
