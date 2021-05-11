package com.example.room_library.data;

import android.app.Application;

import androidx.lifecycle.LiveData;

import com.example.room_library.model.Contact;
import com.example.room_library.util.ContactRoomDataBase;

import java.util.List;

public class ContactRepository {

    private ContactDAO contactDAO;

   private LiveData<List<Contact>> allContacts;

    public ContactRepository(Application application) {
        ContactRoomDataBase db=ContactRoomDataBase.getDataBase(application);
        contactDAO= db.contactDAO();
        allContacts= contactDAO.getAllContact();
    }

    public LiveData<List<Contact>> getAllContacts(){
        return allContacts;
    }

    public void insert(Contact contact){
        ContactRoomDataBase.dataBaseService.execute(()->{
            contactDAO.insert(contact);
        });
    }
}
