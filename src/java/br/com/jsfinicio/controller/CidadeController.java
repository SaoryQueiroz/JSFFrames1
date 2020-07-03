
package br.com.jsfinicio.controller;

import br.com.jsfinicio.model.CidadeModel;
import br.com.jsfinicio.repository.CidadeRepository;
import br.com.jsfinicio.util.Conexao;
import java.util.ArrayList;
import java.util.List;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

/**
 *
 * @author saory
 */
@ManagedBean
@ViewScoped
public class CidadeController extends Conexao {
    private CidadeModel cidadeModel;
    private CidadeRepository cidadeRepository;
    private List<CidadeModel> listaDeCidades;
    
    public CidadeController(){
        this.cidadeModel = new CidadeModel();
        this.cidadeRepository = new CidadeRepository();
        this.listaDeCidades = new ArrayList<>();
    }
    
    public void buscarTodos(){
        this.listaDeCidades = this.cidadeRepository.buscarTodos();
    }

    public CidadeModel getCidadeModel() {
        return cidadeModel;
    }

    public void setCidadeModel(CidadeModel cidadeModel) {
        this.cidadeModel = cidadeModel;
    }

    public CidadeRepository getCidadeRepository() {
        return cidadeRepository;
    }

    public void setCidadeRepository(CidadeRepository cidadeRepository) {
        this.cidadeRepository = cidadeRepository;
    }

    public List<CidadeModel> getListaDeCidades() {
        return listaDeCidades;
    }

    public void setListaDeCidades(List<CidadeModel> listaDeCidades) {
        this.listaDeCidades = listaDeCidades;
    }
    
    
}
