package com.w2a.testcase;

import org.testng.annotations.Test;

import com.w2a.base.BasePage;
import com.w2a.pages.CRMPage;
import com.w2a.pages.ZohoAppPage;

public class CRMPageTest {
	
	@Test
	public void crmPageTest()
	{
		ZohoAppPage zap = new ZohoAppPage();
		CRMPage crm = zap.goToCRM();
		crm.goToPricing();
		BasePage.menu.goToSurvey();
		
	}

}
