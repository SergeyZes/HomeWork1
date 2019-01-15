package zesley.sergey.myapplication;

import java.util.List;

public interface MainView {
    void setButtonText(int btnIndex, int value);
    void showCounters(List<Integer> cntrs);
}
