package bluebiit.fynes.metropolia.helpme20;

/**
 * Created by mike on 23/11/2014.
 */
import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;
import android.view.Gravity;
import android.view.View;
import android.widget.TableRow;
import android.widget.TextView;

public class DatabaseHelper extends SQLiteOpenHelper{

    private static final int databaseVersion = 1;
    static final String dbName="helpMeUsers";
    static final String userTable="users";
    static final String colID="UserID";
    static final String colName="UserName";
    static final String colAccount ="Account";
    static final String colApp ="Application";
    static final String colBrowser="Browser";
    static final String colCam="Camera";
    static final String colGest="Gestures";

    static final String colIcons="ScreenIcons";
    static final String colSounds="Sounds";
    static final String colWallPaper="WallPaper";
    static final String colWifi="Wifi";

    private String task, user;
    private boolean acc_complete, app_complete, browser_complete, cam_complete, gest_complete, icon_complete, sound_complete, wp_complete, wifi_complete;

    public SQLiteDatabase db;
    StartPage m;




    public DatabaseHelper(Context context) {
        super(context, dbName, null, databaseVersion);


    }
    @Override
    public void onCreate(SQLiteDatabase db) {
        // TODO Auto-generated method stub
        try{

            db.execSQL("CREATE TABLE IF NOT EXISTS "+userTable+" ("+colID+" INTEGER PRIMARY KEY AUTOINCREMENT,"+colName+" TEXT, "+
                    colApp+" TEXT, "+colAccount+" TEXT, "+colBrowser+" TEXT, "+colCam+" TEXT, "+colGest+" TEXT, "+colIcons+" TEXT,"+colSounds+" TEXT,"+colWallPaper+" TEXT,"+colWifi+" TEXT)");
            Log.d("DATABASE","I RAN!");
        }
        catch(Exception e){
            Log.d("SQL", "DID NOT CREATE TABLE");
        }
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

        //db.execSQL("DROP TABLE IF EXISTS "+hoursTable);



        //onCreate(db);

    }


    // ALLOWS CREATION OF NEW USER WITH ALL TASKS SET TO UNCOMPLETED
    public String insertData(String uName){
        SQLiteDatabase db=this.getWritableDatabase();





        ContentValues cv=new ContentValues();

        cv.put(colName, uName);
        cv.put(colAccount, "false");
        cv.put(colApp, "false");
        cv.put(colBrowser, "false");
        cv.put(colBrowser, "false");
        cv.put(colBrowser, "false");
        cv.put(colBrowser, "false");
        cv.put(colBrowser, "false");
        cv.put(colBrowser, "false");
        cv.put(colBrowser, "false");
        db.insert(userTable, colID, cv);



        db.close();


        Log.d("DATABASE", "INSERTED SUCCESSFULLY!");






        return uName;
    }


    public void updateTask(String userName, int taskNum){
        SQLiteDatabase db=this.getWritableDatabase();


        switch(taskNum){
            case 1: setTask(colName);
                break;
            case 2:
                setTask(colApp);
                break;
            case 3:
                setTask(colAccount);
                break;
            case 4:
                setTask(colBrowser);
                break;
            case 5:
                setTask(colCam);
                break;
            case 6:
                setTask(colGest);
                break;
            case 7:
                setTask(colIcons);
                break;
            case 8:
                setTask(colSounds);
                break;
            case 9:
                setTask(colWallPaper);
                break;
            case 10:
                setTask(colWifi);
                break;
        }






        String sql = "UPDATE users set " + getTask() + " = 'true' where UserName='" + userName + "';";
        Log.d("DB UPDATE", "TASK: "+getTask()+" USER: "+userName);

     db.execSQL(sql);
        db.close();
    }

    public void getUserStatus(String userName){

        Cursor cursor = getReadableDatabase().rawQuery("SELECT * FROM users WHERE UserName = '" + userName+"';",null);
        cursor.moveToFirst();

      String acc = cursor.getString(2);
        setAcc_complete(Boolean.parseBoolean(acc));

      String app = cursor.getString(3);
        setApp_complete(Boolean.parseBoolean(app));

      String browser = cursor.getString(4);
        setBrowser_complete(Boolean.parseBoolean(browser));

       String cam = cursor.getString(5);
        setCam_complete(Boolean.parseBoolean(cam));

       String gest = cursor.getString(6);
        setGest_complete(Boolean.parseBoolean(gest));

        String icons = cursor.getString(7);
        setIcon_complete(Boolean.parseBoolean(icons));

        String sounds = cursor.getString(8);
        setSound_complete(Boolean.parseBoolean(sounds));

        String wallP = cursor.getString(9);
        setWp_complete(Boolean.parseBoolean(wallP));

        String wifi = cursor.getString(10);
        setWifi_complete(Boolean.parseBoolean(wifi));


    }

   /* public void clearData(){
        SQLiteDatabase db=this.getWritableDatabase();
        db.execSQL("DROP TABLE IF EXISTS "+userTable);
        try{

            db.execSQL("CREATE TABLE IF NOT EXISTS "+hoursTable+" ("+colID+" INTEGER PRIMARY KEY AUTOINCREMENT,"+colName+" TEXT, "+
                    colStart+" LONG, "+colStop+" LONG, "+colTotal+" INT)");
            Log.d("RECREATE","TABLE DROPPED AND RECREATED!");
        }
        catch(Exception e){
            Log.d("SQL", "DID NOT CREATE TABLE");
        }
        db.close();
    }*/

    public String getTask() {
        return task;
    }

    public void setTask(String task) {
        this.task = task;
    }


    public boolean isWifi_complete() {
        return wifi_complete;
    }

    public void setWifi_complete(boolean wifi_complete) {
        this.wifi_complete = wifi_complete;
    }

    public boolean isAcc_complete() {
        return acc_complete;
    }

    public void setAcc_complete(boolean acc_complete) {
        this.acc_complete = acc_complete;
    }

    public boolean isApp_complete() {
        return app_complete;
    }

    public void setApp_complete(boolean app_complete) {
        this.app_complete = app_complete;
    }

    public boolean isBrowser_complete() {
        return browser_complete;
    }

    public void setBrowser_complete(boolean browser_complete) {
        this.browser_complete = browser_complete;
    }

    public boolean isCam_complete() {
        return cam_complete;
    }

    public void setCam_complete(boolean cam_complete) {
        this.cam_complete = cam_complete;
    }

    public boolean isGest_complete() {
        return gest_complete;
    }

    public void setGest_complete(boolean gest_complete) {
        this.gest_complete = gest_complete;
    }

    public boolean isIcon_complete() {
        return icon_complete;
    }

    public void setIcon_complete(boolean icon_complete) {
        this.icon_complete = icon_complete;
    }

    public boolean isSound_complete() {
        return sound_complete;
    }

    public void setSound_complete(boolean sound_complete) {
        this.sound_complete = sound_complete;
    }

    public boolean isWp_complete() {
        return wp_complete;
    }

    public void setWp_complete(boolean wp_complete) {
        this.wp_complete = wp_complete;
    }
}
