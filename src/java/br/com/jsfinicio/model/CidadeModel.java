
package br.com.jsfinicio.model;

import java.io.Serializable;
import java.util.List;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import org.hibernate.annotations.Cascade;
import org.hibernate.annotations.CascadeType;
import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;

/**
 *
 * @author saory
 */
@Entity
@Table(name = "cidade")
public class CidadeModel implements Serializable{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int idCidade;
    
    @Column(length = 75, nullable = false)
    private String nome;
    
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name="idEstado", insertable=true, updatable=true)
    @Fetch(FetchMode.JOIN)
    @Cascade(CascadeType.SAVE_UPDATE)
    private EstadoModel estadoId;
    
    @OneToMany(mappedBy = "cidadeOrigem", fetch = FetchType.LAZY)
    @Cascade(CascadeType.SAVE_UPDATE)
    private List<PessoaModel> listaDePessoas;

    public int getIdCidade() {
        return idCidade;
    }

    public void setIdCidade(int idCidade) {
        this.idCidade = idCidade;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public EstadoModel getIdEstado() {
        return estadoId;
    }

    public void setIdEstado(EstadoModel idEstado) {
        this.estadoId = estadoId;
    }

    public List<PessoaModel> getListaDePessoas() {
        return listaDePessoas;
    }

    public void setListaDePessoas(List<PessoaModel> listaDePessoas) {
        this.listaDePessoas = listaDePessoas;
    }
    
    
}
