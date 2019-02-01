package android.itesm.edu.pokemon.RecycleViewAdapter;

import android.content.Context;
import android.content.Intent;
import android.itesm.edu.pokemon.PokeCard.PokeCard;
import android.itesm.edu.pokemon.PokeCardActivity;
import android.itesm.edu.pokemon.R;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.bumptech.glide.Glide;
import com.bumptech.glide.request.RequestOptions;

import java.util.List;

public class RecycleViewAdapter extends RecyclerView.Adapter<RecycleViewAdapter.MyViewHolder>{

    private Context mContext;
    private List<PokeCard> mData;
    RequestOptions option;

    public RecycleViewAdapter(Context mContext, List<PokeCard> mData){
        this.mContext=mContext;
        this.mData=mData;
         option = new RequestOptions().centerCrop().placeholder(R.drawable.load_card).error(R.drawable.load_card);
    }

    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType){
        View view;
        LayoutInflater inflater= LayoutInflater.from(mContext);
        view= inflater.inflate(R.layout.poke_card_item,parent,false);
        final MyViewHolder viewHolder= new MyViewHolder(view);
        viewHolder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                PokeCard pokeCard= mData.get(viewHolder.getAdapterPosition());
                Toast.makeText(mContext,pokeCard.getName(),Toast.LENGTH_SHORT).show();
                Intent intent=new Intent(mContext, PokeCardActivity.class);
                intent.putExtra("pokemon", pokeCard);
                mContext.startActivity(intent);
            }
        });

        return viewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder myViewHolder, int i) {
        myViewHolder.name.setText(mData.get(i).getName());
        myViewHolder.id.setText(mData.get(i).getId());
        myViewHolder.artist.setText(mData.get(i).getAuthor());

        Glide.with(mContext).load(mData.get(i).getImageUrl()).apply(option).into(myViewHolder.image);

    }

    @Override
    public int getItemCount() {
        return mData.size();
    }

    public class MyViewHolder extends RecyclerView.ViewHolder{
        TextView id, name, artist;
        ImageView image;

        public MyViewHolder(@NonNull View itemView) {
            super(itemView);
            id = itemView.findViewById(R.id.id_card);
            name = itemView.findViewById(R.id.card_name);
            artist = itemView.findViewById(R.id.author_card);
            image = itemView.findViewById(R.id.card);
        }

    }
}
