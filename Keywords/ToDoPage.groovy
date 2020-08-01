import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject

import org.openqa.selenium.Keys

import com.kms.katalon.core.annotation.Keyword
import com.kms.katalon.core.testobject.TestObject
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI

public class ToDoPage {



	@Keyword
	def static selecionarLista(String lista){
		WebUI.click(CustomKeywords.'ListaToDo.getLista'(lista))
	}

	@Keyword
	def static String pegarLista(String lista){
		return WebUI.getText(CustomKeywords.'ListaToDo.getLista'(lista))
	}

	@Keyword
	def static adicionarTarefa(String tarefa){
		WebUI.sendKeys(findTestObject('ToDoPage/input_task'), tarefa)
		WebUI.sendKeys(findTestObject('ToDoPage/input_task'), Keys.chord(Keys.ENTER))
	}

	@Keyword
	def static String pegarTarefaAdicionada(){
		return WebUI.getText(CustomKeywords.'ListaToDo.getUltimaTarefa'())
	}

	@Keyword
	def static criarNovaLista(String nomeDaLista){
		WebUI.click(findTestObject("ToDoPage/img_new_list"))
		WebUI.sendKeys(findTestObject("ToDoPage/input_new_list"), nomeDaLista)
		WebUI.submit(findTestObject("ToDoPage/input_save"))
	}

	@Keyword
	def static selecionarTarefaFinalizada(String tarefa){
	}

	@Keyword
	def static puxarTarefaFinalizada(String tarefa){
	}

	@Keyword
	def static puxarTarefaParaDiaSeguinte(String tarefa){
	}

	@Keyword
	def static agendarTarefa(String tarefa, String data){
	}

	@Keyword
	def static selecionarTarefaFinalizadaDoDiaSeguinte(){
	}

	@Keyword
	def static puxarTarefaFinalizadaDoDiaSeguinte(){
	}

	@Keyword
	def static selecionarTarefaFinalizadaAgendada(String tarefa, String data){
	}

	@Keyword
	def static puxarTarefaInalizadaAgendada(String tarefa, String data){
	}

	@Keyword
	def static int listarQuantidadeDeTarefasDaLista(){
		return CustomKeywords.'ListaToDo.pegaQuantidadeDeAtividades'()
	}

	@Keyword
	def static int listarQuantidadeDeTarefasDoDiaSeguinte(TestObject lista){
	}

	@Keyword
	def static int listarQuantidadeDeTarefasAgendadas(TestObject lista, String data){
	}
}
