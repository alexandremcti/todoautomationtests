import static com.kms.katalon.core.checkpoint.CheckpointFactory.findCheckpoint
import static com.kms.katalon.core.testcase.TestCaseFactory.findTestCase
import static com.kms.katalon.core.testdata.TestDataFactory.findTestData
import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject
import static com.kms.katalon.core.testobject.ObjectRepository.findWindowsObject
import com.kms.katalon.core.checkpoint.Checkpoint as Checkpoint
import com.kms.katalon.core.cucumber.keyword.CucumberBuiltinKeywords as CucumberKW
import com.kms.katalon.core.mobile.keyword.MobileBuiltInKeywords as Mobile
import com.kms.katalon.core.model.FailureHandling as FailureHandling
import com.kms.katalon.core.testcase.TestCase as TestCase
import com.kms.katalon.core.testdata.TestData as TestData
import com.kms.katalon.core.testobject.TestObject as TestObject
import com.kms.katalon.core.webservice.keyword.WSBuiltInKeywords as WS
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI
import com.kms.katalon.core.windows.keyword.WindowsBuiltinKeywords as Windows
import internal.GlobalVariable as GlobalVariable

//preparação
WebUI.openBrowser('')

WebUI.navigateToUrl('https://todolistme.net/')

CustomKeywords.'ToDoPage.selecionarLista'('Today\'s Tasks')

quantidadeDeTarefasInicialmente = CustomKeywords.'ToDoPage.listarQuantidadeDeTarefasDaLista'()

CustomKeywords.'ToDoPage.adicionarTarefa'(tarefa)

quantidadeDeTarefasAtual = CustomKeywords.'ToDoPage.listarQuantidadeDeTarefasDaLista'()

assert quantidadeDeTarefasAtual == quantidadeDeTarefasInicialmente + 1

assert CustomKeywords.'ToDoPage.pegarTarefaAdicionada'() == tarefa

WebUI.closeBrowser()

