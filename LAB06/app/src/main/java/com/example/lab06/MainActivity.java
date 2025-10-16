package com.example.lab06;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.activity.result.ActivityResult;
import androidx.activity.result.ActivityResultCallback;
import androidx.activity.result.ActivityResultLauncher;
import androidx.activity.result.contract.ActivityResultContracts;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity {

    private ListView lv;
    String[]layoutName = {"LinearLayoutV","LinearLayoutH","RelativeLayout","TableLayout","FrameLayout","ScrollLayout","GridLayout",
                        "LinearLayoutV","LinearLayoutH","RelativeLayout","TableLayout","FrameLayout","ScrollLayout","GridLayout",
                        "LinearLayoutV","LinearLayoutH","RelativeLayout","TableLayout","FrameLayout","ScrollLayout","GridLayout"};

    int[]layoutIcon = {R.drawable.linearlayout_v,R.drawable.linearlayout_h,R.drawable.relativelayout,R.drawable.tablelayout,
            R.drawable.framelayout,R.drawable.scrollview,R.drawable.gridlayout,R.drawable.linearlayout_v,
            R.drawable.linearlayout_h,R.drawable.relativelayout,R.drawable.tablelayout,R.drawable.framelayout,
            R.drawable.scrollview,R.drawable.gridlayout,R.drawable.linearlayout_v,R.drawable.linearlayout_h,
            R.drawable.relativelayout,R.drawable.tablelayout,R.drawable.framelayout,R.drawable.scrollview,R.drawable.gridlayout};

    private ActivityResultLauncher<Intent> mGetContentFromIntent;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        lv = (ListView) findViewById(R.id.listViewMain);
        //ArrayAdapter<String> mAdapter = new ArrayAdapter<String>(this,R.layout.list_item,layoutName);
        //lv.setAdapter(mAdapter);
        lv.setAdapter(new myadapter(this));
        lv.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int position, long l) {
                //TextView tv_selected = (TextView) view;
                //Toast.makeText(getApplicationContext(), tv_selected.getText(), Toast.LENGTH_SHORT).show();
                String itemList = layoutName[position];
                Toast.makeText(MainActivity.this, "Clicked "+ itemList+" at Position: "+(position+1), Toast.LENGTH_SHORT).show();
                switch (itemList){
                    case "LinearLayoutV":
                        Intent intent = new Intent(MainActivity.this, LinearVActivity.class);
                        mGetContentFromIntent.launch(intent);
                        break;
                    case "LinearLayoutH":
                        Intent send = new Intent(MainActivity.this, LinearHActivity.class);
                        startActivity(send);
                        break;
                    case "RelativeLayout":
                        Intent mRelativeLayout = new Intent(MainActivity.this, RelativeActivity.class);
                        startActivity(mRelativeLayout);
                        break;
                    case "TableLayout":
                        Intent mTableLayout = new Intent(MainActivity.this, TableActivity.class);
                        startActivity(mTableLayout);
                        break;
                    case "FrameLayout":
                        Intent mFrameLayout = new Intent(MainActivity.this, FrameActivity.class);
                        startActivity(mFrameLayout);
                        break;
                    case "ScrollLayout":
                        Intent mScrollLayout = new Intent(MainActivity.this, ScrollActivity.class);
                        startActivity(mScrollLayout);
                        break;
                    case "GridLayout":
                        Intent mGridLayout = new Intent(MainActivity.this, GridActivity.class);
                        startActivity(mGridLayout);
                        break;
                }
            }
        });

        mGetContentFromIntent = registerForActivityResult(
                new ActivityResultContracts.StartActivityForResult(),
                new ActivityResultCallback<ActivityResult>() {
                    @Override
                    public void onActivityResult(ActivityResult result) {
                        if (result.getResultCode() == Activity.RESULT_OK) {
                            Intent data = result.getData();
                            // Lưu ý: data có thể là null, nên cần kiểm tra
                            if (data != null && data.getExtras() != null) {
                                Bundle bundle = data.getExtras();
                                String index1 = bundle.getString("YourName");
                                Toast.makeText(MainActivity.this, "Your Name is "+ index1, Toast.LENGTH_SHORT).show();
                            }
                        }
                    }
                });
    }

    public static class View_An_Item
    {
        public ImageView imageview;
        public TextView textview;
    }
    public class myadapter extends BaseAdapter
    {
        Context context;
        public myadapter(Context c)
        {
            context=c;
        }
        public int getCount() {
            // TODO Auto-generated method stub
            return layoutIcon.length;
        }
        public Object getItem(int position) {
            // TODO Auto-generated method stub
            return layoutIcon[position];
        }
        public long getItemId(int arg0) {
            // TODO Auto-generated method stub
            return 0;
        }
        public View getView(int arg0, View arg1, ViewGroup arg2) {
            // TODO Auto-generated method stub
            View_An_Item an_item;
            LayoutInflater layoutinflater= ((Activity)context).getLayoutInflater();
            if(arg1==null)
            {
                an_item = new View_An_Item();
                arg1 = layoutinflater.inflate(R.layout.list_item_icon, null);
                an_item.textview = (TextView) arg1.findViewById(R.id.textView1);
                an_item.imageview = (ImageView)arg1.findViewById(R.id.imageView1);
                arg1.setTag(an_item);
            }
            else
                an_item =(View_An_Item)arg1.getTag();
            an_item.imageview.setImageResource(layoutIcon[arg0]);
            an_item.textview.setText(layoutName[arg0]);
            return arg1;
        }
    }

}