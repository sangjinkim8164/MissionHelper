package missionhelper.sj.com.missionhelper;

public class Garbage {


            /*String creatTblSql =
                "CREATE TABLE IF NOT EXISTS " + TABLE_NAME +
                        "(_date INTEGER PRIMARY KEY, day_verse TEXT, night_verse TEXT);";*/
/*

        try {

            //Log.v("mylog", "dbInitialize(mContext) 호출");
            //  copyDB(mContext);

            */
/*//*
/ QtVerseTable 생성
            db.execSQL(creatTblSql);
            Log.v("mylog", "mDB.execSQL(creatTblSql)");*//*


            */
/*
            // (임시) 테이블 한 번 지우기
            db.execSQL("DROP TABLE " + TABLE_NAME);
            Log.v("mylog", "db.execSQL(\"DROP TABLE \" + TABLE_NAME);");
            *//*


            */
/*
            // insert_sql ArrayList에 넣기
            loadFile();
            Log.v("mylog", "loadFile();");

            // INSERT 쿼리로 데이터 삽입
            exeInsertSQL();
            Log.v("mylog", "exeInsertSQL()");
            *//*


        } catch (SQLException e) {
            Log.v("mylog", e.getMessage() + "");
        }
*/
// -------------------------------------------------------------------------------------

    /*// (임시) 테이블 한 번 지우고 삽입
            db.execSQL("DROP TABLE " + "'" + TABLE_NAME + "'");
            Log.v("mylog", "db.execSQL(\"DROP TABLE \" + TABLE_NAME);");

            String creatTblSql =
                    "CREATE TABLE IF NOT EXISTS " + TABLE_NAME +
                            "(_date INTEGER PRIMARY KEY, day_verse TEXT, night_verse TEXT);";

            db.execSQL(creatTblSql);
            Log.v("mylog", "mDB.execSQL(creatTblSql)");*/


    // exeInsertSQL();

// -------------------------------------------------------------------------------------

/*

    // assets에서 db 복사해서 가져오기
    public void copyDB(Context mContext) {
        Log.v("mylog", "dbInitialize(Context context) 함수 실행");

        // check
        File folder = new File(ROOT_DIR + "databases");
        folder.mkdir();
        Log.v("mylog", "database 폴더 생성");

        File outfile = new File(ROOT_DIR + "databases/" + DB_NAME);
        Log.v("mylog", "new File(ROOT_DIR + \"databases/\" + DB_NAME);");

        // if(outfile.length() <= 0){
        // Log.v("mylog", "if(outfile.length() <= 0)");

        // AssetManager assetManager = context.getResources().getAssets();
        AssetManager assetManager = mContext.getResources().getAssets();
        Log.v("mylog", "1");

        try {
            InputStream is = assetManager.open(DB_NAME, AssetManager.ACCESS_BUFFER);
            Log.v("mylog", "2");

            long filesize = is.available();
            byte[] tempdata = new byte[(int) filesize];
            is.read(tempdata);
            Log.v("mylog", "tempdata 값은 : " + tempdata);
            is.close();

            outfile.createNewFile();
            Log.v("mylog", "outfile.createNewFile();");

            FileOutputStream fo = new FileOutputStream(outfile);
            fo.write(tempdata);
            fo.close();

        } catch (IOException e) {
            Log.v("mylog", e.getStackTrace() + "");
        }

        // } // if()

    } // dbInitialize(Context context)
*/
// -------------------------------------------------------------------------------------



    /*// insert 쿼리 반복 실행
    public void exeInsertSQL() {
        Log.v("mylog", "**********************************************************************************");
        Log.v("mylog", "exeInsertSQL() 실행");

        int size = mReadArrayList.size();

        Log.v("mylog", "배열의 크기는 : " + size);
        // 마지막 배열 내용 확인
        Log.v("mylog", "마지막 배열의 내용은 : " + mReadArrayList.get(365).toString());
        *//*mDatabase.execSQL(mReadArrayList.get(1).toString());*//*

        // mReadArrayList 의 각 배열의 내용을 mDatabase.exeSQL( ); 로 실행
        for (int i = 0; i < size; i++) {
            String temp = mReadArrayList.get(i).toString();
            Log.v("mylog", temp);
            mDB.execSQL(temp);

        } // for

        Log.v("mylog", "exeInsertSQL() 실행 완료");
        Log.v("mylog", "**********************************************************************************");

    } // exeInsertSQL()*/

// -------------------------------------------------------------------------------------

    // private ArrayList<String> mReadArrayList;

    /*// raw 폴더의 파일을 읽어오는 함수 (mReadArrayList에 저장)
    public void loadFile(){
        Log.v("mylog", "**********************************************************************************");
        Log.v("mylog", "loadFile() 실행");

        try{
            InputStream in = mContext.getResources().openRawResource(R.raw.insert_sql);

            if (in != null) {
                InputStreamReader stream = new InputStreamReader(in, "utf-8");
                BufferedReader buffer = new BufferedReader(stream);

                String readString;
                *//*StringBuilder sb = new StringBuilder("");*//*

                mReadArrayList = new ArrayList<String>();
                int i = -1;

                while ((readString = buffer.readLine()) != null) {
                    Log.v("mylog", "loadFile() while 실행");

                    i++;

                    // 한 줄씩 읽어온 내용을 mReadArrayList 에 저장
                    mReadArrayList.add(i, readString);
                    Log.v("mylog", "***" + readString);
                    Log.v("mylog", "readArrayList.add(" + i + ", readString");

                } // while( )

                in.close();
                Log.v("mylog", "in.close();");

                // 읽어온 문자열 출력
                *//*SecondQtDateSettingMain.setMShowET(mReadArrayList.size() +"");*//*

            } // if(in != null)

        } catch(Exception e) {
            Log.v("mylog", e.getStackTrace() + "");
        }
        Log.v("mylog", "loadFile() 실행 완료");
        Log.v("mylog", "**********************************************************************************");

    } // loadFile()*/

// -------------------------------------------------------------------------------------
} // class Garbage
