package com.example.ieeetask2;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;
import java.util.ArrayList;
import java.util.List;


public class fragments extends FragmentPagerAdapter {

    private final List <Fragment> fragmentList = new ArrayList <>();
    private final List <String> list_title = new ArrayList <>();



    public fragments(@NonNull FragmentManager fm) {
        super(fm);
    }



    @NonNull
    @Override
    public Fragment getItem(int position) {
        return fragmentList.get(position);
    }



    @Nullable
    @Override
    public CharSequence getPageTitle(int position) {
        return list_title.get(position);
    }




    @Override
    public int getCount() {
        return list_title.size();
    }



    public void add (Fragment fragment , String title)
    {
        fragmentList.add(fragment);
        list_title.add(title);
    }

}
