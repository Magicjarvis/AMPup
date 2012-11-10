package com.melonbear.ampup;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.app.ListFragment;
import android.support.v4.view.ViewPager;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

public class AMPActivity extends FragmentActivity {

  /**
   * The {@link android.support.v4.view.PagerAdapter} that will provide
   * fragments for each of the sections. We use a
   * {@link android.support.v4.app.FragmentPagerAdapter} derivative, which will
   * keep every loaded fragment in memory. If this becomes too memory intensive,
   * it may be best to switch to a
   * {@link android.support.v4.app.FragmentStatePagerAdapter}.
   */
  SectionsPagerAdapter mSectionsPagerAdapter;

  /**
   * The {@link ViewPager} that will host the section contents.
   */
  ViewPager mViewPager;

  @Override
  public void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_amp);
    // Create the adapter that will return a fragment for each of the three
    // primary sections
    // of the app.
    mSectionsPagerAdapter = new SectionsPagerAdapter(
        getSupportFragmentManager());

    // Set up the ViewPager with the sections adapter.
    mViewPager = (ViewPager) findViewById(R.id.pager);
    mViewPager.setAdapter(mSectionsPagerAdapter);

  }

  @Override
  public boolean onCreateOptionsMenu(Menu menu) {
    getMenuInflater().inflate(R.menu.activity_amp, menu);
    return true;
  }

  /**
   * A {@link FragmentPagerAdapter} that returns a fragment corresponding to one
   * of the primary sections of the app.
   */
  public class SectionsPagerAdapter extends FragmentPagerAdapter {

    public SectionsPagerAdapter(FragmentManager fm) {
      super(fm);
    }

    @Override
    public Fragment getItem(int i) {
      switch (i) {
        case 0:
          return new ListSectionFragment();
        case 1:
          return new MediaSectionFragment();
        case 2:
          Fragment dummy = new DummySectionFragment();
          Bundle args = new Bundle();
          args.putInt(DummySectionFragment.ARG_SECTION_NUMBER, 3);
          dummy.setArguments(args);
          return dummy;
      }
      return null;
    }

    @Override
    public int getCount() {
      return 3;
    }
  }

  public static class ListSectionFragment extends ListFragment {
    public ListSectionFragment() {}

    public static final String ARG_SECTION_NUMBER = "section_number";

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
        Bundle savedInstanceState) {
      View v = inflater.inflate(R.layout.list_view, null);
      String[] lessons = new String[10];
      for (int i = 0; i < lessons.length; i++) {
        lessons[i] = String.format("Lesson %d", i + 1);
      }
      setListAdapter(new ArrayAdapter<String>(getActivity(), 
          android.R.layout.simple_list_item_1, lessons));
      return v;
    }

    public int getCount() {
      return 3;
    }

    public CharSequence getPageTitle(int position) {
      switch (position) {
      case 0:
        return getString(R.string.title_section1).toUpperCase();
      case 1:
        return getString(R.string.title_section2).toUpperCase();
      case 2:
        return getString(R.string.title_section3).toUpperCase();
      }
      return null;
    }
  }

  /**
   * A dummy fragment representing a section of the app, but that simply
   * displays dummy text.
   */
  public static class DummySectionFragment extends Fragment {
    public DummySectionFragment() {}

    public static final String ARG_SECTION_NUMBER = "section_number";

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
        Bundle savedInstanceState) {
      TextView textView = new TextView(getActivity());
      textView.setGravity(Gravity.CENTER);
      Bundle args = getArguments();
      textView.setText(Integer.toString(args.getInt(ARG_SECTION_NUMBER)));
      return textView;
    }
  }
}