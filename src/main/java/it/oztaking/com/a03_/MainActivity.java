package it.oztaking.com.a03_;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity implements View.OnClickListener{

    private Context mContext;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mContext = this;
        Button bt_add = (Button) findViewById(R.id.bt_add);
        Button bt_delete = (Button) findViewById(R.id.bt_delete);
        Button bt_update = (Button) findViewById(R.id.bt_update);
        Button bt_query = (Button) findViewById(R.id.bt_query);
        bt_add.setOnClickListener(this);
        bt_delete.setOnClickListener(this);
        bt_update.setOnClickListener(this);
        bt_query.setOnClickListener(this);
    }


    @Override
    public void onClick(View v) {
        int id = v.getId();
        switch (id){
            case R.id.bt_add:
                MyAdd();
                break;
            case R.id.bt_delete:
                MyDelete();
                break;
            case R.id.bt_update:
                MyUpdate();
                break;
            case R.id.bt_query:
                MyQuery();
                break;
            default:
                break;
        }

    }

    /**
     * 在应用1中增加一条数据
     */
    public void MyAdd(){
        Uri uri = Uri.parse("content://wangmazi/insert");
        ContentValues values = new ContentValues();
        values.put("name","zhangliu");
        values.put("money","99");
        Uri uri1 = getContentResolver().insert(uri, values);

        Toast.makeText(getApplicationContext(), uri1.toString(),Toast.LENGTH_SHORT).show();
        //System.out.println("插入内容的地址是："+uri1);


    }

    public void MyDelete(){
        Uri uri = Uri.parse("content://wangmazi/delete");
        int delete = getContentResolver().delete(uri, "name=?", new String[]{"zhangsan"});
        if (delete > 0){
            Toast.makeText(getApplicationContext(),"删除了"+delete+"行",Toast.LENGTH_SHORT).show();
        }
    }

    public void MyUpdate(){
        Uri uri = Uri.parse("content://wangmazi/update");
        ContentValues values = new ContentValues();
        values.put("money","1000000");
        int update = getContentResolver().update(uri, values, "name=?", new String[]{"zhangsan"});
        Toast.makeText(getApplicationContext(),"更新了"+update+"行",Toast.LENGTH_SHORT).show();

    }

    public void MyQuery(){
//        it.oztaking.com.a02_databasedemo","query
        Log.d("wsxingun","第二个应用程序MyQuery()");
        Uri uri = Uri.parse("content://wangmazi/query");
        Cursor cursor = getContentResolver().query(uri, new String[]{"name", "money"}, null, null, null);
        if (cursor != null){
            while (cursor.moveToNext()){
                Log.d("wsxingun","第二个应用程序cursor.moveToNext()");
                String name = cursor.getString(0);
                String money = cursor.getString(1);

                System.out.println("第二个应用查询的数据：name"+name+"------"+money);
                Toast.makeText(getApplicationContext(),"第二个应用查询的数据 name:"+name+"---"+money,Toast.LENGTH_LONG).show();
            }

        }
    }

}
