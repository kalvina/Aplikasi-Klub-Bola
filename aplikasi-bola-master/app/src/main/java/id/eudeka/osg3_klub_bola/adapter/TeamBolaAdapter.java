package id.eudeka.osg3_klub_bola.adapter;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.educa62.osg3_klub_bola.R;

import id.eudeka.osg3_klub_bola.model.TeamDetail;
import id.eudeka.osg3_klub_bola.view.DetailActivity;
import id.eudeka.osg3_klub_bola.view.MainActivity;

import com.squareup.picasso.Picasso;

import java.util.List;

public class TeamBolaAdapter extends RecyclerView.Adapter<TeamBolaAdapter.TeamBolaHolder> {

    private List<TeamDetail> listKlubBola;

    public TeamBolaAdapter(List<TeamDetail> listKlubBola) {
        this.listKlubBola = listKlubBola;
    }

    @NonNull
    @Override
    public TeamBolaHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View itemView = LayoutInflater.from(viewGroup.getContext()
        ).inflate(R.layout.item_row, viewGroup, false);
        return new TeamBolaHolder(itemView);
    }

    @Override
    public void onBindViewHolder(@NonNull TeamBolaHolder klubBolaHolder, int i) {

        TeamDetail data = listKlubBola.get(i);
        klubBolaHolder.clubName.setText(data.getTeamName());
        Picasso.get().load(data.getTeamLogo()).into(klubBolaHolder.clubImage);
        klubBolaHolder.lokasigambar = data.getTeamLogo();
        klubBolaHolder.namatim = data.getTeamName();
        klubBolaHolder.deksripsi = data.getDeskripsiTim();
    }



    @Override
    public int getItemCount() {
        return listKlubBola.size();
    }

    public class TeamBolaHolder extends RecyclerView.ViewHolder {

        TextView clubName;
        ImageView clubImage;
        String lokasigambar;
        String namatim;
        String deksripsi;

        private Context context;



        public TeamBolaHolder(@NonNull View itemView) {
            super(itemView);

            context = itemView.getContext();
            clubName = (TextView) itemView.findViewById(R.id.txt_item_club_name);
            clubImage = (ImageView) itemView.findViewById(R.id.item_club_img);
            //RelativeLayout relativeLayout = (RelativeLayout)findViewById(R.id.detailbutton) ;


            final Button DetailTim = (Button) itemView.findViewById(R.id.detailbutton);
            DetailTim.setOnClickListener(new View.OnClickListener() {

                @Override
                public void onClick(View v) {

                    Bundle extras = new Bundle();
                    extras.putString("name",namatim);
                    extras.putString("gambar",lokasigambar);
                    extras.putString("deskripsi",deksripsi);


                    //Picasso.get().load(data.getTeamLogo()).into(klubBolaHolder.clubImage);

                    Intent detailtim = new Intent(context, DetailActivity.class);
                    detailtim.putExtras(extras);

                    context.startActivity(detailtim);
                }



            });

        }
    }

}
