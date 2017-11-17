package missionhelper.sj.com.missionhelper;

import android.content.Context;
import android.content.res.AssetManager;
import android.database.Cursor;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;


public class DBManager extends SQLiteOpenHelper {

    // 변수 선언
    public static final String ROOT_DIR = "/data/data/missionhelper.sj.com.missionhelper/databases/";
    private static final String DATABASE_NAME = "DB_MissionHelper_ch1.db";
    private static final int SCHEMA_VERSION = 1;
    private static final String QT_TABLE_NAME = "QTDateAndVerse";
    private static final String NAVI_TABLE_NAME = "NaviSixtyVerses";
    private static final String USER_TABLE_NAME = "UserSetDate";


    // 생성자 함수
    public DBManager(Context context) {
        super(context, DATABASE_NAME, null, SCHEMA_VERSION);
        Log.v("mylog", "DBManager() 생성자 실행");

        // setDB 호출(assets에서 복사해오기)
        Log.v("mylog", "setDB 함수 호출");
        setDB(context);

    } // DBManager();


    @Override
    public void onCreate(SQLiteDatabase db) {
        Log.v("mylog", "onCreate(SQLiteDatabase db) 실행");
    } // onCreate(SQLiteDatabase db)


    @Override
    public void onOpen(SQLiteDatabase db) {
        super.onOpen(db);
        Log.v("mylog", "onOpen(SQLiteDatabase db) 실행");

        // 가져온 날짜와 비교해서 큐티 구절 출력
        setShow_qtVerse_tv(db);

    } // onOpen(SQLiteDatabase db)


    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        Log.v("mylog", "onUpgrade(SQLiteDatabase db) 실행");
    } // onUpgrade()

// ---------------------------------------------------------------------------------------------

    // assets에서 DB 복사해서 가져오기
    public static void setDB(Context ctx) {
        Log.v("mylog", "setDB(Context ctx) 함수 실행");

        File folder = new File(ROOT_DIR);

        // check
        if(folder.exists()) {
            Log.v("mylog", "폴더가 이미 존재");
        } else {
            folder.mkdirs();
            Log.v("mylog", "새로 폴더 생성");
        }

        AssetManager assetManager = ctx.getResources().getAssets();

        File outfile = new File(ROOT_DIR+DATABASE_NAME);

        InputStream is = null;

        FileOutputStream fo = null;

        long filesize = 0;

        try{

            // asset 폴더 및 복사할 db 지정
            is = assetManager.open(DATABASE_NAME, AssetManager.ACCESS_BUFFER);
            filesize = is.available();

            // 파일이 없거나 패키지 폴더에 설치된 db 파일이 포함된 db 파일보다
            // 크기가 같지 않을 경우 db 파일을 덮어쓴다
            if (outfile.length() <= 0) {
                byte[] tempdata = new byte[(int) filesize];
                is.read(tempdata);
                Log.v("mylog", "tempdata : " + tempdata);
                is.close();

                outfile.createNewFile();
                Log.v("mylog", "createNewFile()");

                fo = new FileOutputStream(outfile);
                fo.write(tempdata);
                fo.close();

            } else {
                // db가 있는 경우
                Log.v("mylog", "db 있음");
            }

        } catch(IOException e) {
            Log.v("mylog", "db 이동 실패");
            Log.v("mylog", e.getMessage()+"");
        }

    } // setDB(Context ctx)
// ---------------------------------------------------------------------------------------------

    // 시스템 날짜 값과 DB의 값을 비교해서 텍스트 뷰에 값을 출력하는 함수

    public void setShow_qtVerse_tv(SQLiteDatabase db) {
        Log.v("mylog", "setShow_qtVerse_tv()");

        // db 내용 조회
        try{

            String printDay_Verse = "";
            String printNight_Verse = "";

            Cursor c1 = db.rawQuery(select_day_verse(DateQtBibleActivity.mMnd), null);
            Cursor c2 = db.rawQuery(select_night_verse(DateQtBibleActivity.mMnd), null);

            if(c1 != null || c2 != null) {
                Log.v("mylog", "(c1 != null || c2 != null)");

                while(c1.moveToNext()){
                    printDay_Verse += c1.getString(0);
                }

                while(c2.moveToNext()){
                    printNight_Verse += c2.getString(0);
                }

                DateQtBibleActivity.mShowQtVerseTv.setText(printDay_Verse);
                DateQtBibleActivity.mShowReadingVerseTv.setText(printNight_Verse);

            } else {
                Log.v("mylog", "(c1 or c2 = null)");
            }

        } catch(SQLException e) {
            Log.v("mylog", e.getMessage() + "");

        } catch (Exception e) {
            Log.v("mylog", e.getMessage() + "");
        }


    } // setShow_qtVerse_tv()

// ---------------------------------------------------------------------------------------------

    // mnd를 입력받아 select day_verse SQL을 완성하는 메소드

    public String select_day_verse(String mnd) {
        String select_day_verse = "SELECT day_verse FROM " + QT_TABLE_NAME + " WHERE _date=" + "'" + mnd + "'" +";";
        return select_day_verse;
    }

    // mnd를 입력받아 select night_verse SQL을 완성하는 메소드

    public String select_night_verse(String mnd) {
        String select_night_verse = "SELECT night_verse FROM " + QT_TABLE_NAME + " WHERE _date=" + "'" + mnd + "'" +";";
        return select_night_verse;
    }

// ---------------------------------------------------------------------------------------------

} // class DBManager
