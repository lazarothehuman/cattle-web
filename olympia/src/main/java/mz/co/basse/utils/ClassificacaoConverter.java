package mz.co.basse.utils;

import javax.faces.convert.EnumConverter;
import javax.faces.convert.FacesConverter;

import mz.co.basse.cattlecore.models.Classificacao;

@FacesConverter(value="classificacaoConverter")
public class ClassificacaoConverter extends EnumConverter{
	
	public ClassificacaoConverter() {
		super(Classificacao.class);
	}

}
