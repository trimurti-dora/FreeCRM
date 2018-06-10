package com.crm.qa.util;

import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.events.WebDriverEventListener;

import com.crm.qa.base.TestBase;

public class WebEventListener extends TestBase implements WebDriverEventListener {

	@Override
	public void afterAlertAccept(WebDriver driver) {
		System.out.println("Clicked on 'OK' button");
		
	}

	@Override
	public void afterAlertDismiss(WebDriver driver) {
		System.out.println("Alert dissmissed");
		
	}

	@Override
	public void afterChangeValueOf(WebElement element, WebDriver driver, CharSequence[] value) {
		System.out.println(element.toString()+" Element value changed to: "+value.toString());
		
	}

	@Override
	public void afterClickOn(WebElement element, WebDriver driver) {
		System.out.println("Clicked on: "+element.toString());
		
	}

	@Override
	public void afterFindBy(By by, WebElement element, WebDriver driver) {
		System.out.println("Element found: "+by.toString());
		
	}

	@Override
	public void afterNavigateBack(WebDriver driver) {
		System.out.println("Navigated back to previous page");
		
	}

	@Override
	public void afterNavigateForward(WebDriver driver) {
		System.out.println("Navigated forward to previous page");
		
	}

	@Override
	public void afterNavigateRefresh(WebDriver driver) {
		System.out.println("Page refreshed");
		
	}

	@Override
	public void afterNavigateTo(String url, WebDriver driver) {
		System.out.println("Navigated to: '"+url+"'");
	}

	@Override
	public void afterScript(String arg0, WebDriver arg1) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void afterSwitchToWindow(String url, WebDriver driver) {
		System.out.println("driver switched to window '"+url+"'");
		
	}

	@Override
	public void beforeAlertAccept(WebDriver arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void beforeAlertDismiss(WebDriver arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void beforeChangeValueOf(WebElement arg0, WebDriver arg1, CharSequence[] arg2) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void beforeClickOn(WebElement element, WebDriver driver) {
		System.out.println("Clicking on element "+element.toString());
		
	}

	@Override
	public void beforeFindBy(By by, WebElement element, WebDriver driver) {
		System.out.println("Looking for Element :"+by.toString());
		
	}

	@Override
	public void beforeNavigateBack(WebDriver arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void beforeNavigateForward(WebDriver arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void beforeNavigateRefresh(WebDriver arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void beforeNavigateTo(String arg0, WebDriver arg1) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void beforeScript(String arg0, WebDriver arg1) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void beforeSwitchToWindow(String arg0, WebDriver arg1) {

		
	}

	@Override
	public void onException(Throwable error, WebDriver arg1) {
		System.out.println("Exception occured: "+error);
		try {
			TestUtil.takeScreenshotAtEndOfTest();
		} catch (IOException e) {
			e.printStackTrace();
		}
		
	}

}
