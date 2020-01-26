package nd.no.xww.musiclistasneteasy;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.List;

/**
 * @author xww
 * @desciption :
 * @date 2020/1/23
 * @time 17:02
 */
public class MusicAdapter extends RecyclerView.Adapter<MusicAdapter.ViewHolder> {

    List<Music> musicData;

    public MusicAdapter(List<Music> musicData) {
        this.musicData = musicData;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.music_item, viewGroup, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int i) {
        holder.tvId.setText(String.valueOf(musicData.get(i).getId()));
        holder.tvTitle.setText(musicData.get(i).getTitle());
        holder.tvAuthor.setText(musicData.get(i).getAuthor());
    }

    @Override
    public int getItemCount() {
        return musicData.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {

        TextView tvId;
        TextView tvTitle;
        TextView tvAuthor;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);

            tvId = itemView.findViewById(R.id.tv_music_id);
            tvTitle = itemView.findViewById(R.id.tv_music_title);
            tvAuthor = itemView.findViewById(R.id.tv_music_author);
        }
    }
}
