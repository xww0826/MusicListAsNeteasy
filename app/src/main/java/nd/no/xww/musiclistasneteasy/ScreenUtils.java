package nd.no.xww.musiclistasneteasy;

import android.content.Context;
import android.content.res.Resources;
import android.util.DisplayMetrics;
import android.util.TypedValue;
import android.view.WindowManager;

/**
 * @author xww
 * @desciption :
 * @date 2020/1/23
 * @time 14:17
 */
public class ScreenUtils {
    private static ScreenUtils INSTANCE;
    private Context context;

    // design pixels on a prototype diagram（must float）
    private static final float DESIGN_WIDTH = 1080f;
    private static final float DESIGN_HEIGHT = 1920f;

    private int screenWidth;
    private int screenHeight;

    private ScreenUtils(Context context) {
        this.context = context;

        final WindowManager windowManager = (WindowManager) context.getSystemService(Context.WINDOW_SERVICE);
        if (windowManager != null) {
            DisplayMetrics displayMetrics = new DisplayMetrics();
            windowManager.getDefaultDisplay().getRealMetrics(displayMetrics);

            if (displayMetrics.widthPixels > displayMetrics.heightPixels) {
                screenWidth = displayMetrics.heightPixels;
                screenHeight = displayMetrics.widthPixels;
            } else {
                screenWidth = displayMetrics.widthPixels;
                screenHeight = displayMetrics.heightPixels;
            }
        }
    }

    public static ScreenUtils getInstance(Context context) {
        if (INSTANCE == null) {
            INSTANCE = new ScreenUtils(context.getApplicationContext());
        }
        return INSTANCE;
    }

    private int getStatusBarHeight() {
        Resources resources = context.getResources();
        if (resources != null) {
            int resId = resources.getIdentifier("status_bar_height", "dimen", "android");
            return resources.getDimensionPixelSize(resId);
        }
        return 0;
    }

    public int getScreenWidth() {
        return screenWidth;
    }

    public int getScreenHeight() {
        return screenHeight;
    }

    public float getScaleWidth() {
        return getScreenWidth() / DESIGN_WIDTH;
    }

    public float getScaleHeight() {
        return getScreenHeight() / DESIGN_HEIGHT;
    }


    public static int dp2px(Context context, int dp) {
        return (int) TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP, dp, context.getResources().getDisplayMetrics());
    }

    public static int sp2px(Context context, int sp) {
        return (int) TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_SP, sp, context.getResources().getDisplayMetrics());
    }
}
