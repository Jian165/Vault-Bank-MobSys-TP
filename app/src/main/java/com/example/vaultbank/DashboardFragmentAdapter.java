package com.example.vaultbank;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.lifecycle.Lifecycle;
import androidx.viewpager2.adapter.FragmentStateAdapter;

public class DashboardFragmentAdapter extends FragmentStateAdapter
{
    public DashboardFragmentAdapter(@NonNull FragmentManager fragmentManager, @NonNull Lifecycle lifecycle) {
        super(fragmentManager, lifecycle);
    }

    @NonNull
    @Override
    public Fragment createFragment(int position) {
       if(position == 0)
       {
           return new Home();
       }
       else if (position == 1)
       {
           return new Inbox();
       }
       else if(position == 2) {
           return new Transactions();
       }
       else if (position == 3)
       {
           return new Account();
       }
       return new Home();

    }

    @Override
    public int getItemCount() {
        return 4;
    }
}
