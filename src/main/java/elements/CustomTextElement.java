package elements;

public interface CustomTextElement extends CustomElement {
    String getText();
    void sendKeys(String string);
    boolean isDisplayed();
}