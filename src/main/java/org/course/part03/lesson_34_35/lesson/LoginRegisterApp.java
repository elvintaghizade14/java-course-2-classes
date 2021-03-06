package org.course.part03.lesson_34_35.lesson;

import org.course.part03.lesson_34_35.lesson.constant.Menu;
import org.course.part03.lesson_34_35.lesson.controller.UserController;

import java.util.InputMismatchException;
import java.util.Scanner;

public class LoginRegisterApp {
    private static final UserController userController = new UserController();

    public static void main(String[] args) {
        while (true) {
            String menu = Menu.getMenu();
            System.out.println(menu);

            int menuId = getMenuIdFromUser();

            doOperation(menuId);
        }
    }

    private static int getMenuIdFromUser() {
        Integer menuId = null;
        while (menuId == null) {
            Scanner scan = new Scanner(System.in);
            try {
                System.out.print("Enter a menu id [1,3]: ");
                menuId = scan.nextInt();
                if (menuId < 1 || menuId > 3)
                    throw new IllegalArgumentException("You've entered wrong value: " + menuId);
            } catch (InputMismatchException ime) {
                System.out.println("You've entered wrong value.");
                menuId = null;
            } catch (IllegalArgumentException iae) {
                System.out.println(iae.getMessage());
                menuId = null;
            }
        }
        return menuId;
    }

    private static void doOperation(int menuId) {
        if (menuId == 1) {
            Scanner scan = new Scanner(System.in);
            System.out.print("Enter username: ");
            String username = scan.nextLine();
            System.out.print("Enter password: ");
            String password = scan.nextLine();
            String message = userController.login(username, password);
            System.out.println(message);
        } else if (menuId == 2) {
            Scanner scan = new Scanner(System.in);
            System.out.print("Enter username: ");
            String username = scan.nextLine();
            System.out.print("Enter password: ");
            String password = scan.nextLine();
            System.out.print("Enter confirm password: ");
            String confirmPassword = scan.nextLine();
            String message = userController.register(username, password, confirmPassword);
            System.out.println(message);
        } else if (menuId == 3) {
            System.out.println("Bye ...");
            System.exit(1);
        }
    }
}