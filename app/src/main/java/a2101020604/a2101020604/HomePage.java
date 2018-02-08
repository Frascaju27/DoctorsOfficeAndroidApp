package a2101020604.a2101020604;

import  android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.KeyEvent;
import android.view.View;
import android.widget.RadioButton;
import android.widget.RadioGroup;




public class HomePage extends AppCompatActivity implements View.OnClickListener {


    private RadioGroup HomeRadio;
    private RadioButton InsertPatient;
    private RadioButton PatientsResults;
    private RadioButton Tests;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home_page);


        HomeRadio = (RadioGroup) findViewById(R.id.HomeRadio);
        InsertPatient = (RadioButton) findViewById(R.id.InsertPatient);
        PatientsResults = (RadioButton) findViewById(R.id.PatientsResults);
        Tests = (RadioButton) findViewById(R.id.Tests);



        InsertPatient.setOnClickListener(this);
        PatientsResults.setOnClickListener(this);
        Tests.setOnClickListener(this);


    }

    public void onClick(View v){

        int checkedRadioButtonId = HomeRadio.getCheckedRadioButtonId();

        switch (checkedRadioButtonId){
            case R.id.InsertPatient:
                if (InsertPatient.isChecked()){
                    Intent Intents= new Intent(HomePage.this, PatientRegister.class); // <----- START  ACTIVITY
                    startActivity(Intents);
                    setContentView(R.layout.activity_patient_register);

                }
                break;

            case R.id.PatientsResults:
                if (PatientsResults.isChecked()) {
                    Intent Intents = new Intent(HomePage.this, Results.class); // <----- START ACTIVITY
                    startActivity(Intents);
                    setContentView(R.layout.activity_results);

                }
                break;

            case R.id.Tests:
                if (Tests.isChecked()){
                    Intent Intents= new Intent(HomePage.this, Test.class); // <----- START ACTIVITY
                    startActivity(Intents);
                    setContentView(R.layout.activity_test);

                }
        }
    }

    public boolean onKeyDown(int keyCode, KeyEvent event)
    {
        if(keyCode==KeyEvent.KEYCODE_BACK)
        {
            Intent Intents = new Intent(HomePage.this, Login.class); // <----- START ACTIVITY
            startActivity(Intents);
            setContentView(R.layout.activity_login);
        }
        return false;
    }

}
