package tw.tcnr08.m0708;


import android.app.ListActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.SimpleAdapter;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import tw.tcnr08.m0704.R;


public class M0708 extends ListActivity {

    private TextView mTxtResult;
    //    private TextView mTxtResult02;
    private String[] listFromResource;
    private String[] listFromResource02;
    private ArrayList<Map<String, Object>> mList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.m0708);
        setupviewcomponent();
    }

    private void setupviewcomponent() {
        mTxtResult = (TextView) findViewById(R.id.m0708_t001);
//        mTxtResult02 = (TextView) findViewById(R.id.m0708_t002);
        listFromResource = getResources().getStringArray(R.array.week);
        listFromResource02 = getResources().getStringArray(R.array.weekday02);
//--------------------------------------------------------------------------
        mList=new ArrayList<Map<String,Object>>();
//--------------------------------------------------------------------------
        for(int i=0;i<listFromResource.length;i++){
            Map<String,Object> item=new HashMap<String,Object>();

            String idName="img"+String.format("%02d"+"th",i+1);

            int  resID=getResources().getIdentifier(idName,"drawable",getPackageName());

            item.put("imgView", resID);
//    item.put("imgView", R.drawable.img01th);

            item.put("txtView02", listFromResource02[i]);

            item.put("txtView01", listFromResource[i]);


            mList.add(item);
        }

//資料超過1筆以上，要做Adapter，此作SimpleAdapter
        SimpleAdapter adapter=new SimpleAdapter(this,
                mList,
                R.layout.list_new,
                new String[]{"imgView","txtView01","txtView02"},
                new int[]{R.id.imgView2,R.id.textView,R.id.textView2});

        setListAdapter(adapter);
//----------------------------------------------------------------------------------------------------------

        ListView listview = getListView();
        listview.setTextFilterEnabled(true);
        listview.setOnItemClickListener(listviewOnItemClkLis);


    }
    AdapterView.OnItemClickListener listviewOnItemClkLis = new AdapterView.OnItemClickListener() {
        public void onItemClick(AdapterView<?> parent, View view,int position, long id) {


         mTxtResult.setText("你選擇:"+listFromResource[position] +"   " +listFromResource02[position]);

//            mTxtResult.s
        }
    };

}
