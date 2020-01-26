package nd.no.xww.musiclistasneteasy;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.widget.NestedScrollView;
import android.util.AttributeSet;

/**
 * @author xww
 * @desciption :
 * @date 2020/1/25
 * @time 12:40
 */
public class MusicNestedScrollView extends NestedScrollView {

    private onMusicScrollChangedListener onMusicScrollChangedListener;

    public void setOnMusicScrollChangedListener(onMusicScrollChangedListener onMusicScrollChangedListener) {
        this.onMusicScrollChangedListener = onMusicScrollChangedListener;
    }

    public MusicNestedScrollView(@NonNull Context context) {
        super(context);
    }

    public MusicNestedScrollView(@NonNull Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
    }

    public MusicNestedScrollView(@NonNull Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    @Override
    protected void onScrollChanged(int l, int t, int oldl, int oldt) {
        super.onScrollChanged(l, t, oldl, oldt);
        if (onMusicScrollChangedListener != null) {
            onMusicScrollChangedListener.onScrollChanged(l, t, oldl, oldt);
        }
    }
}
