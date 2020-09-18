package com.lupinesoft.widget_sqlite_recy;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class CreateActivity extends AppCompatActivity {
    EditText etName, etCGPA;
    Button button;
    SQLiteDBHelper sqLiteDBHelper;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_create);

        sqLiteDBHelper = new SQLiteDBHelper(this);

        etName = findViewById(R.id.etName_ID);
        etCGPA = findViewById(R.id.etCGPA_ID);
        button = findViewById(R.id.btnSave_ID);

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String name = etName.getText().toString();
                String cgpa = etCGPA.getText().toString();

                long rowID = sqLiteDBHelper.InsertInfo(name, cgpa);

                if(rowID == -1) {
                    Toast.makeText(CreateActivity.this, "Saved Failed", Toast.LENGTH_SHORT).show();
                }else {
                    Toast.makeText(CreateActivity.this, "Saved Success", Toast.LENGTH_SHORT).show();
                    Intent intent=new Intent(CreateActivity.this, MainActivity.class);
                    startActivity(intent);
                }
            }
        });

    }
}
