package com.zhengyuan.leftsideslip.fragment;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.WebView;

import com.zhengyuan.leftsideslip.R;


/**
 * Created by 林亮 on 2018/11/22
 */
public class RightFragment extends Fragment {
    private WebView wv;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        Log.i("test==", "RightFragment onCreateView");
        View root = inflater.inflate(R.layout.rightlayout, null);
        init(root);
        return root;
    }

    private void init(View root) {
        wv = (WebView) root.findViewById(R.id.wv);
    }

    public WebView getView() {//返回rightfragment的webview
        return wv;
    }
}
