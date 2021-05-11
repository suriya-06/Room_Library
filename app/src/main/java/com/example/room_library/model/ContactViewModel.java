package com.example.room_library.model;

import android.app.Application;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;

import com.example.room_library.data.ContactRepository;

import java.util.List;

public class ContactViewModel extends AndroidViewModel {

    public static ContactRepository contactRepository;
    public final LiveData<List<Contact>>  allContact;

    public ContactViewModel(@NonNull  Application application) {
        super(application);
        contactRepository=new ContactRepository(application);
        allContact =contactRepository.getAllContacts();
    }
    public LiveData<List<Contact>> getAllContact(){return allContact;}
    public  void insert(Contact contact){contactRepository.insert(contact);}
}
