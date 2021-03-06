package duke.storage;

import duke.task.*;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

/**
 * Represents the file used to store address book data.
 */
public class Storage {

    /** Default file path used. */
    public static final String DEFAULT_PATH  = "duke.txt";

    /**
     * Saves the {@code TaskList} data to the storage file.
     *
     * @throws IOException if there is a failure in saving of the file.
     */
    public static void save(TaskList tasks) throws IOException {
        File file = new File("duke.txt");
        file.createNewFile();
        FileWriter fw = new FileWriter("duke.txt", false);

        for (Task i : tasks.getTaskArray()) {
            fw.write(i.saveTask());
            fw.write(System.lineSeparator());
        }
        fw.close();
    }

    /**
     * Loads the {@code TaskList} data from this storage file, and then returns it.
     * Returns an empty {@code TaskList} if the file does not exist, or is not a regular file.
     *
     * @throws FileNotFoundException if the default path is invalid.
     */
    public static void retrieve(TaskList tasks) throws FileNotFoundException {
        File f = new File("duke.txt");
        try {
            f.createNewFile();
        } catch (IOException e) {
            System.out.println("Data cannot be saved.");
        }
        Scanner s = new Scanner(f); // create a Scanner using the File as the source
        while (s.hasNext()) {
            String input = s.nextLine();
            String[] parseInput = input.split("[|]");
            switch (parseInput[0].trim()) {
                case ("T"):
                    tasks.addToDo(parseInput[2].trim());
                    break;
                case ("E"):
                    tasks.addEvent(parseInput[2].trim(), parseInput[3].trim());
                    break;
                case ("D"):
                    tasks.addDeadline(parseInput[2].trim(), parseInput[3].trim());
                    break;
            }
            if (parseInput[1].trim().equals("1")) {
                tasks.getTask(tasks.getSize()).updateTask();
            }
        }
    }
}