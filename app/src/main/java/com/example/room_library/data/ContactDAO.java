package com.example.room_library.data;

import androidx.lifecycle.LiveData;
import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.OnConflictStrategy;
import androidx.room.Query;

import com.example.room_library.model.Contact;

import java.util.List;
@Dao
public interface ContactDAO {
    @Insert(onConflict = OnConflictStrategy.IGNORE)
    public void insert(Contact contact);
    @Query("DELETE FROM contact")
    public void deleteAll();
    @Query("SELECT * FROM contact")

    LiveData<List<Contact> >getAllContact();
}
