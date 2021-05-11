package com.example.room_library;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.ViewModelProvider;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.room_library.model.Contact;
import com.example.room_library.model.ContactViewModel;

public class Contacts extends AppCompatActivity {
    public static final String NAME = "name";
    public static final String OCCUPATION="occupation";
    ContactViewModel contactViewModel;
    private EditText name;
    private EditText occupation;
    private Button button;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_contact);

        name=findViewById(R.id.enter_name);
        occupation=findViewById(R.id.enter_occupation);
        button=findViewById(R.id.save_button);

        contactViewModel=new ViewModelProvider.AndroidViewModelFactory(Contacts.this.
                getApplication()).
                create(ContactViewModel.class);

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent replyIntent = new Intent();
                if(!TextUtils.isEmpty(name.getText()) && !TextUtils.isEmpty(occupation.getText())){
                   String data1= name.getText().toString();
                   String data2=occupation.getText().toString();

                   Contact contact=new Contact(data1,data2);

                   contactViewModel.insert(contact);


                }

            }
        });
    }
}