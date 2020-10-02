package controller;

abstract class LayoutController {
    protected ViewportControllable layoutController;
    public LayoutController(ViewportControllable layoutController){
        this.layoutController = layoutController;
    }
}
