package com.example.kamuela94.fhirry_adventure;

import android.support.v4.app.Fragment;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.Manifest;
import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.UUID;

import static com.example.kamuela94.fhirry_adventure.R.id.action_add_new_drug;


/**
 * A placeholder fragment containing a simple view.
 */
public class MainActivityFragment extends Fragment {

//    public MainActivityFragment() {
//    }

    private RecyclerView mMainRecyclerView;
    private DrugAdapter mAdapter;
    private ArrayList<Drug> mDrugs;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_main, container, false);

        setHasOptionsMenu(true);

        mMainRecyclerView = (RecyclerView) view
                .findViewById(R.id.main_recycler_view);

        mMainRecyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));


        updateUI();

        return view;
    }

    @Override
    public void onCreateOptionsMenu(Menu menu, MenuInflater inflater) {
        inflater.inflate(R.menu.menu_main, menu);
        super.onCreateOptionsMenu(menu, inflater);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
// UNCOMMENT TO HAVE ADD CLICK FUNCTIONALITY
//        switch(item.getItemId()){
//            case action_add_new_drug:
//                Log.d("Log","ID 1 PRESSED");
//                Intent intent = NewDrug.newIntent(getActivity(), NewDrug.class);
//                startActivity(intent);
//            default:
                return super.onOptionsItemSelected(item);
//        }
    }

    private void updateUI() {
        DrugMaker drugMaker = DrugMaker.get(getActivity());
        ArrayList<Drug> drugs = drugMaker.getDrugs();
        if (mAdapter == null) {
            mAdapter = new DrugAdapter(getContext(), drugs);
            mMainRecyclerView.setAdapter(mAdapter);
        } else {
            mAdapter.notifyDataSetChanged();
        }

    }

    @Override
    public void onResume() {
        super.onResume();
        updateUI();
    }

    private class DrugAdapter extends RecyclerView.Adapter<DrugHolder>{

        Context mContext;
//        private ArrayList<Drug> mDrugs;
        private View.OnClickListener mListener;
        private View.OnLongClickListener mLongClickListener;

        public DrugAdapter(Context context, ArrayList<Drug> drugs) {
            this.mContext = context;
            mDrugs = drugs;
        }

        @Override
        public DrugHolder onCreateViewHolder(ViewGroup parent, int viewType) {
            LayoutInflater layoutInflater = LayoutInflater.from(getActivity());
            View view = layoutInflater.inflate(R.layout.content_main, parent, false);
            return new DrugHolder(view);
        }

        @Override
        public void onBindViewHolder(DrugHolder holder, int position) {
            Drug card = mDrugs.get(position);
            holder.bindDrug(card);

        }

        @Override
        public int getItemCount() {
            return mDrugs.size();
        }

        public void updateDataset(ArrayList<Drug> storyList) {
            mDrugs.clear();
            mDrugs.addAll(storyList);
            notifyDataSetChanged();
        }

        public void setListener(View.OnClickListener listener) {
            this.mListener = listener;

        }

        public void setLongClickListener(View.OnLongClickListener listener){
            this.mLongClickListener = listener;


        }

    }

    private class DrugHolder extends RecyclerView.ViewHolder
            /*implements View.OnLongClickListener*//*, View.OnLongClickListener*/{

        private TextView mTitleTextView;
        private TextView mTimeText;

        private Drug mDrug;

        public DrugHolder(View itemView) {
            super(itemView);
//            itemView.setOnClickListener(this);
            itemView.setOnLongClickListener(new View.OnLongClickListener() {
                @Override
                public boolean onLongClick(View view) {
                    int position = getAdapterPosition();
                    mDrugs.remove(position);
                    updateUI();
                    return true;
                }
            });

            mTitleTextView = (TextView) itemView.findViewById(R.id.card_drug_title);

            mTimeText = (TextView) itemView.findViewById(R.id.card_time);

        }

        public void bindDrug(Drug drug) {
            mDrug = drug;

            mTitleTextView.setText(mDrug.getDrugName());
            mTimeText.setText(Integer.toString(mDrug.getTimeStarted()));

        }

//        @Override
//        public void onClick(View v) {
//            Intent intent = StoryActivity.newIntent(getActivity(), mStory.getID());
//            startActivity(intent);
//        }


//        @Override
//        public boolean onLongClick(View view) {
//            UUID id = mDrug.getUUID();
//            return false;
//        }

        void setTitle(String title) {
            String name = title;
            this.mTitleTextView.setText(name);
        }

        void setID(String id) {
            String ID = id;

        }
    }

}
