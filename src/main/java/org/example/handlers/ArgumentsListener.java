package org.example.handlers;


import org.example.entities.Coordinates;
import org.example.entities.MusicBand;
import org.example.entities.Person;
import org.example.enums.Country;
import org.example.enums.EyeColor;
import org.example.enums.HairColor;
import org.example.enums.MusicGenre;

import java.io.File;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.Arrays;
import java.util.Scanner;

/**
 * Класс, отвечающий за работу с пользователем во время
 * ввода данных о новом элементе коллекции
 */
public class ArgumentsListener {
    /**
     * Метод обработки и инициализации данных примитивных типов для переданного
     * в аргументе MusicBand
     *
     * @param musicBand музыкальная группа, характеристики примитивных типов которого вводит пользователь
     */
    private final Invoker invoker;

    private final Printer printer;

    public ArgumentsListener(Invoker invoker) {
        this.invoker = invoker;
        this.printer = invoker.getPrinter();
    }

    public void inputPrimitives(MusicBand musicBand) {
        Scanner scanner = new Scanner(System.in);
        String[] inputArray = scanner.nextLine().split(" ");
        try {
            musicBand.setName(inputArray[0]);
            musicBand.setNumberOfParticipants(Integer.parseInt(inputArray[1]));
        } catch (IllegalArgumentException | ArrayIndexOutOfBoundsException e) {
            System.out.println("Введены некорректные данные, верный формат: name numberOfParticipants[>0]");
            inputPrimitives(musicBand);
        }
    }
    /**
     * Метод обработки и инициализации имя группы (не устанавливает данные
     * в поля объекта коллекции)
     *
     * @return объект координат, данные которых ввёл пользователь
     */
    public void inputMusicBandName(MusicBand musicBand) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Введите название музыкальной группы:");
        try {
            musicBand.setName(scanner.nextLine());
        } catch (IllegalArgumentException e) {
            System.out.println("Имя не может быть пустым или null, попробуйте снова");
            inputMusicBandName(musicBand);
        }
    }

    /**
     * Метод обработки и инициализации имя группы (не устанавливает данные
     * в поля объекта коллекции)
     *
     * @return объект координат, данные которых ввёл пользователь
     */
    public void inputNumberOfParticipants(MusicBand musicBand) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Введите количество участников группы:");
        try {
            musicBand.setNumberOfParticipants(Integer.parseInt(scanner.nextLine()));
        } catch (IllegalArgumentException e) {
            System.out.println("Введены некорректные данные.");
            inputNumberOfParticipants(musicBand);
        }
    }

    /**
     * Метод обработки и инициализации координат (не устанавливает данные
     * в поля объекта коллекции)
     *
     * @return объект координат, данные которых ввёл пользователь
     */
    public Coordinates inputCoordinates() {
        System.out.println("Введите координаты:");
        Coordinates newCoordinates = new Coordinates();
        inputX(newCoordinates);
        inputY(newCoordinates);
        return newCoordinates;
    }

    /**
     * Метод обработки и инициализации координаты Y и присваивание ее объекту координат
     *
     * @param coordinates объект координат, y которых вводит пользователь
     */
    private void inputY(Coordinates coordinates) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Введите координату y (целое число): ");
        try {
            coordinates.setY(Integer.parseInt(scanner.nextLine()));
        } catch (NumberFormatException e) {
            System.out.println("Число имеет неверный формат");
            inputY(coordinates);
        } catch (IllegalArgumentException e) {
            System.out.println("Число должно быть больше -224");
            inputY(coordinates);
        }
    }

    /**
     * Метод обработки и инициализации координаты X и присваивание ее объекту координат
     *
     * @param coordinates объект координат, у которых вводит пользователь
     */
    private void inputX(Coordinates coordinates) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Введите x(число с плавающей точкой): ");
        try {
            String inputString = scanner.nextLine();
            inputString = inputString.replace(',', '.');
            coordinates.setX(Float.parseFloat(inputString));
        } catch (NumberFormatException e) {
            System.out.println("Ошибка ввода");
            inputX(coordinates);
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
            inputX(coordinates);
        }
    }

    /**
     * Метод обработки и инициализации вокалиста группы (не устанавливает данные
     * в поля объекта коллекции)
     *
     * @return вокалист группы, данные о которой ввёл пользователь
     */
    public Person inputFrontMan() {
        Person newPerson = new Person();
        inputName(newPerson);
        inputHeight(newPerson);
        inputEyeColor(newPerson);
        inputHairColor(newPerson);
        inputCountry(newPerson);

        File file = new File("dfs");
        return newPerson;
    }
    /**
     * Метод обработки и инициализации имени лидера группы и присваивание ее объекту Person
     *
     * @param person имя, которое запрашивается у пользователя
     */
    private void inputName(Person person) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Введите имя вокалиста группы: ");
        try {
            person.setName(scanner.nextLine());
        } catch (IllegalArgumentException e) {
            System.out.println("Имя не может быть пустым или null, попробуйте снова");
            inputName(person);
        }
    }
    /**
            * Метод обработки цвета глаз, полученного от пользователя
     *
             * @param person человек, цвет глаз которого запрашивается у пользователя
     */
    protected void inputEyeColor(Person person) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Введите цвет глаз, доступные цвета: " + Arrays.toString(EyeColor.values()) + ", если нужного цвета нету, нажмите Enter: ");
        String inputString = scanner.nextLine().toUpperCase();
        if ("".equals(inputString)) {
            person.setEyeColor(null);
        } else {
            try {
                switch (inputString) {
                    case "1" -> person.setEyeColor(EyeColor.BLACK);
                    case "2" -> person.setEyeColor(EyeColor.YELLOW);
                    case "3" -> person.setEyeColor(EyeColor.BROWN);
                    case "4" -> person.setEyeColor(EyeColor.WHITE);
                    default -> person.setEyeColor(EyeColor.valueOf(inputString));
                }

            } catch (IllegalArgumentException e) {
                System.out.println("Ошибка ввода, такого цвета не существует");
                inputEyeColor(person);
            }
        }
    }
    /**
     * Метод обработки цвета волос, полученного от пользователя
     *
     * @param person человек, цвет волос которого запрашивается у пользователя
     */
    protected void inputHairColor(Person person) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Введите цвет волос, доступные цвета: " + Arrays.toString(HairColor.values()) + ", если нужного цвета нету, нажмите Enter: ");
        String inputString = scanner.nextLine().toUpperCase();
        if ("".equals(inputString)) {
            person.setHairColor(null);
        } else {
            try {
                switch (inputString) {
                    case "1" -> person.setHairColor(HairColor.BLUE);
                    case "2" -> person.setHairColor(HairColor.YELLOW);
                    case "3" -> person.setHairColor(HairColor.ORANGE);
                    case "4" -> person.setHairColor(HairColor.WHITE);
                    case "5" -> person.setHairColor(HairColor.BROWN);
                    default -> person.setHairColor(HairColor.valueOf(inputString));
                }
            } catch (IllegalArgumentException e) {
                System.out.println("Ошибка ввода, такого цвета не существует");
                inputHairColor(person);
            }
        }
    }
    /**
     * Метод обработки страны, полученного от пользователя
     *
     * @param person человек, национальность которого запрашивается у пользователя
     */
    protected void inputCountry(Person person) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Введите страну рождения, доступные страны: " + Arrays.toString(Country.values()) + " : ");
        String inputString = scanner.nextLine().toUpperCase();
        try {
            switch (inputString) {
                case "1" -> person.setCountry(Country.CHINA);
                case "2" -> person.setCountry(Country.INDIA);
                case "3" -> person.setCountry(Country.VATICAN);
                default -> person.setCountry(Country.valueOf(inputString));
            }
        } catch (IllegalArgumentException e) {
            System.out.println("Ошибка ввода, такой страны не существует");
            inputCountry(person);
        }
    }
    /**
     * Метод обработки и инициализации роста лидера группы и присваивание ее объекту Person
     *
     * @param height рост, который запрашивается у пользователя
     */
    private void inputHeight(Person height) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Введите его рост (число с плавающей точкой, большее 0): ");
        try {
            String inputString = scanner.nextLine();
            inputString = inputString.replace(',', '.');
            height.setHeight(Float.parseFloat(inputString));
        } catch (NumberFormatException e) {
            System.out.println("Ошибка ввода");
            inputHeight(height);
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
            inputHeight(height);
        }
    }

    /**
     * Метод обработки цвета музыкального жанра, полученного от пользователя
     *
     * @param musicBand группа, жанр которого запрашивается у пользователя
     */
    public void inputMusicGenre(MusicBand musicBand) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Введите музыкальный жанр группы, доступные жанры: " + Arrays.toString(MusicGenre.values()) + ", если у группы нету жанра, нажмите Enter: ");
        String inputString = scanner.nextLine().toUpperCase();
        if ("".equals(inputString)) {
            musicBand.setMusicGenre(null);
        } else {
            try {
                switch (inputString) {
                    case "1" -> musicBand.setMusicGenre(MusicGenre.PROGRESSIVE_ROCK);
                    case "2" -> musicBand.setMusicGenre(MusicGenre.RAP);
                    case "3" -> musicBand.setMusicGenre(MusicGenre.HIP_HOP);
                    case "4" -> musicBand.setMusicGenre(MusicGenre.PSYCHEDELIC_CLOUD_RAP);
                    case "5" -> musicBand.setMusicGenre(MusicGenre.BLUES);
                    default -> musicBand.setMusicGenre(MusicGenre.valueOf(inputString));
                }
            } catch (IllegalArgumentException e) {
                System.out.println("Ошибка ввода, такого цвета не существует");
                inputMusicGenre(musicBand);
            }
        }
    }
    /**
     * Метод обработки времени создания группы, полученного от пользователя
     *
     * @param musicBand время создания, которое запрашивается у пользователя
     */
    public void inputEstablishmentDate(MusicBand musicBand) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Введите дату создания группы(в формате yyyy-MM-dd): ");
        String inputString = scanner.nextLine();
        System.out.println(inputString);
        try {
            DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
            LocalDate localDate = LocalDate.parse(inputString, formatter);

            ZoneId zoneId = ZoneId.of("Europe/Moscow");
            ZonedDateTime zonedDateTime = localDate.atStartOfDay(zoneId);
            LocalDateTime localDateTime = zonedDateTime.toLocalDateTime();

            musicBand.setEstablishmentDate(localDateTime);
        } catch (DateTimeParseException e) {
            System.out.println("Некорректный формат даты! Пожалуйста, введите дату в формате: yyyy-MM-dd");
            inputEstablishmentDate(musicBand);
        }
    }
}

