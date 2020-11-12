package com.android.custom.editadapter;

import android.app.Activity;
import android.graphics.Rect;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewTreeObserver;
import android.widget.EditText;
import android.widget.RelativeLayout;

/**
 * @ProjectName: Potential_Safety
 * @Package: com.gzinfo.wisdomsafe.util
 * @ClassName: EditUtil
 * @Author: 1984629668@qq.com
 * @CreateDate: 2020/11/12 9:48
 */
public class EditUtil {
    public static void changeViewHeight(final Activity activity, final EditText editText, final ViewGroup viewGroup) {
        final RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) viewGroup.getLayoutParams();
        final int height = layoutParams.height;
        editText.setOnFocusChangeListener(new View.OnFocusChangeListener() {
            @Override
            public void onFocusChange(View v, boolean hasFocus) {
                if (hasFocus) {
                    //当键盘弹出隐藏的时候会调用此方法。
                    editText.getViewTreeObserver().addOnGlobalLayoutListener(new ViewTreeObserver.OnGlobalLayoutListener() {
                        @Override
                        public void onGlobalLayout() {
                            Rect r = new Rect();
                            //获取当前界面可视部分
                            activity.getWindow().getDecorView().getWindowVisibleDisplayFrame(r);
                            //获取屏幕的高度
                            int screenHeight = activity.getWindow().getDecorView().getRootView().getHeight();
                            //此处就是用来获取键盘的高度的， 在键盘没有弹出的时候 此高度为0 键盘弹出的时候为一个正数
                            int heightDifference = screenHeight - r.bottom;
                            Log.e("height", heightDifference + "");
                            if (heightDifference > 0) {
                                if (heightDifference > height) {
                                    layoutParams.height = heightDifference + 30;
                                    viewGroup.setLayoutParams(layoutParams);
                                } else {
                                    layoutParams.height = height;
                                    viewGroup.setLayoutParams(layoutParams);
                                }
                            }
                        }
                    });
                }
            }
        });
    }
}
