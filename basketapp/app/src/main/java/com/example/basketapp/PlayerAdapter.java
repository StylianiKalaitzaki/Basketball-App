package com.example.basketapp;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.List;

public class PlayerAdapter extends RecyclerView.Adapter<PlayerAdapter.ViewHolder> {
    Context context;
    List<Player> playerList;

    public PlayerAdapter(Context context, List<Player> playerList) {
        this.context = context;
        this.playerList = playerList;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.item_layout, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        if (playerList != null && playerList.size() >= 0) {
            Player player = playerList.get(position);
            holder.nameCol.setText(player.getFirstname() + "\n" + player.getLastname());
            holder.positionCol.setText(player.getPosition());

            JSONObject jsonObject = player.getStatistics();
            try {
                holder.p1Col.setText((String) jsonObject.get("1p"));
                holder.p2Col.setText((String) jsonObject.get("2p"));
                holder.p3Col.setText((String) jsonObject.get("3p"));
                holder.foulsCol.setText((String) jsonObject.get("fouls"));
                holder.astCol.setText((String) jsonObject.get("assists"));
                holder.pointsCol.setText((String) jsonObject.get("points"));
                holder.blocksCol.setText((String) jsonObject.get("blocks"));
                holder.shotsCol.setText((String) jsonObject.get("shots"));
                holder.reboundsCol.setText((String) jsonObject.get("rebounds"));
                holder.stealsCol.setText((String) jsonObject.get("steals"));
                holder.turnoversCol.setText((String) jsonObject.get("turnovers"));

            } catch (JSONException e) {
                e.printStackTrace();
            }


            JSONArray jArray = null;
            try {
                jArray = jsonObject.getJSONArray("Statistics");

            } catch (JSONException e) {
                e.printStackTrace();
            }




        } else {
            return;
        }
    }

    @Override
    public int getItemCount() {
        return playerList.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        TextView nameCol,  p2Col, p3Col,foulsCol,astCol,p1Col,blocksCol,shotsCol,reboundsCol,stealsCol,turnoversCol,pointsCol,positionCol;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            nameCol = itemView.findViewById(R.id.nameCol);
            positionCol = itemView.findViewById(R.id.positionCol);
            pointsCol= itemView.findViewById(R.id.pointsCol);
            p1Col = itemView.findViewById(R.id.p1Col);
            p2Col = itemView.findViewById(R.id.p2Col);
            p3Col = itemView.findViewById(R.id.p3Col);
            foulsCol = itemView.findViewById(R.id.foulsCol);
            astCol = itemView.findViewById(R.id.astCol);
            blocksCol = itemView.findViewById(R.id.blocksCol);
            shotsCol = itemView.findViewById(R.id.shotsCol);
            reboundsCol = itemView.findViewById(R.id.reboundsCol);
            stealsCol = itemView.findViewById(R.id.stealsCol);
            turnoversCol = itemView.findViewById(R.id.turnoversCol);

        }
    }
}
