package nd.no.xww.musiclistasneteasy;

import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;

import java.util.List;

/**
 * @author xww
 * @desciption :
 * @date 2020/1/23
 * @time 17:02
 */
public class MusicAdapter2 extends BaseQuickAdapter<Music, BaseViewHolder> {


    public MusicAdapter2(int layoutResId, @Nullable List<Music> data) {
        super(layoutResId, data);
    }

    @Override
    protected void convert(BaseViewHolder helper, Music item) {
        helper.setText(R.id.tv_music_id, String.valueOf(item.getId()));
        helper.setText(R.id.tv_music_title, String.valueOf(item.getTitle()));
        helper.setText(R.id.tv_music_author, String.valueOf(item.getAuthor()));
    }

}
