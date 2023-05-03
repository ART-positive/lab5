package org.example.entities;

import org.example.enums.MusicGenre;

import java.time.*;
import java.util.Comparator;
import java.util.Date;
import java.util.Objects;

import static java.time.LocalDateTime.now;

/**
 * Класс объектов, хранимых в коллекции, которой управляет программа
 */
public class MusicBand {

    /**
     * Количество полей примитивного типа, которые необходимо передавать при инициализации
     * нового дракона в одной строчке с используемой командой
     */
    public static final int COUNT_OF_PRIMITIVE_ARGS = 2;
    /**
     * Счетчик id элементов, служит для обеспечения уникальности поля id у каждого элемента
     */
    private static long idCounter = 1;
    /**
     * id текущего элемента коллекции
     * <strong>(Значение поля должно быть больше 0, значение этого поля должно быть уникальным,
     * значение этого поля должно генерироваться автоматически)</strong>
     */
    private long id;
    /**
     * Имя текущего элемента коллекции
     * <strong>(Поле не может быть null, строка не может быть пустой)</strong>
     */
    private String name;
    /**
     * Координаты текущего элемента коллекции
     * <strong>(Поле не может быть null)</strong>
     */
    private Coordinates coordinates;
    /**
     * Дата создания текущего элемента коллекции
     * <strong>(Поле не может быть null, Значение этого поля должно генерироваться автоматически)</strong>
     */
    /**
     * Дата создания текущего элемента коллекции
     * <strong>(Поле не может быть null, Значение этого поля должно генерироваться автоматически)</strong>
     */
    private java.time.ZonedDateTime creationDate;  //Поле не может быть null, Значение этого поля должно генерироваться автоматически

    private Long numberOfParticipants; //Поле может быть null, Значение поля должно быть больше 0
    private java.time.LocalDateTime establishmentDate; //Поле не может быть null
    private MusicGenre genre; //Поле может быть null
    private Person frontMan; //Поле не может быть null

    /**
     * Конструктор объекта данного класса
     */
    public MusicBand() {
        setCreationDate();
    }
    /**
     * Метод, устанавливающий id текущему элементу коллекции. Генерация происходит автоматически,
     * аргументы на вход не поступают
     */
    public void setId() {
        this.id = idCounter++;
    }

    /**
     * Метод, возвращающий значение поля id у текущего элемента коллекции
     *
     * @return id дракона
     */
    public long getId() {
        return id;
    }

    /**
     * Метод, устанавливающий значение поля name у текущего элемента коллекции
     *
     * @param name имя дракокна
     */
    public void setName(String name) {
        checkName(name);
        this.name = name;
    }

    public void checkName(String name) {
        if (name == null || "".equals(name)) {
            throw new IllegalArgumentException("Имя не может быть пустым или null, попробуйте снова");
        }
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
     * Метод, устанавливающий значение поля coordinates у текущего элемента коллекции
     *
     * @param coordinates координаты дракона
     */
    public void setCoordinates(Coordinates coordinates) {
        checkCoordinates(coordinates);
        this.coordinates = coordinates;
    }

    public void checkCoordinates(Coordinates coordinates) {
        if (coordinates == null) {
            throw new IllegalArgumentException("Не переданы координаты или они некорректны, попробуйте снова");
        }
    }
    /**
     * Метод, возвращающий содержимое поля coordinates текущего элемента коллекции
     *
     * @return объект координат
     */
    public Coordinates getCoordinates() {
        return this.coordinates;
    }

    /**
     * Метод, установливающий значение поля numberOfParticipants текущему элементу коллекции
     *
     * @param numberOfParticipants значение возраста дракона
     */
    public void setNumberOfParticipants(long numberOfParticipants) {
        checkNumberOfParticipants(numberOfParticipants);
        this.numberOfParticipants = numberOfParticipants;
    }

    public void checkNumberOfParticipants(long numberOfParticipants) {
        if (numberOfParticipants <= 0) {
            throw new IllegalArgumentException("Количество участников должно быть больше 0, попробуйте снова");
        }
    }

    /**
     * Метод, возвращающий значение поля numberOfParticipants текущего элемента коллекции
     *
     * @return значение возраста дракона
     */
    public long getNumberOfParticipants() {
        return this.numberOfParticipants;
    }

    /**
     * Метод, устанавливающий значение поля Музыкальный жанр у текущего элемента коллекции
     *
     * @param genre цвет дракона
     */
    public void setMusicGenre (MusicGenre genre) {
        this.genre = genre;
    }

    /**
     * Метод, возвращающий значение поля Музыкальный жанр у текущего элемента коллекции
     *
     * @return цвет дракона
     */
    public MusicGenre getMusicGenre () {
        return this.genre;
    }

    /**
     * Метод, устанавливающий значение поля Лидер группы у текущего элемента коллекции
     *
     * @param frontMan характер дракона
     */
    public void setFrontMan(Person frontMan) {
        checkFrontMan(frontMan);
        this.frontMan = frontMan;
    }

    public void checkFrontMan(Person frontMan) {
        if (frontMan == null) {
            throw new IllegalArgumentException("Не передан ведущий вокалист, попробуйте снова");
        }
    }

    /**
     * Метод, возвращающий значение поля Лидер группы у текущего элемента коллекции
     *
     * @return характер дракона
     */
    public Person getFrontMan() {
        return this.frontMan;
    }

    /**
     * Метод, устанавливающий значение поля establishmentDate у текущего элемента коллекции.
     */
    public void setEstablishmentDate(LocalDateTime establishmentDate) {
        this.establishmentDate = establishmentDate;
    }

    /**
     * Метод, возвращающий значение поля establishmentDate у текущего элемента коллекции
     *
     * @return дата создания MusicBand
     */
    public java.time.LocalDateTime getEstablishmentDate() {
        return this.establishmentDate;
    }
    /**
     * Метод, устанавливающий значение поля creationDate у текущего элемента коллекции.
     * Значение генерируется автоматически, аргументов нет
     */
    public void setCreationDate() {
        // getting current date
        LocalDate date = LocalDate.now();

        // getting current time
        LocalTime time = LocalTime.now();

        // getting system default zone id
        ZoneId zoneId = ZoneId.systemDefault();

        // creating a new ZonedDateTime object
        this.creationDate = ZonedDateTime.of(date, time, zoneId);
    }

    /**
     * Метод, возвращающий значение поля creationDate у текущего элемента коллекции
     *
     * @return дата создания дракона
     */
    public java.time.ZonedDateTime getCreationDate() {
        return creationDate;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        MusicBand dragon = (MusicBand) obj;

        return getName().equals(dragon.getName())
                && Objects.equals(numberOfParticipants, dragon.numberOfParticipants)
                && coordinates.equals(dragon.coordinates)
                && genre.equals(dragon.genre)
                && id == dragon.id
                && frontMan.equals(dragon.frontMan);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, coordinates, numberOfParticipants, establishmentDate, genre, frontMan, creationDate);
    }

    @Override
    public String toString() {
        return "\nMusicBand #" + id + "\nname: " + name
                + "\ncreationDate: " + creationDate.toString().substring(0, 10) + " " + creationDate.toString().substring(11, 19)
                + "\nnumberOfParticipants: " + numberOfParticipants
                + "\nestablishmentDate: " + establishmentDate.toString().substring(0, 10)
                + "\ncoordinates: " + coordinates.toString() + "\ngenre: " + genre
                + "\nfrontMan: \n" + frontMan.toString() + "\n========================";
    }

}

