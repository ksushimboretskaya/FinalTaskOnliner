package elements;

import org.openqa.selenium.WebElement;

public class CustomButtonImpl implements CustomButton {
    private final WebElement wrappedElement;

    public CustomButtonImpl(final WebElement wrappedElement) {
        this.wrappedElement = wrappedElement;
    }

    @Override
    public void click() {
        wrappedElement.click();
    }
}