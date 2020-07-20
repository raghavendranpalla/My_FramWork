package com.herokuapp.theinternet.test;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.herokuapp.theinternet.base.BaseTest;
import com.herokuapp.theinternet.pages.ActionsRelated;

public class ActionsRelated_Test extends BaseTest {

	@Test(priority = 0,groups = {"unstable"})
	public void dragAndDropTest() {
		ActionsRelated actionsRelated = new ActionsRelated(driver, log);
		actionsRelated.openActionsPage().testDragAndDrop();
		Assert.assertEquals(actionsRelated.actualReturnDropText(), actionsRelated.expectedDropText());
	}

}
