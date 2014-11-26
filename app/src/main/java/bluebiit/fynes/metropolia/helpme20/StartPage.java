package bluebiit.fynes.metropolia.helpme20;

import android.app.ActionBar;
import android.app.Activity;
import android.content.Intent;
import android.content.SharedPreferences;
import android.database.Cursor;
import android.os.Bundle;
import android.util.Log;
import android.view.Gravity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.RelativeLayout;
import android.widget.TableLayout;
import android.widget.TableRow;
import android.widget.TextView;

import java.io.BufferedWriter;
import java.io.FileOutputStream;
import java.io.OutputStreamWriter;
import java.util.Locale;


public class StartPage extends Activity implements View.OnClickListener {
    private Button btnAddUser;
    private EditText newUser;
    private String user, userFromDb;
    private static final String PREF = "TestPref";
    private TableLayout tableLayout;
    DatabaseHelper d;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_start_page);

        final RelativeLayout mainView = (RelativeLayout) findViewById(R.id.mainLayout);

        SharedPreferences prefGet = getSharedPreferences(PREF, Activity.MODE_PRIVATE);
        setUser(prefGet.getString("User", "Test"));

        d = new DatabaseHelper(this);

        btnAddUser = (Button) findViewById(R.id.btnAddUser);
        btnAddUser.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                newUser = (EditText) findViewById(R.id.newUser);
                String dbUser = newUser.getText().toString();
                 d.insertData(dbUser);

                tableLayout.addView(addRow(dbUser));
                newUser.setText("");
                setUser(dbUser);
                userChooser();
                startSecondAct();


            }
        });

        readUsersFromDataBase();

    }








    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.start_page, menu);
        return false;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();
        if (id == R.id.action_settings) {
            return true;
        }
        return super.onOptionsItemSelected(item);
    }

    public void startSecondAct() {
        Intent intent = new Intent(this, FirstPage.class);
        startActivity(intent);

    }

    @Override
    public void onClick(View v) {



        userChooser();

        startSecondAct();
    }

    public String getUser() {
        return user;
    }

    public void setUser(String user) {
        this.user = user;

    }


      public void userChooser(){
    String input = getUser();
    String Fname = "user.txt";
    try {
        FileOutputStream fOs = openFileOutput(Fname, MODE_WORLD_WRITEABLE);
        OutputStreamWriter oSw = new OutputStreamWriter(fOs);
        BufferedWriter bW = new BufferedWriter(oSw);
        bW.write(input);
        bW.flush();
        bW.close();
        oSw.close();
        fOs.close();
    }
    catch (Exception e) {
        Log.d("onClick", e.toString());
    }
      }


    public void readUsersFromDataBase(){

        // FINDS TABLE LAYOUT
        tableLayout = (TableLayout)findViewById(R.id.userTable);



        // OPENS DATABASE TELLS IT WHAT NEEDS TO BE READ
        Cursor cursor = d.getReadableDatabase().rawQuery("SELECT * FROM users",null);

        int rows = cursor.getCount();


        cursor.moveToFirst();

        // outer for loop
        for (int i = 0; i < rows; i++) {

            TableRow row = new TableRow(this);
            TableRow.LayoutParams params = new TableRow.LayoutParams(TableRow.LayoutParams.FILL_PARENT, TableRow.LayoutParams.WRAP_CONTENT);

            row.setLayoutParams(params);
            row.setGravity(Gravity.CENTER | Gravity.BOTTOM);
            row.setBackgroundColor(getResources().getColor(R.color.title_background));
            row.setPadding(1, 1, 1, 1);

            // USERNAME COLUMN
            TextView tv2 = new TextView(this);
            tv2.setTextSize(40);
            tv2.setPadding(25, 0, 25, 0);



            final String dbUser = cursor.getString(1);
            tv2.setText(dbUser);

            row.addView(tv2);
            row.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    setUser(dbUser);
                    userChooser();
                    startSecondAct();
                } });
            cursor.moveToNext();

            TableRow rowGap = new TableRow(this);

            rowGap.setLayoutParams(params);
            rowGap.setGravity(Gravity.CENTER | Gravity.BOTTOM);
            rowGap.setBackgroundColor(getResources().getColor(R.color.white));
            rowGap.setPadding(1, 1, 1, 1);

            tableLayout.addView(row);
            tableLayout.addView(rowGap);


            // DIALOGUE FRAGMENT




        }





        //	CLOSES READ STATE CLOSES DB

        cursor.close();
        d.close();
    }


    public TableRow addRow(String uName){
        TableRow row = new TableRow(this);
        TableRow.LayoutParams params = new TableRow.LayoutParams(TableRow.LayoutParams.FILL_PARENT, TableRow.LayoutParams.WRAP_CONTENT);

        row.setLayoutParams(params);
        row.setGravity(Gravity.CENTER | Gravity.BOTTOM);
        row.setBackgroundColor(getResources().getColor(R.color.title_background));
        row.setPadding(1, 1, 1, 1);

        // USERNAME COLUMN
        TextView tv2 = new TextView(this);
        tv2.setTextSize(40);
        tv2.setPadding(25, 0, 25, 0);




        tv2.setText(uName);

        row.addView(tv2);

        return row;
    }

}



