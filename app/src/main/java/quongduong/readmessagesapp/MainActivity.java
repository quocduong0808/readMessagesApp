package quongduong.readmessagesapp;

import android.database.Cursor;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    private RecyclerView rvMessage;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        List<Messages> messages = new ArrayList<>();
        ArrayList<String> arrayMess = getAllMess();
        int i = 0;
        while(i < arrayMess.size()){
            messages.add(new Messages(arrayMess.get(i)));
            i++;
        }
        rvMessage = (RecyclerView) findViewById(R.id.rv_listmess);
        LinearLayoutManager layoutManager = new LinearLayoutManager(this, LinearLayoutManager.VERTICAL,false);
        rvMessage.setLayoutManager(layoutManager);
        rvMessage.setHasFixedSize(true);
        rvMessage.setAdapter(new RecyclerDataAdapter(this, messages));
    }

    public ArrayList<String> getAllMess() {
        ArrayList<String> mess = new ArrayList<String>();
        Uri uri = Uri.parse("content://sms");
        Cursor cursor = getContentResolver().query(uri, new String[]{"id", "address", "date", "body"}, null, null, null);
        cursor.moveToFirst();
        while (cursor.moveToNext()) {
            String address = cursor.getString(1);
            String body = cursor.getString(3);
            mess.add("Phone: " + address + "\n" + body);
        }
        return mess;
    }
    }

