package com.merini.derbyAgenda.teste.classificacao;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.junit.runners.Suite.SuiteClasses;

@RunWith(Suite.class)
@SuiteClasses({CT1verificaInclusaoBancoTest.class, CT2verificaExclusao.class, CT3verificaRecuperaTodosOsNomesBanco.class})
   //, CT4verificaEdicaoTest.class})
public class TestAll {

}
