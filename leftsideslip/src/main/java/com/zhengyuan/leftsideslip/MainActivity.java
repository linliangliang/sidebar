package com.zhengyuan.leftsideslip;

import android.graphics.Color;
import android.os.Build;
import android.os.Bundle;
import android.support.v4.widget.SlidingPaneLayout;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;

import com.zhengyuan.leftsideslip.R;
import com.zhengyuan.leftsideslip.fragment.LeftFragment;
import com.zhengyuan.leftsideslip.fragment.RightFragment;

public class MainActivity extends AppCompatActivity implements LeftFragment.setWebsite {
    SlidingPaneLayout spl;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        //沉浸式状态栏
        //4.4以上设置状态栏为透明
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.KITKAT) {
            getWindow().addFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS);
        }
        // 5.0以上系统状态栏透明，
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
            Window window = getWindow();
            window.clearFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS);
            window.getDecorView().setSystemUiVisibility(View.SYSTEM_UI_FLAG_LAYOUT_FULLSCREEN
                    | View.SYSTEM_UI_FLAG_LAYOUT_STABLE);
            window.addFlags(WindowManager.LayoutParams.FLAG_DRAWS_SYSTEM_BAR_BACKGROUNDS);
            //window.setStatusBarColor(Color.TRANSPARENT);//设置状态栏颜色和主布局背景颜色相同
            window.setStatusBarColor(Color.parseColor("#03A9F4"));//设置状态栏为指定颜色
        }
        super.onCreate(savedInstanceState);
        Log.i("test==","setContentView1");
        setContentView(R.layout.activity_main);
        Log.i("test==","setContentView2");
        init();
    }

    private void init() {
        spl = (SlidingPaneLayout) findViewById(R.id.spl);
        spl.closePane();
        changeWebsite("http://www.baidu.com");//设置初始的webview界面为baidu
    }

    //重写方法设置webview显示界面
    @Override
    public void changeWebsite(String url) {
        RightFragment rf = (RightFragment) MainActivity.this.getSupportFragmentManager().findFragmentById(R.id.fragment_right);
        WebView webView = rf.getView();
        WebSettings settings = webView.getSettings();
        settings.setJavaScriptEnabled(true);
        WebViewClient client = new WebViewClient();
        webView.setWebViewClient(client);
        webView.loadUrl(url);
    }
}
