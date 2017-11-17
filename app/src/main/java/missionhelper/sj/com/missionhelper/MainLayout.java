package missionhelper.sj.com.missionhelper;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.util.Log;
import android.view.View;
import android.widget.Button;


public class MainLayout extends Activity {

    // 변수 선언
    private Intent mMainIntent;
    private Button mDailyQtBtn;
    private Button mRecitationBtn;
    private Button mMissionPaperViewerBtn;
    private Context mContext;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        Log.v("mylog", "onCreate()");
        super.onCreate(savedInstanceState);
        this.setContentView(R.layout.main_layout);

        // 주소 가져오기
        mContext = this;
        this.mDailyQtBtn = (Button)findViewById(R.id.dailyQtBtn);
        this.mRecitationBtn = (Button)findViewById(R.id.recitaion_Btn);
        this.mMissionPaperViewerBtn= (Button)findViewById(R.id.missionPaperViewer_Btn);

        // QT버튼 클릭
        mDailyQtBtn.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view) {
                Log.v("mylog", "QT버튼 클릭");
                startActivity(new Intent(mContext, DateQtBibleActivity.class));
                Log.v("mylog", "startActivity(DateQtBibleActivity.class);");
            }
        });

        // 암송버튼 클릭
        mRecitationBtn.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view) {
                Log.v("mylog", "암송버튼 클릭");

            }
        });

        // 전도지뷰어버튼 클릭
        mMissionPaperViewerBtn.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view) {
                Log.v("mylog", "전도지 뷰어 버튼 클릭");

            }
        });


    } // onCreate


} // class MainLayout
