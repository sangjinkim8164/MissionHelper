/*
package missionhelper.sj.com.missionhelper;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;


public class MainListActivity extends Activity {



    // oncCreate()
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        Log.v("mylog", "onCreate 실행");
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main_layout);
        setTitle("리스트뷰 테스트");

        final String strMenuArray [] = {"큐티 & 성경 읽기", "LDI 전도지 뷰어", "금주의 암송",
                "네비게이토 60구절", "LDI 60구절"};

        ListView menuList = (ListView)findViewById(R.id.main_list_view);

        // 어댑터 객체 생성 및 연결
        final ArrayAdapter<String> refArrayAdapter = new ArrayAdapter<String>(this, R.layout.list_item, strMenuArray);
        Log.v("mylog", "refArrayAdapter 생성");

        menuList.setAdapter(refArrayAdapter);
        Log.v("mylog", "setListAdapter(refArrayAdapter)");


        // 클릭 이벤트 처리
        menuList.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                Toast.makeText(getApplicationContext(), strMenuArray[i], Toast.LENGTH_SHORT).show();

                // 선택한 레이아웃 호출
                switch (i) {
                    case 1 : i = 0;
                        Log.v("mylog", "onItemClick case 1");
                        Intent intent = new Intent(getApplicationContext(), DateQtBibleActivity.class);
                        startActivity(intent);
                        break;

                    case 2 : i = 1;
                        Log.v("mylog", "onItemClick case 2");
                        break;

                    case 3 : i = 2;
                        Log.v("mylog", "onItemClick case 3");
                        break;

                    case 4 : i = 3;
                        Log.v("mylog", "onItemClick case 4");
                        break;

                    case 5 : i = 4;
                        Log.v("mylog", "onItemClick case 5");
                        break;

                    case 6 : i = 5;
                        Log.v("mylog", "onItemClick case 6");
                        break;
                }


            }
        });



    } // onCreate


} // class MainListActivity
*/
