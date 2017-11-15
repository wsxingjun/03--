package it.oztaking.com.a03_;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

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
        new SQLiteOpenHelper()


    }

    public void MyDelete(){

    }

    public void MyUpdate(){

    }

    public void MyQuery(){
        SQLiteDatabase.openDatabase("/data/data/it.oztaking.com.a02_databasedemo/")
    }

}
