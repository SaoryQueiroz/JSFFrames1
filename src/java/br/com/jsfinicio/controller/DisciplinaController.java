
package br.com.jsfinicio.controller;

import br.com.jsfinicio.model.AlunoModel;
import br.com.jsfinicio.model.AreaModel;
import br.com.jsfinicio.model.DisciplinaModel;
import br.com.jsfinicio.model.ProfessorModel;
import br.com.jsfinicio.repository.AlunoRepository;
import br.com.jsfinicio.repository.AreaRepository;
import br.com.jsfinicio.repository.DisciplinaRepository;
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
public class DisciplinaController extends Conexao {
    private DisciplinaModel disciplinaModel;
    private DisciplinaRepository disciplinaRepository;
    private List<DisciplinaModel> listaDeDisciplinas;
    private AlunoModel alunoModel;
    private AlunoRepository alunoRepository;
    private ProfessorModel professorModel;
    private ProfessorRepository professorRepository;
    private AreaModel areaModel;
    private AreaRepository areaRepository;
    private List<AlunoModel> listaAlunos;
    
    
    public DisciplinaController() {
        this.disciplinaModel = new DisciplinaModel();
        this.disciplinaRepository = new DisciplinaRepository();
        this.professorModel = new ProfessorModel();
        this.professorRepository = new ProfessorRepository();
        this.areaModel = new AreaModel();
        this.areaRepository = new AreaRepository();
        this.alunoModel = new AlunoModel();
        this.alunoRepository = new AlunoRepository();
        this.listaDeDisciplinas = new ArrayList<>();
        this.listaAlunos = new ArrayList<>();
    }
    
    public void salvar() {
        try {
            this.professorModel = this.professorRepository.buscarPorID(this.professorModel.getIdpessoa());
            this.disciplinaModel.setProfessor(this.professorModel);
            this.areaModel = this.areaRepository.buscarPorID(this.areaModel.getIdArea());
            this.disciplinaModel.setArea(this.areaModel);
            this.disciplinaRepository.salvar(this.disciplinaModel);
            this.disciplinaModel = new DisciplinaModel();
            
        } catch (Exception e) {
        }
    }
    
    

    public void buscarTodos(){
        this.listaDeDisciplinas = this.disciplinaRepository.buscarTodos();
    }
    
    public void buscarPorNome() {
        this.listaDeDisciplinas = this.disciplinaRepository.buscarPorNome(this.disciplinaModel.getNome());
    }
    
    public void excluirPorID(long iddisciplina) {
        this.disciplinaRepository.excluirPorID(iddisciplina);
    }
    
    public String editarPorID(int idDisciplina)throws IOException{
        this.disciplinaModel = this.disciplinaRepository.buscarPorID(idDisciplina);
        
        return "editarDisciplina.xhtml?faces-redirect=true";
    }
    
    public String matriculaAluno(){
        this.disciplinaModel = this.disciplinaRepository.buscarPorID(this.disciplinaModel.getIdDisciplina());
        this.alunoModel = this.alunoRepository.buscarPorID(this.alunoModel.getIdpessoa());
        this.listaAlunos = this.disciplinaModel.getListaDeAlunos();
        this.alunoRepository.buscarPorID(this.alunoModel.getIdpessoa());
        this.listaAlunos.add(this.alunoModel);
        this.disciplinaModel.setListaDeAlunos(this.listaAlunos);
        this.disciplinaRepository.salvar(this.disciplinaModel);
        this.disciplinaModel = new DisciplinaModel();
        
        return "buscarDisciplina.xhtml?faces-redirect=ture";
    }
    
    public String excluirAluno(){
        this.disciplinaModel = this.disciplinaRepository.buscarPorID(this.disciplinaModel.getIdDisciplina());
        this.listaAlunos = this.disciplinaModel.getListaDeAlunos();
        this.alunoModel = this.alunoRepository.buscarPorID(this.alunoModel.getIdpessoa());
        this.listaAlunos.remove(this.alunoModel);
        this.disciplinaModel.setListaDeAlunos(this.listaAlunos);
        this.disciplinaRepository.salvar(this.disciplinaModel);
        this.disciplinaModel = new DisciplinaModel();
        
        return "listaDeAlunos.xhtml?faces-redirect=true";
    }
    
    public String listarDisciplinas(int id) throws IOException{
        this.disciplinaModel = this.disciplinaRepository.buscarPorID(id);
        
        return "listaDeAlunos.xhtml?faces-redirect=true";
    }
    
    public AlunoModel getAlunoModel() {
        return alunoModel;
    }

    public void setAlunoModel(AlunoModel alunoModel) {
        this.alunoModel = alunoModel;
    }

    public List<AlunoModel> getListaDeAlunos() {
        return listaAlunos;
    }

    public void setListaDeAlunos(List<AlunoModel> listaDeAlunos) {
        this.listaAlunos = listaDeAlunos;
    }
    
    public AlunoRepository getAlunoRepository() {
        return alunoRepository;
    }

    public void setAlunoRepository(AlunoRepository alunoRepository) {
        this.alunoRepository = alunoRepository;
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

    public ProfessorRepository getProfessorRepository() {
        return professorRepository;
    }

    public void setProfessorRepository(ProfessorRepository professorRepository) {
        this.professorRepository = professorRepository;
    }
    
    public List<DisciplinaModel> getListaDeDisciplinas() {
        return listaDeDisciplinas;
    }

    public void setListaDeDisciplinas(List<DisciplinaModel> listaDeDisciplinas) {
        this.listaDeDisciplinas = listaDeDisciplinas;
    }
    
    public DisciplinaModel getDisciplinaModel() {
        return disciplinaModel;
    }

    public void setDisciplinaModel(DisciplinaModel disciplinaModel) {
        this.disciplinaModel = disciplinaModel;
    }

    public DisciplinaRepository getDisciplinaRepository() {
        return disciplinaRepository;
    }

    public void setDisciplinaRepository(DisciplinaRepository disciplinaRepository) {
        this.disciplinaRepository = disciplinaRepository;
    }

    public ProfessorModel getProfessorModel() {
        return professorModel;
    }

    public void setProfessorModel(ProfessorModel professorModel) {
        this.professorModel = professorModel;
    }
    
    
}
