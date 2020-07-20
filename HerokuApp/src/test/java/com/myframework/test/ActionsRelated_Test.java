package com.myframework.test;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.myframework.base.BaseTest;
import com.myframework.pages.ActionsRelated;

public class ActionsRelated_Test extends BaseTest {

	@Test(priority = 0,groups = {"unstable"})
	public void dragAndDropTest() {
		ActionsRelated actionsRelated = new ActionsRelated(driver, log);
		actionsRelated.openActionsPage().testDragAndDrop();
		Assert.assertEquals(actionsRelated.actualReturnDropText(), actionsRelated.expectedDropText());
	}

}
