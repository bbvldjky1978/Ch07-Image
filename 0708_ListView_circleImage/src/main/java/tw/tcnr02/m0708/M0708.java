package tw.tcnr02.m0708;


import android.app.ListActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.SimpleAdapter;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;


public class M0708 extends ListActivity {

    private TextView mTxtResult;
    private String[] listFromResource;
    private String[] listFromResource02;
    private ArrayList<Map<String, Object>> mList;
    private TextView mTxtResult2;
    private CircleImgView img;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.m0708);
        setupviewcomponent();
    }

    private void setupviewcomponent() {

        img=(CircleImgView)findViewById(R.id.circleImgView);
        mTxtResult = (TextView) findViewById(R.id.m0708_t001);
        mTxtResult2 = (TextView) findViewById(R.id.m0708_t002);
        listFromResource = getResources().getStringArray(R.array.teacname);     //陣列一來源
        listFromResource02 = getResources().getStringArray(R.array.descr);   //陣列二來源
//--------------------------------------------------------------------------
        mList=new ArrayList<Map<String,Object>>();
//--------------------------------------------------------------------------
        for(int i=0;i<listFromResource.length;i++){
            Map<String,Object> item=new HashMap<String,Object>();


            //圖片用for迴圈做變化
            String idName="t"+String.format("%03d",i+1);
            int  resID=getResources().getIdentifier(idName,"drawable",getPackageName());  //  圖片來源需三個參數 id,源資料夾,源Package
            item.put("circleImgView", resID);
//    item.put("imgView", R.drawable.img01th);
            item.put("txtView", listFromResource[i]);                 //陣列一設在第一文字框
            item.put("textView2", listFromResource02[i]);        //陣列二設在第二文字框
            mList.add(item);
        }

//資料超過1筆以上，要做Adapter，此作SimpleAdapter
        SimpleAdapter adapter=new SimpleAdapter(this,
                mList,
                R.layout.list_item,
                new String[]{"circleImgView","txtView"},
                new int[]{R.id.circleImgView,R.id.txtView});
                setListAdapter(adapter);
//----------------------------------------------------------------------------------------------------------

        ListView listview = getListView();
        listview.setTextFilterEnabled(true);
        listview.setOnItemClickListener(listviewOnItemClkLis);


    }





    AdapterView.OnItemClickListener listviewOnItemClkLis = new AdapterView.OnItemClickListener() {
        public void onItemClick(AdapterView<?> parent, View view,
                                int position, long id) {
            mTxtResult.setText("講師:"+listFromResource[position] );
            mTxtResult2.setText("學位:" +listFromResource02[position]);
        }
    };

}