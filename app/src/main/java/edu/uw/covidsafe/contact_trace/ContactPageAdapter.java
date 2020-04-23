package edu.uw.covidsafe.contact_trace;

import android.os.Bundle;
import android.util.Log;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;
import androidx.fragment.app.FragmentTransaction;

import com.example.covidsafe.R;

import edu.uw.covidsafe.ui.onboarding.StoryFragment;
import edu.uw.covidsafe.utils.Constants;

public class ContactPageAdapter extends FragmentPagerAdapter {

    public ContactPageAdapter(@NonNull FragmentManager fm) {
        super(fm);
    }

    @NonNull
    @Override
    public Fragment getItem(int position) {
        Log.e("state","contact page adapter "+position);
        ContactStepFragment frag = new ContactStepFragment();
        Bundle bundle = new Bundle();
        bundle.putInt("pgnum", position);
        if (position == 0) {
        }
        else if (position == 1) {
            bundle.putInt("image", R.drawable.clipboard);
        }
        else if (position == 2) {
            bundle.putInt("image", R.drawable.map_header);
        }
        else if (position == 3) {
            bundle.putInt("image", R.drawable.person);
        }
        else if (position == 4) {
            bundle.putInt("image", R.drawable.speech_icon);
        }
        frag.setArguments(bundle);
        return frag;
    }

    @Override
    public int getCount() {
        return 5;
    }

    @Nullable
    @Override
    public CharSequence getPageTitle(int position) {
        return "Interview Preparation";
    }
}
