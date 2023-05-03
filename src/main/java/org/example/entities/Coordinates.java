package org.example.entities;


/**
 * Класс координат, объекты которого присваиваются элементам колекции
 */
public class Coordinates {
    /**
     * Минимальное допустимое по условию задачи значение координаты Y
     */
    private static final int MIN_Y_VALUE = -225;
    /**
     * Координата Y
     * <strong>(Минимальное значение поля: -225, поле не может быть null)</strong>
     */
    private long y;
    /**
     * Координата X
     */
    private float x;

    /**
     * Метод, устанавливающий значение координаты Х в соответствии с ограничивающими условиями
     *
     * @param y Y
     */
    public void setY(Integer y) {
        if (y < MIN_Y_VALUE) {
            throw new IllegalArgumentException("Некорректное значение координаты y");
        } else {
            this.y = y;
        }
    }

    /**
     * Метод, устанавливающий значение координаты Y у данного объекта координат
     *
     * @param x X
     */
    public void setX(float x) {
        if (x == Float.NEGATIVE_INFINITY | x == Float.POSITIVE_INFINITY) {
            throw new IllegalArgumentException("Слишком большое значение, попробуйте снова");
        }
        this.x = x;
    }

    /**
     * Метод, возвращающий значение координаты Y у данного объекта координат
     *
     * @return Y
     */
    public long getY() {
        return this.y;
    }

    /**
     * Метод, возвращающий значение координаты X у данного объекта координат
     *
     * @return X
     */
    public float getX() {
        return this.x;
    }

    @Override
    public String toString() {
        return "x: " + x + " y: " + y;
    }
}