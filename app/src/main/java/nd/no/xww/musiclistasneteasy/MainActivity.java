package nd.no.xww.musiclistasneteasy;

import android.annotation.SuppressLint;
import android.graphics.Color;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.load.DataSource;
import com.bumptech.glide.load.engine.GlideException;
import com.bumptech.glide.request.RequestListener;
import com.bumptech.glide.request.RequestOptions;
import com.bumptech.glide.request.target.Target;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import jp.wasabeef.glide.transformations.BlurTransformation;

public class MainActivity extends AppCompatActivity {

    private final String artist_image = "https://timgsa.baidu.com/timg?image&quality=80&size=b9999_10000&sec=1579779066051&di=36e5b38a5ff3fd4d7d0c496b5805249a&imgtype=0&src=http%3A%2F%2Fb-ssl.duitang.com%2Fuploads%2Fitem%2F201706%2F21%2F20170621093321_TwKGh.jpeg";

    private static final String TAG = "MainActivity";

    private Toolbar toolbar;
    private ImageView iv_bg;
    private ImageView iv_bg_fixed;
    private ImageView iv_artist_image;
    private MusicNestedScrollView nested_view;
    private RecyclerView rv_music;
    private FrameLayout head_content;
    private final int scrollMaxHeight = 300; // 48dp
    private int px = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        StatusBarUtils.setTranslucent(this);
        initView();
        px = ScreenUtils.dp2px(this, scrollMaxHeight);
    }

    private void initView() {
        iv_bg = (ImageView) findViewById(R.id.iv_bg);
        iv_bg_fixed = (ImageView) findViewById(R.id.iv_bg_fixed);
        iv_artist_image = (ImageView) findViewById(R.id.iv_artist_image);
        nested_view = (MusicNestedScrollView) findViewById(R.id.nested_view);
//        head_content = (FrameLayout) findViewById(R.id.head_content);
        rv_music = (RecyclerView) findViewById(R.id.rv_music);
        toolbar = (Toolbar) findViewById(R.id.toolbar);
        toolbar.setTitle("歌单");
        toolbar.setNavigationIcon(R.drawable.ic_arrow_back_black_24dp);
        setSupportActionBar(toolbar);

        ViewGroup.MarginLayoutParams params = (ViewGroup.MarginLayoutParams) toolbar.getLayoutParams();
        params.setMargins(0, StatusBarUtils.getStatusBarHeight(this), 0, 0);

        Glide.with(this)
                .load(artist_image)
                .into(iv_artist_image);

        Glide.with(this)
                .load(artist_image)
                .apply(RequestOptions.bitmapTransform(new BlurTransformation(50, 20)))
                .into(iv_bg_fixed);

        Glide.with(this)
                .load(artist_image)
                .apply(RequestOptions.bitmapTransform(new BlurTransformation(100, 30)))
                .into(iv_bg);

        initMusicData();

        nested_view.setOnMusicScrollChangedListener((scrollX, scrollY, oldScrollX, oldScrollY) -> onScrollAction(scrollY));

    }

    private void initMusicData() {
        List<Music> musicData = new ArrayList<>();
        final String[] musicName = new String[]{"What is love", "海阔天空", "Opera", "怨苍天变了心", "慢慢", "红玫瑰", "爱殇", "Somebody that i used to know"};
        final String[] musicAuthor = new String[]{"Haddaway", "Beyond", "Vitas", "谭晶", "张学友", "陈奕迅", "小时姑娘", "Gotye"};

        Random random = new Random();
        for (int i = 1; i <= 50; i++) {
            int r = random.nextInt(8);
            Music music = new Music(i, musicName[r], musicAuthor[r]);
            musicData.add(music);
        }
        rv_music.setLayoutManager(new LinearLayoutManager(this));
        rv_music.setNestedScrollingEnabled(false);
        rv_music.setHasFixedSize(false);
        MusicAdapter2 adapter2 = new MusicAdapter2(R.layout.music_item, musicData);
        View header = LayoutInflater.from(this).inflate(R.layout.header_view_item, rv_music,false);
        adapter2.addHeaderView(header);
        rv_music.setAdapter(adapter2);
    }


    @SuppressLint("Range")
    private void onScrollAction(int scrollY) {
        Drawable drawable = iv_bg.getDrawable();
        if (drawable == null) {
            return;
        }

        float alpha = scrollY * 1.0f / px;
        if (scrollY > px) {
            drawable.mutate().setAlpha(255);
        } else {
            drawable.mutate().setAlpha((int) (alpha * 255));
        }
        iv_bg.setImageDrawable(drawable);


//        Log.i(TAG, "scrollY: " + scrollY);
//        Log.i(TAG, "alpha: " + alpha);
//        Log.i(TAG, "px: " + px);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.toolbar_menu, menu);
        return true;
    }
}
