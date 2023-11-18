package com.hps
import static com.kms.katalon.core.checkpoint.CheckpointFactory.findCheckpoint
import static com.kms.katalon.core.testcase.TestCaseFactory.findTestCase
import static com.kms.katalon.core.testdata.TestDataFactory.findTestData
import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject

import com.kms.katalon.core.annotation.Keyword
import com.kms.katalon.core.checkpoint.Checkpoint
import com.kms.katalon.core.checkpoint.CheckpointFactory
import com.kms.katalon.core.mobile.keyword.MobileBuiltInKeywords as Mobile
import com.kms.katalon.core.model.FailureHandling
import com.kms.katalon.core.testcase.TestCase
import com.kms.katalon.core.testcase.TestCaseFactory
import com.kms.katalon.core.testdata.TestData
import com.kms.katalon.core.testdata.TestDataFactory
import com.kms.katalon.core.testobject.ObjectRepository
import com.kms.katalon.core.testobject.TestObject
import com.kms.katalon.core.webservice.keyword.WSBuiltInKeywords as WS
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI
import com.kms.katalon.core.webui.keyword.internal.WebUIAbstractKeyword

import internal.GlobalVariable

import org.openqa.selenium.WebElement
import org.openqa.selenium.WebDriver
import org.openqa.selenium.By

import com.kms.katalon.core.mobile.keyword.internal.MobileDriverFactory
import com.kms.katalon.core.webui.driver.DriverFactory

import com.kms.katalon.core.testobject.RequestObject
import com.kms.katalon.core.testobject.ResponseObject
import com.kms.katalon.core.testobject.ConditionType
import com.kms.katalon.core.testobject.TestObjectProperty

import com.kms.katalon.core.mobile.helper.MobileElementCommonHelper
import com.kms.katalon.core.util.KeywordUtil

import com.kms.katalon.core.webui.exception.WebElementNotFoundException

import cucumber.api.java.en.And
import cucumber.api.java.en.Given
import cucumber.api.java.en.Then
import cucumber.api.java.en.When



class CreateStep {
	@Given("User is on the Todo list application.")
	def accessToHomePage() {
		WebUI.openBrowser('')
		WebUI.navigateToUrl('https://bdd-todo.minhtringuyennn.com/')
	}

	@When("User adds a task with the title (.*).")
	def addTask(String taskName) {
		WebUI.setText(findTestObject('Object Repository/Page_BDD To Do App/input_BDD Testing_bg-transparent w-full h-f_4fe21c'), taskName)
	}

	@And("Click add button.")
	def clickAddButton() {
		WebUI.click(findTestObject('Object Repository/Page_BDD To Do App/button_Add'))
	}

	@Then("The new task (.*) and (.*) should be added to the Todo list.")
	def verifyNameTasks(String nameTask1, String nameTask2) {
		WebUI.waitForElementPresent(findTestObject('Object Repository/Page_BDD To Do App/div_task_1'), 5)
		String actualName1 = WebUI.getText(findTestObject('Object Repository/Page_BDD To Do App/div_task_1'),FailureHandling.CONTINUE_ON_FAILURE)
		assert nameTask1 == actualName1:"Error real name was : ${actualName1}"

		WebUI.waitForElementPresent(findTestObject('Object Repository/Page_BDD To Do App/div_task_2'), 5)
		String actualName2 = WebUI.getText(findTestObject('Object Repository/Page_BDD To Do App/div_task_2'),FailureHandling.CONTINUE_ON_FAILURE)
		assert nameTask2 == actualName2:"Error real name was : ${actualName2}"
	}

	@And("The task amount displayed should be (.*).")
	def verifyAmount(String number) {
		WebElement ulElement
		try {
			WebUI.waitForElementPresent(findTestObject('Object Repository/Page_BDD To Do App/div_task'), 5)
			ulElement = WebUI.findWebElement(findTestObject('Object Repository/Page_BDD To Do App/div_task'),5)
		} catch(Exception e1) {
			assert number == "0":"Error real count was : ${number}"
			return
		}
		List<WebElement> liElements = ulElement.findElements(By.tagName('li'))
		int countOfElements = liElements.size();
		assert countOfElements.toString() == number:"Error real count was : ${countOfElements}"
	}

	@And("With notify (.*).")
	def verifyMessage(String message) {
		WebUI.waitForElementPresent(findTestObject('Object Repository/Page_BDD To Do App/p_task_left'), 5)
		String actualMessage = WebUI.getText(findTestObject('Object Repository/Page_BDD To Do App/p_task_left'),FailureHandling.CONTINUE_ON_FAILURE)
		assert message == actualMessage:"Error real message was : ${actualMessage}"
		WebUI.closeBrowser()
	}
}