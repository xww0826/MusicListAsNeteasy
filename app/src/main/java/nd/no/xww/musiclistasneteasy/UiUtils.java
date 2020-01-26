package nd.no.xww.musiclistasneteasy;

import android.view.View;
import android.view.ViewGroup;

/**
 * @author xww
 * @desciption :
 * @date 2020/1/23
 * @time 14:18
 */
public class UiUtils {

    public static void setSize(View view, int width, int height) {
        ViewGroup.LayoutParams params = view.getLayoutParams();
        if (width > 0 && height > 0) {
            params.width = (int) (width * ScreenUtils.getInstance(view.getContext()).getScaleWidth());
            params.height = (int) (height * ScreenUtils.getInstance(view.getContext()).getScaleHeight());
        } else if (width == 0) {
            params.height = (int) (height * ScreenUtils.getInstance(view.getContext()).getScaleHeight());
        } else if (height == 0) {
            params.width = (int) (width * ScreenUtils.getInstance(view.getContext()).getScaleWidth());
        }
        view.setLayoutParams(params);
    }

    public static void setMargin(View view, int left, int top, int right, int bottom) {
        ViewGroup.MarginLayoutParams params = (ViewGroup.MarginLayoutParams) view.getLayoutParams();
        if (left > 0 && top > 0 && right > 0 && bottom > 0) {
            params.leftMargin = (int) (left * ScreenUtils.getInstance(view.getContext()).getScaleWidth());
            params.topMargin = (int) (top * ScreenUtils.getInstance(view.getContext()).getScaleHeight());
            params.rightMargin = (int) (right * ScreenUtils.getInstance(view.getContext()).getScaleHeight());
            params.bottomMargin = (int) (bottom * ScreenUtils.getInstance(view.getContext()).getScaleHeight());
        }
        view.setLayoutParams(params);
    }

    public static void setMarginLeft(View view, int left) {
        ViewGroup.MarginLayoutParams params = (ViewGroup.MarginLayoutParams) view.getLayoutParams();
        if (left > 0) {
            params.leftMargin = (int) (left * ScreenUtils.getInstance(view.getContext()).getScaleWidth());
        }
        view.setLayoutParams(params);
    }

    public static void setMarginTop(View view, int top) {
        ViewGroup.MarginLayoutParams params = (ViewGroup.MarginLayoutParams) view.getLayoutParams();
        if (top > 0) {
            params.topMargin = (int) (top * ScreenUtils.getInstance(view.getContext()).getScaleWidth());
        }
        view.setLayoutParams(params);
    }

    public static void setMarginRight(View view, int right) {
        ViewGroup.MarginLayoutParams params = (ViewGroup.MarginLayoutParams) view.getLayoutParams();
        if (right > 0) {
            params.rightMargin = (int) (right * ScreenUtils.getInstance(view.getContext()).getScaleWidth());
        }
        view.setLayoutParams(params);
    }

    public static void setMarginBottom(View view, int bottom) {
        ViewGroup.MarginLayoutParams params = (ViewGroup.MarginLayoutParams) view.getLayoutParams();
        if (bottom > 0) {
            params.bottomMargin = (int) (bottom * ScreenUtils.getInstance(view.getContext()).getScaleWidth());
        }
        view.setLayoutParams(params);
    }
}
