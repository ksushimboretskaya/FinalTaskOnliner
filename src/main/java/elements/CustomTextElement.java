package elements;

public interface CustomTextElement extends CustomElement {
    String getText();
    void sendKeys(String message);
    boolean isDisplayed();
}