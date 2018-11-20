/*
 * Copyright 2009-2014 PrimeTek.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package org.primefaces.olympia.view.data;

import java.io.Serializable;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

import mz.co.basse.cattlecore.managers.CattleManager;
import mz.co.basse.cattlecore.managers.CattleManagerImp;
import mz.co.basse.cattlecore.models.Coral;


@ManagedBean
@ViewScoped
public class CoralListView implements Serializable {
    
    private List<Coral> corais;
   
    private Coral selectedCoral;
    
    private CattleManager cattleManager = new CattleManagerImp();
    
    
    
    @PostConstruct
    public void init() {
        corais = cattleManager.findCorais(Boolean.TRUE);
    }



	public List<Coral> getCorais() {
		return corais;
	}



	public void setCorais(List<Coral> corais) {
		this.corais = corais;
	}



	public Coral getSelectedCoral() {
		return selectedCoral;
	}



	public void setSelectedCoral(Coral selectedCoral) {
		this.selectedCoral = selectedCoral;
	}

   
}
