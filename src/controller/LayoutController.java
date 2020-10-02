package controller;

abstract class LayoutController implements Controllable{
    protected ViewportControllable layoutController;

    @Override
    public void initialize(ViewportControllable controller) {
        this.layoutController = controller;
    }

    public ViewportControllable getLayoutController() {
        return layoutController;
    }
}
