package com.example.room_library.util;

import android.content.Context;

import androidx.annotation.NonNull;
import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;
import androidx.sqlite.db.SupportSQLiteDatabase;

import com.example.room_library.data.ContactDAO;
import com.example.room_library.model.Contact;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

@Database(entities = {Contact.class},version = 1,exportSchema = false)
public abstract class ContactRoomDataBase extends RoomDatabase {

    public abstract ContactDAO contactDAO();

    public static final int NUMBER_THREADS=4;

    private static volatile ContactRoomDataBase INSTANCE;

    public static final ExecutorService dataBaseService=Executors.newFixedThreadPool(NUMBER_THREADS);

    public static ContactRoomDataBase getDataBase(final Context context) {
        if (INSTANCE == null) {
            synchronized (RoomDatabase.class) {
                if (INSTANCE == null) {
                    INSTANCE = Room.databaseBuilder(context.getApplicationContext(), ContactRoomDataBase.class, "CONTACT_DATABASE").addCallback(sRoomDatabaseCallback)
                            .build();
                }
            }
        }
        return INSTANCE;
    }

    private static final RoomDatabase.Callback sRoomDatabaseCallback=new Callback() {
        @Override
        public void onCreate(@NonNull SupportSQLiteDatabase db) {
            super.onCreate(db);
            dataBaseService.execute(()->{
               ContactDAO contactDAO=INSTANCE.contactDAO();
               contactDAO.deleteAll();
               Contact contact=new Contact("Suriya","DEV");
               contactDAO.insert(contact);

                Contact contact2=new Contact("DEV","DEVEOPS");
                contactDAO.insert(contact2);
            });
        }
    };
}
