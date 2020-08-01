

import org.openqa.selenium.By
import org.openqa.selenium.WebDriver
import org.openqa.selenium.WebElement

import com.kms.katalon.core.annotation.Keyword
import com.kms.katalon.core.testobject.TestObject
import com.kms.katalon.core.util.KeywordUtil
import com.kms.katalon.core.webui.driver.DriverFactory
import com.kms.katalon.core.webui.exception.WebElementNotFoundException
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI
import com.kms.katalon.core.webui.keyword.builtin.getCSSValueKeyword

import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject



public class ListaToDo {



	@Keyword
	def static int listaQuantidadeDeElementos(TestObject to){
		def idName = WebUI.getAttribute(to, 'id')
		def driver = getWebDriver()
		WebElement ul = driver.findElement(By.id(idName))
		List<WebElement> liList = ul.findElements(By.tagName("li"))
		def quantidadeDeLis = liList.size()
		return quantidadeDeLis
	}



	@Keyword
	def static TestObject getLista(String nomeDaLista){
		try{
			def driver = getWebDriver()
			def idName = WebUI.getAttribute(findTestObject('ToDoPage/ul_categoriaPrincipal'), 'id')
			WebElement ul = driver.findElement(By.id(idName))
			List<WebElement> liList = ul.findElements(By.tagName("li"))
			for(def li in liList){
				WebElement span = li.findElement(By.xpath('span[@class = "listname"]'))
				String spanName = span.getText()
				println "Achou a lista - "+ spanName
				if(spanName.equals(nomeDaLista)){
					return WebUI.convertWebElementToTestObject(span)
				}
			}
			KeywordUtil.markFailed('Lista Não Encontrada')
		}catch(WebElementNotFoundException e){
			KeywordUtil.markError("Elemento Não Encontrado")
		}catch(Exception ex){
			KeywordUtil.markError(ex)
		}
	}

	@Keyword
	def static TestObject getUltimaTarefa(){

		try{
			def driver = getWebDriver()
			def quantidadeDeRegistros = pegaQuantidadeDeAtividades()
			if(quantidadeDeRegistros > 0){
				def idLi = WebUI.getAttribute(findTestObject('ToDoPage/li_list', ['idTask' : (String)(quantidadeDeRegistros - 1)]), 'id')
				WebElement span = driver.findElement(By.id(idLi))
				return WebUI.convertWebElementToTestObject(span)
			}
			return KeywordUtil.markFailed("Nenhum Registro Encontrado na Lista")
		}catch(WebElementNotFoundException){
			KeywordUtil.markFailed('Elemento Não Encontrado')
		}
	}

	@Keyword
	def static int pegaQuantidadeDeAtividades(){
		return listaQuantidadeDeElementos(findTestObject('ToDoPage/ul_list'))
	}



	private static WebDriver getWebDriver(){
		return  DriverFactory.getWebDriver()
	}
}
