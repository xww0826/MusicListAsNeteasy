package nd.no.xww.musiclistasneteasy;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.Context;
import android.content.res.Resources;
import android.graphics.Color;
import android.os.Build;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.view.WindowManager;

/**
 * @author xww
 * @desciption : 状态栏工具类
 * @date 2020/1/22
 * @time 19:21
 */
public class StatusBarUtils {

    /**
     * 获取状态栏高度
     */
    public static int getStatusBarHeight(Context context) {
        Resources resources = context.getResources();
        int identifier = resources.getIdentifier("status_bar_height", "dimen", "android");
        if (identifier > 0) {
            return resources.getDimensionPixelSize(identifier);
        }
        return 0;
    }

    /**
     * 获取导航栏高度
     */
    public static int getNavigationBarHeight(Context context) {
        Resources resources = context.getResources();
        int identifierNav = resources.getIdentifier("config_showNavigationBar", "bool", "android");
        if (identifierNav != 0) {
            int identifier = resources.getIdentifier("navigation_bar_height", "dimen", "android");
            return resources.getDimensionPixelSize(identifier);
        } else {
            return 0;
        }
    }

    /**
     * 设置状态栏颜色
     */
    public static void setStatusBarColor(Activity activity, int colorId) {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
            Window window = activity.getWindow();
            window.setStatusBarColor(colorId);
        }
//        else if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.KITKAT) {
//            //使用SystemBarTintManager,需要先将状态栏设置为透明
//            setTranslucentStatus(activity);
//            SystemBarTintManager systemBarTintManager = new SystemBarTintManager(activity);
//            systemBarTintManager.setStatusBarTintEnabled(true);//显示状态栏
//            systemBarTintManager.setStatusBarTintColor(colorId);//设置状态栏颜色
//        }
    }

    /**
     * 沉浸式 - 状态栏透明
     */
    @SuppressLint("ObsoleteSdkInt")
    public static void setTranslucent(Activity activity) {
        Window window = activity.getWindow();
        ViewGroup decorView = (ViewGroup) window.getDecorView();
        WindowManager.LayoutParams attributes = window.getAttributes();
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
            //两个 flag 要结合使用，表示让应用的主体内容占用系统状态栏的空间
            int option = View.SYSTEM_UI_FLAG_LAYOUT_FULLSCREEN | View.SYSTEM_UI_FLAG_LAYOUT_STABLE;
            decorView.setSystemUiVisibility(option);
            window.addFlags(WindowManager.LayoutParams.FLAG_DRAWS_SYSTEM_BAR_BACKGROUNDS);
            //设置状态栏透明颜色
            window.setStatusBarColor(Color.TRANSPARENT);
            //设置导航栏透明颜色
//            window.setNavigationBarColor(Color.TRANSPARENT);
        } else if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.KITKAT) {
            attributes.flags |= WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS;
        }
        //导航栏开启透明效果
//        attributes.flags |= WindowManager.LayoutParams.FLAG_TRANSLUCENT_NAVIGATION;
        window.setAttributes(attributes);

        // 将 occupyView 添加到状态栏上
        decorView.addView(getOccupyView(activity));
    }

    private static OccupyStatusView getOccupyView(Activity activity) {
        // 创建一个占位 View 并设置背景透明
        OccupyStatusView occupyView = new OccupyStatusView(activity);
        ViewGroup.LayoutParams params = new ViewGroup.LayoutParams(WindowManager.LayoutParams.MATCH_PARENT, getStatusBarHeight(activity));
        occupyView.setBackgroundColor(Color.TRANSPARENT);
        occupyView.setLayoutParams(params);
        return occupyView;
    }
}
