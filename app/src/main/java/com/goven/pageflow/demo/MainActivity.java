package com.goven.pageflow.demo;

import android.app.Activity;
import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import com.goven.pageflow.PageFlowView;
import com.goven.pageflow.PageScrollView;
import com.goven.pageflow.R;

public class MainActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        final PageFlowView pageview = (PageFlowView) findViewById(R.id.pageview);

        int margin = DensityUtil.dip2px(this, 4);
        final PageScrollView.TagStyle tagStyle = PageScrollView.TagStyle.build()
                .backgroundResId(R.drawable.flag_01)
                .textColor(Color.WHITE).textSize(margin * 4)
                .padding(3 * margin, (int)(1.2f * margin), 3 * margin, (int)(1.2f * margin))
                .margin(2 * margin);
        pageview.setData(new String[]{"自动化", "探索", "测试", "遍历", "基本的界面",
                "了解", "主要界面的", "可用性", "比如", "兼容性", "基本功能", "利用", "遍历获取", "app加载时间", "性能数据"}, tagStyle);
        findViewById(R.id.button).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                pageview.addTag(PageFlowView.SCROLL_TO_END, "增加一个标签", tagStyle);
            }
        });
        findViewById(R.id.button1).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                pageview.setData(new String[]{"自动化", "探索", "测试", "遍历", "基本的界面",
                        "了解", "主要界面的", "可用性", "比如", "兼容性", "基本功能", "利用", "遍历获取", "app加载时间", "性能数据"}, tagStyle);
            }
        });
        findViewById(R.id.button2).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (pageview.getTagCount() > 0) {
                    pageview.removeTagViewAt(pageview.getTagCount() - 1);
                }
            }
        });
        pageview.setOnTagClickListener(new PageScrollView.OnTagClickListener() {
            @Override
            public void onClick(View view, Object obj) {
                String text = (String) obj;
                Toast.makeText(getBaseContext(), text, Toast.LENGTH_SHORT).show();
            }
        });
    }

}
