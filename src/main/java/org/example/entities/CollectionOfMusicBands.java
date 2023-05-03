package org.example.entities;


import java.io.File;
import java.util.Date;
import java.util.HashSet;

/**
 * Класс коллекции, содержащий текущую коллекцию <b>dragons</b>,
 * отвечает за генерацию ID для новых элементов и за все действия,
 * связанные с коллекцией.
 */
public class CollectionOfMusicBands {
    /**
     * Статичное поле, отвечающее за инкрементацию ID для исключения повторений
     */
    private static int idCounter = 1;
    /**
     * Дата создания коллекции
     */
    private final Date creationDate;
    /**
     * Файл, в который будет производиться запись коллекции при сохранении
     */
    private File outFile;
    /**
     * Сет объектов класса Dragon, текущее содержимое коллекции
     */
    private final HashSet<MusicBand> musicBands;

    /**
     * Конструктор объекта данного класса.
     * Устанавливает коллекцию и дату её создания
     */
    public CollectionOfMusicBands() {
        musicBands = new HashSet<>();
        creationDate = new Date();
    }

    /**
     * Метод, возвращающий текущую коллекцию драконов в формате HashSet
     *
     * @return HashSet драконов, находящихся в коллекции
     */
    public HashSet<MusicBand> getMusicBands() {
        return musicBands;
    }

    /**
     * Метод, возвращающий дату создания коллекции
     *
     * @return дата создания коллекции
     */
     public Date getCreationDate() {
        return creationDate;
     }

    /**
     * Метод, возвращающий текущий файл, в который будет производиться запись коллекции при сохранении
     *
     * @return файл, в который производится запись готовой коллекции
     */
    public File getOutFile() {
        return outFile;
    }

    /**
     * Метод, устанавливающий файл, в который будет производиться запись коллекции при сохранении
     *
     * @param outFile файл, в который будет производиться запись коллекции
     */
    public void setOutFile(File outFile) {
        this.outFile = outFile;
    }

    /**
     * Метод, добавляющий полученную группу в коллекцию
     *
     * @param musicBand группа, которую нужно добавить в коллекцию
     */
    public void addMusicBand(MusicBand musicBand) {
        musicBand.setId();
        idCounter++;
        musicBands.add(musicBand);
        System.out.println("Группа успешно добавлена в коллекцию");
    }

    /**
     * Метод, очищающий текущую коллекцию
     */
    public void clear() {
        musicBands.clear();
    }

    /**
     * Метод, удаляющий дракона из коллекции по полученному ID, если таковой существует
     *
     * @param id id дракона, которого нужно удалить
     */
    public void removeById(long id) {
        boolean idIsValid = false;
        for (MusicBand musicBand : musicBands) {
            if (musicBand.getId() == id) {
                idIsValid = true;
                musicBands.remove(musicBand);
                System.out.println("Группа с #" + id + " успешно удалена");
            }
        }
        if (!idIsValid) {
            System.out.println("Группы с таким id нет в коллекции");
        }
    }

    /**
     * Метод, выводящий пользователю информацию о коллекции
     */
    public void showInfo() {
        System.out.println("Collection type: " + musicBands.getClass()
                + "\nInitialization date: " + creationDate
                + "\nCount of musicBands: " + musicBands.size());
    }
}
