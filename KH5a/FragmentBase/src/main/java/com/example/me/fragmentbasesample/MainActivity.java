package com.example.me.fragmentbasesample;

import android.support.v4.app.DialogFragment;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity implements HeadlinesFragment.OnHeadlineSelectedListener
        ,DateDialogFragment.NoticeDialogListener,SingleChoiceDialogFragment.NoticeDialogListener {
    String riqi;
    String wlan;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        if (findViewById(R.id.fragment_container) != null) {

            // However, if we're being restored from a previous state,
            // then we don't need to do anything and should return or else
            // we could end up with overlapping fragments.
            if (savedInstanceState != null) {
                return;
            }

            // Create an instance of ExampleFragment
            HeadlinesFragment headlinesFragment = new HeadlinesFragment();

            // In case this activity was started with special instructions from an Intent,
            // pass the Intent's extras to the fragment as arguments
            headlinesFragment.setArguments(getIntent().getExtras());

            // Add the fragment to the 'fragment_container' FrameLayout
            getSupportFragmentManager().beginTransaction().add(R.id.fragment_container, headlinesFragment).commit();
        }
    }

    public void onArticleSelected(int position) {
        // The user selected the headline of an article from the HeadlinesFragment

        // Capture the article fragment from the activity layout
        ArticleFragment articleFrag = (ArticleFragment) getSupportFragmentManager().findFragmentById(R.id.article_fragment);

        if (articleFrag != null) {
            // If article frag is available, we're in two-pane layout...

            // Call a method in the ArticleFragment to update its content
            articleFrag.updateArticleView(position);

        } else {
            // If the frag is not available, we're in the one-pane layout and must swap frags...

            // Create fragment and give it an argument for the selected article
            ArticleFragment newFragment = new ArticleFragment();
            Bundle args = new Bundle();
            args.putInt(ArticleFragment.ARG_POSITION, position);
            newFragment.setArguments(args);
            FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
            // Replace whatever is in the fragment_container view with this fragment,
            // and add the transaction to the back stack so the user can navigate back
            transaction.replace(R.id.fragment_container, newFragment);
            transaction.addToBackStack(null);

            // Commit the transaction
            transaction.commit();
        }
    }

    public void btnsOnClick(View v){
        DialogFragment newFragment = new SingleChoiceDialogFragment();
        newFragment.show(getSupportFragmentManager(), "singlechoice");
    }

    public void btndOnClick(View v) {
        DialogFragment newFragment = new DateDialogFragment();
        newFragment.show(getSupportFragmentManager(), "datedialog");
    }

    @Override
    public void onDateDialogDateSet(DialogFragment dialog) {
        DateDialogFragment dialogFragment = (DateDialogFragment) dialog;
        riqi = dialogFragment.getDateString();
        Ipsum.Headlines[0] = riqi;
    }

    @Override
    public void onDialogPositiveClick(DialogFragment dialog) {
        SingleChoiceDialogFragment dialogFragment = (SingleChoiceDialogFragment) dialog;
        wlan = dialogFragment.getLoginString();
        Ipsum.Headlines[1] = wlan;
    }
}