# PageFlowView
An automatic paging custom view for android，Android上自定义一个自动分页的FlowLayout

参考了FlowLayout，实现一个可自动分页的FlowLayout

### 效果图

![](http://ohg2vhg1g.bkt.clouddn.com/image/gif/page_flow_view.gif)

### 使用方法

1. 布局文件进入PageFlowView，注意：
- 指定初始宽度、高度，添加子View时候会动态计算高度，当超出初始高度时自动分页；
```
<com.goven.pageflow.PageFlowView
        android:id="@+id/pageview"
        android:layout_width="300dp"
        android:layout_height="300dp"/>
```

- 也可以指定子View的最大行数，当超出最大行数时自动分页；
- 也可以指定最大分页数，当超出最大分页数，不再添加分页。
```
<com.goven.pageflow.PageFlowView
        android:id="@+id/pageview"
        android:layout_width="300dp"
        android:layout_height="wrap_content"
        app:maxRows="3"
        app:maxPages="5"/>
```
2. 自定义TagStyle
```
int margin = DensityUtil.dip2px(this, 4);
PageScrollView.TagStyle tagStyle = PageScrollView.TagStyle.build()
    .backgroundResId(R.drawable.flag_01)
    .textColor(Color.WHITE).textSize(margin * 4)
    .padding(3 * margin, (int)(1.2f * margin), 3 * margin, (int)(1.2f * margin))
    .margin(2 * margin);
```
3. 填充数据
```
// 批量添加
pageview.setData(new String[]{"自动化", "探索", "测试", "遍历", "基本的界面",
    "了解", "主要界面的", "可用性", "比如", "兼容性", "基本功能", "利用", "遍历获取", "app加载时间", "性能数据"}, tagStyle);

// 单条添加
pageview.addTag(PageFlowView.SCROLL_TO_END, "增加一个标签", tagStyle);
```
4. 删除数据
```
// 批量删除
pageview.removeAllTagView();

// 单条删除
pageview.removeTagViewAt(pageview.getTagCount() - 1);
```
