package com.example.concursodetartas;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.RadioGroup;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    EditText name, surname, age, otherName;
    RadioGroup radioGroup;
    CheckBox answer;
    Button signUp;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.scroll_main);

        name = (EditText) findViewById(R.id.name);
        surname = (EditText)findViewById(R.id.surname);
        age = (EditText)findViewById(R.id.age);
        otherName = (EditText)findViewById(R.id.otherName);
        answer = (CheckBox) findViewById(R.id.answer);
        answer.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(answer.isChecked()){
                    otherName.setVisibility(View.VISIBLE);
                }else{
                    otherName.setVisibility(View.INVISIBLE);
                }
            }
        });
        radioGroup = (RadioGroup)findViewById(R.id.checkRadio);
        signUp = (Button)findViewById(R.id.signUp);
        signUp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String correctName =  name.getText().toString();
                String correctSurname = surname.getText().toString();

                String number = age.getText().toString();
                int correctAge = 0;
                if(number.length() != 0){
                    correctAge = Integer.parseInt(number);
                }

                if(correctName.length() != 0 && correctSurname.length() != 0 && correctAge >= 18
                        && radioGroup.getCheckedRadioButtonId() != -1){
                    Toast.makeText(MainActivity.this,
                            "La inscripción se ha realizado con éxito",
                            Toast.LENGTH_SHORT).show();
                }else{

                    if(correctName.length() == 0 ){
                        Toast.makeText(MainActivity.this, "Hay un error en el " +
                                        "formulario, faltan datos.", Toast.LENGTH_SHORT).show();
                    } if(correctSurname.length() == 0){
                        Toast.makeText(MainActivity.this, "Hay un error en el " +
                                        "formulario, faltan datos.", Toast.LENGTH_SHORT).show();
                    } if(correctAge == 0){
                        Toast.makeText(MainActivity.this, "Hay un error en el " +
                                "formulario, faltan datos.", Toast.LENGTH_SHORT).show();
                    } else if (correctAge > 1 && correctAge < 18){
                        Toast.makeText(MainActivity.this, "Eres menor de edad, no " +
                                "puedes inscribirte.", Toast.LENGTH_SHORT).show();
                    } if (radioGroup.getCheckedRadioButtonId() == -1){
                        Toast.makeText(MainActivity.this, "Hay un error en el " +
                                        "formulario, faltan datos.", Toast.LENGTH_SHORT).show();
                    }
                }
            }
        });
    }
}