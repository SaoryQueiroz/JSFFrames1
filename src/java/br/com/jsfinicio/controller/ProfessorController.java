
package br.com.jsfinicio.controller;

import br.com.jsfinicio.model.AreaModel;
import br.com.jsfinicio.model.CidadeModel;
import br.com.jsfinicio.model.EstadoModel;
import br.com.jsfinicio.model.ProfessorModel;
import br.com.jsfinicio.repository.AreaRepository;
import br.com.jsfinicio.repository.CidadeRepository;
import br.com.jsfinicio.repository.EstadoRepository;
import br.com.jsfinicio.repository.ProfessorRepository;
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
public class ProfessorController extends Conexao {
    private ProfessorModel professorModel;
    private EstadoModel estadoModel;
    private EstadoRepository estadoRepository;
    private ProfessorRepository professorRepository;
    private List<ProfessorModel> listaDeProfessores;
    private CidadeModel cidadeModel;
    private CidadeRepository cidadeRespository;
    private AreaModel areaModel;

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
    private AreaRepository areaRepository;

    public ProfessorModel getProfessorModel() {
        return professorModel;
    }

    public CidadeModel getCidadeModel() {
        return cidadeModel;
    }

    public void setCidadeModel(CidadeModel cidadeModel) {
        this.cidadeModel = cidadeModel;
    }

    public CidadeRepository getCidadeRespository() {
        return cidadeRespository;
    }

    public void setCidadeRespository(CidadeRepository cidadeRespository) {
        this.cidadeRespository = cidadeRespository;
    }

    public void setProfessorModel(ProfessorModel professorModel) {
        this.professorModel = professorModel;
    }

    public EstadoModel getEstadoModel() {
        return estadoModel;
    }

    public void setEstadoModel(EstadoModel estadoModel) {
        this.estadoModel = estadoModel;
    }

    public EstadoRepository getEstadoRepository() {
        return estadoRepository;
    }

    public void setEstadoRepository(EstadoRepository estadoRepository) {
        this.estadoRepository = estadoRepository;
    }

    public ProfessorRepository getProfessorRepository() {
        return professorRepository;
    }

    public void setProfessorRepository(ProfessorRepository professorRepository) {
        this.professorRepository = professorRepository;
    }

    public List<ProfessorModel> getListaDeProfessores() {
        return listaDeProfessores;
    }

    public void setListaDeProfessores(List<ProfessorModel> listaDeProfessores) {
        this.listaDeProfessores = listaDeProfessores;
    }

    public ProfessorController(){
        this.estadoRepository = new EstadoRepository();
        this.professorModel = new ProfessorModel();
        this.estadoModel = new EstadoModel();
        this.professorRepository = new ProfessorRepository();
        this.listaDeProfessores = new ArrayList<>();
        this.cidadeModel = new CidadeModel();
        this.cidadeRespository = new CidadeRepository();
        this.areaModel = new AreaModel();
        this.areaRepository = new AreaRepository();
    }
    
    public void salvar(){
        try{
            this.areaModel = this.areaRepository.buscarPorID(this.areaModel.getIdArea());
            this.professorModel.setArea(this.areaModel);
            this.estadoModel = this.estadoRepository.buscarPorID(this.estadoModel.getIdEstado());
            this.professorModel.setEstado(this.estadoModel);
            this.cidadeModel = this.cidadeRespository.buscarPorID(this.cidadeModel.getIdCidade());
            this.professorModel.setCidadeOrigem(this.cidadeModel);
            this.professorRepository.salvar(this.professorModel);
            this.professorModel = new ProfessorModel();
            
        }catch(Exception e){}
    }
    
    public void buscarTodos() {
        this.listaDeProfessores = this.professorRepository.buscarTodos();
    }
    
    public void buscarPorNome() {
        this.listaDeProfessores = this.professorRepository.buscarPorNome(this.professorModel.getNome());
    }
    
    public void excluirPorID(long idpessoa) {
        this.professorRepository.excluirPorID(idpessoa);
    }

    
    public String editarPorID(long idpessoa) throws IOException {
        this.professorModel = this.professorRepository.buscarPorID(idpessoa);

        return "editarProfessor.xhtml?faces-redirect=true";
    }
}
