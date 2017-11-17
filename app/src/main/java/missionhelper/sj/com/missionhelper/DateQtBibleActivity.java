package missionhelper.sj.com.missionhelper;

import android.app.Activity;
import android.app.DatePickerDialog;
import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.TextView;

import java.util.Calendar;

public class DateQtBibleActivity extends Activity {

    // 변수 선언
    static Context mContext;
    static TextView mShowQtVerseTv;
    static TextView mShowReadingVerseTv;

    // DBManager 클래스 참조 변수
    private DBManager mDbManager;

    // 날짜 및 시간 보관 변수
    static Calendar mRefCalendar;
    static int mYear;
    static int mMonth;
    static int mDay;

    static String mMnd;

    // 사용자 날짜 선택
    String mUserPickMnD;

    // 날짜 출력창(버튼)
    static Button mShowDateBt;


    // onCreate()
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        Log.v("mylog", "DateQtBibleActivity oncreate 실행" );
        super.onCreate(savedInstanceState);
        setContentView(R.layout.date_qt_bible_layout);

        // 주소 가져오기
        mContext = this;
        this.mShowDateBt = (Button)findViewById(R.id.date_setting_bt);
        this.mShowQtVerseTv = (TextView) findViewById(R.id.show_qtVerse_tv);
        this.mShowReadingVerseTv = (TextView)findViewById(R.id.show_readingVerse_tv);

        // 시스템 날짜 가져와서 출력
        String tempDate = getDate();
        mShowDateBt.setText(tempDate);
        Log.v("mylog", "mShowDateEt.setText(tempDate);");

        // Mnd 만들기
        getMnD();

        // DBManager 클래스 호출
        mDbManager = new DBManager(mContext);
        mDbManager.getReadableDatabase();
        mDbManager.close();
        Log.v("mylog", "mDbManager.close(); 실행 완료");

        // 버튼 클릭 이벤트 - DatePickerdialog
        mShowDateBt.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view) {
                Log.v("mylog", "mShowDateBt 클릭");

             new DatePickerDialog(DateQtBibleActivity.this, dateSetListener, mYear, mMonth-1, mDay).show();

            }
        });

    } // onCreate()


    // dateSetListener 구현
    private DatePickerDialog.OnDateSetListener dateSetListener = new DatePickerDialog.OnDateSetListener(){

        @Override
        public void onDateSet(DatePicker datePicker, int i, int i1, int i2) {

            int userPickYear = i;
            int userPickMonth = i1+1;
            int userPickday = i2;
            mUserPickMnD = Integer.toString(userPickMonth) + userPickday;
            Log.v("mylog",mUserPickMnD);

            // 토스트 출력
//            String msg = String.format("%d월 %d일 선택", i1+1, i2);
//            Toast.makeText(mContext, msg, Toast.LENGTH_SHORT).show();

            // 날짜표시 버튼 text 바꾸기
            mShowDateBt.setText(userPickYear + "년 " + userPickMonth + "월 " + userPickday + "일");

            // mMnd 바꾸기
            mMnd = mUserPickMnD;

            // setShow_qtVerse_tv(db) 호출
            mDbManager.getReadableDatabase();
            mDbManager.close();

        }
    };


    // Calendar 클래스에 접근하는 함수
    static void getCalendarInfo() {
        mRefCalendar = Calendar.getInstance();
    }

    // 현재 날짜를 읽어오는 함수
    public String getDate() {
        Log.v("mylog","getDate");
        getCalendarInfo();

        // 연도 가져오기
        mYear = mRefCalendar.get(Calendar.YEAR);
        // 월 가져오기
        mMonth = mRefCalendar.get(Calendar.MONTH) + 1;
        // 일 가져오기
        mDay = mRefCalendar.get(Calendar.DATE);

        String currentDate = mYear + "년 " + mMonth + "월 " + mDay + "일";
        return  currentDate;
    }

    // 월, 일만 가져오는 함수(mMnd 반환)
    static String getMnD() {
        Log.v("mylog","getMnD()실행");
        getCalendarInfo();

        String month = Integer.toString(mRefCalendar.get(Calendar.MONTH)+1);
        int day = mRefCalendar.get(Calendar.DATE);

        String tempDay = String.format("%02d", day);
        mMnd = month + tempDay;

        return mMnd;
    }

} // class DateQtBibleActivity
