package elements;

import org.openqa.selenium.WebElement;

public class CustomCheckBoxImpl implements CustomCheckBox {
    private final WebElement wrappedElement;

    public CustomCheckBoxImpl(final WebElement wrappedElement) {
        this.wrappedElement = wrappedElement;
    }

    @Override
    public void click() {
        wrappedElement.click();
    }
}
