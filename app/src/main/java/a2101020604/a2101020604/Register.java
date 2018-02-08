package a2101020604.a2101020604;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.KeyEvent;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;


public class Register extends AppCompatActivity  {


    DatabaseHelperClass myDb;
    EditText Username, Password, FullName, Department;
    public Button LoginPage;
    public Button RegisterBtn;

    public void init() {

        LoginPage = (Button) findViewById(R.id.LoginPage);
        LoginPage.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent toy2 = new Intent(Register.this, Login.class);
                startActivity(toy2);
                setContentView(R.layout.activity_login);

            }
        });

    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);
        init();
        myDb = new DatabaseHelperClass(this);
        Username = (EditText) findViewById(R.id.Username);
        Password = (EditText) findViewById(R.id.Password);
        FullName = (EditText) findViewById(R.id.FullName);
        Department = (EditText) findViewById(R.id.Department);
        LoginPage = (Button) findViewById(R.id.LoginBtn);
        RegisterBtn = (Button) findViewById(R.id.RegisterBtn);
        AddData();

    }

    public void AddData() {
        RegisterBtn.setOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        boolean isInserted =
                                myDb.insertData(Username.getText().toString(),
                                Password.getText().toString(),
                                FullName.getText().toString(),
                                        Department.getText().toString());

                        if( Username.getText().toString().trim().equals("")) {


                            Username.setError( "required!" );

                        }
                        if( Password.getText().toString().trim().equals("")) {



                            Password.setError( "required!" );

                        }

                        if( FullName.getText().toString().trim().equals("")) {



                            FullName.setError( " required!" );

                        }
                        if( Department.getText().toString().trim().equals("")) {



                            Department.setError( " required!" );

                        }
                        if (isInserted)
                            Toast.makeText(Register.this, "Data Inserted", Toast.LENGTH_LONG).show();
                        else
                            Toast.makeText(Register.this, "Data not Inserted", Toast.LENGTH_LONG).show();





                    }
                }
        );
    }


    public boolean onKeyDown(int keyCode, KeyEvent event)
    {
        if(keyCode==KeyEvent.KEYCODE_BACK)
        {
            Intent Intents = new Intent(Register.this, Login.class); // <----- START ACTIVITY
            startActivity(Intents);
            setContentView(R.layout.activity_login);
        }
        return false;
    }

}