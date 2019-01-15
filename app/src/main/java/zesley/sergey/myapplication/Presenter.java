package zesley.sergey.myapplication;

public class Presenter {
    private Model mModel;
    private MainActivity view;

    public Presenter(MainActivity view) {
        this.mModel = new Model();
        this.view = view;
    }

    private int calcNewModelValue(int modelElementIndex) {
        int currentValue = mModel.getElementValueAtIndex(modelElementIndex);
        return currentValue + 1;
    }

    public void buttonClick(int btnIndex, int firstBtnId, int secondBtnId, int thirdBtnId) {
        int newModelValue;
        if (btnIndex == firstBtnId) {
            newModelValue = calcNewModelValue(0);
            mModel.setElementValueAtIndex(0, newModelValue);
            view.setButtonText(1, newModelValue);
        } else if (btnIndex == secondBtnId) {
            newModelValue = calcNewModelValue(1);
            mModel.setElementValueAtIndex(1, newModelValue);
            view.setButtonText(2, newModelValue);

        } else if (btnIndex == thirdBtnId) {
            newModelValue = calcNewModelValue(2);
            mModel.setElementValueAtIndex(2, newModelValue);
            view.setButtonText(3, newModelValue);
        }

    }
}
