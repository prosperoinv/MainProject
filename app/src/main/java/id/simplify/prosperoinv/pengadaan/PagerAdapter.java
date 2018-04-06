package id.simplify.prosperoinv.pengadaan;

import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;
import android.support.v4.app.Fragment;

import id.simplify.prosperoinv.pengadaan.FragmentPengadaan1;
import id.simplify.prosperoinv.pengadaan.FragmentPengadaan2;

public class PagerAdapter extends FragmentStatePagerAdapter {
    int mNumOfTabs;
    public PagerAdapter(FragmentManager fm, int NumOfTabs) {
        super(fm);
        this.mNumOfTabs = NumOfTabs;
    }

    @Override
    public Fragment getItem(int position) {
        switch (position) {
            case 0:
                return new FragmentPengadaan1();
            case 1:
                return new FragmentPengadaan2();
            default:
                return null;
        }
    }
    @Override
    public int getCount() {
            return mNumOfTabs;
    }
}
