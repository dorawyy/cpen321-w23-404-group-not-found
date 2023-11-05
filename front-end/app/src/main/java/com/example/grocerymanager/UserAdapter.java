package com.example.grocerymanager;

import androidx.recyclerview.widget.RecyclerView;
import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.annotation.NonNull;

import java.util.List;
public class UserAdapter extends RecyclerView.Adapter<UserAdapter.UserViewHolder>{
    private List<UserData> userList;
    private Context context;

    public UserAdapter(Context context, List<UserData> userList) {
        this.context = context;
        this.userList = userList;
    }

    @NonNull
    @Override
    public UserViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.item_user, parent, false);
        return new UserViewHolder(itemView, context);
    }

    @Override
    public void onBindViewHolder(@NonNull UserViewHolder holder, int position) {
        UserData user = userList.get(position);
        holder.userName.setText(user.getFirstName() + " " + user.getLastName());
        holder.userEmail.setText(user.getUserEmail());
        holder.bindUser(user);  // Associate the user with the ViewHolder
    }

    @Override
    public int getItemCount() {
        return userList.size();
    }

    public static class UserViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {
        public TextView userName;
        public TextView userEmail;
        private UserData currentUser;
        private Context context;

        public UserViewHolder(View view, Context context) {
            super(view);
            this.context = context;
            userName = view.findViewById(R.id.userName);
            userEmail = view.findViewById(R.id.userEmail);
            view.setOnClickListener(this);
        }

        public void bindUser(UserData user) {
            this.currentUser = user;
        }

        @Override
        public void onClick(View v) {
            int position = getAdapterPosition();
            if (position != RecyclerView.NO_POSITION) {
//                Intent intent = new Intent(context, ChatDietitianActivity.class); ///
//                context.startActivity(intent);
            }
        }
    }
}
