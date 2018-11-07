package gorental.com.sqliteex1practice.DatabaseHelper;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.widget.Toast;

public class MyDataBaseHelper extends SQLiteOpenHelper{
        private static final String DATABASE_NAME = "student.db";
        private static final String TABLE_NAME = "student_details";
        private static final String ID = "_id";
        private static final String NAME = "Name";
        private static final String AGE = "Age";
        private static final int DATABASE_VERSION_NO = 2;
        private static final String CREATE_TABLE = "CREATE TABLE "+TABLE_NAME+"("+ID+" INTEGER PRIMARY KEY AUTOINCREMENT,"+NAME+" VARCHAR(255),"+AGE+" INTEGER);";
        private static final String DROP_TABLE = "DROP TABLE IF EXISTS "+TABLE_NAME;

        private Context context;

        public MyDataBaseHelper(Context context) {
            super(context, DATABASE_NAME, null, DATABASE_VERSION_NO);
            this.context = context;
        }

        @Override
        public void onCreate(SQLiteDatabase db) {

            try {
                Toast.makeText(context,"onCreate is called",Toast.LENGTH_SHORT).show();
                db.execSQL(CREATE_TABLE);
            }catch (Exception e)
            {
                Toast.makeText(context,"Exception : "+e,Toast.LENGTH_SHORT).show();
            }
        }

        @Override
        public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

            try {
                Toast.makeText(context,"onUpgrade is called",Toast.LENGTH_SHORT).show();
                db.execSQL(DROP_TABLE);
                onCreate(db);
            }catch (Exception e)
            {
                Toast.makeText(context,"Exception : "+e,Toast.LENGTH_SHORT).show();
            }

        }
}
