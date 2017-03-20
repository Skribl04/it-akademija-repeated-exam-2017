package lt.itakademija.controller;

import lt.itakademija.model.Id;
import lt.itakademija.model.command.CreateContact;
import lt.itakademija.model.command.CreateMessage;
import lt.itakademija.model.command.UpdateContact;
import lt.itakademija.model.query.Contact;
import lt.itakademija.model.query.Message;
import lt.itakademija.repository.MessengerRepository;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by mariusg on 2017.03.19.
 */
@RestController
@RequestMapping (value = "/webapi/messenger")
public class MessengerServiceController {

    private final MessengerRepository repository;
    
    @Autowired
    public MessengerServiceController(MessengerRepository repository) {
        this.repository = repository;
    }
    
    @PostMapping (value= "/contacts")
    public Id createContact(CreateContact createContact) {
    	return new Id(repository.createContact(createContact));
    }
    @GetMapping (value= "/contacts")
    public List<Contact> getContacts() {
        return repository.getContacts();
    }
    @GetMapping (value= "/contacts/{contactId}")
    public Contact getContact(@PathVariable ("contactId")Long contactId) {
        return repository.getContact(contactId);
    }
    @PostMapping (value= "/contacts/{contactId}")
    public void updateContact(@PathVariable Long contactId,
                              UpdateContact updateContact) {
    	repository.updateContact(contactId, updateContact);
    }
    @DeleteMapping (value= "/contacts/{contactId}")
    public void deleteContact(@PathVariable ("contactId") Long contactId) {
        repository.deleteContact(contactId);
    }
    @PostMapping (value= "/messages/{contactId}")
    public Id createMessage(@PathVariable Long contactId,
                            CreateMessage createMessage) {
        return new Id(repository.createMessage(contactId, createMessage));
    }
    @GetMapping (value= "/messages/{contactId}")
    public List<Message> getMessages(@PathVariable Long contactId) {
        return repository.getMessages(contactId);
    }

}
