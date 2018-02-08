package a2101020604.a2101020604;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.database.Cursor;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.KeyEvent;
import android.view.View;
import android.widget.Button;


public class Results extends AppCompatActivity {


    DatabaseHelperClass myDb;
    Button btnviewAll;
    Button btnviewAll2;
    Button btnviewAll3;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_results);

        myDb = new DatabaseHelperClass(this);


        btnviewAll = (Button) findViewById(R.id.button_viewAll);
        btnviewAll2 = (Button) findViewById(R.id.button_viewAll2);
        btnviewAll3 = (Button) findViewById(R.id.button_viewAll3);

        viewAll();
        viewAll2();
        viewAll3();

    }

    public void viewAll() {
        btnviewAll.setOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        Cursor res = myDb.getAllData();
                        if (res.getCount() == 0) {
                            // show message
                            showMessage("Error", "Nothing found");
                            return;
                        }

                        StringBuffer buffer = new StringBuffer();
                        while (res.moveToNext()) {
                            buffer.append("Test ID :" + res.getString(0) + "\n");
                            buffer.append("Patient Name:" + res.getString(1) + "\n");
                            buffer.append("BPL:" + res.getString(2) + "\n");
                            buffer.append("BPH :" + res.getString(3) + "\n");
                            buffer.append("Temapture :" + res.getString(4) + "\n\n");

                        }

                        // Show all data
                        showMessage("Data", buffer.toString());
                    }
                }
        );
    }


    public void viewAll2() {
        btnviewAll2.setOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        Cursor res = myDb.getAllData2();
                        if (res.getCount() == 0) {
                            // show message
                            showMessage("Error", "Nothing found");
                            return;
                        }

                        StringBuffer buffer = new StringBuffer();
                        while (res.moveToNext()) {
                            buffer.append("Paitent ID :" + res.getString(0) + "\n");
                            buffer.append("Patient First Name:" + res.getString(1) + "\n");
                            buffer.append("Patient Last Name:" + res.getString(2) + "\n");
                            buffer.append("Room Number:" + res.getString(3) + "\n");
                            buffer.append("Doctor Name:" + res.getString(4) + "\n\n");

                        }

                        // Show all data
                        showMessage("Data", buffer.toString());
                    }
                }
        );
    }


    public void viewAll3() {
        btnviewAll3.setOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        Cursor res = myDb.getAllData3();
                        if (res.getCount() == 0) {
                            // show message
                            showMessage("Error", "Nothing found");
                            return;
                        }

                        StringBuffer buffer = new StringBuffer();
                        while (res.moveToNext()) {
                            buffer.append("Doctor ID :" + res.getString(0) + "\n");
                            buffer.append("Username:" + res.getString(1) + "\n");
                            buffer.append("Full Name:" + res.getString(3) + "\n");
                            buffer.append("Department:" + res.getString(4) + "\n\n");

                        }

                        // Show all data
                        showMessage("Data", buffer.toString());
                    }
                }
        );
    }



    public void showMessage(String title, String message) {
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setCancelable(true);
        builder.setPositiveButton("Ok", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInteface, int i) {
                dialogInteface.dismiss();
            }
        });
        builder.setTitle(title);
        builder.setMessage(message);
        builder.show();
    }
    public boolean onKeyDown(int keyCode, KeyEvent event)
    {
        if(keyCode==KeyEvent.KEYCODE_BACK)
        {
            Intent Intents = new Intent(Results.this, HomePage.class); // <----- START ACTIVITY
            startActivity(Intents);
            setContentView(R.layout.activity_login);
        }
        return false;
    }

}
