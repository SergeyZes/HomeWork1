package zesley.sergey.myapplication;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity implements MainView, View.OnClickListener {
    private Button btnCounter1;
    private Button btnCounter2;
    private Button btnCounter3;
    private Presenter mPresenter;
    private MainPresenter presenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        btnCounter1 = findViewById(R.id.btnCounter1);
        btnCounter2 = findViewById(R.id.btnCounter2);
        btnCounter3 = findViewById(R.id.btnCounter3);
        btnCounter1.setOnClickListener(this);
        btnCounter2.setOnClickListener(this);
        btnCounter3.setOnClickListener(this);
        //mPresenter = new Presenter(this);
        if (savedInstanceState == null) {
            presenter = new MainPresenter();
            List<Integer> model=new ArrayList<>(3);
            model.add(0);
            model.add(0);
            model.add(0);
            presenter.setModel(model);

        } else {
            presenter = PresenterManager.getInstance().restorePresenter(savedInstanceState);
        }
    }

    @Override
    public void onClick(View v) {
        //Для задания 1
       // mPresenter.buttonClick(v.getId(),R.id.btnCounter1,R.id.btnCounter2,R.id.btnCounter3);
        presenter.buttonClick(v.getId(),R.id.btnCounter1,R.id.btnCounter2,R.id.btnCounter3);

    }

    @Override
    public void setButtonText(int btnIndex, int value) {
        switch (btnIndex) {
            case 1:
                btnCounter1.setText("Количество = " + value);
                break;
            case 2:
                btnCounter2.setText("Количество = " + value);
                break;
            case 3:
                btnCounter3.setText("Количество = " + value);
                break;
        }

    }

    @Override
    public void showCounters(List<Integer> cntrs) {
        btnCounter1.setText("Количество = " + cntrs.get(0));
        btnCounter2.setText("Количество = " + cntrs.get(1));
        btnCounter3.setText("Количество = " + cntrs.get(2));

    }

    @Override
    protected void onResume() {
        super.onResume();

        presenter.bindView(this);
    }

    @Override
    protected void onPause() {
        super.onPause();

        presenter.unbindView();
    }

    @Override
    protected void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);

        PresenterManager.getInstance().savePresenter(presenter, outState);
    }



}
