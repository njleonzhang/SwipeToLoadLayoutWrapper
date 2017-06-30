# SwipeToLoadLayoutWrapper
[SwipeToLoadLayout](https://github.com/Aspsine/SwipeToLoadLayout)的封装，便于使用。

# 默认的view
 ```
 private SwipeToLoadLayoutWrapper mWrapper;


 // 同时设置head和footer:
 // TYPE_GOOGLE
 // TYPE_GOOGLE_CIRCLE
 swipeWrapper.setHeadAndFoot(SwipeToLoadLayoutWrapper.TYPE_GOOGLE);
 
 // 分别设置head和footer:
 mWrapper.setHeaderView(SwipeToLoadLayoutWrapper.TYPE_GOOGLE).setFooterView(SwipeToLoadLayoutWrapper.TYPE_GOOGLE_CIRCLE);

 // 设置自定义heade或者footer:
  View footerView = new LoadMoreFooterView(mActivity);
  footerView.setLayoutParams(new LinearLayout.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.WRAP_CONTENT));
  swipeWrapper.setFooterView(footerView);
```

关于如何自定义head和footer，参见[SwipeToLoadLayout](https://github.com/Aspsine/SwipeToLoadLayout)文档。
