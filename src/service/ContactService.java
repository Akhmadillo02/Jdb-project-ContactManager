package service;

import dto.Contact;
import repository.ContactRepository;

import java.util.List;

public class ContactService {

    private ContactRepository contactRepository = new ContactRepository();

    public void addContact(Contact contact) {
        Contact exists = contactRepository.getByPhone(contact.getPhone());
        if (exists != null) {
            System.out.println("Phone already exists !");
            return;
        }
        boolean result = contactRepository.saveContact(contact);
        if (result) {
            System.out.println("entity.Contact added");
        } else {
            System.out.println("entity.Contact something");

        }

    }

    public void contactList() {
        List<Contact> contactList = contactRepository.getContactList();
        if (contactList.isEmpty()) {
            System.out.println("Not entity.Contact");
        }
        for (Contact contact : contactList) {
            System.out.println(contact.getName() + " " + contact.getSurname() + " " + contact.getPhone());
        }
    }

    public void deleteContact(String phone) {
        int effectedRows = contactRepository.delete(phone);
        if (effectedRows == 1) {
            System.out.println("entity.Contact successfully deleted");
        } else {
            System.out.println("entity.Contact not exists !");
        }

    }

    public void search(String query) {
        List<Contact> contactList = contactRepository.search(query);
        for (Contact contact : contactList) {
            System.out.println(contact.getName() + " " + contact.getSurname() + " " + contact.getPhone());

        }
    }
}
