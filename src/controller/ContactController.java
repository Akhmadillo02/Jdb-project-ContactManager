package controller;

import dto.Contact;
import service.ContactService;
import util.DatabaseUtil;

import java.util.Scanner;

public class ContactController {

    private ContactService contactService = new ContactService();

    private Scanner strscanner = new Scanner(System.in);
    public void start() {
        DatabaseUtil.createTable();

        boolean b = true;
        while (b) {
            showMenu();
            int action = getAction();
            switch (action) {
                case 1:
                    addContact();
                    break;
                case 2:
                    contactList();
                    break;
                case 3:
                    deleteContact();
                    break;
                case 4:
                    search();
                    break;
                case 0:
                    System.out.println("exit");
                    b = false;
                    break;
                default:
                    b = false;


            }
        }
    }
    public void showMenu() {
        System.out.println("*** Menu ***");
        System.out.println("1. Add entity.Contact");
        System.out.println("2. entity.Contact List");
        System.out.println("3. Delete entity.Contact");
        System.out.println("4. Search entity.Contact");
        System.out.println("0. Exit");
    }

    public int getAction() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter action: ");
        return strscanner.nextInt();
    }


    public void addContact() {
        System.out.println("Enter name: ");
        String name = strscanner.next();

        System.out.println("Enter surname: ");
        String surname = strscanner.next();

        System.out.println("Enter phone: ");
        String phone = strscanner.next();

        Contact contact = new Contact();
        contact.setName(name);
        contact.setSurname(surname);
        contact.setPhone(phone);

        contactService.addContact(contact);

    }

    public void contactList() {
        contactService.contactList();
    }

    public void deleteContact() {
        System.out.println("Enter phone: ");
        String phone = strscanner.next();
        contactService.deleteContact(phone);

    }

    public void search() {
        System.out.println("Enter query: ");
        String query = strscanner.next();
        contactService.search(query);

    }
}
