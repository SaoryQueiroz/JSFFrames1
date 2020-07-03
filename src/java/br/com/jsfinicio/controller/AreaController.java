
package br.com.jsfinicio.controller;

import br.com.jsfinicio.model.AreaModel;
import br.com.jsfinicio.repository.AreaRepository;
import br.com.jsfinicio.util.Conexao;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

/**
 *
 * @author saory
 */
@ManagedBean
@SessionScoped
public class AreaController extends Conexao {
    private AreaModel areaModel;
    private AreaRepository areaRepository;
    private List<AreaModel> listaDeArea;

    
    public AreaController(){
        this.areaRepository = new AreaRepository();
        this.areaModel = new AreaModel();
        this.listaDeArea = new ArrayList<>();
    }
    
    public void salvar(){
        try{
            this.areaRepository.salvar(this.areaModel);
            this.areaModel = new AreaModel();
        }catch(Exception e){}
    }
    
    public void buscarTodos() {
        this.listaDeArea = this.areaRepository.buscarTodos();
    }

    public void buscarPorNome() {
        this.listaDeArea = this.areaRepository.buscarPorNome(this.areaModel.getDescricao());
    }

    public void excluirPorID(int idArea) {
        this.areaRepository.excluirPorID(idArea);
    }

    public String editarPorID(int idArea) throws IOException {
        this.areaModel = this.areaRepository.buscarPorID(idArea);

        return "editarArea.xhtml?faces-redirect=true";
    }
    
    public AreaModel getAreaModel() {
        return areaModel;
    }

    public void setAreaModel(AreaModel areaModel) {
        this.areaModel = areaModel;
    }

    public AreaRepository getAreaRepository() {
        return areaRepository;
    }

    public void setAreaRepository(AreaRepository areaRepository) {
        this.areaRepository = areaRepository;
    }

    public List<AreaModel> getListaDeArea() {
        return listaDeArea;
    }

    public void setListaDeArea(List<AreaModel> listaDeArea) {
        this.listaDeArea = listaDeArea;
    }
    
    

}
