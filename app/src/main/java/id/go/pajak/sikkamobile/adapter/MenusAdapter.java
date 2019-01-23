package id.go.pajak.sikkamobile.adapter;

import android.app.AlertDialog;
import android.app.Dialog;
import android.content.ClipData;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.sax.StartElementListener;
import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import java.util.List;

import id.go.pajak.sikkamobile.activity.CutiActivity;
import id.go.pajak.sikkamobile.activity.LoginActivity;
import id.go.pajak.sikkamobile.activity.PresensiActivity;
import id.go.pajak.sikkamobile.activity.ProfileActivity;
import id.go.pajak.sikkamobile.model.Menu;
import id.go.pajak.sikkamobile.R;
/**
 * Created by TTKI on 19-Jul-17.
 */

public class MenusAdapter extends RecyclerView.Adapter<MenusAdapter.MyViewHolder> {
    private Context mContext;
    private List<Menu> menuList;

    public class MyViewHolder extends RecyclerView.ViewHolder {
        public TextView title;
        public ImageView thumbnail;
        public CardView cardView;
        public RelativeLayout rel;

        public MyViewHolder(View view) {
            super(view);
            title = (TextView) view.findViewById(R.id.title);
            thumbnail = (ImageView) view.findViewById(R.id.thumbnail);
            cardView = (CardView) view.findViewById(R.id.card_view);
            rel = (RelativeLayout) view.findViewById(R.id.rel);

            view.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    int position = getAdapterPosition();
                    if (position == 3) {
                        final Dialog dialog = new Dialog(mContext);
                        dialog.setContentView(R.layout.dialog_box_logout);
                        Button yesbut = (Button) dialog.findViewById(R.id.yes);
                        Button nobut = (Button) dialog.findViewById(R.id.no);
                        yesbut.setOnClickListener(new View.OnClickListener() {
                            @Override
                            public void onClick(View v) {
                                Intent i = new Intent(mContext, LoginActivity.class);
                                mContext.startActivity(i);
                            }
                        });
                        nobut.setOnClickListener(new View.OnClickListener() {
                            @Override
                            public void onClick(View v) {
                                dialog.dismiss();
                            }
                        });
                        dialog.show();

                    } else if (position == 1)

                    {
                        Intent a = new Intent(mContext, CutiActivity.class);
                        mContext.startActivity(a);
                    } else if (position == 0)

                    {
                        Intent a = new Intent(mContext, ProfileActivity.class);
                        mContext.startActivity(a);
                    } else if (position == 2)

                    {
                        Intent a = new Intent(mContext, PresensiActivity.class);
                        mContext.startActivity(a);
                    }

                }
            });
        }

    }


    public MenusAdapter(Context mContext, List<Menu> menuList) {
        this.mContext = mContext;
        this.menuList = menuList;
    }

    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.menu_card, parent, false);
        return new MyViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(final MyViewHolder holder, final int position) {
        final Menu menu = menuList.get(position);
        holder.title.setText(menu.getName());
        holder.thumbnail.setImageResource(menu.getThumbnail());
    }

    @Override
    public int getItemCount() {
        return menuList.size();
    }
}
