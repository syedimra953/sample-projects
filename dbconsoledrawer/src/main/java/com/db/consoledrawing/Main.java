package com.db.consoledrawing;

import com.db.consoledrawing.command.*;
import com.db.consoledrawing.exception.InvalidCommandException;
import com.db.consoledrawing.exception.InvalidCommandParamsException;
import com.db.consoledrawing.interfaces.Canvas;
import com.db.consoledrawing.interfaces.Command;
import com.db.consoledrawing.interfaces.DrawEntityCommand;
import com.db.consoledrawing.model.CanvasImpl;
import com.db.consoledrawing.model.EntityFactory;
import com.db.consoledrawing.exception.InvalidEntityException;

import java.util.Objects;
import java.util.Scanner;
import java.util.logging.Logger;

public class Main {

    private static final Logger LOGGER = Logger.getLogger(Main.class.getName());

    private static Canvas canvas;
    private static Scanner  scanner;
    private static CommandFactory commandFactory;
    private static EntityFactory entityFactory;

    public static void main(String[] args) throws NumberFormatException {

        scanner = new Scanner(System.in);
        commandFactory = new CommandFactory();
        entityFactory = new EntityFactory();

        LOGGER.info("Enter command:");

        while (true) {
            process(scanner.nextLine());
            LOGGER.info("Enter command:");
        }
    }

    private static void process(String commandLine) {

        Command command = null;

        try {
            command = commandFactory.getCommand(commandLine);
        } catch (InvalidCommandException e) {
            LOGGER.warning("Please enter a valid command.");
        } catch (InvalidCommandParamsException invalidCommandParams) {
            LOGGER.warning("Command syntax is not correct: " + invalidCommandParams.getMessage());
            LOGGER.warning("Refer to following correct syntax: \n" + invalidCommandParams.getHelpMessage());
        }

        if (command instanceof QuitCommand) {
            quit();
        }

        if (command instanceof CreateCommand) {
            createNewCanvas((CreateCommand) command);
            return;
        }

        if (command instanceof DrawEntityCommand) {
            draw((DrawEntityCommand) command);
        }
    }

    private static void draw(DrawEntityCommand command) {
        if (Objects.isNull(command)) {
            LOGGER.warning("You need to create a canvas first");
            return;
        }
        try {
            canvas.addEntity(entityFactory.getEntity(command));
            System.out.println(canvas.render());
        } catch (InvalidEntityException e) {
            LOGGER.warning("Can not add the model to canvas: " + e.getMessage());
        }
    }

    private static void createNewCanvas(CreateCommand command) {
        canvas = new CanvasImpl(command.getWidth(), command.getHeight());
        System.out.println(canvas.render());
    }

    private static void quit() {
        scanner.close();
        LOGGER.info("Exiting...");
        System.exit(0);
    }
}