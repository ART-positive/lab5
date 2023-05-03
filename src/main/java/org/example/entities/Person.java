package org.example.entities;

import org.example.enums.Country;
import org.example.enums.EyeColor;
import org.example.enums.HairColor;

import java.util.Comparator;

public class Person {
    /**
     * Имя текущего элемента коллекции
     * <strong>(Поле не может быть null, строка не может быть пустой)</strong>
     */
    private String name; //Поле не может быть null, Строка не может быть пустой
    /**
     * Высота человека
     */
    private float height; //Значение поля должно быть больше 0
    private EyeColor eyeColor; //Поле может быть null
    private HairColor hairColor; //Поле может быть null
    private Country nationality; //Поле не может быть null

    /**
     * Метод, устанавливающий значение поля name у текущего элемента коллекции
     *
     * @param name имя дракокна
     */
    public void setName(String name) {
        if (name == null || "".equals(name)) {
            throw new IllegalArgumentException("Имя не может быть пустым или null, попробуйте снова");
        }
        this.name = name;
    }

    /**
     * Метод, возвращающий значение поля name у текущего элемента коллекции
     *
     * @return имя дракона
     */
    public String getName() {
        return this.name;
    }
    /**
     * Метод, устанавливающий значение поля name у текущего элемента коллекции
     *
     * @param height имя дракокна
     */
    public void setHeight(float height) {
        if (height <= 0) {
            throw new IllegalArgumentException("Некорректный рост человека, попробуйте снова");
        }
        this.height = height;
    }

    /**
     * Метод, возвращающий значение поля name у текущего элемента коллекции
     *
     * @return имя дракона
     */
    public float getHeight() {
        return this.height;
    }

    /**
     * Метод, устанавливающий значение поля eyeColor у текущего элемента коллекции
     *
     * @param eyeColor цвет дракона
     */
    public void setEyeColor(EyeColor eyeColor) {
        this.eyeColor = eyeColor;
    }

    /**
     * Метод, возвращающий значение поля eyeColor у текущего элемента коллекции
     *
     * @return цвет дракона
     */
    public EyeColor getEyeColor() {
        return this.eyeColor;
    }
    /**
     * Метод, устанавливающий значение поля hairColor у текущего элемента коллекции
     *
     * @param hairColor цвет дракона
     */
    public void setHairColor(HairColor hairColor) {
        this.hairColor = hairColor;
    }

    /**
     * Метод, возвращающий значение поля hairColor у текущего элемента коллекции
     *
     * @return цвет дракона
     */
    public HairColor getHairColor() {
        return this.hairColor;
    }
    /**
     * Метод, устанавливающий значение поля nationality у текущего элемента коллекции
     *
     * @param nationality цвет дракона
     */
    public void setCountry(Country nationality) {
        if (nationality == null) {
            throw new IllegalArgumentException("Не передана страна человека, попробуйте снова");
        }
        this.nationality = nationality;
    }

    /**
     * Метод, возвращающий значение поля nationality у текущего элемента коллекции
     *
     * @return цвет дракона
     */
    public Country getCountry() {
        return this.nationality;
    }


    @Override
    public String toString() {
        return "name: " + name +
                " \nheight: " + height +
                " \neye color: " + eyeColor +
                " \nhair color: " + hairColor +
                " \ncountry: " + nationality ;
    }

    public int compareTo(Person o) {
        return Comparator.comparing(Person::getHeight).compare(this, o);
    }
}