package com.example.QuangTin.HW6;

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
                        IcareMapClick(v);
                    } else {
                        IcareWebClick(v);
                    }
                } else if (groupPosition == 2) {
                    if (childPosition == 0) {
                        TriMapClick(v);
                    } else {
                        TriWebClick(v);
                    }
                } else {
                    if (childPosition == 0) {
                        AltaMapClick(v);
                    } else {
                        AltaWebClick(v);
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
        listDataHeader.add("Icare Tân Bình");
        listDataHeader.add("Pyramid Software & Consulting");
        listDataHeader.add("AltaMedia Co LTD");

        List<String> sgu = new ArrayList<String>();
        sgu.add("Map It");
        sgu.add("More Info");

        List<String> Icare = new ArrayList<String>();
        Icare.add("Map It");
        Icare.add("More Info");

        List<String> Tri = new ArrayList<String>();
        Tri.add("Map It");
        Tri.add("More Info");

        List<String> Alta = new ArrayList<String>();
        Alta.add("Map It");
        Alta.add("More Info");

        listDataChild.put(listDataHeader.get(0), sgu);
        listDataChild.put(listDataHeader.get(1), Alta);
        listDataChild.put(listDataHeader.get(2), Tri);
        listDataChild.put(listDataHeader.get(3), Icare);
    }

    public void sguMapClick(View view) {
        openWebView("https://www.google.com/maps/place/%C4%90%E1%BA%A1i+h%E1%BB%8Dc+S%C3%A0i+G%C3%B2n/@10.759798,106.6801638,17z/data=!3m1!4b1!4m5!3m4!1s0x31752f1b7c3ed289:0xa06651894598e488!8m2!3d10.759798!4d106.6823525");
    }

    public void sguWebClick(View view) {
        openBrowser("http://www.sgu.edu.vn/");
    }

    public void AltaMapClick(View view) {
        openWebView("https://www.google.com/maps/place/Alta+Media+Company/@10.773088,106.6490493,17z/data=!3m1!4b1!4m5!3m4!1s0x31752ebf74a8eb17:0xb6a89fd703b233df!8m2!3d10.773088!4d106.651238");
    }

    public void AltaWebClick(View view) {
        openBrowser("http://www.altamedia.vn/");
    }

    public void IcareMapClick(View view) {
        openWebView("https://www.google.com/maps/place/iCare+Center/@10.799819,106.6579203,17z/data=!3m1!4b1!4m5!3m4!1s0x31752930e0a5be19:0x56756880cac84070!8m2!3d10.799819!4d106.660109");
    }

    public void IcareWebClick(View view) {
        openBrowser("http://www.icare.center/");
    }

    public void TriMapClick(View view) {
        openWebView("https://www.google.com/maps/place/Pyramid+Software+%26+Consulting/@10.797537,106.6912369,15z/data=!4m5!3m4!1s0x0:0xfa26e56900423d76!8m2!3d10.797537!4d106.6912369");
    }

    public void TriWebClick(View view) {
        openBrowser("http://psctelecom.com.vn/");
    }

    private void openWebView(String url) {
        closeBtn.setVisibility(View.VISIBLE);
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
        closeBtn.setVisibility(View.INVISIBLE);
    }
}
