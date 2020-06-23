package com.example.login;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    private EditText Name;
    private EditText Password;
    private TextView Info;
    private Button Login;
    private int counter = 5;
    private Button Clear;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Name = (EditText)findViewById(R.id.Usuario);
        Password = (EditText)findViewById(R.id.Clave);
        Info = (android.widget.TextView)findViewById(R.id.Intentos);
        Login = (android.widget.Button)findViewById(R.id.Loginbtn);
        Clear = (android.widget.Button)findViewById(R.id.btnclear);


        Info.setText("Numero de intentos restante: 5");

        Login.setOnClickListener(new View.OnClickListener()
            {
            @Override
            public void onClick(View view) {
                validate(Name.getText().toString(), Password.getText().toString());
            }
        });
        Clear.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View view)
            {
                Name.setText("");
                Password.setText("");
            }
        });
    }
    private void validate (String userName, String userPassword) {
        if((userName.equals("Admin")) &&  userPassword.equals("root"))
        {
            Intent intent = new Intent(MainActivity.this, SecondActivity.class);
            startActivity(intent);
        }
        else
            {
            counter--;
            Info.setText("Numero de intentos restante: "+ String.valueOf(counter));
            if(counter == 0)
            {
            Login.setEnabled(false);
            }
            }
    }
}
