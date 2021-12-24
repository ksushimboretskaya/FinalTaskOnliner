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

    @Override
    public void sendKeys(String string){
        wrappedElement.sendKeys(string);
    }

    @Override
    public boolean isDisplayed(){
       return wrappedElement.isDisplayed();
    }
}