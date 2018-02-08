package a2101020604.a2101020604;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.KeyEvent;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class PatientRegister extends AppCompatActivity {

    DatabaseHelperClass myDb;
    EditText FirstName, LastName, RoomNum;
    public Button SubmitPatients;
    public Button SelectDoc;
    TextView DoctorName;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_patient_register);

        myDb = new DatabaseHelperClass(this);
        FirstName = (EditText) findViewById(R.id.FirstName);
        LastName = (EditText) findViewById(R.id.LastName);
        RoomNum = (EditText) findViewById(R.id.roomNum);
        DoctorName = (EditText) findViewById(R.id.DoctorName);

        SubmitPatients = (Button) findViewById(R.id.SubmitPatients);
        AddData2();


    }

    public void AddData2() {
        SubmitPatients.setOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        boolean isInserted =
                                myDb.insertData2(FirstName.getText().toString(),
                                        LastName.getText().toString(),
                                        RoomNum.getText().toString(),
                                        DoctorName.getText().toString());

                        if (isInserted)
                            Toast.makeText(PatientRegister.this, "Data Inserted", Toast.LENGTH_LONG).show();
                        else
                            Toast.makeText(PatientRegister.this, "Data not Inserted", Toast.LENGTH_LONG).show();

                        if( FirstName.getText().toString().trim().equals("")) {


                            FirstName.setError( " required!" );

                        }
                        if( LastName.getText().toString().trim().equals("")) {



                            LastName.setError( " required!" );

                        }

                        if( RoomNum.getText().toString().trim().equals("")) {


                            RoomNum.setError( " required!" );


                        }
                        if( DoctorName.getText().toString().trim().equals("")) {



                            DoctorName.setError( "required!" );

                        }
                    }
                }
        );
    }
    public boolean onKeyDown(int keyCode, KeyEvent event)
    {
        if(keyCode==KeyEvent.KEYCODE_BACK)
        {
            Intent Intents = new Intent(PatientRegister.this, HomePage.class); // <----- START ACTIVITY
            startActivity(Intents);
            setContentView(R.layout.activity_login);
        }
        return false;
    }

}
