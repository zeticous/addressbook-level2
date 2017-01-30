package seedu.addressbook.ui;

import static seedu.addressbook.common.Messages.*;

import seedu.addressbook.commands.CommandResult;
import seedu.addressbook.data.person.ReadOnlyPerson;

import java.io.InputStream;
import java.io.PrintStream;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.Scanner;

/**
 * Adds line prefix to appropriate messages
 */
public class PrefixFormatter {
    /** A decorative prefix added to the beginning of lines printed by AddressBook */
    private static final String LINE_PREFIX = "|| ";
    
    /** A platform independent line separator. */
    private static final String LS = System.lineSeparator();

    /**
     * Adds decorative prefix to the front of the printed messages.
     *
     * @param message to be printed
     */
    public static String addPrefix(String message){
        return LINE_PREFIX + message.replace("\n", LS + LINE_PREFIX);
    }
}
