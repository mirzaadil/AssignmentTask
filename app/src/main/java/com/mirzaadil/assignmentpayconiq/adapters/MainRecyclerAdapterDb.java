package com.mirzaadil.assignmentpayconiq.adapters;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.util.Base64;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.mirzaadil.assignmentpayconiq.R;
import com.mirzaadil.assignmentpayconiq.database.entity.Model;

import java.util.List;

public class MainRecyclerAdapterDb extends RecyclerView.Adapter<MainRecyclerAdapterDb.RepositoriesViewHolder> {
    private Context context;
    private List<Model.RepositoryModel> reposList;

    public MainRecyclerAdapterDb(Context context, List<Model.RepositoryModel> reposList) {
        this.context = context;
        this.reposList = reposList;
    }


    @NonNull
    @Override
    public RepositoriesViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.single_row_repositories, parent, false);
        return new RepositoriesViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull RepositoriesViewHolder holder, int position) {

        holder.textViewReposName.setText(reposList.get(position).getName());
        holder.textViewReposDescription.setText(reposList.get(position).getDesceiption());
        holder.textViewId.setText(String.valueOf(reposList.get(position).getPostId()));
        byte[] decodedString = Base64.decode(reposList.get(position).getImage_url(), Base64.DEFAULT);
        Bitmap decodedByte = BitmapFactory.decodeByteArray(decodedString, 0, decodedString.length);
        holder.imageView_user.setImageBitmap(decodedByte);

    }

    @Override
    public int getItemCount() {
        return reposList.size();
    }

    class RepositoriesViewHolder extends RecyclerView.ViewHolder {


        private TextView textViewReposName;
        private TextView textViewReposDescription;
        private TextView textViewId;
        private ImageView imageView_user;

        public RepositoriesViewHolder(View itemView) {
            super(itemView);

            textViewReposName = itemView.findViewById(R.id.tv_repo_name);
            textViewReposDescription = itemView.findViewById(R.id.tv_repo_description);
            textViewId = itemView.findViewById(R.id.main_product_id);
            imageView_user = itemView.findViewById(R.id.main_product_image);
        }
    }

}
