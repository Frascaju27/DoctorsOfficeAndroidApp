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


public class Test extends AppCompatActivity  {


    DatabaseHelperClass myDb;
    EditText BPL, BPH, Tempature;
    public Button SubmitTest;
    public Button SelectPatient;
    TextView pName;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_test);

        myDb = new DatabaseHelperClass(this);
        pName = (TextView) findViewById(R.id.pName);
        BPL = (EditText) findViewById(R.id.Bpl);
        BPH = (EditText) findViewById(R.id.Bph);
        Tempature = (EditText) findViewById(R.id.Temp);
        SubmitTest = (Button) findViewById(R.id.SubmitTest);
        SelectPatient = (Button) findViewById(R.id.RegisterBtn);
        AddData();

    }

    public void AddData() {
        SubmitTest.setOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        boolean isInserted =
                                myDb.insertData3(pName.getText().toString(),
                                        BPL.getText().toString(),
                                        BPH.getText().toString(),
                                        Tempature.getText().toString());

                        if( pName.getText().toString().trim().equals("")) {


                            pName.setError( "required!" );

                        }
                        if( BPL.getText().toString().trim().equals("")) {



                            BPL.setError( "required!" );

                        }
                        if( BPH.getText().toString().trim().equals("")) {



                            BPH.setError( "required!" );

                        }

                        if( Tempature.getText().toString().trim().equals("")) {



                            Tempature.setError( "required!" );

                        }


                        if (isInserted)
                            Toast.makeText(Test.this, "Data Inserted", Toast.LENGTH_LONG).show();
                        else
                            Toast.makeText(Test.this, "Data not Inserted", Toast.LENGTH_LONG).show();


                    }
                }
        );
    }


    public boolean onKeyDown(int keyCode, KeyEvent event)
    {
        if(keyCode==KeyEvent.KEYCODE_BACK)
        {
            Intent Intents = new Intent(Test.this, HomePage.class); // <----- START ACTIVITY
            startActivity(Intents);
            setContentView(R.layout.activity_login);
        }
        return false;
    }

}