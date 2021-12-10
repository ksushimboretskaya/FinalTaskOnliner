package elements;

import org.openqa.selenium.WebElement;

public class CustomTextElementImpl implements CustomTextElement {
    private final WebElement wrappedElement;

    public CustomTextElementImpl(final WebElement wrappedElement) {
        this.wrappedElement = wrappedElement;
    }

    @Override
    public String getText() {
        return wrappedElement.getText();
    }
}
