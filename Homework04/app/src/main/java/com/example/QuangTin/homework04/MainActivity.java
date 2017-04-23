package com.example.QuangTin.homework04;

import android.content.Intent;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.Button;
import android.widget.ExpandableListView;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;


public class MainActivity extends AppCompatActivity {

    ExpandableListAdapter listAdapter;
    ExpandableListView expListView;
    List<String> listDataHeader;
    HashMap<String, List<String>> listDataChild;
    WebView webView;
    Button closeBtn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        webView = (WebView) findViewById(R.id.webView);
        closeBtn = (Button) findViewById(R.id.closeBtn);

        expListView = (ExpandableListView) findViewById(R.id.listViewMain);

        prepareListData();

        listAdapter = new ExpandableListAdapter(this, listDataHeader, listDataChild);

        expListView.setAdapter(listAdapter);

        expListView.setOnChildClickListener(new ExpandableListView.OnChildClickListener() {

            @Override
            public boolean onChildClick(ExpandableListView parent, View v, int groupPosition, int childPosition, long id) {
                // TODO Auto-generated method stub
                if (groupPosition == 0) {
                    if (childPosition == 0) {
                        sguMapClick(v);
                    } else {
                        sguWebClick(v);
                    }
                } else if (groupPosition == 1) {
                    if (childPosition == 0) {
                        nwMapClick(v);
                    } else {
                        nwWebClick(v);
                    }
                } else if (groupPosition == 2) {
                    if (childPosition == 0) {
                        libMapClick(v);
                    } else {
                        libWebClick(v);
                    }
                } else {
                    if (childPosition == 0) {
                        aeonMapClick(v);
                    } else {
                        aeonWebClick(v);
                    }
                }
                return false;
            }
        });
    }

    private void prepareListData() {
        listDataHeader = new ArrayList<String>();
        listDataChild = new HashMap<String, List<String>>();

        listDataHeader.add("Đại học Sài Gòn");
        listDataHeader.add("Nhà Tín");
        listDataHeader.add("Thư viện trung tâm ĐHQG");
        listDataHeader.add("AEON Bình Tân");

        List<String> sgu = new ArrayList<String>();
        sgu.add("Xem bản đồ");
        sgu.add("Truy cập website");

        List<String> ctyTin = new ArrayList<String>();
        ctyTin.add("Map It");
        ctyTin.add("More Infor");

        List<String> lib = new ArrayList<String>();
        lib.add("Xem bản đồ");
        lib.add("Truy cập website");

        List<String> aeon = new ArrayList<String>();
        aeon.add("Xem bản đồ");
        aeon.add("Truy cập website");

        listDataChild.put(listDataHeader.get(0), sgu);
        listDataChild.put(listDataHeader.get(1), ctyTin);
        listDataChild.put(listDataHeader.get(2), lib);
        listDataChild.put(listDataHeader.get(3), aeon);
    }

    public void sguMapClick(View view) {
        openWebView("https://www.google.com/maps/place/%C4%90%E1%BA%A1i+h%E1%BB%8Dc+S%C3%A0i+G%C3%B2n/@10.759798,106.6801638,17z/data=!3m1!4b1!4m5!3m4!1s0x31752f1b7c3ed289:0xa06651894598e488!8m2!3d10.759798!4d106.6823525");
    }

    public void sguWebClick(View view) {
        openBrowser("http://www.sgu.edu.vn/");
    }

    public void aeonMapClick(View view) {
        openWebView("https://www.google.com/maps/place/CGV-Aeon+Mall+B%C3%ACnh+T%C3%A2n/@10.743435,106.6101133,17z/data=!3m1!4b1!4m5!3m4!1s0x31752dcec1b9cb21:0xc76983f1bcfd1227!8m2!3d10.743435!4d106.612302");
    }

    public void aeonWebClick(View view) {
        openBrowser("http://aeon.com.vn/");
    }

    public void nwMapClick(View view) {
        openWebView("https://www.google.com/maps/place/Alta+Media+Company/@10.7730933,106.6490493,17z/data=!3m1!4b1!4m5!3m4!1s0x31752ebf74a8eb17:0xb6a89fd703b233df!8m2!3d10.773088!4d106.651238");
    }

    public void nwWebClick(View view) {
        openBrowser("http://www.altamedia.vn/");
    }

    public void libMapClick(View view) {
        openWebView("https://www.google.com/maps/place/Th%C6%B0+vi%E1%BB%87n+Trung+t%C3%A2m+%C4%90HQG+-+HCM/@10.8698184,106.7960072,15z/data=!4m5!3m4!1s0x0:0xf2f6dc77057ba1df!8m2!3d10.8698184!4d106.7960072");
    }

    public void libWebClick(View view) {
        openBrowser("http://www.vnulib.edu.vn/#1");
    }

    private void openWebView(String url) {
        webView.setVisibility(View.VISIBLE);
        webView.setWebViewClient(new WebViewClient());
        webView.getSettings().setJavaScriptEnabled(true);
        webView.loadUrl(url);
    }

    private void openBrowser(String url) {
        Uri uriUrl = Uri.parse(url);
        Intent launchBrowser = new Intent(Intent.ACTION_VIEW, uriUrl);
        startActivity(launchBrowser);
    }

    public void closeBrowser(View v) {
        webView.setVisibility(View.INVISIBLE);
    }
}
