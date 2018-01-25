package com.roomdemo;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by umesh.dabhade on 15/01/18.
 */

public class UsersAdapter extends RecyclerView.Adapter<UsersAdapter.UsersViewHolder> {

    private ArrayList<User> arlstUser;

    public UsersAdapter() {
        this.arlstUser = new ArrayList<User>();
    }

    @Override
    public UsersViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.row_user, parent, false);
        return new UsersViewHolder(view);
    }

    @Override
    public void onBindViewHolder(UsersViewHolder holder, int position) {

        User user = this.arlstUser.get(position);
        holder.tvUser.setText(user.getFirstName()+" "+user.getLastName());
    }

    public void setUsers(ArrayList<User> users){
        this.arlstUser.clear();
        this.arlstUser.addAll(users);
        notifyDataSetChanged();
    }

    @Override
    public int getItemCount() {
        return this.arlstUser.size();
    }

    public class UsersViewHolder extends RecyclerView.ViewHolder {

        @BindView(R.id.tvUser)
        TextView tvUser;
        public UsersViewHolder(View itemView) {
            super(itemView);
            ButterKnife.bind(this,itemView);
        }
    }
}
